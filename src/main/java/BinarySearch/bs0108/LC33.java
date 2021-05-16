package BinarySearch.bs0108;
/*
 * @Description: 33. 搜索旋转排序数组
升序排列的整数数组 nums 在预先未知的某个点上进行了旋转
（例如， [0,1,2,4,5,6,7] 经旋转后可能变为[4,5,6,7,0,1,2] ）。

请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1。
*
示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
*
示例2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1
*
示例 3：
输入：nums = [1], target = 0
输出：-1

提示：
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
nums 肯定会在某个点上旋转
-10^4 <= target <= 10^4

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/8 8:46
 */
public class LC33 {
    public static void main(String[] args) {
        int[] nums = {5,1,3};
        int res = search(nums,3);
        System.out.println(res);
    }

    public static int search(int[] nums, int target) {
        //判断是否已经是升序
        if(nums[nums.length-1]>nums[0]){
            //直接在整个区间二分查找
            return helper(nums,target,0,nums.length);
        }
        //判断0
        if(nums.length==0 || nums==null){
            return -1;
        }
        //先利用二分找到旋转点
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            //与右端点比较
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else if(nums[mid]<=nums[right]){
                right = mid;
            }
        }
        //旋转点为left,确定旋转点可以确定左右两个旋转区间
        int pivot = left;
        if(target == nums[pivot]){
            return pivot;
        }
        //判断target在左升序区间还是右升序区间
        //左右两边都是升序,再进行二分
        //右端点>target 在右升序区间
        //右端点<target 在左升序区间
        if(nums[nums.length-1]>=target){
            //右升序区间
            return helper(nums,target,pivot,nums.length);
        }else{
            //左升序区间
            return helper(nums,target,0,pivot);
        }

    }

    public static int helper(int[] nums, int target, int lBound, int rBound) {
        int l = lBound;
        int r = rBound;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (target == nums[m]) {
                return m;
            } else if (target < nums[m]) {
                r = m;
            } else if (target > nums[m]) {
                l = m + 1;
            }
        }
        return -1;
    }

}
