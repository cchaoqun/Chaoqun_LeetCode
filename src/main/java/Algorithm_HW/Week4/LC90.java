package Algorithm_HW.Week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/26-17:38
 */

public class LC90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //排序是保证不重复的关键
        Arrays.sort(nums);
        backtrack(nums, res, path, 0);
        return res;

    }

    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> path, int start){
        //当前路径对应的子集加入到res
        res.add(new ArrayList<>(path));
        //从数组的开始添加元素的索引已经越界
        if(start==nums.length){
            //虽然在这之前已经将path加入了res, 但是此时path中包含的是start=<nums.length之前子集, 不影响
            return;
        }

        //从start下标处 开始遍历所有可能的子集
        for(int i=start; i<nums.length; i++){
            //对于从start开始的子集, 必须保证每一层尝试放入的元素不能相同否则就重复了
            //例如  [1,2,2,2,2]
            //start=0, 第二个位置尝试放入了 第一个2, 回溯回来了以后, 尝试下一个可以放在第二个位置上的元素
            // 因为后面的元素都相同就不能放了 所以子集大小为2的子集且包含了1的 只有一个 就是 [1,2]
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            //放入当前元素
            path.add(nums[i]);
            //继续寻找下一个可以放入下一个位置的元素
            backtrack(nums, res, path, i+1);
            //当前这个元素不选择
            path.remove(path.size()-1);
        }



    }
}
