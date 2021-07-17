package company.bytedance;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/30-22:22
 */

public class LC20 {
    public boolean isValid(String s) {
        /**
         左括号入栈,
         遇到右括号, 栈顶如果不配对 return false
         如果配对, 出栈,
         最后栈空 return true

         */
        int n = s.length();
        if((n&1)==1){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new LinkedList<>();
        for(char cur : s.toCharArray()){
            if(!map.containsKey(cur)){
                stack.push(cur);
            }else{
                if(stack.isEmpty() || stack.pop()!=map.get(cur)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isLeft(char c){
        return c=='(' || c=='[' || c=='{';
    }

    private boolean match(char left, char right){
        if(left=='('){
            return right==')';
        }else if(left=='['){
            return right==']';
        }
        else{
            return right=='}';
        }

    }
}
