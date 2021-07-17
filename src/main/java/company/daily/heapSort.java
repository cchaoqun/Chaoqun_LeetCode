package company.daily;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/15-14:07
 */

public class heapSort {
    public int[] sortArray(int[] nums){
        int len = nums.length;
        heapify(nums);
        //不断把最大的元素交换到末尾
        for(int i=len-1; i>=0; ){
            // 堆顶的元素交换到了最后一个位置, 这个元素是当前堆中最大的
            swap(nums, i, 0);
            i--;
            // 因为本来在最后一个位置的元素交换到了堆顶, 需要下沉到合适的位置
            // 并且已经找到了一个最大的元素, 堆中元素减一,
            percolateDowm(nums, 0, i);
        }
        return nums;
    }

    private void heapify(int[] nums){
        // 从 (nums.length-1)/2开始下沉即可
        // 因为最后一个元素对应的父节点在数组中的下标 就是 (nums.length-1)/2
        for(int i=(nums.length-1)/2; i>=0; i--){
            percolateDowm(nums, i, nums.length-1);
        }
    }

    /**
     *
     * @param nums 堆对应的数组
     * @param k     当前需要下沉的数组
     * @param end   当前堆的最后一个元素在数组中对应的下标
     */
    private void percolateDowm(int[] nums, int k, int end){
        // 2*end+1 是k位置对应的左子节点在数组中的下标
        while(2*k+1<=end){
            // 找到左右子节点中较大的那个
            int left = 2*k+1;
            if(left+1<=end && nums[left+1]>nums[left]){
                left++;
            }
            if(nums[k]<nums[left]){
                swap(nums, k, left);
                k = left;
            }else{
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
