package BinarySearch.bs0108;
/*
 * @Description: 81. 搜索旋转排序数组 II
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组[0,0,1,2,2,5,6]可能变为[2,5,6,0,0,1,2])。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回true，否则返回false。

示例1:
输入: nums = [2,5,6,0,0,1,2], target = 0
输出: true
*
示例2:
输入: nums = [2,5,6,0,0,1,2], target = 3
输出: false
进阶:

这是 搜索旋转排序数组的延伸题目，本题中的nums 可能包含重复元素。
这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/8 11:38
 */
public class LC81 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,0,0,1,2};
        int target = 0;
        boolean res = search(nums,target);
        System.out.println(res);
    }
    //判断 nums[left] 与 nums[mid]之间的关系 <
//    public static boolean search(int[] nums, int target) {
//        int n = nums.length;
//        if(nums==null || n==0){
//            return false;
//        }
//        if(n == 1){
//            return nums[0]==target ? true:false;
//        }
//        int l = 0;
//        int r = n-1;
//        while(l<=r){
//            int mid = l+(r-l)/2;
//            if(nums[mid] == target){
//                return true;
//            }
//            //判断nums[l]和nums[mid]的关系
//            //1. nums[l] == nums[mid] 无法判断mid在左区间还是右区间 l++去掉一个干扰项
//            if(nums[l] == nums[mid]){
//                l++;
//                continue;
//            }else if(nums[l]<nums[mid]){
//                //2. mid在左区间 && nums[l]<target<nums[mid] 左区间找
//                if(nums[l]<=target && target<nums[mid]){
//                    r = mid-1;
//                }else{
//                    //否则去右区间找
//                    l = mid+1;
//                }
//            }else if(nums[l]>nums[mid]){
//                //3. mid在右区间 && nums[mid]<target && target<nums[r] 右区间找
//                if(nums[mid]<target && target<=nums[r]){
//                    l = mid+1;
//                }else{
//                    //否则去左区间找
//                    r = mid-1;
//                }
//            }
//        }
//        return false;
//    }

//    // 与左端点比较  <
//    public static boolean search(int[] nums, int target){
//        int n = nums.length;
//        int l = 0;
//        int r = n-1;
//        while(l<r){
//            int mid = l+(r-l)/2;
//            //左区间递增
//            if(nums[l]<nums[mid]){
//                //target在左区间
//                if(nums[l]<=target && target<=nums[mid]){
//                    r = mid;
//                }else{
//                    //否则在右区间
//                    l = mid+1;
//                }
//            }else if(nums[l]>nums[mid]){
//                //右区间递增
//                if(nums[mid]<target && target<=nums[r]){
//                    //target在右区间
//                    l = mid+1;
//                }else{
//                    //否则在左区间
//                    r = mid;
//                }
//            }else{
//                //左区间去掉之前需要判断是否相等
//                if(nums[l]==target){
//                    return true;
//                }else{
//                    l++;
//                }
//            }
//        }
//        //判断一下left
//        return nums[l]==target;
//    }

    //与右端点比较
    public static boolean search(int[] nums, int target){
        int n = nums.length;
        int l = 0;
        int r = n-1;
        while(l<r){
            //取右中点
            int mid = l+(r-l+1)/2;
            //右区间递增
            if(nums[mid]<nums[r]){
                //target在右区间
                if(nums[mid]<=target && target<=nums[r]){
                    l = mid;
                }else{
                    //target在左
                    r = mid-1;
                }
            }else if(nums[mid] > nums[r]){
                //左区间递增
                if(nums[l]<=target && target<nums[mid]){
                    r = mid-1;
                }else{
                    l = mid;
                }
            }else{
                //nums[mid] == nums[r]
                if(nums[r] == target){
                    return true;
                }else{
                    r--;
                }
            }
        }
        return nums[l] == target;
    }
}
