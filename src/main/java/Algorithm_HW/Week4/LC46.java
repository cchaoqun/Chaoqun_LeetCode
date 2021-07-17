package Algorithm_HW.Week4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/26-13:01
 */

public class LC46 {
    /**
     backtracking
     对于排列中的每个位置, 分别有nums.length个选择
     现在我来到了第i个位置 对于可以放在当前位置的每个元素来说, 我有两种选择
     (如果当前元素已经放入到路径中, 就跳过)
     选择: 选择当前元素 --> 当前元素加入到路径中, 去到下一层, 去查看下一个位置可能可以选择的元素(当前选择的元素需要markvisited)
     不选择: 不选择当前元素 --> 因为当前元素之前尝试加入到路径中, 递归回来, 需要将其从路径中删除
     每一层做什么:
     考虑在位置i 加入哪一个元素(这个元素必须之前没有加入过) visited[i] = false
     有多少种做法
     nums[] 数组中没有遍历到的都可以加入到当前位置
     对于nums[]中每一个可以加入到当前位置的元素来说 都可以 加 或者 不加
     一共做多少层
     一共有 nums.length 层
     */
    public List<List<Integer>> permute(int[] nums) {
        //数组的长度
        int n = nums.length;
        //结果的list
        List<List<Integer>> res = new ArrayList<>();
        //路径 全过程只有一个
        List<Integer> path = new ArrayList<>();
        //标记这个元素是否访问过
        boolean[] visited = new boolean[n];
        //backtracking
        backTrack(nums, res, path, visited);
        return res;
    }

    //
    private void backTrack(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] visited){
        //已经是一个全排列
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
        }
        //遍历整个数组
        for(int i=0; i<nums.length; i++){
            //已经在当前的排列中出现过
            if(visited[i]){
                //跳过
                continue;
            }

            //==========选择: 当前结点可以加到排列中==========
            path.add(nums[i]);
            //当前结点mark为已经访问过
            visited[i] = true;

            //==========backtrack 去查找下一个可以放在下一个位置上的元素 (我这一层做的事情就是把当前元素加入到路径中)
            backTrack(nums, res, path, visited);

            //===========不选择:这个元素 (因为之前加入过, 所以需要将其删除, 尝试在当前位置放入下一个可行的元素)
            visited[i] = false;
            //需要从排列中移除
            path.remove(path.size()-1);
        }
    }
}
