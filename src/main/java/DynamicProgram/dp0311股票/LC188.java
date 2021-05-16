package DynamicProgram.dp0311股票;
/*
 * @Description: 188. 买卖股票的最佳时机 IV
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。



示例 1：

输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2：

输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。


提示：

0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/21 15:07
 */
public class LC188 {
    //三维dp
    public int maxProfit(int k, int[] prices) {
        if(prices==null || prices.length<2){
            return 0;
        }
        if(k >= prices.length / 2){
            return greedy(prices);
        }
        //第一维表示总的天数,多开一行,去除了边界的判定
        //第二维, 统计[0,i]天内的交易次数,限制为k次
        //第三维表示当天结束是否持股 0不持股 1持股
        int[][][] dp = new int[prices.length+1][k+1][2];
        // 初始化：把持股的部分都设置为一个较小的负值
        // 注意：如果使用默认值 0，状态转移的过程中会做出错误的决策
        for(int i=0; i<=prices.length; ++i){
            for(int j=0; j<=k; ++j){
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        for(int i=1; i<=prices.length; ++i){
            for(int j=1; j<=k; ++j){
                //i从1开始,注意跟原来的prices[]有1的下标偏移,所以i天的股价为prices[i-1]
                //i天结束不持股,交易j次
                //可能是i-1天结束不持股,交易了j次
                //也可能是i-1天结束持股,交易了j次,i天卖出
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1]+prices[i-1]);
                //i天结束持股,交易了j次
                //可能是i-1天结束持股,交易了j次
                //可能是i-1天结束不持股,交易了j-1次,i天买入
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0]-prices[i-1]);
            }
        }
        return dp[prices.length][k][0];
    }

    //k >= prices.length/2
    //等于没有限制,因为一次交易至少需要两天,prices.length天最多也只能进行 prices.length/2次交易
    public int greedy(int[] prices){
        int res = 0;
        for(int i=1; i<prices.length; ++i){
            //只要相邻两天的利润大于0就包括在内
            int diff = prices[i] - prices[i-1];
            if(diff > 0){
                res += diff;
            }
        }
        return res;
    }
}

class LC188_M2{
    //二维dp
    public int maxProfit(int k, int[] prices){
        if(prices==null || prices.length<2){
            return 0;
        }
        int len = prices.length;
        if(k>=len/2){
            return greedy(prices);
        }
        int[][] dp = new int[k+1][2];
        for(int i=0; i<=k; ++i){
            dp[i][1] = Integer.MIN_VALUE;
        }
        for(int i=0; i<len; ++i){
            for(int j=1; j<=k; ++j){
                int dpj1 = Math.max(dp[j][1], dp[j-1][0]-prices[i]);
                int dpj0 = Math.max(dp[j][0], dp[j][1]+prices[i]);
                dp[j][1] = dpj1;
                dp[j][0] = dpj0;

            }
        }
        return dp[k][0];
    }



    //k >= prices.length/2
    //等于没有限制,因为一次交易至少需要两天,prices.length天最多也只能进行 prices.length/2次交易
    public int greedy(int[] prices){
        int res = 0;
        for(int i=1; i<prices.length; ++i){
            //只要相邻两天的利润大于0就包括在内
            int diff = prices[i] - prices[i-1];
            if(diff > 0){
                res += diff;
            }
        }
        return res;
    }
}
