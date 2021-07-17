package Algorithm_HW.Week6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/10-11:20
 */

public class LC22 {
    public List<String> generateParenthesis(int n) {
        /**
         每一层做什么
         放一个单括号
         有多少种选择
         左 left>0
         右 left < right
         一共做多少层
         2^n
         */
        List<String> res = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        backtrack(res, path, n, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuffer path, int left, int right){
        //所有的括号都用完了
        if(left==0 && right==0){
            res.add(new String(path));
            return;
        }
        // 只要有左就可以加
        if(left>0){
            path.append("(");
            backtrack(res, path, left-1, right);
            path.deleteCharAt(path.length()-1);
        }
        // 左括号的数量<右括号的数量 可以加右括号
        if(left<right){
            path.append(")");
            backtrack(res, path, left, right-1);
            path.deleteCharAt(path.length()-1);
        }
    }

    
}
