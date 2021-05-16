package BinarySearch.bs0107;

import java.util.Arrays;

/*
 * @Description: 209. 长度最小的子数组
给定一个含有n个正整数的数组和一个正整数s ，
找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
如果不存在符合条件的子数组，返回 0。

示例：
输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组[4,3]是该条件下的长度最小的子数组。

进阶：
如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 18:20
 */
public class LC209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int s = 13;
        int res = minSubArrayLen(s,nums);
        System.out.println(res);
    }


    //双指针 O(n) O(1)
//    public static int minSubArrayLen(int s, int[] nums) {
//        if(nums.length==0){
//            return 0;
//        }
//        //定义两个指针分别指向连续子数组的头尾 初始化为0
//        int start = 0, end = 0, sum=0;
//        //定义连续数组的长度
//        int minLen = Integer.MAX_VALUE;
//        //当尾指针没有达到数组末尾
//        while(end<nums.length){
//            //尾指针右移直到子数组的和>=s
//            sum += nums[end];
//            while(sum>=s){
//                minLen = Math.min((end-start+1),minLen);
//                //移除子数组的第一个元素直到 sum<s
//                sum -= nums[start];
//                //start右移
//                start++;
//            }
//            //sum<s end右移
//            end++;
//        }
//        return minLen == Integer.MAX_VALUE ? 0:minLen;
//    }

    //前缀和+二分
    public static int minSubArrayLen(int s, int[] nums){
        if(nums.length == 0 ){
            return 0;
        }
        //前缀和 计算0-(i-1)元素的和存放在i位置
        int[] preSum = new int[nums.length+1];
        //preSum的长度为nums.length+1
        //preSum[0]=0       前0个元素的和为0
        //preSum[1]=nums[0] 前1个元素的和为 nums[0]
        for(int i=1; i<nums.length+1; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        System.out.println(Arrays.toString(preSum));
        //因为每个元素都非负,严格递增,可以二分
        //对于每一个nums[i],在preSum中找到  preSum[bound]-preSum[i] >= s
        //并记录长度
        int minLen = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            if(nums[i]>=s){
                return 1;
            }

            int pos = 0;
            //二分查找满足preSum[bound]-preSum[i-1] >= s的最小bound
            int l = i;
            int r = nums.length;
            while(l<=r){
                int mid = l+(r-l)/2;
                if(preSum[mid]-preSum[i-1] >= s){
                    pos = mid;
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }
            //根据pos==0判断当前的长度是否符合,记录当前长度
            if(pos!=0){
                minLen = Math.min((pos-i+1),minLen);
            }

        }
        return minLen==Integer.MAX_VALUE ? 0:minLen;
    }
}
