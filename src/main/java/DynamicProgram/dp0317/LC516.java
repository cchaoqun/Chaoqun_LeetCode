package DynamicProgram.dp0317;
/*
 * @Description: 516. 最长回文子序列
给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。



示例 1:
输入:

"bbbab"
输出:

4
一个可能的最长回文子序列为 "bbbb"。

示例 2:
输入:

"cbbd"
输出:

2
一个可能的最长回文子序列为 "bb"。



提示：

1 <= s.length <= 1000
s 只包含小写英文字母
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/17 21:18
 */
public class LC516 {

    //从后往前
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //dp[i][j] = 字符串s[i,j]中最长的回文子串
        int[][] dp = new int[n][n];
        for(int i=n-1; i>=0; --i){
            //单个字符为回文串且长度为1
            dp[i][i] = 1;
            //j从i后面一个位置开始,因为[i,j]的判定依赖于[i+1,j-1]中间的情况
            for(int j=i+1; j<n; ++j){
                if(s.charAt(i)==s.charAt(j)){
                    //两边的指针向内收缩一个位置, 2为两端的两个相同的字符对于整个回文串长度的贡献
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    //两头不相同,这两个字符不会对回文串的长度有贡献,查看左指针右移或者右指针左移一个位置后较大的情况
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}

class LC516_M2{
    //从前往后
    //i 0-->n-1
    //j 0<--i-1
    public int longestPalindromeSubseq(String s){
        int n = s.length();
        //dp[j][i] = [j,i]之间最长的回文子串
        int[][] dp = new int[n][n];
        for(int i=0; i<n; ++i){
            dp[i][i] = 1;
            for(int j=i-1; j>=0; --j){
                if(s.charAt(i)==s.charAt(j)){
                    dp[j][i] = dp[j+1][i-1] + 2;
                }else{
                    dp[j][i] = Math.max(dp[j+1][i], dp[j][i-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
