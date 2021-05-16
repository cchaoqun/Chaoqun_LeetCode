package DynamicProgram.dp0324;
/*
 * @Description: 1143. 最长公共子序列
给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。



示例 1:

输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace"，它的长度为 3。
示例 2:

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc"，它的长度为 3。
示例 3:

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0。


提示:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
输入的字符串只含有小写英文字符。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/24 17:49
 */
public class LC1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        //dp[i][j] = text1[0:i-1] 和text2[0:j-1]序列的最长公共子序列长度
        int[][] dp = new int[len1+1][len2+1];

        //text2为空
        for(int i=0; i<len1+1; i++){
            dp[i][0] = 0;
        }
        //text1为空
        for(int j=0; j<len2+1; j++){
            dp[0][j] = 0;
        }
        for(int i=1; i<len1+1; i++){
            for(int j=1; j<len2+1; j++){
                if(arr1[i-1]==arr2[j-1]){
                    //当前两个字符相同,当前最大子序列长度应该为
                    //遍历到当前两个字符之前的最长长度+1
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    //当前遍历到arr2[j],因为不相等,
                    //当前的最大子序列长度应该为遍历到arr2[j]之前的最长长度
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
