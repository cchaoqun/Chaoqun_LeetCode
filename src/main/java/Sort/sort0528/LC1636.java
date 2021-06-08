package Sort.sort0528;

import java.util.PriorityQueue;

/**
 * 1636. 按照频率将数组升序排序
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 *
 * 请你返回排序后的数组。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,2,2,3]
 * 输出：[3,1,1,2,2,2]
 * 解释：'3' 频率为 1，'1' 频率为 2，'2' 频率为 3 。
 * 示例 2：
 *
 * 输入：nums = [2,3,1,3,2]
 * 输出：[1,3,3,2,2]
 * 解释：'2' 和 '3' 频率都为 2 ，所以它们之间按照数值本身降序排序。
 * 示例 3：
 *
 * 输入：nums = [-1,1,-6,4,5,-6,1,4,1]
 * 输出：[5,-1,4,4,-6,-6,1,1,1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/28-12:15
 */

public class LC1636 {
    public int[] frequencySort(int[] nums) {
        //count[i] = i-100的count
        int[] count = new int[201];
        for(int i:nums){
            count[i+100]++;
        }
        //o[0]: 频率 o[1] 数值本身
        //频率相等 按照值本身的大小降序, 频率不等, 按照频率升序
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0]);
        for(int i=0; i<201; i++){
            if(count[i]!=0){
                //[-100,100]映射到[0,100]
                pq.offer(new int[]{count[i], i-100});
            }
        }
        int[] res = new int[nums.length];
        int index = 0;
        //取出每个数组, 放入对应次数的数字
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            for(int i=0; i<cur[0]; i++){
                res[index++]=cur[1];
            }
        }
        return res;
    }
}
