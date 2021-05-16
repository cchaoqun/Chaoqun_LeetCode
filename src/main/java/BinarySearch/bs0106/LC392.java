package BinarySearch.bs0106;

import java.util.Arrays;

/*
 * @Description: 392. 判断子序列
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
进阶：
如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
在这种情况下，你会怎样改变代码？
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 10:01
 */
public class LC392 {
    public static void main(String[] args) {
        String s = "abb";
        String t = "ahbgdb";
        boolean res = isSubsequence(s,t);
        System.out.println(res);
    }


    //自己的解法
//    public static boolean isSubsequence(String s, String t) {
//        //s是否为t的子序列
//        if(s.length()>t.length()){
//            return false;
//        }
//
//        //保存上一个s字符在t中的位置
//        int index = 0;
//        //保存s字符在t中的位置
////        int sIndex[] = new int[s.length()];
//        //遍历s各个字符
//        int i=0, j=index;
//        for(i=0; i<s.length(); i++){
//            String sStr = s.charAt(i)+"";
//            for(j=index; j<t.length(); ){
//                String tStr = t.charAt(j)+"";
//                if(tStr.equals(sStr)){
//                    //下一个字符从当前匹配位置的下一个开始
//                    index = j+1;
//                    //记录下标
////                    sIndex[i] = j;
//                    break;
//                }
//                j++;
//            }
//            //未在t中找到当前字符
//            if(j==t.length()){
//                return false;
//            }
//        }
////        System.out.println(Arrays.toString(sIndex));
//        return true;
//    }

    //双指针
//    public static boolean isSubsequence(String s, String t){
//        if(s.length()>t.length()){
//            return false;
//        }
//        int i=0, j=0;
//        while(i<s.length() && j<t.length()) {
//            if(s.charAt(i) == t.charAt(j)){
//                i++;
//            }
//            j++;
//        }
//        return i==s.length();
//
//    }

    //dp
    public static boolean isSubsequence(String s, String t){
        int[][] dp = dp(t);
        return match(s,dp);
    }

    //匹配的方法
    public static boolean match(String s, int[][] dp){
        //代表dp中的行数
        int index = 0;
        int m = s.length();
        for(int i=0; i<m; i++){
            if(dp[index][s.charAt(i)-'a'] == -1){
                //未匹配
                return false;
            }
            //匹配到,跳转到该匹配字符的下一行
            index = dp[index][s.charAt(i) - 'a']+1;
        }
        return true;
    }

    //创建dp数组用于后面与s字符串比较
    public static int[][] dp(String t){
        int n = t.length();
        //创建dp二维数组
        int[][] dp = new int[n+1][26];
        //将最后一行赋值为-1
        for(int i=0; i<26; i++){
            dp[n][i] = -1;
        }
        //从最后一行开始向前遍历
        //如果t中的这个字符与二维数组的列匹配到就把行数记录到这个位置
        //否则就照抄下面一行的数字
        for(int i=n-1; i>=0; i--){
            for(int j=0; j<26; j++){
                if(t.charAt(i) == j+'a'){
                    //匹配到,就把行数放入到这个位置
                    dp[i][j] = i;
                }else{
                    //未匹配到,就照抄下面一行对应的数字
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        for(int[] link:dp){
            System.out.println(Arrays.toString(link));
        }
        return dp;
    }

}
