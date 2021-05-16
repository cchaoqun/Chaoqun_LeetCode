package DynamicProgram.dp0328;
/*
 * @Description:97. 交错字符串
给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。

两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
提示：a + b 意味着字符串 a 和 b 连接。



示例 1：


输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
输出：true
示例 2：

输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
输出：false
示例 3：

输入：s1 = "", s2 = "", s3 = ""
输出：true


提示：

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1、s2、和 s3 都由小写英文字母组成
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/28 20:10
 */
public class LC97 {
    /**
     如果s1 s2的长度之和不等于s3的长度 则不能构成
     dp[i][j] = s1的前i个字符和s2的前j个字符能否构成s3的前i+j个字符
     如果s1.charAt(i-1)==s3.charAt(i+j-1) 取决于s1前i-1个字符和s2的前j个字符能否构成s3的前i+j-1个字符
     如果s2.charAt(j-1)==s3.charAt(i+j-1) 取决于s1前i个字符和s2的前j-1个字符能否构成s3的前i+j-1个字符
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if(n1+n2 != n3){
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        boolean[][] dp = new boolean[n1+1][n2+1];
        dp[0][0] = true;
        for(int i=0; i<=n1; i++){
            for(int j=0; j<=n2; j++){
                if(i>0){
                    //如果s1第i个字符等于s3的第i+j个字符
                    dp[i][j] = dp[i][j] || (dp[i-1][j] && arr1[i-1]==arr3[i+j-1]);
                }
                if(j>0){
                    //如果s2第j个字符等于s3的第i+j个字符
                    dp[i][j] = dp[i][j] || (dp[i][j-1] && arr2[j-1]==arr3[i+j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
class LC97_M2{

    //一维dp
    public boolean isInterleave(String s1, String s2, String s3){
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();
        if(n1+n2 != n3){
            return false;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        char[] arr3 = s3.toCharArray();
        boolean[] dp = new boolean[n2+1];
        dp[0] = true;
        for(int i=0; i<=n1; i++){
            for(int j=0; j<=n2; j++){
                if(i>0){
                    //如果s1第i个字符等于s3的第i+j个字符
                    dp[j] = dp[j]&&(arr1[i-1]==arr3[i+j-1]);

                }
                if(j>0){
                    //如果s2第j个字符等于s3的第i+j个字符
                    dp[j] = dp[j] || (dp[j-1]&&arr2[j-1]==arr3[i+j-1]);
                }
            }
        }
        return dp[n2];
    }


}
