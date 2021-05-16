package BinarySearch;
/*
 * @Description: 分析二分查找的左右边界以及 < <= 问题
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 15:15
 */
public class BinarySearchTest {
    public static void main(String[] args) {
        int nums[] = {1,2,2,4};
        int target = 2;
        int res = findRight(nums,target);
        System.out.println(res);
    }

    public static int binarySearch1(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                right = mid-1;
            }else if(target > nums[mid]){
                left = mid+1;
            }
        }
        return left;
    }

    public static int findLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;//
        while(left<=right){//
            int mid = left+(right-left)/2;
            //找到目标值向左收缩
            if(target==nums[mid]){
                right = mid-1;//
            }else if(target<nums[mid]){
                right = mid-1;
            }else if(target>nums[mid]){
                left = mid+1;
            }
        }
        //退出循环条件为 left=right+1, 检查left是否越界
        if(left>=nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    public static int findRight(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;//
        while(left<=right){
            int mid = left+(right-left)/2;
            if(target==nums[mid]){
                left = mid+1;
            }else if(target<nums[mid]){
                right = mid-1;
            }else if(target>nums[mid]){
                left = mid+1;
            }
        }
        //判断right越界的情况
        if(right<0 || nums[right]!=target){
            return -1;
        }
        return right;
    }
}
