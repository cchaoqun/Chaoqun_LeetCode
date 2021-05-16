package GreedyAlgorithm.greedy0428;

/**
 * 1758. 生成交替二进制字符串的最少操作数
 * 给你一个仅由字符 '0' 和 '1' 组成的字符串 s 。一步操作中，你可以将任一 '0' 变成 '1' ，或者将 '1' 变成 '0' 。
 *
 * 交替字符串 定义为：如果字符串中不存在相邻两个字符相等的情况，那么该字符串就是交替字符串。例如，字符串 "010" 是交替字符串，而字符串 "0100" 不是。
 *
 * 返回使 s 变成 交替字符串 所需的 最少 操作数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "0100"
 * 输出：1
 * 解释：如果将最后一个字符变为 '1' ，s 就变成 "0101" ，即符合交替字符串定义。
 * 示例 2：
 *
 * 输入：s = "10"
 * 输出：0
 * 解释：s 已经是交替字符串。
 * 示例 3：
 *
 * 输入：s = "1111"
 * 输出：2
 * 解释：需要 2 步操作得到 "0101" 或 "1010" 。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s[i] 是 '0' 或 '1'
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/28-15:35
 */

public class LC1758 {
    //dp
    public int minOperations(String s) {
        if(s==null || s.length()==1){
            return 0;
        }
        int[][] dp = new int[s.length()][2];
        //dp[i][0] = 第i个位置不换所需要的操作数
        //dp[i][1] = 第i个位置换所需要的操作数
        //i换, 如果i和i-1位置相同, i-1就不能换, dp[i][1] = dp[i-1][0]+1
        //     如果i和i-1位置不相同,i-1必须换, dp[i][1] = dp[i-1][1]+1
        //i不换, 如果i和i-1位置相同, i-1就必须换, dp[i][0] = dp[i-1][1]
        //     如果i和i-1位置不相同,i-1就不能换, dp[i][0] = dp[i-1][0]
        dp[0][0] = 0;
        dp[0][1] = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)==s.charAt(i-1)){
                dp[i][0] = dp[i-1][1];
                dp[i][1] = dp[i-1][0]+1;
            }else{
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1]+1;
            }
        }
        return Math.min(dp[s.length()-1][0], dp[s.length()-1][1]);
    }
}

class LC1758_M2{
    //一次遍历
    public int minOperations(String s) {
        //01所在的位值和值的奇偶性不一致, 1在偶数位, 0在奇数位
        int odd0 = 0;
        //01所在的位值和值的奇偶性一致, 0 在偶数位, 1在奇数位
        int even0 = 0;
        int index = 0;
        for(char c:s.toCharArray()){
            if(index%2!=(c-'0')%2){
                odd0++;
            }else{
                even0++;
            }
            index++;
        }
        return Math.min(odd0, even0);
    }
}
