package BinarySearch.bs0106;
/*
 * @Description: 35. 搜索插入位置
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 12:11
 */
public class LC35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 7;
        int res = searchInsert(nums,target);
        System.out.println(res);

    }

//    public static int searchInsert(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length;
//        while(left<right){
//            int mid = left+(right-left)/2;
//            int midval = nums[mid];
//            if(target == midval){
//                return mid;
//            }else if (target<midval){
//                right = mid;
//            }else {
//                left = mid+1;
//            }
//        }
//        if(left==nums.length){
//            return left;
//        }
//        if(nums[left] < target){
//            return left+1;
//        }else{
//            return left;
//        }
//    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midval = nums[mid];
            if (target > midval) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
