package JZOffer.jz0302;
/*
 * @Description: 剑指 Offer 42. 连续子数组的最大和
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。



示例1:

输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。


提示：

1 <= arr.length <= 10^5
-100 <= arr[i] <= 100
注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/


 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/2 21:34
 */
public class jz42 {
    /**
     * 初始sum=0, ans = nums[0]
     * 遍历数组
     * 如果sum<0,对于子序和的没有增益作用,舍弃sum,将sum更新为num[i]
     * ans = math.max(ans,sum)
     * 如果sum>=0,对于子序和有增益作用 sum += num[i]
     * ans = math.max(ans,sum)
     *
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for(int i=0; i<nums.length; ++i){
            //如果sum>=0, nums[i]+sum > nums[i] 返回sum+nums[i]
            //如果sum<0, nums[i]+sum < nums[i] 返回nums[i]
            sum = Math.max(nums[i], sum+nums[i]);
            //更新最大子序和如果有必要的情况下;
            ans = Math.max(ans,sum);
        }
        return ans;
    }

}
