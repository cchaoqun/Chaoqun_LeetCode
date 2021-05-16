package String.str0204;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 22. 括号生成
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

 

示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]
 

提示：

1 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/generate-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/4 14:48
 */
public class LC22 {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        System.out.println(res);
    }
    public static  List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n==0){
            return res;
        }
//        String comb = "";
//        dfs(n,n,res,comb,n);
        StringBuilder comb1 = new StringBuilder();
        dfs1(n,n,res,comb1,n);
        return res;
    }

    public static void dfs(int left, int right, List<String> res, String comb, int n){
        if(left==0 && right==0){
            res.add(comb);
            return;
        }
        //剩余可用左括号数量严格大于右括号,则路径中右括号数量大于左括号,返回
        if(left>right ){
            return;
        }
        //剩余可用左括号.添加左括号
        if(left>0){
            dfs(left-1,right,res,comb+"(",n);
        }
        //剩余可用右括号,添加右括号
        if(right>0){
            dfs(left,right-1,res,comb+")", n);
        }

    }

    //利用StringBuilder 需要回溯,因为全程只有一个变量StringBuilder,回到递归处需要删除最后一个元素
    public static void dfs1(int left,int right, List<String> res, StringBuilder comb, int n){
        if(left==0 && right==0){
            res.add(comb.toString());
            return;
        }
        if(left>right){
            return;
        }
        if(left>0){
            comb.append("(");
            dfs1(left-1,right,res,comb,n);
            //重置
            comb.deleteCharAt(comb.length()-1);
        }
        if(right>0){
            comb.append(")");
            dfs1(left,right-1,res,comb,n);
            comb.deleteCharAt(comb.length()-1);
        }
    }

}
