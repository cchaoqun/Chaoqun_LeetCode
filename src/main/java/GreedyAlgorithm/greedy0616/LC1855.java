package GreedyAlgorithm.greedy0616;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/16-14:09
 */

public class LC1855 {
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        /** 记录前一个i 使得nums1[i]<=nums2[j] 并且 j-i最大的i
         对于nums2[j+1] nums2[j+1]<nums2[j] nums1[i-1]>nums2[j]>nums2[j+1]
         所以从j+1 只需要从i+1开始往右找即可
         */
        //对于每一个j当前第一个在nums1数组中比较的下标, 因为nums1[0:start-1]一定都>nums2[j]
        int start = 0;
        for(int j=0; j<n2; j++){
            //对于相同的数找到最右边的下标, 这样对于相同的nums1[i] 一定是最右边的nums[j]导致的下标距离最大
            while(j<n2-1 && nums2[j]==nums2[j+1]){
                j++;
            }
            //nums1[start-1]一定是>nums[j]的
            for(int i=start; i<n1 && i<=j; i++){
                //如果nums1[i]>nums2[j] start需要更显因为[0:start]一定>nums2[j]
                //如果nums1[i]<=nums2[j] 一定会进入下边的条件判断 并且跳出了循环,
                //  那么 start一定是第一个小于nums2[j]的下标
                //更新start
                start = i;
                //从左到右找到第一个<=nums2[j]的数
                if(nums1[i]<=nums2[j]){
                    //更新最大距离
                    maxDist = Math.max(maxDist, j-i);
                    //因为从左到右, 找到的第一个一定是最大的, 直接跳出循环找下一个j+1的最大距离
                    break;
                }

            }
        }
        return maxDist;
    }
}

class LC1855_M2{
    //双指针
    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDist = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        //nums1的指针
        int i = 0;
        /**
         * 双指针 i j
         * i,j初始指向0, 对于nums2中每一段连续的相同的数, j直接走到连续相等元素的最右边的边界
         * i从当前值开始 在保证 i不越界(i<n1) 并且i<=j 并且 nums1[i]>nums2[j] i++
         * 找到第一个nums1[i]<=nums[j]这种情况 对于当前的j来说j-i一定是最大的
         * 更新maxDist
         * 下一个i还是保持在当前值, 因为nums1[i-1]>nums2[j]>=nums2[j+1] 但是nums1[i]<=nums2[j] 可能同时nums1[i]<=nums2[j+1]
         */
        for(int j=0; j<n2; j++){
            //找到连续相等区间的右端点
            while(j<n2-1 && nums2[j]==nums2[j+1]){
                j++;
            }
            //找到第一个i使得nums1[i]<=nums2[j]
            while(i<n1 && i<=j && nums1[i]>nums2[j]){
                i++;
            }
            //如果i不越界更新最大距离
            if(i<n1){
                maxDist = Math.max(maxDist, j-i);
            }else{
                //直接结束
                return maxDist;
            }
        }
        return maxDist;
    }
}































