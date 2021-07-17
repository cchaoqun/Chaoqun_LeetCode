package company.bytedance;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/25-12:25
 */

public class LC300 {
    /**
     dp[i] 代表了以nums[i]结尾的序列的最大长度
     对于每一个dp[i] 需要取寻找所有的 j 属于 [0,i-1],
     如果nums[j]<nums[i] nums[i]可以接在nums[j]结尾的序列后面 dp[j]+1
     否则 不能接在后面
     每个dp[i] = Math.max(dp[j]+1, dp[i])
     结束本次dp[i] 更新最大值
     */
    public int lengthOfLIS(int[] nums) {
        int prevMax = Integer.MAX_VALUE;
        int n = nums.length;
        int[] dp = new int[n];
        int max = 0;
        for(int i=0; i<nums.length; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;

    }
}
