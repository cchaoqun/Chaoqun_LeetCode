package JZOffer.review;

/**剑指 Offer 03. 数组中重复的数字
 找出数组中重复的数字。


 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

 示例 1：

 输入：
 [2, 3, 1, 0, 2, 5, 3]
 输出：2 或 3


 限制：

 2 <= n <= 100000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/21-13:40
 */

public class jz03 {
    public int findRepeatNumber(int[] nums) {
        /**
         * 0-n-1 的长度为n的数组, 排序后应该每个nums[i] = i
         * 对于遇到的每个nums[i]
         *  如果nums[i] == i 跳过
         *  否则 交换 nums[i] 和 i下标处的两个元素直到nums[i] == i
         *  如果交换过程中发现 nums[i] == nums[nums[i]]
         *      i 位置的元素值 == nums[i]位置的元素值, 这样就找到了一个重复的元素 nums[i]
         */
        for(int i=0; i<nums.length; i++){
            //
            if(nums[i]==i){
                continue;
            }
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
