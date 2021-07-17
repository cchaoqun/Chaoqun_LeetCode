package company.daily;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/15-14:34
 */

public class mergeSort {
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums, 0, len - 1, temp);
        return nums;
    }

    private void mergeSort(int[] nums, int l, int r, int[] temp){
        if(l>=r){
            return;
        }

        int mid = (l+r)>>>1;
        mergeSort(nums, l, mid, temp);
        mergeSort(nums, mid+1, r, temp);
        mergeTwoSortedArray(nums, l, mid, r, temp);
    }

    private void mergeTwoSortedArray(int[] nums, int l, int mid, int r, int[] temp){
        System.arraycopy(nums, l, temp, l, r-l+1);

        int i = l;
        int j = mid+1;

        for(int k=l; k<=r; k++){
            if(i==mid+1){
                nums[k] = temp[j];
                j++;
            }else if(j==r+1){
                nums[k] = temp[i];
                i++;
            }else if(temp[i]<=temp[j]){
                nums[k] = temp[i];
                i++;
            }else{
                // temp[i]>temp[j]
                nums[k] = temp[j];
                j++;
            }
        }
    }

}
