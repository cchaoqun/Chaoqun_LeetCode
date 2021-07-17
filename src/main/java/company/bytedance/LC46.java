package company.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/30-22:32
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
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);
            backTrack(nums, res, path, visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }

    }
}
