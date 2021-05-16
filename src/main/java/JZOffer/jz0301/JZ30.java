package JZOffer.jz0301;

import java.util.Stack;

/*
 * @Description: 剑指 Offer 30. 包含min函数的栈
定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。



示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.


提示：

各函数的调用总次数不超过 20000 次


注意：本题与主站 155 题相同：https://leetcode-cn.com/problems/min-stack/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/1 15:41
 */
public class JZ30 {

    private Stack<Integer> data = new Stack<>();
    private Stack<Integer> min = new Stack<>();
    /** initialize your data structure here. */
    public JZ30() {

    }

    public void push(int x) {
        //x入数据栈
        data.push(x);
        //最小值栈为空或者待添加元素小于栈顶元素,入栈
        if(min.isEmpty() || x <= min.peek()){
            min.push(x);
        }
    }

    public void pop() {
        //栈顶元素相等同时出栈
        //这里需要用equals,因为如果pop()返回的是Integer对象,如果在 [-128,127]比较的是值,超出范围比较的是对象是否相同
        if(data.pop().equals(min.peek())){
            min.pop();
        }
    }

    public int top() {
        return data.peek();

    }

    public int min() {
        return min.peek();
    }
}
