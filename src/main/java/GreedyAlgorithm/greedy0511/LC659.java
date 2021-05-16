package GreedyAlgorithm.greedy0511;

import java.util.HashMap;
import java.util.Map;

/**
 * 659. 分割数组为连续子序列
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
 *
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 *
 *
 *
 * 示例 1：
 *
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * 示例 2：
 *
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 示例 3：
 *
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 10000
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/11-21:13
 */

public class LC659 {
    public boolean isPossible(int[] nums){
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for(int i:nums){
            countMap.put(i, countMap.getOrDefault(i,0)+1);
        }
        for(int n:nums){
            //n的个数
            int cur = countMap.getOrDefault(n,0);
            if(cur>0){
                //以n-1结尾的序列的个数
                int preEndCount = endMap.getOrDefault(n-1,0);
                if(preEndCount>0){
                    //用掉了一个n
                    countMap.put(n, cur-1);
                    //将一个n加入到一个以n-1结尾的序列
                    //n-1结尾的序列个数-1
                    endMap.put(n-1, preEndCount-1);
                    //以n结尾的序列个数+1
                    endMap.put(n, endMap.getOrDefault(n,0)+1);
                }else{
                    //没有以n-1结尾的序列,需要新建一个以n开头长度为3的连续序列
                    //因此,n+1 n+2 必须存在 否则不能构成
                    int next1 = countMap.getOrDefault(n+1,0);
                    int next2 = countMap.getOrDefault(n+2,0);
                    if(next1>0 && next2>0){
                        countMap.put(n+1, next1-1);
                        countMap.put(n+2, next2-1);
                        countMap.put(n, cur-1);
                        endMap.put(n+2, endMap.getOrDefault(n+2,0)+1);
                    }else{
                        return false;
                    }
                }

            }
        }
        return true;

    }
}



































