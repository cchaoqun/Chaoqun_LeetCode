package Algorithm_HW.Week4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/26-15:17
 */

public class LC47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        //数组的长度
        int n = nums.length;
        //结果的list
        List<List<Integer>> res = new ArrayList<>();
        //路径 全过程只有一个
        List<Integer> path = new ArrayList<>();
        //标记这个元素是否访问过
        boolean[] visited = new boolean[n];
        backTrack(nums, res, path, visited);
        return res;
    }

    private void backTrack(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] visited){
        //已经是一个全排列
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //这是当前位置可以放得数, 不能重复 (位置下标是path.size())
        Set<Integer> curLevel = new HashSet<>();
        //这个for循环是在找 path.size()下标对应的位置可以放的数
        //  比如初始path.size()==0, 我们在找可以放在下标为0的位置的数, 每一轮尝试放入, 到下一轮会删除掉
        for(int i=0; i<nums.length; i++){
            //每一轮放的元素 都不能是之前已经放入path的数 visited[i] = false
            //每一轮放的元素 都不能相同, 而之前放入到过这个位置的数都存放在了curLevel中, curLevel.contains(nums[i]) = false
            //只有这两个条件都满足, 当前这个数才可以放到这个位置 否则 continue
            if(visited[i] || curLevel.contains(nums[i])){
                continue;
            }
            //======选择当前元素=======
            //当前元素nums[i] 放入路径
            path.add(nums[i]);
            //当前位置选择了nums[i] 以后在这个位置不能再放了
            curLevel.add(nums[i]);
            //标记访问
            visited[i] = true;
            //继续找下一个位置可以放的数
            backTrack(nums, res, path, visited);
            //======不选择当前元素======
            //从路径移除
            path.remove(path.size()-1);
            //标记未访问
            visited[i] = false;
        }
    }
}
