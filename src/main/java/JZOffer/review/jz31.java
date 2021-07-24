package JZOffer.review;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-13:50
 */

public class jz31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for(int i=0; i<pushed.length; i++){
            //压栈
            stack.push(pushed[i]);
            //栈顶元素等于popped[j] 出栈
            while(!stack.isEmpty() && stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();

    }
}
