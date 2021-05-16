package JZOffer.jz0307;
/*
 * @Description: 剑指 Offer 63. 股票的最大利润
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？



示例 1:

输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
示例 2:

输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。


限制：

0 <= 数组长度 <= 10^5



注意：本题与主站 121 题相同：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/7 21:11
 */
public class jz63 {
    public int maxProfit(int[] prices) {

        int cost = Integer.MAX_VALUE;
        int profit = 0;
        for(int i=0; i<prices.length; ++i){
            //记录前面的最低值
            cost = Math.min(cost, prices[i]);
            //当前最大利润 = 前一天的最大利润 和 今天股价减去前i-1天的最小股价当中的最大值
            profit = Math.max(profit, prices[i]-cost);
        }
        return profit;
    }
}
