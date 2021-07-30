package JZOffer.review;

import java.util.ArrayDeque;
import java.util.Deque;

/**剑指 Offer 59 - I. 滑动窗口的最大值
 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

 示例:

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


 提示：

 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/

 通过次数116,731提交次数263,035
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/29-18:07
 */

public class jz59_I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null || nums.length==0){
            return new int[0];
        }
        /**单调队列
         i=-(k-1) j = 0
         删除 i>0 nums[i-1] 增加 nums[j]
         如果队列头的数等于 nums[i-1]删除
         将队列中所有<nums[j]的数都出队
         nums[j]入队
         最后一个窗口左边界 len-1-i+1 = k ==> i = len-k
         //一共有 len-k-0+1 = len-k+1个数
         */
        Deque<Integer> queue = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len-k+1];
        int index = 0;
        int i = 0, j = 0;
        //初始化第一个窗口
        while(j<k){
            //因为第一个窗口未形成, 只需要考虑添加nums[j] 只要队列不为空并且队列尾的元素<nums[j] 就出列
            while(!queue.isEmpty() && queue.peekLast()<nums[j]){
                queue.pollLast();
            }
            // nums[j]加进去
            queue.offer(nums[j]);
            j++;
        }
        //第一个窗口的最大值
        res[index++] = queue.peekFirst();
        //一次更新 i++ j++
        for(i=1; i<=len-k; i++){
            //需要删除nums[i-1] 确认是否队列头==nums[i-1]是就删除
            if(nums[i-1]==queue.peekFirst()){
                queue.pollFirst();
            }
            // 添加nums[j] 删除所有小于nums[j]的元素
            while(!queue.isEmpty() && queue.peekLast()<nums[j]){
                queue.pollLast();
            }
            // nums[j]加进去
            queue.offer(nums[j]);
            // 添加当前窗口最大值
            res[index++] = queue.peekFirst();
            j++;
        }
        return res;
    }
}
