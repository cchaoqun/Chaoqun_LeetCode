package DynamicProgram.dp0319;
/*
 * @Description: 面试题 16.17. 连续数列
给定一个整数数组，找出总和最大的连续数列，并返回总和。

示例：

输入： [-2,1,-3,4,-1,2,1,-5,4]
输出： 6
解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶：

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/19 17:31
 */
public class interview16_17 {
    public int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        //当前连续子序列和的最大值
        int max = nums[0];
        //前面的连续子数组的和
        int curSum = nums[0];
        for(int i=1; i<nums.length; ++i){
            //前面的和<=0对于连续和没有贡献
            if(curSum<=0){
                //连续和变成当前值
                curSum = nums[i];
            }else{
                //前面的和>0,当前元素加入连续数组
                curSum += nums[i];
            }
            //每次都检查是否需要更新最大值
            max = curSum>max?curSum:max;
        }
        return max;
    }
}
