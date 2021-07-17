package GreedyAlgorithm.greedy0616;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**1296. 划分数组为连续数字的集合
 给你一个整数数组 nums 和一个正整数 k，请你判断是否可以把这个数组划分成一些由 k 个连续数字组成的集合。
 如果可以，请返回 True；否则，返回 False。



 注意：此题目与 846 重复：https://leetcode-cn.com/problems/hand-of-straights/



 示例 1：

 输入：nums = [1,2,3,3,4,4,5,6], k = 4
 输出：true
 解释：数组可以分成 [1,2,3,4] 和 [3,4,5,6]。
 示例 2：

 输入：nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 输出：true
 解释：数组可以分成 [1,2,3] , [2,3,4] , [3,4,5] 和 [9,10,11]。
 示例 3：

 输入：nums = [3,3,2,2,1,1], k = 3
 输出：true
 示例 4：

 输入：nums = [1,2,3,4], k = 3
 输出：false
 解释：数组不能分成几个大小为 3 的子数组。


 提示：

 1 <= nums.length <= 10^5
 1 <= nums[i] <= 10^9
 1 <= k <= nums.length
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/16-15:57
 */

public class LC1296 {
    /** 排序 map
     统计每个数字出现的个数
     对数组进行排序
     依次遍历排序后的nums,
     获取当前nums[i]的次数 如果为0 continue 说明当前这个数字已经被选完了
     将nums[i]取得的次数-1 put回HashMap
     依次从map中获取 nums[i]+j (j=1,2,...,k-1)
     如果获取到次数为0 return false
     对于每个获取的数次数-1 put回HashMap
     获取到一个完整的k个数的连续序列 总的分组-1
     */
    public boolean isPossibleDivide(int[] nums, int k) {

        if(nums.length % k != 0){
            return false;
        }
        int n = nums.length;
        int size = n / k;
        //统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for(int i:nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        //排序
        Arrays.sort(nums);
        //遍历每个数字作为k个连续数的起始点
        int index = -1;
        while(size>0){
            index++;
            //当前数字出现的次数
            int cur = nums[index];
            int count = map.get(cur);
            //当前数字出现在了之前的区间里, 已经用完了, 继续下一个
            if(count==0){
                continue;
            }
            //当前数字的次数-1
            map.put(cur, count-1);
            //依次获取后面的连续的k-1个数, 这些数都是确定的 cur+i
            for(int i=1; i<=k-1; i++){
                //r如果这些数字不存在, return false
                int temp = map.getOrDefault(cur+i,0);
                if(temp==0){
                    return false;
                }
                //如果存在, 出现次数-1并且put回map
                map.put(cur+i, temp-1);
            }
            //获取一个连续的k个数后 需要的分组-1
            size--;
        }
        return true;
    }
}

class LC1296_M2{
    //优先队列
    public boolean isPossibleDivide(int[] nums, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i:nums){
            heap.offer(i);
        }
        while(!heap.isEmpty()){
            //获取最小的数
            int top = heap.poll();
            //依次从堆中删除后续连续的k-1个数
            for(int i=1; i<=k-1; i++){
                //如果不能删除, return false;
                if(!heap.remove(top+i)) {
                    return false;
                }
            }

        }
        return true;
    }
}


































