package company.bytedance;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-12:25
 */

public class LC121 {
    public int maxProfit(int[] prices) {
        //每天更新最大利润
        int maxProfit = 0;
        //之前天数的最小股价
        int preMin = prices[0];
        for(int i=0; i<prices.length; i++){
            maxProfit = Math.max(maxProfit, prices[i]-preMin);
            preMin = Math.min(preMin, prices[i]);
        }
        return maxProfit;
    }
}
