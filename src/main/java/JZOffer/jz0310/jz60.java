package JZOffer.jz0310;
/*
 * @Description: 剑指 Offer 60. n个骰子的点数
把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。



你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。



示例 1:

输入: 1
输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
示例 2:

输入: 2
输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]


限制：

1 <= n <= 11
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/10 10:29
 */
public class jz60 {

    public double[] dicesProbability(int n) {
        //dp[i][j] = 投掷i个筛子点数总和为j的次数
        int[][] dp = new int[n+1][6*n+1];
        //初始边界,一个筛子的情况
        for(int i=1; i<=6; ++i){
            //一个筛子1-6可能出现的次数都为1
            dp[1][i] = 1;
        }

        //i为投掷的筛子个数,从2开始
        for(int i=2; i<=n; ++i){
            //投掷i个筛子所有可能的点数情况为 [i, 6*i]
            for(int j=i; j<=6*i; ++j){
                /**
                 * 如果当前投掷了i个筛子,总点数为j的情况下
                 * 如果第i次投掷了1, 前i-1次需要投掷j-1
                 * 如果第i次投掷了2, 前i-1次需要投掷j-2
                 * 如果第i次投掷了3, 前i-1次需要投掷j-3
                 * 如果第i次投掷了4, 前i-1次需要投掷j-4
                 * 如果第i次投掷了5, 前i-1次需要投掷j-6
                 * 如果第i次投掷了6, 前i-1次需要投掷j-6
                 */
                //dp[i][j] = sum(dp[i-1][j-1], dp[i-1][j-6])
                for(int k=1; k<=j && k<=6; ++k){
                    dp[i][j] += dp[i-1][j-k];
                }
            }
        }
        //投掷n个筛子所有可能的点数为[n,6*n]
        //一共有6*n-n+1 = 5*n+1种可能
        double[] res = new double[5*n+1];
        for(int i=n; i<=6*n; ++i){
            res[i-n] = ((double)dp[n][i]) / (Math.pow(6, n));
        }
        return res;
    }
}
