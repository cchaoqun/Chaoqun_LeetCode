package Algorithm_HW.exam;

import org.junit.jupiter.api.Test;

/**
 * n integers divide the set into 2 n/2 sizes each such that difference between the sum of 2 subsets is as minimum as possible
 * return the minimum difference
 * n>=2
 * High level
 *      每一层分配到一个set  setA setB
 *      怎么分, 要么 setA 要么 setB
 *      一共多少层 n层
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/24-8:36
 */

public class exam0724 {

    @Test
    public void test(){
        int[] nums = {1,2,3,4};
        int min  = miniDiff(nums);
        System.out.println(min);
    }


    public int miniDiff(int[] nums){
        int total = getSum(nums, 0);
        int[] min = new int[]{total};
        int sumA = 0;
        int index = 0;
        int size = 0;
        backtrack(nums, min, index, sumA, total, size);
        return min[0];
    }

    /**
     *
     * @param nums 需要分割的数组
     * @param min   当前分割的两个数组和的最小值
     * @param index 当前决定加入A还是B的元素在nums中的下标
     * @param sumA  当前加入到setA中元素的和
     * @param total nums数组的和
     * @param size  当前加入到setA中的元素个数
     */
    void backtrack(int[] nums, int[] min, int index, int sumA, int total, int size){
        if(index==nums.length){
            //更新两个set最小的差                sumB       -  sumA
            min[0] = Math.min(min[0], Math.abs(total-sumA - sumA));
            return;
        }
        // setA已经放了nums.length/2的元素 不需要再放了
        if(size==nums.length/2){
            //更新两个set最小的差                sumB       -  sumA
            min[0] = Math.min(min[0], Math.abs(total-sumA - sumA));
            return;
        }
        //setA 还没有放到一半的元素可以放
        if(size<nums.length/2){
            //当前元素加到A
            sumA += nums[index];
            backtrack(nums, min, index+1, sumA, total, size+1);
            sumA -= nums[index];
        }

        //当前元素加到B
        backtrack(nums, min, index+1, sumA, total, size);
    }

    /**
     * 返回从 index开始的nums数组的和 sum[index, nums.length-1]
     * @param nums
     * @param index
     * @return
     */
    private int getSum(int[] nums, int index){
        if(index==nums.length-1){
            return nums[index];
        }
        return nums[index] + getSum(nums, index+1);
    }



}
