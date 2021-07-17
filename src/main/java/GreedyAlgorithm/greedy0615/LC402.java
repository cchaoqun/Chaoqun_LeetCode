package GreedyAlgorithm.greedy0615;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/15-17:44
 */

public class LC402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        if(num==null || num.length()==0){
            return "0";
        }
        char[] arr = num.toCharArray();
        int len = num.length();
        //遍历所有的字符
        for(int i=0; i<len; i++){
            //当前字符
            char cur = arr[i];
            /** 保证栈的单调不减性
             * 如果栈为空, 当前字符入栈
             * 如果栈不为空, 只要栈顶元素>当前元素 && k>0, 栈顶元素出栈就一直出栈, 每出栈一个元素k--
             * 最后当前元素入栈
             */
            while(!stack.isEmpty() && k>0 && stack.peekLast()>cur){
                stack.pollLast();
                k--;
            }
            stack.offerLast(cur);
        }
        //如果没有减去k个数, 还需要将剩余的数从栈顶减去,
        // 因为栈从底到顶单调不减, 则栈顶的元素一定大于等于地下的元素, 所以从栈顶减去元素一定保证了数字最小
        while(k>0 && !stack.isEmpty()){
            stack.pollLast();
            k--;
        }
        //解决前导0, 从栈底开始将连续的前导0一直减去
        while(!stack.isEmpty() && stack.peekFirst()=='0'){
            stack.pollFirst();
        }
        //StringBuffer从栈底到栈顶连接剩余的字符
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pollFirst());
        }
        //如果没有剩余的字符, 返回0
        if(sb.length()==0){
            return "0";
        }
        return sb.toString();



    }
}
