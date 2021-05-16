package NumList.List0131;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 216. 组合总和 III
找出所有相加之和为n 的k个数的组合。组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/31 19:59
 */
public class LC216 {

    public static void main(String[] args) {
        List<List<Integer>> res = combinationSum3(3,9);

        System.out.println(res);
    }


    //考虑回溯,如果当前为倒数第二轮,考虑target-i是否在(i,9]之间
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n == 0){
            res.add(new ArrayList<>());
            return res;
        }
        //维护栈保存可能的集合
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }

    public static void dfs(int target, int count, int start, ArrayDeque<Integer> path, List<List<Integer>> res){
        //System.out.println("target="+target+" count="+count+" path="+path);
        //结束条件,三数之和=n
        if(count==0 && target==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=start; i<10; i++){
            //目标已经小于0,剪枝
            if(target<0){
                return;
            }
            //选择
            path.addLast(i);
            //递归
            //如果当前为倒数第二轮,目标元素在i-9之间
            if(count==2){
                //如果当前添加的元素i<0 并且 剩余的一个元素在 (i,9]之间
                if(i<9 && i<target-i && target-i<=9){
                    //下一次就将target-i添加到路径
                    dfs(target-i,count-1,target-i, path,res);
                }
            }else{
                //下一层从i+1开始保证了一个组合中没有重合的元素
                dfs(target-i,count-1,i+1, path,res);
            }
            //撤销选择,查看当前的第i个元素的其他可能
            path.removeLast();


        }
    }
}
