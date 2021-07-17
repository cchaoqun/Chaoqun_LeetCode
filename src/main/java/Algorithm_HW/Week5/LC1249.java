package Algorithm_HW.Week5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/3-12:42
 */

public class LC1249 {
    public String minRemoveToMakeValid(String s) {
        /**
         1. 保留匹配的括号对
         2. 没有匹配的左括号 || 右括号 删除
         3. 遇到左括号 对应的index入栈
         4. 遇到右括号 出栈一个左括号, 如果栈空, index放入set
         5. 结束 栈中左括号下标放入set
         6. 遍历s 跳过下标存在于set中的字符
         */
        Deque<Integer> stack = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur == '('){
                stack.push(i);
            }else if(cur==')'){
                if(stack.isEmpty()){
                    set.add(i);
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            set.add(stack.pop());
        }
        for(int i=0; i<s.length(); i++){
            if(!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
