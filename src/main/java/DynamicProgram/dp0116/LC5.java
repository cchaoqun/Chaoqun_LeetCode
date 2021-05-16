package DynamicProgram.dp0116;

import java.util.Arrays;

/*
 * @Description: 5. 最长回文子串
 *
给你一个字符串 s，找到 s 中最长的回文子串。
*
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
*
示例 2：
输入：s = "cbbd"
输出："bb"
*
示例 3：
输入：s = "a"
输出："a"
*
示例 4：
输入：s = "ac"
输出："a"

提示：
1 <= s.length <= 1000
s 仅由数字和英文字母（大写和/或小写）组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-palindromic-substring
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/16 15:11
 */
public class LC5 {
    public static void main(String[] args) {
        String s ="aaaa";
        String res = longestPalindrome(s);
        System.out.println(res);
    }

    //Brute Force
//    public static String longestPalindrome(String s) {
//        if(s==null || s.length()==0){
//            return null;
//        }
//        String res = "";
//        for(int i=0; i<s.length(); i++){
//            if(res.length() > (s.length()-i+1)){
//                //后续最长子串不可能大于当前回文串长度则终止
//                return res;
//            }
//            for(int j=i; j<s.length(); j++){
//                if(check(s,i,j) && (j-i+1 > res.length())){
//                    res = s.substring(i,j+1);
//                }
//            }
//        }
//        return res;
//    }
//
//    public static boolean check(String s, int left, int right){
//        while(left<=right){
//            if(s.charAt(left) != s.charAt(right)){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

    // dp
    // dp[i][j] = 字符串从i到j位置的子串是否为回文串
    // 状态转移方程 dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1]
    // 如果子串的首尾字符i,j相等,考虑去掉头尾的子串[i+1,j-1]是否是回文串
    // 如果子串的首尾字符i,j相等,如果 j-1 -(i+1) +1 < 2 => j-i < 3
    //      (去掉头尾的子串长度为0或1,则该子串[i,j]一定为回文串)
    // 如果子串的首尾字符i,j不相等,一定不是回文串

    public static String longestPalindrome(String s){
        int len = s.length();
        if(len < 2){
            return s;
        }
        //最长回文串的长度
        int maxLen = 1;
        //最长回文串的起始位置
        int start = 0;
        //dp二维数组
        boolean[][] dp = new boolean[len][len];
        //初始化全为false
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],false);
        }
        //遍历字符串
        for(int j=1; j<len; j++){
            for(int i=0; i<j; i++){
                //判断首尾字符是否相等
                if(s.charAt(i) == s.charAt(j)){
                    //如果子串长度<=3
                    if(j-i < 3){
                        //一定为回文串
                        dp[i][j] = true;
                    }else{
                        //状态转移,取决于子串是否是回文串
                        dp[i][j] = dp[i+1][j-1];
                    }
                }else{
                    //子串首尾字符不相等,一定不是回文串
                    dp[i][j] = false;
                }
                //判断当前回文串的长度是否>之前找到的回文串的长度
                if(dp[i][j]){
                    if(j-i+1 > maxLen){
                        //最大回文串长度
                        maxLen = j-i+1;
                        //最大回文串起始下标
                        start = i;
                    }
                }
            }
        }
        //返回最长回文子串
        return s.substring(start,start+maxLen);
    }
}
