package company.bytedance;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/30-21:53
 */

public class LC31 {
    public void nextPermutation(int[] nums) {
        /**
         从后向前找到第一个 nums[i]<nums[i+1]
         再从后向前在区间[i+1:end]找到第一个 nums[i] < nums[j]
         交换 nums[i] nums[j]
         此时区间 [i+1:end]必定是降序的
         因为 nums[j]是从后往前第一个大于nums[i] 那么 nums[i] > nums[j+1:end] 所有的数
         [i+1:end]降序, nums[j]>nums[i] nums[j-1] > nums[j] > nums[i]
         将区间[i+1:end]翻转变成升序
         */
        int n = nums.length;
        int i = n-2;
        //找到第一个非降序的位置
        for(; i>=0; i--){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        //数组是降序的
        if(i<0){
            reverse(nums, 0, n-1);
            return;
        }
        //找到右边的大数
        int j = n-1;
        for(; j>=i+1; j--){
            if(nums[j]>nums[i]){
                break;
            }
        }
        //交换 小数和大数
        swap(nums, i, j);
        //因为区间[i+1:n-1]是降序的 对称交换翻转就变成原来的逆序
        reverse(nums, i+1, n-1);


    }

    //翻转区间[i:j]
    private void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
