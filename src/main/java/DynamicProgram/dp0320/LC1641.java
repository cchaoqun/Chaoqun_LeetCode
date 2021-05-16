package DynamicProgram.dp0320;

import java.util.Arrays;

/*
 * @Description:1641. 统计字典序元音字符串的数目
给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。

字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。



示例 1：

输入：n = 1
输出：5
解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
示例 2：

输入：n = 2
输出：15
解释：仅由元音组成的 15 个字典序字符串为
["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
示例 3：

输入：n = 33
输出：66045


提示：

1 <= n <= 50
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/20 22:27
 */
public class LC1641 {

    public int countVowelStrings(int n) {
        //dp[i][j] = 长度为i以元音中第j个字符结尾的个数
        //1<=i<=n   0<=j<=4
        int[][] dp = new int[n+1][5];
        //初始化第一行
        for(int j=0; j<5; ++j){
            //长度为1,只有每个单独的字符一种情况
            dp[1][j] = 1;
        }
        for(int i=2; i<=n; ++i){
            //长度i 以a结尾, 只能在长度为i-1以a结尾的基础上加上a
            dp[i][0] = dp[i-1][0];
            //长度i, 以e结尾,
            //所有长度i以a结尾的组合中, 都可以将最后一个a替换成e,
            //以及长度为i-1,以e结尾再加上e
            dp[i][1] = dp[i][0] + dp[i-1][1];
            //后续i, o, u都同理可得,相同长度,最后结尾的字符只要在当前字符之前,都可以替换成当前字符,
            // 以及长度i-1当前字符结尾的情况
            dp[i][2] = dp[i][1] + dp[i-1][2];
            dp[i][3] = dp[i][2] + dp[i-1][3];
            dp[i][4] = dp[i][3] + dp[i-1][4];
        }

        return dp[n][0]+dp[n][1]+dp[n][2]+dp[n][3]+dp[n][4];
    }
}

class LC1641_M2{
    //一维dp
    public int countVowelStrings(int n){
        //dp[i] 当前长度-1对应a,e,i,o,u结尾的组合个数
        int[] dp = new int[5];
        //初始化长度为1时的情况
        Arrays.fill(dp,1);
        for(int i=2; i<=n; ++i){
            //从前往后
            dp[0] = dp[0];
            dp[1] += dp[0];
            dp[2] += dp[1];
            dp[3] += dp[2];
            dp[4] += dp[3];
        }
        return dp[0]+dp[1]+dp[2]+dp[3]+dp[4];
    }
}
