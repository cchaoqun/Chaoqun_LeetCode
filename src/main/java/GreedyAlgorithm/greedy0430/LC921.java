package GreedyAlgorithm.greedy0430;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 921. 使括号有效的最少添加
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 *
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 *
 *
 *
 * 示例 1：
 *
 * 输入："())"
 * 输出：1
 * 示例 2：
 *
 * 输入："((("
 * 输出：3
 * 示例 3：
 *
 * 输入："()"
 * 输出：0
 * 示例 4：
 *
 * 输入："()))(("
 * 输出：4
 *
 *
 * 提示：
 *
 * S.length <= 1000
 * S 只包含 '(' 和 ')' 字符。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/30-18:05
 */

public class LC921 {
    public int minAddToMakeValid(String S){
        //'('的数量
        int left = 0;
        //')'的数量
        int right = 0;
        for(char c:S.toCharArray()){
            //当前为'(' left++
            if(c=='('){
                left++;
            }else if(left>0){
                //当前为')' 并且有左括号, 消除一个左括号
                left--;
            }else{
                //左边没有左括号, 右括号++
                right++;
            }
        }
        //left right 表示的为剩余的未被消除的左右括号数量
        return left+right;
    }
}

class LC921_M2{
    //辅助栈
    public int minAddToMakeValid(String S) {
        Deque<Character> stack = new LinkedList<>();
        for(char c: S.toCharArray()){
            //空栈, 当前为左括号, 栈顶为右括号, 当前字符入栈
            if(stack.isEmpty() || c=='(' || stack.peek()==')'){
                stack.push(c);
            }else{
                //否则栈顶为左括号 当前为右括号 可以消除
                stack.pop();
            }
        }
        //栈内剩余的括号数量
        return stack.size();
    }
}
































