package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/28-15:16
 */

public class jz53_I {
    public int search(int[] nums, int target){
        return helper(nums, target)-helper(nums, target-1);
    }

    //寻找第一个大于target的数的下标
    private int helper(int[] nums, int target){
        int l = 0, r = nums.length-1;
        while(l<=r){
            int mid = (l+r)>>>1;
            if(nums[mid]<=target){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
