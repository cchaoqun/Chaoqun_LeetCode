package BinarySearch;
/*
 * @Description: 剑指 Offer 53 - I. 在排序数组中查找数字 I
统计一个数字在排序数组中出现的次数。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 22:11
 */
public class Offer53_1 {
    public static void main(String[] args) {
//        int[] nums = {-1,0,3,5,9,12};
        int[] nums = {2,2};
        int target = 2;
        int res = search(nums,target);
        System.out.println(res);
    }


    //二分查找左右边界 <=
    //通过二分查找找到目标在数组中的左侧边界和右侧边界来计算目标出现的个数
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0] == target? 1:0;
        }
        int left = 0;
        int right = nums.length-1;
        int l = findleft(nums,left,right,target);
        int r = findright(nums,left,right,target);
        if(l==-1 || r==-1){
            return 0;
        }else{
            return r-l+1;
        }
    }

    //找左边界 左闭右开
    public static int findleft(int[] nums, int left, int right, int target){
        while(left<=right) {
            int mid = left + (right - left) / 2;
            int midval = nums[mid];
            if(target<=midval){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        if(left>=nums.length || nums[left]!=target){
            return -1;
        }
        return left;
    }

    //找右边界 左闭右开
    public static int findright(int[] nums, int left, int right, int target){
        while(left<=right) {
            int mid = left + (right - left) / 2;
            int midval = nums[mid];
            if (target >= midval) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(right<0 || nums[right] != target){
            return -1;
        }
        return right;
    }


    //二分查找左右边界 <
//    public static int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length;
//        int l = findleft(nums,left,right,target);
//        int r = findright(nums,left,right,target);
//        if(l==-1 || r==-1){
//            return 0;
//        }else{
//            return r-l+1;
//        }
//    }
//
//    public static int findleft(int[] nums, int left, int right, int target){
//        while(left<right){
//            int mid = left+(right-left)/2;
//            int midval = nums[mid];
//            if(target == midval){
//                right = mid;
//            }else if(target < midval){
//                right = mid;
//            }else{
//                left = mid + 1;
//            }
//        }
//        if(left==nums.length || nums[left] != target){
//            return -1;
//        }
//        return left;
//    }
//
//    public static int findright(int[] nums, int left, int right, int target){
//        while(left<right){
//            int mid = left+(right-left)/2;
//            int midval = nums[mid];
//            if(target == midval){
//                left = mid+1;
//            }else if(target < midval){
//                right = mid;
//            }else {
//                left = mid+1;
//            }
//        }
//        if(left==0){
//            return -1;
//        }
//        return nums[left-1]==target? left-1:-1;
//    }

}
