package Algorithm_HW.Week4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/26-16:01
 */

public class LC39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //数组的长度
        int n = candidates.length;
        //结果的list
        List<List<Integer>> res = new ArrayList<>();
        //路径 全过程只有一个
        List<Integer> path = new ArrayList<>();
        backtrack(candidates, res, path, 0, 0, target);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path,int start, int sum, int target){
        //当前路径总和达到target
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        //控制当前层的元素不能重复
        Set<Integer> curLevel = new HashSet<>();
        //每次查找都是从指定的地方开始 而不是总是0,
        //保证从 start开始 不往前找, 因为包含了 start以及[:start]的元素的组合已经在以之前的元素开头的组合中找到了, 再找会重复
        for(int i=start; i<nums.length; i++){
            //跳过的情况, 当前层已经放过了 nums[i]
            // 加上当前元素已经大于target
            //这里是continue 而不是 break 因为没有对数组进行排序,
            //如果排序过 则可以break 因为后面的元素一定大于等于nums[i]
            if(sum+nums[i]>target || curLevel.contains(nums[i])){
                continue;
            }
            //当前元素加入
            path.add(nums[i]);
            //当前层加入过nums[i] 后面在当前层的尝试中不能再放nums[i]
            curLevel.add(nums[i]);
            //查找下一个可以放入总和当中的数, 要求是必须在数组的i以及以后开始找, 而不能往前找, 避免了重复
            backtrack(nums, res, path, i, sum+nums[i], target);
            //当前元素不放入总和
            path.remove(path.size()-1);
        }
    }
}
