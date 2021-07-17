package Algorithm_HW.Week3;

import java.util.Deque;
import java.util.LinkedList;

/**逆波兰表达式：

 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。

 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 逆波兰表达式主要有以下两个优点：

 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。

 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/14-16:17
 */

public class LC150 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> numStack = new LinkedList<>();
        for(int i=0; i<tokens.length; i++){
            String cur = tokens[i];
            //当前是运算符
            if(isOper(cur)){
                //出栈两个数字
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                //计算的结果入栈
                numStack.push(calc(num1, num2, cur));
            }else{//当前是数字
                numStack.push(parseNum(cur));
            }
        }
        return numStack.pop();

    }

    //判断是否是操作符
    public static boolean isOper(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return true;
        }else{
            return false;
        }
    }

    //字符串转换成数字
    public static int parseNum(String s){
        return Integer.valueOf(s);
    }

    //计算
    public static int calc(int num1, int num2, String oper){
        if(oper.equals("+")){
            return num1 + num2;
        }
        if(oper.equals("-")){
            return num1-num2;
        }
        if(oper.equals("*")){
            return num1 * num2;
        }
        if(oper.equals("/")){
            return num1 / num2;
        }
        return -1;
    }
}
