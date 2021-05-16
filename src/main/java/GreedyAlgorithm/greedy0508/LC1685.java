package GreedyAlgorithm.greedy0508;

/**
 * 1685. 有序数组中差绝对值之和
 * 给你一个 非递减 有序整数数组 nums 。
 *
 * 请你建立并返回一个整数数组 result，它跟 nums 长度相同，且result[i] 等于 nums[i] 与数组中所有其他元素差的绝对值之和。
 *
 * 换句话说， result[i] 等于 sum(|nums[i]-nums[j]|) ，其中 0 <= j < nums.length 且 j != i （下标从 0 开始）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,5]
 * 输出：[4,3,5]
 * 解释：假设数组下标从 0 开始，那么
 * result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4，
 * result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3，
 * result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5。
 * 示例 2：
 *
 * 输入：nums = [1,4,6,8,10]
 * 输出：[24,15,13,15,21]
 *
 *
 * 提示：
 *
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= nums[i + 1] <= 104
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/8-14:43
 */

public class LC1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        //nums[i-1]与[0, i-2]差的绝对值
        int pre = 0;
        //nums[i-1]与[i, len-1]差的绝对值
        int post = 0;
        int len = nums.length;
        int[] res = new int[len];
        //计算第一个元素与后面所有元素的差的和(非递减,大减小即可)
        for(int i=1; i<len; i++){
            post += nums[i]-nums[0];
        }
        //pre=0
        res[0] = pre+post;
        //从i=1开始计算后续元素对应的值
        for(int i=1; i<len; i++){
            //当前元素与前一个元素的差
            int diff = nums[i]-nums[i-1];
            //对于nums[i] 与 [i+1, len-1]差的和
            //因为nums[i-1]<=nums[i], 当前元素在nums[i-1]的post的基础上每一个都少了diff, 因为被减数大了
            //[i+1, len-1]一共有 len-1-(i+1)+1=len-1-i个元素, 所以要*diff这么多次
            //无需考虑减去 diff(nums[i-1]的post 包括了 nums[i-1]-nums[i], 但是pre里少了 nums[i]-nums[i-1]  刚好抵消了)
            post -= (len-1-i)*(diff);
            //对于nums[i] 与 [0, i-2]差的和
            //在nums[i-1]的pre的基础上, 每个差都需要加上diff, 因为被减数大了
            //[0,i-2]一共i-2-0+1 = i-1个数, 每个差都需要加上diff
            pre += (i-1)*(diff);
            //当前元素对应的结果为pre + post
            res[i] = pre+post;
        }
        return res;
    }
}

class LC1685_M2{
    public int[] getSumAbsoluteDifferences(int[] nums){
        int len = nums.length;
        //prefixSum[i] = sum[0,i]
        int[] prefixSum = new int[len];
        int[] res = new int[len];
        prefixSum[0] = nums[0];
        for(int i=1; i<len; i++){
            prefixSum[i] += prefixSum[i-1]+nums[i];
        }
        int left = 0;
        int right = 0;
        //[1,len-1]所有元素的和 - nums[0]*(1到最后一个元素的个数)
        res[0] = prefixSum[len-1]- prefixSum[0] - nums[0]*(len-1-0);
        for(int i=1; i<len; i++){
            //当前元素*左边元素个数 - 左边的元素和
            left = nums[i]*(i) - prefixSum[i-1];
            //右边的元素和 - 当前元素*右边元素个数
            right = prefixSum[len-1]-prefixSum[i] - nums[i]*(len-1-(i+1)+1);
            res[i] = left+right;
        }
        return res;
    }
}
