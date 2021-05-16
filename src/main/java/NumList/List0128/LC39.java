package NumList.List0128;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Description: 39. 组合总和
给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的数字可以无限制重复被选取。

说明：
所有数字（包括target）都是正整数。
解集不能包含重复的组合。
*
示例1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
*
示例2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
 [2,2,2,2],
 [2,3,3],
 [3,5]
]

提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/combination-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/28 16:29
 */
public class LC39 {

    public static void main(String[] args) {
        int[] candidates = new int[]{10,1,2,7,6,1,5};
        List<List<Integer>> res = combinationSum(candidates,7);
        System.out.println(res);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n==0){
            return res;
        }
        //排序是可以剪枝的前提
        Arrays.sort(candidates);
        //路径保存在一个栈中
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(candidates,0,target,path,res);
        return res;


    }
    // begin: 对于该层的元素的target,搜索可以减去的元素的起点
    // 从每一层的第 2 个结点开始，都不能再搜索产生同一层结点已经使用过的 candidate 里的元素
    public static void dfs(int[] candidates, int begin, int target, ArrayDeque<Integer> path, List<List<Integer>> res){
        //在上一层已经判断过剪枝的情况,这一层只需要判断是否等于0
        if(target == 0){
            //当前路径为所求的排列，将路径添加到res集合中(这里将path的地址复制到list)
            res.add(new ArrayList<>(path));
            //找到一个路径，返回父节点
            return;
        }
        for(int i=begin; i<candidates.length; i++){
            //大剪枝
            if(target-candidates[i]<0){
                //如果当前目标值减去candidates[i]已经小于0则减去后续元素一定小于0因为已经排序
                break;
            }
            //小剪枝,如果该层当前减去的数与之前减去的相同则跳到下一个不同的元素,这样可以避免重复
//            if(i>begin && candidates[i] == candidates[i-1]){
//                continue;
//            }
            //将当前减去的元素添加到路径中
            path.addLast(candidates[i]);
            System.out.println("递归之前=>"+path);
            //进入下一层
            //注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            dfs(candidates,i+1,target-candidates[i],path,res);
            //回到该层后,减去添加到路径中的最后一个元素,进入减去数组下一个元素的树的分支
            path.removeLast();
            System.out.println("递归之后=>"+path);
        }

    }
}
