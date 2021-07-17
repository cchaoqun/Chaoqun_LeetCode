package Algorithm_HW.Week7;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/17-11:04
 */

public class AllValidParenthesis_II {
    /**
     * Get all valid permutation of l pair () m pair <> n pair {}
     * @param l ()
     * @param m <>
     * @param n {}
     * @return
     需要找到所有的合法的括号组合
     1. 每一层在做什么
        放入一个括号
            放入左括号
                有左括号就可以放
            放入右括号
                上一个待匹配的左括号刚好能跟我匹配
     2. 每一层有多少种做法
        3种左括号 3种右括号
            遍历每一种可能查看是否可以放
     3. 一共有多少层
        2*(l+m+n)
     4. 什么时候收集解
        所有括号都用完了
        length == 2*(l+m+n)
     */

    @Test
    public void test(){
        List<String> res = validParentheses(1,1,0);
        System.out.println(res);
    }


    private static final char[] allP = new char[]{'(',')','<','>','{','}'};
    public List<String> validParentheses(int l, int m, int n){
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        int[] remain = new int[]{l,l,m,m,n,n};
        int totalLen = 2*(l+m+n);
        backtrack(res,path,stack,remain,totalLen);
        return res;
    }


    private void backtrack(List<String> res,StringBuilder path ,Deque<Character> stack ,int[] remain, int totalLen){
        if(path.length() == totalLen){
            res.add(new String(path));
            return;
        }
        // 遍历所有可能的括号
        for(int i=0; i<allP.length; i++){
            // 左括号
            if(i%2==0){
                //有就可以加
                if(remain[i]>0){
                    //加入path
                    path.append(allP[i]);
                    //stack
                    stack.push(allP[i]);
                    //数量-1
                    remain[i]--;
                    //backtrack
                    backtrack(res,path,stack,remain,totalLen);
                    //path中删除
                    path.deleteCharAt(path.length()-1);
                    //stack中pop
                    stack.pop();
                    //数量+1
                    remain[i]++;
                }
            }else{
                //右括号
                //有这个右括号, 并且有一个对应的左括号在栈顶等待匹配
                if(!stack.isEmpty() && remain[i]>0 && stack.peek()==allP[i-1]){
                    //加入path
                    path.append(allP[i]);
                    //stack中pop对应的左括号
                    stack.pop();
                    //数量-1
                    remain[i]--;
                    backtrack(res,path,stack,remain,totalLen);
                    //从path中删除
                    path.deleteCharAt(path.length()-1);
                    //stack中push对应的右括号
                    stack.push(allP[i-1]);
                    //数量+1
                    remain[i]++;
                }
            }
        }
    }
}





































