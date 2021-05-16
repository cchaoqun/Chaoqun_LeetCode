package GreedyAlgorithm.greedy0121;
/*
 * @Description: 122. 买卖股票的最佳时机 II
 *
给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出,
这笔交易所能获得利润 = 5-1 = 4 。
随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出,
这笔交易所能获得利润 = 6-3 = 3 。
*
示例 2:
输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出,
这笔交易所能获得利润 = 5-1 = 4 。
注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
*
示例3:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
*
提示：
1 <= prices.length <= 3 * 10 ^ 4
0 <= prices[i]<= 10 ^ 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/21 18:18
 */
public class LC122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }

    // 遍历数组,如果存在递增的区间则在最小点买入,最高点卖出,
    // [7,1,5,3,6,4]
//    public static int maxProfit(int[] prices) {
//        int len = prices.length;
//        if(len == 0 || len == 1){
//            return 0;
//        }
//        int profit = 0;
//        int buy = 0;
//        for(int i=1; i<len; ++i){
//            if(prices[i] < prices[i-1]){
//                //i-1为一个峰值,计算递增区间的获利
//                profit += prices[i-1] - prices[buy];
//                //从峰值的后一天买入
//                buy = i;
//            }
//        }
//        profit += prices[len-1] - prices[buy];
//        return profit;
//    }

    // dp[i][0] = 第i天不持有股票的利润 = Math.max(dp[i-1][0], dp[i-1][1] + prices[i])
    //  0.0 前一天不持有股票 dp[i-1][0]
    //  0.1 前一天持有股票,第i天卖出了 dp[i-1][1] + prices[i]
    // dp[i][1] = 第i天持有股票的利润 = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]
    //  1.0 前一天不持有股票,第i天买入 dp[i-1][0] - prices[i]
    //  1.1 前一天持有股票,dp[i-1][1]
    // 最后一天不持有股票的利润一定高于持有股票的利润,返回 dp[len-1][0]
    // 每一天的dp只与前一天的情况有关,只需要用两个变量保存前一天的信息即可

    public static int maxProfit(int[] prices){
        int len = prices.length;
        if (len == 0 || len == 1){
            return 0;
        }
        int profit = 0;
        //第一天不持有,利润为0
        int dp0 = 0;
        //第一天持有,利润为 -prices[0]
        int dp1 = -prices[0];
        for(int i=1; i<len; ++i){
            int tempDp0 = Math.max(dp0,dp1+prices[i]);
            int tempDp1 = Math.max(dp1,dp0-prices[i]);
            //保存第i天的信息
            dp0 = tempDp0;
            dp1 = tempDp1;
        }
        return dp0;
    }

    // 贪心: 如果今天的股价比昨天高,就交易
    // 贪心的点在于,每次都作出最优解,而今天与昨天的股价相比,可能的情况只有,<0; =0; >0;
    // 所以贪心的最优解就是>0的情况,即只要今天比昨天股价高就交易
//    public static int maxProfit(int[] prices){
//        int len = prices.length;
//        if (len == 0 || len == 1){
//            return 0;
//        }
//        int profit = 0;
//        for(int i=1; i<len; ++i){
//            //今天的股价>昨天就把这部分利润加上
//            if(prices[i] > prices[i-1]){
//                profit += prices[i] - prices[i-1];
//            }
//        }
//        return profit;
//    }
}
