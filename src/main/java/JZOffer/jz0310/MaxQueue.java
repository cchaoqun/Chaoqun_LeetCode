package JZOffer.jz0310;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description:剑指 Offer 59 - II. 队列的最大值
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
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/10 8:56
 */
public class MaxQueue {

    //存放数据的队列
    Queue<Integer> data;
    //存放最大值的单调队列
    Deque<Integer> maxVal;
    public MaxQueue() {
        //初始化
        data  = new LinkedList<>();
        maxVal  = new LinkedList<>();
    }

    public int max_value() {
        //空 -> -1
        //不空 -> 双端队列头
        return maxVal.size()==0? -1 : maxVal.peekFirst();
    }

    public void push_back(int value) {
        //添加到数据队列尾
        data.offer(value);
        //存放最大值的双端队列不为空且尾部结点数据小于当前待添加数据
        while(maxVal.size()!=0 && maxVal.peekLast()<value){
            //尾部出队直到尾部>=value
            maxVal.pollLast();
        }
        //当前value入队尾
        maxVal.addLast(value);
    }

    public int pop_front() {
        //数据队列空 -> -1
        if(data.size()==0){
            return -1;
        }
        //最大值队列不为空且当前数据队列头==最大值队列头
        if(maxVal.size()!=0 && data.peek().equals(maxVal.peekFirst())){
            //两队列头相等时同时出队
            maxVal.pollFirst();
        }
        return data.poll();

    }

}
