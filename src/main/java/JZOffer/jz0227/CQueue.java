package JZOffer.jz0227;

import java.util.ArrayDeque;

/*
 * @Description: 剑指 Offer 09. 用两个栈实现队列
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )



示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
提示：

1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 13:45
 */
public class CQueue {

    //用来添加数据
    ArrayDeque<Integer> appendStack ;
    //用来删除头部数据
    ArrayDeque<Integer> deleteStack ;

    public CQueue() {
        //初始化两个栈
        appendStack = new ArrayDeque<>();
        deleteStack = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        appendStack.push(value);
    }

    public int deleteHead() {
        //判断两个栈是否都为空
        if(appendStack.isEmpty() && deleteStack.isEmpty()){
            //队列中无元素
            return -1;
        }else if(deleteStack.isEmpty()){
            //将appendStack中的元素全部出栈压栈进入deleteStack
            while(!appendStack.isEmpty()){
                deleteStack.push(appendStack.pop());
            }
            //deleteStack栈顶元素即为队列头部元素
            return deleteStack.pop();
        }else {
            //两个栈都不为空,直接deletetStack头部元素出栈
            return deleteStack.pop();
        }
    }
}
