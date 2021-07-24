package JZOffer.review;

/**剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。



 示例：

 输入：nums = [1,2,3,4]
 输出：[1,3,2,4]
 注：[3,1,2,4] 也是正确的答案之一。


 提示：

 0 <= nums.length <= 50000
 1 <= nums[i] <= 10000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/22-20:24
 */

public class jz21 {
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int p1=0;
        for(int i=0; i<len; i++){
            if((nums[i]&1)==1){
                swap(nums, i, p1);
                p1++;
            }
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class jz21_M2{
    public int[] exchange(int[] nums) {
        int len = nums.length;
        int left=0;
        int right = len-1;
        while(left<right){
            // left一直到指向偶数
            while(left<right && nums[left]%2==1){
                left++;
            }
            // right一直到指向奇数
            while(left<right && nums[right]%2==0){
                right--;
            }
            // 终止条件
            if(left==right){
                return nums;
            }
            //交换
            swap(nums, left, right);
            //向中间移动
            left++;
            right--;
        }
        return nums;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
