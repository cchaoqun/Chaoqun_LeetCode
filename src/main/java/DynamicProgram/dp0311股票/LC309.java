package DynamicProgram.dp0311股票;
/*
 * @Description: 309. 最佳买卖股票时机含冷冻期
给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/11 21:42
 */
public class LC309 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];
        //dp[i][0]:i天结束持有股票
        //dp[i][1]:i天结束不持有股票并且处于冷冻期
        //dp[i][2]:i天结束不持有股票并且不处于冷冻期
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i=1; i<prices.length; ++i){
            //第i天结束持有股票
            //i-1天结束持有股票 / i-1天结束不持有股票并且不出在冷冻期，并且在i天买入
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);

            //第i天结束不持有股票并且处在冷冻期
            //i-1天结束持有股票,第i天结束卖出
            dp[i][1] = dp[i-1][0]+prices[i];

            //第i天结束不持有股票不处于冷冻期
            //i-1天不持有股票不处于冷冻期 / i-1天不持有股票处于冷冻期
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }
        //最后一天      不持有股票处于冷冻期       不持有股票不处于冷冻期
        return Math.max(dp[prices.length-1][1], dp[prices.length-1][2]);
    }

    //空间优化只保留前一天的三个状态
//    public int maxProfit(int[] prices){
//        //每一天的状态只与前一天的三个状态有关,只需要一维数组,每天结束更新即可
//        int[] dp = new int[3];
//        dp[0] = -prices[0];
//        dp[1] = 0;
//        dp[2] = 0;
//        for(int i=1; i<prices.length; ++i){
//            //i天持有股票
//            int newdp0 = Math.max(dp[0], dp[2]-prices[i]);
//            //i天不持有股票处于冷冻期
//            int newdp1 = dp[0]+prices[i];
//            //i天不持有股票不处于冷冻期
//            int newdp2 = Math.max(dp[2], dp[1]);
//
//            dp[0] = newdp0;
//            dp[1] = newdp1;
//            dp[2] = newdp2;
//        }
//        return Math.max(dp[1],dp[2]);
//
//    }
}
class LC309_M2{
    public int maxProfit(int[] prices){
        //dp[i][0] i天结束后持股
        //dp[i][1] i天结束后不持股但是出于冷冻期
        //dp[i][2] i天结束后不持股,不处于冷冻期
        int[][] dp = new int[prices.length][3];
        int len = prices.length;
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for(int i=1; i<len; ++i){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2]-prices[i]);
            dp[i][1] = dp[i-1][0]+prices[i];
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][1]);
        }
        return Math.max(dp[len-1][1], dp[len-1][2]);
    }
}
class LC309_M3{
    public int maxProfit(int[] prices){
        int[] dp = new int[3];
        dp[0] = -prices[0];
        dp[1] = 0;
        dp[2] = 0;
        for(int i=1; i<prices.length; ++i){
            int d0 = Math.max(dp[0], dp[2]-prices[i]);
            int d1 = dp[0]+prices[i];
            int d2 = Math.max(dp[2], dp[1]);
            dp[0] = d0;
            dp[1] = d1;
            dp[2] = d2;
        }
        return Math.max(dp[1], dp[2]);
    }
}
