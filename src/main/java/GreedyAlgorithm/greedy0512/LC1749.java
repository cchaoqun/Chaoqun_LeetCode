package GreedyAlgorithm.greedy0512;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/12-23:01
 */

public class LC1749 {
    public int maxAbsoluteSum(int[] nums) {
        //最大连续子数组的和(>0)
        int maxSum = 0;
        //最小连续子数组的和(<0)
        int minSum = 0;
        int res = 0;
        for(int i:nums){
            //最大和,
            //如果前面的和<0, 选则以当前元素为新的起点
            //如果前面的和>0, 将当前元素+上
            maxSum = Math.max(maxSum+i, i);
            //更新最大绝对值
            res = Math.max(res, maxSum);
            //如果前面的和<0, 将当前元素+上
            //如果前面的和>0, 选则以当前元素为新的起点
            minSum = Math.min(minSum+i, i);
            //更新最大绝对值
            res = Math.max(res, Math.abs(minSum));
        }
        return res;
    }
}
