package BinarySearch.bs0107;
/*
 * @Description: 162. 寻找峰值

峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设nums[-1] = nums[n] = -∞。

输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5
解释: 你的函数可以返回索引 1，其峰值元素为 2；
    或者返回索引 5， 其峰值元素为 6。
说明:

你的解法应该是 O(logN) 时间复杂度的。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 16:13
 */
public class LC162 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        int res = findPeakElement(nums);
        System.out.println(res);
    }

    /*
     * @Description: 迭代实现
     * 如果中点处在下降区域,那么峰值在左侧
     * 如果中点处在上升区域 峰值处在右侧
     * 如果刚好处在峰值直接返回
     */
    public static int findPeakElement(int[] nums) {
        //如果只有一个元素
        if(nums.length == 1){
            return 0;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            //左中点 mid+1可以保证不越界 所以让 mid和mid+1比较
            //如果让mid与mid-1比较,可以去右中点 mid=left+(right-left+1)/2;
            int mid = left+(right-left)/2;
            if(nums[mid]<nums[mid+1]){
                //上升区域
                left = mid+1;
            }else if(nums[mid]>=nums[mid+1]){
                //下降区域或mid为峰值
                right = mid;
            }
        }
        return left;
    }

    //递归实现
//    public static int findPeakElement(int[] nums){
//        return search(nums,0,nums.length-1);
//
//    }
//
//    public static int search(int[] nums, int l, int r){
//        if(l==r){
//            return l;
//        }
//        int mid = l+(r-l)/2;
//        if(nums[mid]<nums[mid+1]){
//            //上升区域 向右递归
//            return search(nums, mid+1, r);
//        }else{
//            //下降区域 向左递归
//            return search(nums,l,mid);
//        }
//    }
}
