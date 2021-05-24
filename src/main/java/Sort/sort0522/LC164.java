package Sort.sort0522;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/22-12:45
 */

public class LC164 {

    @Test
    public void test(){
        int[] nums = {1,1,1,1};
        int res = maximumGap(nums);
        System.out.println(res);
    }


    //快排
    Random random = new Random();
    public int maximumGap(int[] nums) {
        if(nums==null || nums.length<2){
            return 0;
        }
        quickSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        int prev = nums[0];
        int diff = 0;
        for(int i=1; i<nums.length; i++){
            diff = Math.max(diff, nums[i]-prev);
            prev = nums[i];
        }
        return diff;

    }

    public void quickSort(int[] nums, int lo, int hi){
        if(lo>=hi){
            return;
        }
        int pivot = partition(nums, lo, hi);

        quickSort(nums, lo, pivot-1);
        quickSort(nums, pivot+1, hi);
    }

    public int partition(int[] nums, int lo, int hi){
        int pivot = random.nextInt(hi-lo+1)+lo;
        int cur = nums[pivot];
        swap(nums, lo, pivot);
        int index = lo;
        for(int i=lo+1; i<=hi; i++){
            if(nums[i]<=cur){
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, index, lo);
        return index;

    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
