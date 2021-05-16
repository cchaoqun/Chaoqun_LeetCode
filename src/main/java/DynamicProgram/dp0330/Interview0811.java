package DynamicProgram.dp0330;
/*
 * @Description: 面试题 08.11. 硬币
硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)

示例1:

 输入: n = 5
 输出：2
 解释: 有两种方式可以凑成总金额:
5=5
5=1+1+1+1+1
示例2:

 输入: n = 10
 输出：4
 解释: 有四种方式可以凑成总金额:
10=10
10=5+5
10=5+1+1+1+1+1
10=1+1+1+1+1+1+1+1+1+1
说明：

注意:

你可以假设：

0 <= n (总金额) <= 1000000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/30 21:07
 */
public class Interview0811 {

    /**
     状态方程: dp[i] = 构成i的方法有多少种
     状态转移公式; dp[i] = (((dp[i-1] + dp[i-5])%N+dp[i-10])%N)+dp[i-25])%N
     初始化: dp[0] = 1;
     dp[0]: 虽dp[5] += dp[5-5]=dp[0]刚好一枚硬币,
     */

    public int waysToChange(int n) {
        if(n==0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;

        int N = 1000000007;
        int[] coins = {1,5,10,25};
        //这里先遍历全部用1的情况,
        //在遍历5, 10, 25,  这样避免了同样的硬币不同的顺序造成的重复
        for(int coin:coins){
            for(int i=coin; i<n+1; i++){
                dp[i] = (dp[i]+dp[i-coin])%N;
            }
        }
        return dp[n];
    }
}
