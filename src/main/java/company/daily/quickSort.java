package company.daily;

import java.util.Random;

/**912. 排序数组
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/15-14:07
 */

public class quickSort {
    Random rand = new Random();
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length-1);
        return nums;
    }
    private void quickSort(int[] nums, int l, int r){
        if(l>=r){
            return;
        }
        int pivot = partition(nums, l, r);
        quickSort(nums, l, pivot-1);
        quickSort(nums, pivot+1, r);
    }
    private int partition(int[] nums, int l, int r){
        int pivot = rand.nextInt(r-l+1)+l;
        int cur = nums[pivot];
        int index = l;
        swap(nums, l, pivot);
        for(int i=l+1; i<=r; i++){
            if(nums[i]<=cur){
                index++;
                swap(nums, index, i);
            }
        }
        swap(nums, l, index);
        return index;
    }
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
