package Divide_Conquer;

import java.util.Arrays;

/**
 * 312. 戳气球
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 *
 *
 * 示例 1：
 * 输入：nums = [3,1,5,8]
 * 输出：167
 * 解释：
 * nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
 * coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
 * 示例 2：
 *
 * 输入：nums = [1,5]
 * 输出：10
 *
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 500
 * 0 <= nums[i] <= 100
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/21-13:09
 */

public class LC312 {
    //递归自下而上
    int[][] memo;
    public int maxCoins(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        //n+2 左右端点添加一个为1的气球不影响结果 处理边界
        int[] arr = new int[n+2];
        for(int i=1; i<=n; i++){
            arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[n+1] = 1;
        //缓存
        this.memo = new int[n+2][n+2];
        for(int i=0; i<n+2; i++){
            Arrays.fill(memo[i], -1);
        }
        return dfs(arr, 0, n+1);
    }

    public int dfs(int[] arr, int lo, int hi){
        //区间没有元素 因为是开区间hi>lo+1中间才有元素
        if(lo>=hi-1){
            return 0;
        }
        //当前范围内已经遍历过直接返回缓存的结果
        if(memo[lo][hi]!=-1){
            return memo[lo][hi];
        }
        //当前区间对应的最大值
        int res = 0;
        //(lo,hi)开区间
        for(int i=lo+1; i<hi; ++i){
            //以[lo+1, hi-1]遍历每一个气球为第一个添加的气球,当前只有一个气球
            int cur = arr[lo]*arr[i]*arr[hi];
            //左边的开区间为(lo,i) 右边为(i,hi)的分数递归得到
            cur += dfs(arr, lo, i)+dfs(arr,i,hi);
            //加起来, 取最后的最大值
            res = Math.max(res, cur);
        }
        //当前区间的结果缓存
        memo[lo][hi] = res;
        return res;
    }
}

class LC312_M2{
    //dp
    public int maxCoins(int[] nums){
        if(nums==null || nums.length==0){
            return 0;
        }
        int n = nums.length;
        //n+2 左右端点添加一个为1的气球不影响结果 处理边界
        int[] arr = new int[n+2];
        for(int i=1; i<=n; i++){
            arr[i] = nums[i-1];
        }
        arr[0] = 1;
        arr[n+1] = 1;
        // dp[lo][hi] 开区间(lo,hi)的最大分数
        int[][] dp = new int[n+2][n+2];
        //从下往上遍历 即从数组的后往前遍历
        for(int i=n-1; i>=0; --i){
            //每次让区间中间有一个元素开始
            for(int j=i+2; j<=n+1; ++j){
                //k为开区间(i,j)的元素
                for(int k=i+1; k<j; ++k){
                    //当前k为最后一个戳破的气球, 区间只剩下当前气球和左右端点的气球
                    int cur = arr[i]*arr[k]*arr[j];
                    //左边区间的最大分数(i,k) 右边区间(k,j)
                    cur += dp[i][k]+dp[k][j];
                    dp[i][j] = Math.max(cur,dp[i][j]);
                }
            }
        }
        return dp[0][n+1];
    }
}
































