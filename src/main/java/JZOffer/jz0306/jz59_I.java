package JZOffer.jz0306;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description:剑指 Offer 59 - I. 滑动窗口的最大值
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
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/6 18:46
 */
public class jz59_I {

    /**
     *单调队列
     * 队列从大到小放入
     * 如果首位值不再窗口区,需要删除
     * 新增的值小于队列尾,加到队列尾
     * 如果新增的值大于队列尾,删除队列中比新增值小的元素,再把新增值加入到队列中
     * 如果新增值大于队列所有值,删除所有,然后把新增值放入队首,保证队列一直从大到小
     */
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length==0 || k==0){
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length-k+1];
        //res数组下标
        int index = 0;
        //窗口未形成
        for(int i=0; i<k; ++i){
            //deque不为空,并且队列尾部元素小于当前值,一直删除队列尾
            while(!deque.isEmpty() && nums[i]>deque.peekLast()){
                deque.removeLast();
            }
            //当前元素入队
            deque.addLast(nums[i]);
        }
        //第一个窗口形成后的最大值添加到结果数组
        //因为下面的循环从k开始跳过了第一窗口
        res[index++] = deque.peekFirst();
        //窗口形成
        for(int i=k; i<nums.length; ++i){
            if(deque.peekFirst() == nums[i-k]){
                //窗口向后移动一位,i-k位置元素已经不再窗口中,需要删除
                deque.removeFirst();
            }
            //当队列尾部元素大于当前元素,一直删除
            while(!deque.isEmpty() && nums[i]>deque.peekLast()){
                deque.removeLast();
            }
            //当前值添加到队列
            deque.addLast(nums[i]);
            //队列首位元素添加到数组
            res[index++] = deque.peekFirst();

        }
        return res;
    }
}
