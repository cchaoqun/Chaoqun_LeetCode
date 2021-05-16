package Stack.stack0221;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/*
 * @Description: 232. 用栈实现队列
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：

实现 MyQueue 类：

void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false


说明：

你只能使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。


进阶：

你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。


示例：

输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]

解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false


提示：

1 <= x <= 9
最多调用 100 次 push、pop、peek 和 empty
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/21 18:08
 */
public class MyQueue {

    //入队的元素直接添加在pushStack最后
    private Deque<Integer> pushStack;
    //当popStack不为空,可以直接出栈popStack最后一个元素
    private Deque<Integer> popStack;

    /** Initialize your data structure here. */
    public MyQueue() {
        pushStack = new ArrayDeque<>();
        popStack = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        //直接添加到pushStack最后
        pushStack.addLast(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        //如果popStack不为空
        if(!popStack.isEmpty()){
            //返回从popStack移除的最后一个元素
            return popStack.removeLast();
        }
        //如果popStack为空,将pushStack中的元素从最后向第一个全部出队并且添加到popStack的最后
        while(!pushStack.isEmpty()){
            popStack.addLast(pushStack.removeLast());
        }
        //出队popStack的最后一个元素
        return popStack.removeLast();
    }

    /** Get the front element. */
    public int peek() {
        //如果popStack不为空
        if(!popStack.isEmpty()){
            //返回最后一个
            return popStack.peekLast();
        }
        //如果popStack为空,依旧将pushStack元素全部从后往前添加到popStack最后
        while(!pushStack.isEmpty()){
            popStack.addLast(pushStack.removeLast());
        }
        return popStack.peekLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        //两个栈都为空
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
