package Algorithm_HW.Advanced.dp;

/**
 * @author Chaoqun Cheng
 * @date 2021-08-2021/8/1-9:24
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Step 1 DP定义
 * Step 2 Base case
 * Step 3 Induction rule
 * Step 4 Fill in Order
 * Step 5 Return what
 * Step 6 Time && Space
 */
public class LargestSubArr {
    /**剑指 Offer 42. 连续子数组的最大和
     输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
     要求时间复杂度为O(n)。
     示例1:
     输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
     输出: 6
     解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     提示：
     1 <= arr.length <= 10^5
     -100 <= arr[i] <= 100

     * Step 1 DP定义
     *      dp[i] = 到i为止的最大子数组的和 Include i
     * Step 2 Base case
     *      dp[0] = nums[0]     子数组不允许为空至少含有一个元素
     * Step 3 Induction rule
     *      取决于以i-1结尾的最大子数组的和大小---> depends on dp[i-1]
     *          dp[i-1]>0
     *              dp[i] = dp[i-1]+nums[i]
     *          dp[i-1]<=0
     *              dp[i] = nums[i]
     *      跟新global max
     *          globalMax = Math.max(globalMax, dp[i])
     * Step 4 Fill in Order
     *      左-->右
     *          因为每一个都depends on 左边的元素 dp[i-1]
     * Step 5 Return what
     *      globalMax
     * Step 6 Time && Space
     *      Time: 遍历数组O(n) 每个元素的操作 O(1)
     *      Space:  dp[n] 数组 O(n) 可以优化为 O(1) 因为只depends on 前面一个元素
     */
    // 连续子数组的最大和
    public int maxSubArr(int[] nums){

        if(nums==null || nums.length==0){
            return Integer.MIN_VALUE;
        }
        int len = nums.length;
        int dp = nums[0];
        int globalMax = nums[0];
        for(int i=1; i<len; i++){
            dp = Math.max(dp+nums[i], nums[i]);
            globalMax = Math.max(globalMax, dp);
        }
        return globalMax;
    }

    /**1186. 删除一次得到子数组最大和
     给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。
     换句话说，你可以从原数组中选出一个子数组，并可以决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。
     注意，删除一个元素后，子数组 不能为空。
     请看示例：
     示例 1：
     输入：arr = [1,-2,0,3]
     输出：4
     解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。
     示例 2：
     输入：arr = [1,-2,-2,3]
     输出：3
     解释：我们直接选出 [3]，这就是最大和。
     示例 3：
     输入：arr = [-1,-1,-1,-1]
     输出：-1
     解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
     提示：
     1 <= arr.length <= 10^5
     -10^4 <= arr[i] <= 10^4

     * Step 1 DP定义
     *      需要两个dp数组
     *          keep[i] = 代表到i位置 include i 的最大子数组和
     *          dp[i] = 代表到i位置为止, include i, 考虑 删 || 不删除 nums[i] 的最大子数组和
     * Step 2 Base case
     *      keep[0] = nums[0]
     *      dp[0] = nums[0]
     *      必须保证至少有一个元素, 所以base case 都是第一个元素
     * Step 3 Induction rule
     *      dp[i] = 考虑是否删除当前元素nums[i]
     *                  删除nums[i]: 必须保证前面的元素都不能删除即=keep[i-1]
     *                  不删除nums[i]: 无论如何dp[i]中都只会删除一个元素, 所以无论dp[i-1]中删除了哪个, 都不会影响连续性 =dp[i-1]+nums[i]
     *                      这里包含了删除前面一个元素和前面都不删的两种情况
     *              考虑 keep[i-1]<=0的情况
     *                  舍弃keep[i-1]直接重新开始 只有nums[i]
     *       最后考虑着三种情况中的最大值
     *       需要先跟新dp 在优化到O(1)空间的情况下, dp depends on keep
     *      keep[i] = keep[i-1]>0?keep[i-1]+nums[i] : nums[i]
     *      更新完两个dp 更新最大值
     *          不更新, 保留所有的nums[0:i]=keep[i], 中间可能删除了一个dp[i]
     *          globalMax = Math.max(globalMax, dp[i], keep[i])
     * Step 4 Fill in Order
     *      左--> 右 因为 dp[i] depends on dp[i-1] keep[i-1]
     *                  keep[i] depends on keep[i-1]
     * Step 5 Return what
     *       globalMax
     * Step 6 Time && Space
     *      Time: O(n)
     *      Space: O(2*n) dp[n] keep[n] 优化--> O(2) dp num
     */
    // 允许删除一个元素的最大子数组和
    public int maxSubArrWithOneDelete(int[] nums){
        if(nums==null || nums.length==0){
            return Integer.MIN_VALUE;
        }
        int len = nums.length;
        int dp = nums[0];
        int keep = nums[0];
        int globalMax = nums[0];
        for(int i=1; i<len; i++){
            dp = Math.max(keep, Math.max(nums[i], dp+nums[i]));
            keep = Math.max(nums[i], keep+nums[i]);
            globalMax = Math.max(Math.max(dp, keep), globalMax);
        }
        return globalMax;
    }

    //环形数组最大子数组和
    public int LargestSubArrayCircular(int[] nums){
        int curMin = Integer.MAX_VALUE;
        int curMax = Integer.MIN_VALUE;
        int globalMin = Integer.MAX_VALUE;
        int globalMax = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            curMin = curMin<0?curMin+nums[i]:nums[i];
            curMax = curMax>0?curMax+nums[i]:nums[i];
            globalMin = Math.min(curMin, globalMin);
            globalMax = Math.max(curMax, globalMax);
        }
        //全负数 sum-globalMin = 0 但是不能全不选
        if(globalMax<0){
            return globalMax;
        }
        return Math.max(globalMax, sum-globalMin);
    }

    //TODO LC1504 17.24 152
    @Test
    public void testProdMaxMatrix(){
        double[][] matrix ={{1,5,-1},
                            {0,-1.5,1},
                            {1,1,1}};
        double res = maxMatrixProd(matrix);
        System.out.println(res);
    }
    //最大乘积子矩阵
    public double maxMatrixProd(double[][] matrix){
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0.0;
        }
        double globalMax = 0.0;
        int m=matrix.length, n=matrix[0].length;
        for(int i=0; i<m; i++){
            double[] cur = new double[n];
            Arrays.fill(cur, 1.0);
            for(int j=i; j<m; j++){
                for(int k=0; k<n; k++){
                    cur[k] *= matrix[j][k];
                }
                globalMax = Math.max(globalMax, maxProd(cur));
            }
        }
        return globalMax;
    }
    private double maxProd(double[] num){
        double dpMax = num[0];
        double dpMin = num[0];
        double max = num[0];
        for(int i=1; i<num.length; i++){
            double preMax = dpMax;
            dpMax = Math.max(dpMax*num[i], Math.max(dpMin*num[i], num[i]));
            dpMin = Math.min(preMax*num[i], Math.min(dpMin*num[i], num[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }

}































