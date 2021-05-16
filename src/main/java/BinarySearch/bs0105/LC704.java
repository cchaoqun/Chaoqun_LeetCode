package BinarySearch;
/*
 * @Description: 704. 二分查找
给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
*
* 计算 mid 时需要防止溢出，代码中 left + (right - left) / 2 就和 (left + right) / 2
* 的结果相同，但是有效防止了 left 和 right 太大直接相加导致溢出。
*
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 20:15
 */
public class LC704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int res = search(nums,0);
        System.out.println(res);

    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            int midval = nums[mid];
            if(target == midval){
                return mid;
            }else if(target<midval){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }
}
