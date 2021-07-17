package Algorithm_HW.Week5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/3-12:42
 */

public class LC1003 {
    public boolean isValid(String s) {
        /**
         1. 数量匹配 ab = c
         2. 字符匹配 ab==c
         */
        Deque<Character> stack = new ArrayDeque<>();
        for(char cur : s.toCharArray()){
            if(cur=='c'){
                if(stack.isEmpty() || stack.pop()!='b'){
                    return false;
                }
                if(stack.isEmpty() || stack.pop()!='a'){
                    return false;
                }
            }else{
                stack.push(cur);
            }
        }
        return stack.isEmpty();
    }
}
