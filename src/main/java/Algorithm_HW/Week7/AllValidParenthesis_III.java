package Algorithm_HW.Week7;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/17-11:29
 */

public class AllValidParenthesis_III {
    /** priority subject to {} higher than <> higher than ()
     什么是一个解?
        所有的括号都用完了
            左括号 有, 并且前一个左括号的优先级要大于当前的左括号
            右括号 有, 并且离当前右括号最近的左括号就是这个右括号对应的左括号
     每一层做什么?
        放入一个括号
     有多少层?
        2*(l+m+n)
     *
     *
     *
     *
     */

    @Test
    public void test(){
        List<String> res = validParentheses(2,0,1);
        System.out.println(res);
    }


    private static final char[] allP = new char[]{'(',')','<','>','{','}'};
    private static Map<Character, Integer> priority = new HashMap<>();


    public List<String> validParentheses(int l, int m, int n){
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        int[] remain = new int[]{l,l,m,m,n,n};
        int totalLen = 2*(l+m+n);
        priority.put('(',0);
        priority.put('<',1);
        priority.put('{',2);
        backtrack(res, path, stack, remain, totalLen);
        return res;
    }

    private void backtrack(List<String> res,StringBuilder path ,Deque<Character> stack ,int[] remain, int totalLen){
        //收集解
        if(path.length()==totalLen){
            res.add(new String(path));
            return ;
        }
        // 遍历每个括号
        for(int i=0; i<allP.length; i++){
            // 偶数 左括号
            if((i&1)==0){
                // 有
                if(remain[i]>0){
                    //上一个优先级小于当前这个 不可以加
                    if(!stack.isEmpty() && priority.get(stack.peek())<=priority.get(allP[i])){
                        continue;
                    }
                    // 上一个优先级大于当前 或者 栈空
                    // 加入path
                    path.append(allP[i]);
                    // 加入stack
                    stack.push(allP[i]);
                    // 数量-1
                    remain[i]--;
                    backtrack(res, path, stack, remain, totalLen);
                    // path中移除
                    path.deleteCharAt(path.length()-1);
                    // stack pop
                    stack.pop();
                    // 数量+1
                    remain[i]++;
                }
            }else{
                // 奇数 右括号
                //有 并且 当前栈顶的括号需要与右括号匹配
                if(remain[i]>0 && !stack.isEmpty() && stack.peek()==allP[i-1]){
                    // 加入path
                    path.append(allP[i]);
                    // stack.pop
                    stack.pop();
                    // 数量-1
                    remain[i]--;
                    backtrack(res, path,  stack, remain, totalLen);
                    // path中移除
                    path.deleteCharAt(path.length()-1);
                    // stack.push(allP[i-1])
                    stack.push(allP[i-1]);
                    // 数量+1
                    remain[i]++;

                }
            }
        }

    }
}



















































