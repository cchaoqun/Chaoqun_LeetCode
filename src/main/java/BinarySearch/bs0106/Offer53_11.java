package BinarySearch.bs0106;
/*
 * @Description: 剑指 Offer 53 - II. 0～n-1中缺失的数字
一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 17:00
 */
public class Offer53_11 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        int res = missingNumber(nums);
        System.out.println(res);

    }
//    public static int missingNumber(int[] nums) {
//        int left = 0;
//        int right = nums.length-1;
//        while(left<=right){
//            int mid = left+(right-left)/2;
//            if(nums[mid]==mid){
//                if(mid==nums.length-1){
//                    return mid+1;
//                }
//                if(nums[mid+1] != mid+1){
//                    return mid+1;
//                }else{
//                    left = mid+1;
//                }
//            }else {
//                if(mid==0){
//                    return 0;
//                }
//                if(nums[mid-1]==mid-1){
//                    return mid;
//                }else{
//                    right = mid;
//                }
//            }
//        }
//        return -1;
//    }

    public static int missingNumber(int[] nums){
        int left = 0, right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==mid){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}
