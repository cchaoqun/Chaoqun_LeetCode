package company.frequence;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/8-13:07
 */

public class LC32 {
    public int longestValidParentheses(String s) {
        /**
         栈内push -1
         遇到左括号对应下标入栈
         遇到右括号
         pop
         如果栈空, 当前右括号没有被匹配, 对应下标入栈
         如果栈不为空, 当前右括号匹配了, 匹配的长度为两个下标的差
         栈顶的元素表示当前第一个没有被匹配的括号的下标
         所以当前元素如果匹配了, 从当前下标到栈顶下标之间都匹配了
         */
        if(s==null || s.length()==0){
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        //最开始代表第一个元素一定没有被匹配
        stack.push(-1);
        int index = 0;
        int max = 0;
        for(char cur : s.toCharArray()){
            // 左括号入栈
            if(cur=='('){
                stack.push(index);
            }else{
                // 右括号先pop
                stack.pop();
                // 如果栈空 说明当前右括号是最后一个没有被匹配的括号
                if(stack.isEmpty()){
                    // 入栈
                    stack.push(index);
                }else{
                    // 当前右括号匹配了, 说明从当前最后一个没有被匹配的位置到当前位置都匹配, 匹配长度为 index-stack.peek()
                    max = Math.max(max, index-stack.peek());
                }
            }
            index++;
        }
        return max;

    }
}

class LC32_M2{
    public int longestValidParentheses(String s) {
        /**
         int[] dp = new int[s.length()]
         dp[i] = i位置结尾的子串中最长的连续配对括号的个数
         如果 s.charAt(i) == '(' dp[i] = 0
         如果 s.charAt(i) == ')' 如果 i i-1配对 = dp[i-2]+2

         如果不配对  i-dp[i-1]-1是'(' = dp[i-1] + dp[i-dp[i-1]-2]+2
         dp[i-1] = i-dp[i-1] ~ i配对的长度
         dp[i-dp[i-1]-2] = i-dp[i-1]-2结尾的长度
         2 dp[i-dp[i-1]-1] 与 i配对长度+2
         */
        if(s==null || s.length()==0){
            return 0;
        }
        int len = s.length();
        int max = 0;
        int[] dp = new int[len];
        char[] arr = s.toCharArray();
        for(int i=1; i<len; i++){
            //左括号结尾一定不是有效括号
            if(arr[i]=='('){
                dp[i] = 0;
            }else if(arr[i]==')'){
                // 右括号
                //前一个是左括号
                if(arr[i-1]=='('){
                    //配对成2个长度
                    dp[i] = 2;
                    // 加上i-2位置结尾的有效括号长度
                    if(i-2>=0){
                        dp[i] += dp[i-2];
                    }
                }else if(arr[i-1]==')') {// 前一个右括号
                    //如果前一个位置结尾的有效括号子串开头前一个位置是'('
                    // 这个左括号会和当前位置的')'配对
                    if(i-dp[i-1]-1>=0 && arr[i-dp[i-1]-1]=='('){
                        //在dp[i-1]结尾的基础上长度+2
                        dp[i] = dp[i-1]+2;
                        //再加上与当前括号配对的左括号前一个位置结尾的长度
                        if(i-dp[i-1]-2>=0){
                            dp[i] += dp[i-dp[i-1]-2];
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;


    }
}
