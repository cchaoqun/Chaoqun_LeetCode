package Algorithm_HW.Week4;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/26-16:04
 */

public class LC40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //数组的长度
        int n = candidates.length;
        //结果的list
        List<List<Integer>> res = new ArrayList<>();
        //路径 全过程只有一个
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, res, path, 0,target);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, int start,int target){
        //path中的元素总和刚好等于target 是一个目标结果
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        //当前层加入过的元素, 每一层的元素不能重复
        Set<Integer> curLevel = new HashSet<>();
        //尝试从start下标位置开始 将nums[start]以后的元素放入path
        for(int i=start; i<nums.length; i++){
            //不能放的情况
            //1. 当前元素放入nums[i]或使得target<0 即路径的总和>target 后面的元素都>=nums[i] 所以直接break
            if(target-nums[i]<0){
                break;
            }
            //2. 当前层已经放入过nums[i]
            if(curLevel.contains(nums[i])){
                continue;
            }

            //当前元素放入总和
            path.add(nums[i]);
            //当前层放入了nums[i] 以后当前层不能放了
            curLevel.add(nums[i]);
            //递归去找下一个位置可以放的数, 但是每一个元素只能使用一次 需要从下一个位置开始找
            backtrack(nums, res, path, i+1, target-nums[i]);
            //这个位置的数 不放入总和中
            path.remove(path.size()-1);
        }
    }
}
