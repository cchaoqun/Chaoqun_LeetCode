package DynamicProgram.dp0327;
/*
 * @Description:
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/27 19:28
 */
public class LC813 {

    /**
     * 一维dp 从前往后
     *     dp[i]从i开始到数组结尾分成k个子数组的平均值的最大值
     *     preSum[i] = sum(A[0]:A[i-1])
     *     dp[i] = Math.max(dp[i], dp[j] + (preSum[j]-preSum[i])/(j-i))
     *     在[i+1:]中找一个j [j:]分成k-1个子数组, [i:j-1]分成一个子数组 这样加起来就是k个子数组
     *     dp[j] = [j:]分成k-1个子数组的最大平均值
     *     (preSum[j]-preSum[i])/(j-i) = [i:j-1]分成一个子数组的平均值
     *     需要初始化从i开始分成一个子数组的情况作为后续dp状态转移的依据
     *     dp[i] = (preSum[len]-preSum[i]) / (len-i)
     */
    public double largestSumOfAverages(int[] A, int K) {
        //前缀和
        int len = A.length;
        //preSum[i] = sum[A[0]:A[i-1]];
        int[] preSum = new int[len+1];
        //前缀和数组
        for(int i=1; i<len+1; i++){
            preSum[i] = preSum[i-1]+A[i-1];
        }
        //dp[i] = 从i开始将数组分成K个子数组获得的最大平均值
        double[] dp = new double[len];
        //先分成1个子数组的情况
        for(int i=0; i<len; i++){
            dp[i] = (double)(preSum[len]-preSum[i])/(len-i);
        }
        //分成k个子数组的情况取决于k-1的情况
        //dp[i] = i开始分成k个子数组的最大平均值
        //j>i, dp[j]表示从j开始分成k-1个子数组的最大平均值
        //剩下的[i:j-1]分成一个子数组,平均值为(preSum[j]-preSum[i])/ (j-i)
        //所以当前dp[i]=i~j-1分成一个子数组的平均值加上j到最后分成k-1个子数组的平均值之和
        //dp[i] = (preSum[j]-preSum[i])/ (j-i) + dp[j];

        //已经计算了分成1个子数组的情况
        //还剩下分成2~k个子数组的情况,剩下k-1次
        for(int k=0; k<K-1; k++){
            for(int i=0; i<len; i++){
                for(int j=i+1; j<len; j++){
                    //[i:j-1]分成一个子数组, [j:]分成k-1个子数组
                    dp[i] = Math.max(dp[i], (double)(preSum[j]-preSum[i])/(j-i)+dp[j]);
                }
            }
        }
        //[0:]f分成k个子数组的最大均值
        return dp[0];
    }
}

class LC813_M2{

    /**二维dp 从后往前
     * dp[i][k] = 到第i个数位置,分成k个子数组的最大平均值
     * [:i-1]找到一个j, [:j]分成k-1个子数组, [j+1:i]分成一个子数组 加起来为k个子数组
     * dp[j][k-1] = [:j]分成k-1个子数组的最大平均值
     * (preSum[i+1]-preSum[j+1])/(i-j) = [j+1:i]分成一个子数组的平均值
     * 初始化到i分成一个子数组的平均值
     * dp[i] = preSum[i+1] / (i+1)
     *
     */
    public double largestSumOfAverages(int[] A, int K){
        int len = A.length;
        //preSum[i] = sum[A[0]:A[i-1]];
        int[] preSum = new int[len+1];
        //前缀和数组
        for(int i=1; i<len+1; i++){
            preSum[i] = preSum[i-1]+A[i-1];
        }

        //dp[i][k] = 到i位置为止 分成k个子数组的最大均值
        double[][] dp = new double[len][K+1];
        //初始化dp分成1个子数组的情况
        for(int i=0; i<len; i++){
            dp[i][1] = (double)preSum[i+1]/(i+1);
        }
        //一共需要计算从分成2个子数组到K个子数组的情况,需要循环K次
        for(int k=2; k<=K; k++){
            //分成k个子数组至少需要k个元素,第k个元素下标为k-1
            for(int i=k-1; i<len; i++){
                //[0:i)找到到j位置分成k-1个数组的平均值 + [j+1:i]分成一个子数组的平均值=分成k个子数组的平均值
                for(int j=0; j<i; j++){
                    dp[i][k] = Math.max(dp[i][k], dp[j][k-1]+(double)(preSum[i+1]-preSum[j+1])/(i-j));
                }
            }
        }
        return dp[len-1][K];
    }
}
