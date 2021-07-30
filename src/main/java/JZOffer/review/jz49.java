package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/27-16:02
 */

public class jz49 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p2 =1, p3 =1, p5 =1;
        for(int i=2; i<=n; i++){
            int n1 = dp[p2]*2, n2 = dp[p3]*3, n3=dp[p5]*5;
            int cur = Math.min(Math.min(n1, n2),n3);
            dp[i] = cur;
            if(cur==n1){
                p2++;
            }
            if(cur==n2){
                p3++;
            }
            if(cur==n3){
                p5++;
            }
        }
        return dp[n];
    }
}
