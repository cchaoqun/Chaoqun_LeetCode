package EveryDay;

import java.util.*;

/*
 * @Description: 90. 子集 II
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。



示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/31 13:30
 */
public class LC90 {

    private static ArrayDeque<Integer> path;
    private static List<List<Integer>> res;
    public static List<List<Integer>> subsetsWithDup(int[] nums){
        path = new ArrayDeque<>();
        res = new ArrayList<>();
        if(nums==null || nums.length==0){
            res.add(new ArrayList<>());
            return res;
        }
        //回溯的基础是排序
        Arrays.sort(nums);
        dfs(nums,0);
        return res;

    }

    static void dfs(int[] nums, int start){
        if(start==nums.length){
            //加入数组的最后一个元素后,对应路径还没有添加
            res.add(new ArrayList<>(path));
            return;
        }
        //当前子集加入res
        res.add(new ArrayList<>(path));
        //同一个start对应的for循环遍历的元素都在路径的同一个位置
        for(int i=start; i<nums.length; i++){
            //剪枝. 同一个位置不能选择相同的元素否则造成重复
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            //当前元素加入路径
            path.addLast(nums[i]);
            //递归到下一层,起始位置从当前已经遍历到的位置下一个位置开始
            //这里注意一定是i+1, 而不是start+1,因为当前已经遍历到的位置为i,而i可能大于当前的start
            //从start开始就有可能遍历重复,因为又回到了之前遍历过的位置
            dfs(nums, i+1);
            //递归回来,取消当前位置的选择
            path.removeLast();

        }
    }
}
