package Algorithm_HW.Week5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/3-12:42
 */

public class LC224 {
    public int evalRPN(String[] tokens) {
        /**
         1. 遇到数字 放入 stack
         2. 遇到运算符 从stack中取出两个数进行运算后放入栈

         */
        Deque<Integer> stack = new ArrayDeque<>();
        Set<String> opers = new HashSet<>();
        opers.add("+");
        opers.add("-");
        opers.add("*");
        opers.add("/");
        for(String str : tokens){
            if(opers.contains(str)){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(evaluate(str, num1, num2));
            }else{
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();


    }

    private int evaluate(String ope, int num1, int num2){
        if(ope.equals("+")){
            return num2+num1;
        }
        if(ope.equals("-")){
            return num2-num1;
        }
        if(ope.equals("*")){
            return num2*num1;
        }
        if(ope.equals("/")){
            return num2/num1;
        }
        return 0;
    }
}
