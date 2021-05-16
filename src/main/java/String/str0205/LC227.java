package String.str0205;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @Description: 227. 基本计算器 II
实现一个基本的计算器来计算一个简单的字符串表达式的值。

字符串表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。

示例 1:

输入: "3+2*2"
输出: 7
示例 2:

输入: " 3/2 "
输出: 1
示例 3:

输入: " 3+5 / 2 "
输出: 5
说明：

你可以假设所给定的表达式都是有效的。
请不要使用内置的库函数 eval。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/basic-calculator-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 12:53
 */
public class LC227 {
    public static void main(String[] args) {
        String s =  "1*2-3/4+5*6-7*8+9/10";
        int res = calculate(s);
        System.out.println(res);
    }

    public static int calculate(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<Character> operStack = new ArrayDeque<>();
        int num1=0, num2=0;
        char oper = ' ', curChar = ' ';
        String conNum = "";
        int index = 0;
        char[] arr = s.toCharArray();
        while(index<s.length()){
            //获取当前字符,不为空格
            while(index<s.length() && arr[index]==' '){
                ++index;
            }
            if(index==s.length()){
                break;
            }
            curChar = arr[index];
            if(isOper(curChar)){
                //字符栈空
                if(operStack.isEmpty()){
                    operStack.push(curChar);
                }else if(priority(curChar)>priority(operStack.peek())){
                    //当前运算符优先级大于字符栈顶运算符优先级
                    operStack.push(curChar);
                }else{
                    //当前运算符优先级小于栈顶运算符优先级
                    //数字栈出栈两个数字
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    //运算符栈出栈一个运算符
                    oper = operStack.pop();
                    //运算
                    int res = cal(num1,num2,oper);
                    //更新符号
                    if(!operStack.isEmpty() && operStack.peek()=='-'){
                        //将运算结果更新为负数,并将-用+代替
                        operStack.pop();
                        operStack.push('+');
                        res = -res;
                    }
                    //运算结果入栈
                    numStack.push(res);
                    //当前运算符入栈
                    operStack.push(curChar);
                }
            }else{
                //当前字符为数字,存在多位数的情况,先将当前数字添加到字符串中
                conNum += curChar;
                //如果当前到达字符串最后一位
                if(index == s.length()-1){
                    //当前数字入栈
                    numStack.push(Integer.parseInt(conNum));
                }else if(index+1<s.length() && (isOper(arr[index+1]) || arr[index+1]==' ')) {
                    //一直到下一位为运算符或者空格将当前数字入栈
                    numStack.push(Integer.parseInt(conNum));
                    //重置链接数字字符串
                    conNum = "";
                }
            }
            index++;
        }
        //运算符栈不为空
        while(!operStack.isEmpty()){
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            int res = cal(num1,num2,oper);
            numStack.push(res);
        }
        return numStack.pop();
    }

    //判断是否是运算符
    public static boolean isOper(char c){
        return (c=='+' || c=='-' || c=='*' || c=='/');
    }

    //比较优先级
    public static int priority(char c){
        if(c=='+' || c=='-'){
            return 1;
        }else{
            return 2;
        }
    }

    //运算
    public static int cal(int num1, int num2, char oper){
        if(oper=='+'){
            return num2 + num1;
        }else if(oper=='-'){
            return num2 - num1;
        }else if(oper=='*'){
            return num2 * num1;
        }else {
            return num2 / num1;
        }
    }

}
