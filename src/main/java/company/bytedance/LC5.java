package company.bytedance;

import org.junit.jupiter.api.Test;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/2-13:33
 */

public class LC5 {



    public String longestPalindrome(String s) {
        //最长回文串的长度
        int maxLen = 1;
        //最长回文串对应的左右下标
        int[] res = new int[2];
        int len = s.length();
        //dp[i][j] = s.substring(i,j+1)是否是回文串
        boolean[][] dp = new boolean[len][len];
        //对角线的代表只有一个字符, 一定是回文串
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }
        char[] arr = s.toCharArray();
        //从左到右填表
        for(int j=1; j<len; j++){
            //对于每一个j 从i=j-1开始向左遍历, 这样保证计算这个回文串 [i+1,j-1]之间是否是回文串已经确定过了
            for(int i=j-1; i>=0; i--){
                //只有两个字符, 两个字符必须相等
                if(i==j-1){
                    dp[i][j] = arr[i]==arr[j];
                }else{
                    //大于两个字符, 头尾字符相等并且中间的也是一个回文串
                    dp[i][j] = arr[i]==arr[j] && dp[i+1][j-1];
                }
                //如果当前[i,j]是一个回文串, 并且长度大于之前的最长回文串
                if(dp[i][j] && j-i+1>maxLen){
                    //更新长度已经最长回文串的左右下标
                    maxLen = j-i+1;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return s.substring(res[0], res[1]+1);
    }
}

class LC5_M2{

    @Test
    public void test(){
        String s = "aaaa";
        String res = longestPalindrome(s);
        System.out.println(res);

    }
    public String longestPalindrome(String s) {
        //最长回文串的长度
        int maxLen = 1;
        //最长回文串对应的左右下标
        int[] res = new int[2];
        int len = s.length();
        //dp[i][j] = s.substring(i,j+1)是否是回文串
        boolean[][] dp = new boolean[len][len];
        //对角线的代表只有一个字符, 一定是回文串
        for(int i=0; i<len; i++){
            dp[i][i] = true;
        }
        char[] arr = s.toCharArray();
        //从右向左填表
        for(int i=len-2; i>=0; i--){
            for(int j=i+1; j<len; j++){
                if(arr[i] != arr[j]){
                    continue;
                }
                if(j==i+1){
                    dp[i][j] = true;
                }else{
                    dp[i][j] = dp[i+1][j-1];
                }
                if(dp[i][j] && j-i+1>maxLen){
                    maxLen = j-i+1;
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return s.substring(res[0], res[1]+1);
    }
}
