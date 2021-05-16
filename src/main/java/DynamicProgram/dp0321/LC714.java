package DynamicProgram.dp0321;
/*
 * @Description: 714. 买卖股票的最佳时机含手续费
给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

示例 1:

输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:
在此处买入 prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
注意:

0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/21 11:12
 */
public class LC714 {

    public int maxProfit(int[] prices, int fee) {
        //dp[i][0] = 第i天结束不持有股票,
        // 可能是i-1天不持有dp[i-1][0]
        // 也可能是i-1天持有,i天卖出 dp[i-1][1]+prices[i]-fee
        //dp[i][1] = 第i天结束持有股票
        //  可能是i-1天持有dp[i-1][1]
        //  也可能是i-1天不持有,i天买入dp[i-1][0]-prices[i]
        //规定当前买入则手里的钱减去当天的股价 -prices[i]
        //当前卖出,手里钱加上当前的股价        prices[i]
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<prices.length; ++i){
            //第i天结束后手上不持有股票
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]+prices[i]-fee);
            //第i天结束后手上持有股票
            dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);

        }
        return Math.max(dp[prices.length-1][0],dp[prices.length-1][1]);
    }
}

class LC714_M2 {
    //一维滚动数组
    public int maxProfit(int[] prices, int fee){
        //dp[0]昨天结束不持有的最大利润
        //dp[1]昨天结束持有的最大利润
        int[] dp = new int[2];
        //第一天不持有
        dp[0] = 0;
        //第一天持有
        dp[1] = -prices[0];
        for(int i=1; i<prices.length; ++i){
            //第i天结束不持有
            int dp00 = Math.max(dp[0], dp[1]+prices[i]-fee);
            //第i天结束持有
            int dp11 = Math.max(dp[1], dp[0]-prices[i]);
            //更新滚动数组
            dp[0] = dp00;
            dp[1] = dp11;
        }
        return Math.max(dp[0],dp[1]);
    }
}
