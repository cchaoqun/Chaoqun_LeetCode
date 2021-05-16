package BinarySearch.bs0108;
/*
 * @Description:154. 寻找旋转排序数组中的最小值 II

假设按照升序排序的数组在预先未知的某个点上进行了旋转。
( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
请找出其中最小的元素。
注意数组中可能存在重复的元素。

示例 1：
输入: [1,3,5]
输出: 1
*
示例2：
输入: [2,2,2,0,1]
输出: 0
说明：

这道题是寻找旋转排序数组中的最小值的延伸题目。
允许重复会影响算法的时间复杂度吗？会如何影响，为什么？

 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/8 16:06
 */
public class Hard_LC154 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,3,4,4,4,5,5,0,1,2,2,2,2,2};
        int res = findMin(nums);
        System.out.println(res);

    }

    //二分,每次缩减完判断缩减的数组是否已经排序
    public static int findMin(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if(n==1){
            return nums[0];
        }
        //数组已经有序,第一个元素为最小值
        if(nums[0]<nums[n-1]){
            return nums[0];
        }
        //二分
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            //变化后需判断数组是否有序
            if(nums[l]<nums[r]){
                return nums[l];
            }
            int mid = l+(r-l)/2;
            //与左端点比较
            if(nums[mid]>nums[l]){
                //最小值在右区间
                l = mid+1;
            }else if(nums[mid]<nums[l]){
                //最小值在左区间
                r = mid;
            }else if(nums[mid]==nums[l]){
                //与左端点相等无法判断在左还是右区间
                //去掉起始点
                l++;
            }
        }
        return nums[l];
    }
}
