package company.bytedance;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-13:42
 */

public class LC53 {
    public int maxSubArray(int[] nums) {
        int sumMax = Integer.MIN_VALUE;
        //前面连续的元素和
        int preSum = 0;
        for(int i=0; i<nums.length; i++){
            //连续和<=0 对当前的元素没有好处 从当前元素开始重新计算
            if(preSum<=0){
                preSum = nums[i];
            }else{
                //>0 加上当前元素
                preSum += nums[i];
            }
            //更新最大值
            sumMax = Math.max(preSum, sumMax);
        }
        return sumMax;
    }
}
