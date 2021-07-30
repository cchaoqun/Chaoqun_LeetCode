package Algorithm_HW.Week8;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/24-15:53
 */

public class LC518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        /**
         dp[i] = 构成i的组合总数 可以由 i-coins[j] 0<=j<n构成 加上对应的coins[j]总和就变成了 i
         */
        int[] dp = new int[amount+1];
        //总和=0 不选也是一种解法
        dp[0] = 1;
        //遍历硬币
        for(int c : coins){
            //对于可能从当前c组成的amount开始逐渐增加, 每个都可能由 i-c + c构成
            for(int i=c; i<=amount; i++){
                dp[i] += dp[i-c];
            }
        }
        return dp[amount];
    }
}
