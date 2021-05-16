package BroadFirstSearch.bfs0115;

/*
 * @Description: 121. 买卖股票的最佳时机
给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
注意：你不能在买入股票前卖出股票。
*
示例 1:
输入: [7,1,5,3,6,4]
输出: 5
解释: 在第 2 天（股票价格 = 1）的时候买入，
在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
*
示例 2:
输入: [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 10:53
 */
public class LC121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
//    public static int maxProfit(int[] prices) {
//        int n = prices.length;
//        //最大利润
//        int maxProfit = 0;
//        //创建数组,存储每个下标后续的最大元素的值
//        int[] maxNext = new int[n];
//        maxNext = Arrays.copyOf(prices,n);
//        //数组的倒数第二个元素开始,这样只需要比较当前元素与后一个位置的元素
//        for(int i=n-2; i>=0; i--){
//            if(maxNext[i]<maxNext[i+1]){
//                maxNext[i] = maxNext[i+1];
//            }
//            //i位置买入的最大利润是否当前的最大利润
//            if(maxNext[i] - prices[i] > maxProfit){
//                maxProfit = maxNext[i] - prices[i];
//            }
//        }
//        return maxProfit;
//    }

    //dp
    public static int maxProfit(int[] prices){
        int len = prices.length;
        if(len<2){
            return 0;
        }
        int[] dp = new int[2];
        //当前利润最大值,今天结束不持股
        dp[0] = 0;
        //今天结束持股.第一天买入
        dp[1] = -prices[0];
        for(int i=1; i<len; i++){
            //当天结束
            //比较当前利润最大值,与今天结束卖出得到的利润的最大值
            //每次比较如果今天卖出的利润是否大于当前的最大利润
            //dp[1]始终存储之前天数的最低股价,总是查看今天卖出是否有更大的利润
            //当前的dp[1]0 - i-1天的股价最小值
            dp[0] = Math.max(dp[0], dp[1]+prices[i]);
            //保存了到i天为止的股价最低值
            dp[1] = Math.max(dp[1], -prices[i]);
        }

        return dp[0];
    }
}
