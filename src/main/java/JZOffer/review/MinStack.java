package JZOffer.review;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-13:28
 */

public class MinStack {
    Deque<Integer> stack ;
    Deque<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack  = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek()>=x){
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()){
            return;
        }
        int cur = stack.pop();
        if(!minStack.isEmpty() && minStack.peek().equals(cur)){
            minStack.pop();
        }
    }

    public int top() {
        return stack.isEmpty()? 0 : stack.peek();
    }

    public int min() {
        return minStack.isEmpty()? 0 : minStack.peek();
    }
}
