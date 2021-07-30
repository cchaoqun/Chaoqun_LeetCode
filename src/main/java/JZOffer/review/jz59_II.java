package JZOffer.review;

import java.util.ArrayDeque;
import java.util.Deque;

/**剑指 Offer 59 - II. 队列的最大值
 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

 若队列为空，pop_front 和 max_value 需要返回 -1

 示例 1：

 输入:
 ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 [[],[1],[2],[],[],[]]
 输出: [null,null,null,2,1,2]
 示例 2：

 输入:
 ["MaxQueue","pop_front","max_value"]
 [[],[],[]]
 输出: [null,-1,-1]


 限制：

 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 1 <= value <= 10^5
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/29-19:49
 */

public class jz59_II {
}
class MaxQueue {
    /** 单调栈
     max_value
     返回max队列头
     push_back
     放入queue尾
     出队所有max队尾<value的元素
     value入队尾
     pop_front
     如果front==max头 一起出队

     */
    Deque<Integer> queue;
    Deque<Integer> max;
    public MaxQueue() {
        queue = new ArrayDeque<>();
        max = new ArrayDeque<>();
    }

    public int max_value() {
        return max.isEmpty()?-1:max.peekFirst();
    }

    public void push_back(int value) {
        queue.addLast(value);
        while(!max.isEmpty() && max.peekLast()<value){
            max.pollLast();
        }
        max.addLast(value);
    }

    public int pop_front() {
        int res = -1;
        if(!queue.isEmpty()){
            res = queue.pollFirst();
            if(!max.isEmpty() && max.peekFirst()==res){
                max.pollFirst();
            }
        }
        return res;
    }
}