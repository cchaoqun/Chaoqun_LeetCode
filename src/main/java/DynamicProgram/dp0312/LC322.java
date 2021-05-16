package DynamicProgram.dp0312;

import java.util.Arrays;

/*
 * @Description: 322. 零钱兑换
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

你可以认为每种硬币的数量是无限的。



示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0
示例 4：

输入：coins = [1], amount = 1
输出：1
示例 5：

输入：coins = [1], amount = 2
输出：2


提示：

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/12 18:02
 */
public class LC322 {
    public int coinChange(int[] coins, int amount){
        //dp[i] = 金额总和为i所需要的的最小金币数
        /**
         * dp[0] = 0;
         * dp[i] = Math,min(dp[i-cj])(cj=c0~cj)+1
         */
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i=1; i<dp.length; ++i){
            //dp[i-cj]中前面最小的状态
            int minPre = Integer.MAX_VALUE;
            for(int c:coins){
                //如果当前金额总和i-硬币面值c >=0, 并且i-c金额总和是可以获得的
                if(i-c>=0 && dp[i-c]>=0){
                    //取较小值
                    minPre = Math.min(minPre, dp[i-c]+1);
                }
            }
            //如果minPre没变,说明i不可以获得,赋值为-1,否则可以获得,最小硬币数量为minPre
            dp[i] = minPre==Integer.MAX_VALUE?-1:minPre;
        }
        //dp[amount] = 金额总和为amount对应的最小硬币数量
        return dp[amount];
    }

//    public int coinChange(int[] coins, int amount){
//        if(amount<1){
//            return 0;
//        }
//        return dfs(coins,amount,new int[amount+1]);
//    }
//
//    /**
//     *
//     * @param coins 硬币数组
//     * @param res 剩余金额
//     * @param count count[i] 金额总和为i的最小硬币数量
//     * @return
//     */
//    public int dfs(int[] coins, int res, int[] count){
//        //剩余金额<0,没有解,返回-1
//        if(res<0){
//            return -1;
//        }
//        //刚好为0,返回0
//        if(res==0){
//            return 0;
//        }
//        //金额总和为res的最小硬币数量已经计算过,直接返回
//        if(count[res]!=0){
//            return count[res];
//        }
//        //当前res的最小硬币数量
//        int minPre = Integer.MAX_VALUE;
//        //遍历每一种可能的减去的硬币面值
//        for(int c:coins){
//            //当前剩余金额res 减去 当前的硬币面值c 的金额总和的最小硬币数量
//            int curMin = dfs(coins,res-c,count);
//            //如果有解,并且最小硬币数量小于minPre
//            if(curMin>=0 && curMin<minPre){
//                //更新
//                minPre = curMin+1;
//            }
//        }
//        //如果minPre没有变化,说明res金额总不可以通过已有的硬币面值获得返回-1
//        count[res] = minPre==Integer.MAX_VALUE? -1:minPre;
//        return count[res];
//    }
}
