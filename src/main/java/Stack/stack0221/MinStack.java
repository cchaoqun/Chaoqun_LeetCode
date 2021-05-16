package Stack.stack0221;

import java.util.*;

/*
 * @Description: 155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。


示例:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.


提示：

pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/21 16:40
 */
public class MinStack {

    //数据栈
    private Stack<Integer> data;
    //辅助栈
    private Stack<Integer> helper;

    public MinStack(){
        data = new Stack<>();
        helper = new Stack<>();
    }

    //辅助栈和数据栈不同步
    public void push(int x){
        data.add(x);
        //只有当辅助栈栈顶元素大于当前添加的元素时才会将x添加到辅助栈
        if(helper.isEmpty() || helper.peek()>=x){
            helper.add(x);
        }
    }

    public void pop(){
        if(!data.isEmpty()){
            int top = data.pop();
            //当出栈数据与辅助栈顶元素相同时才会出栈
            if(top==helper.peek()){
                helper.pop();
            }
        }

        throw new RuntimeException("栈空,操作异常");
    }

    public int top(){
        if(!data.isEmpty()){
            return data.peek();
        }
        throw new RuntimeException("栈空,操作异常");
    }

    public int getMin(){
        if(!helper.isEmpty()){
            return helper.peek();
        }
        throw new RuntimeException("栈空,操作异常");
    }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
