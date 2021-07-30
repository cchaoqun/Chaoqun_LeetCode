package Algorithm_HW.Week8;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/24-15:54
 */

public class interview0811 {
    public int waysToChange(int n) {
        int mod = 1000000007;
        int[] coins = new int[]{1,5,10,25};
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int c : coins){
            for(int i=c; i<=n; i++){
                dp[i] = (dp[i] + dp[i-c])%mod;
            }
        }
        return dp[n];
    }
}
