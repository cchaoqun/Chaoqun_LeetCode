package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/24-8:35
 */

public class jz33 {
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length-1);
    }

    private boolean check(int[] nums, int l, int r){
        if(l>=r){
            return true;
        }
        int left = l;
        //左边<root.val
        while(left<r && nums[left]<nums[r]){
            left++;
        }
        int right = left;
        //右边>root.val
        while(right<r && nums[right]>nums[r]){
            right++;
        }
        //[left,r-1]必须全部>root.val
        return right==r && check(nums, l, left-1) && check(nums, left, r-1);
    }
}
