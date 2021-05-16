package NumList.List0128;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Description:40. 组合总和 II
 *
给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
*
示例1:
输入: candidates =[10,1,2,7,6,1,5], target =8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*
示例2:
输入: candidates =[2,5,2,1,2], target =5,
所求解集为:
[
 [1,2,2],
 [5]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/28 21:23
 */
public class LC40 {

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println("输出 => " + res);

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        //维护栈保存路径
        ArrayDeque<Integer> path = new ArrayDeque<>();
        //剪枝的前提是对数组进行排序
        Arrays.sort(candidates);
        dfs(candidates,0,target,path,res);
        return res;
    }

    public static void dfs(int[] candidates, int begin, int target, ArrayDeque<Integer> path, List<List<Integer>> res){
        //上一层已经判断过<0的情况,这里只需要判断是否是一个符合的路径组合
        if(target==0){
            //将这条路径添加到res
            res.add(new ArrayList<>(path));
            //返回上一层结点,搜索其他的组合
            return;
        }
        for(int i=begin; i<candidates.length; ++i){
            //大剪枝,如果target减去当前元素<0,因为数组已经排序过,减去后续元素也一定<0,退出当前循环
            if(target-candidates[i]<0){
                break;
            }
            //小剪枝,一个for循环代表一层的结点,需要保证不重复,则在当前层不能减去相同的元素,
            // 在数组已经排序的情况下,即当前减去的元素不能与前一个相同
            if(i>begin && candidates[i] == candidates[i-1]){
                //跳到下一个不相同的元素
                continue;
            }
            //将当前元素添加到路径的最后一个
            path.addLast(candidates[i]);
            //这里调试,查看递归的过程前后的变化
            System.out.println("递归之前 => "+path);
            //下一层从当前元素的下一个开始,因为每一个元素只能使用一次
            dfs(candidates,i+1,target-candidates[i], path,res);
            //递归回到当前层后,重置path
            path.removeLast();
            //查看递归后的变化
            System.out.println("递归之后 => "+path);
        }
    }
}
