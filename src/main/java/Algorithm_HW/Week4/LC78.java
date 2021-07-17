package Algorithm_HW.Week4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/26-16:59
 */

public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, res, path, 0);
        return res;
    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, int start){
        if(start == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //不选 nums[start] 所以回溯到这里的时候下一步没有path.remove
        backtrack(nums, res, path, start+1);
        //选 nums[start] 添加到路径
        path.add(nums[start]);
        //递归到下一层
        backtrack(nums, res, path, start+1);
        //回到这一层的时候, 需要删除之前添加的nums[start]
        //这样回到上一层的, 上一层这个时候可以选择选择上一层的元素
        //如果这一层没有删除, 当前添加的元素就会在上一层添加上一层元素的前面
        //事实上我们在做每一层的操作的时候, 是不知道下一层干了什么的
        path.remove(path.size()-1);
    }

}
