package NumList.List0130;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Description: 90. 子集 II
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/30 21:08
 */
public class LC90 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        List<List<Integer>> res = subsetsWithDup(nums);
        System.out.println(res);
        System.out.println(res.size());
    }


    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if(n==0){
            res.add(new ArrayList<>());
            return res;
        }
        //维护栈来保存子集
        ArrayDeque<Integer> path = new ArrayDeque<>();
        //对数组排序
        Arrays.sort(nums);
        dfs(nums,0, path, res);
        return res;
    }

    public static void dfs(int[] nums, int start, ArrayDeque<Integer> path, List<List<Integer>> res){
        //将子集添加到集合
        res.add(new ArrayList<>(path));
        for(int i=start; i<nums.length; i++){
            //如果遇到重复的则不选择
            //i>start保证了这一层不出现重复的元素,每个start对应了一层
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            //如果当前元素和之前不同则选择
            path.addLast(nums[i]);
            //递归到下一层,下一层的开始元素要从下一位开始
            dfs(nums, i+1, path, res);
            //递归回来则重置,删除最后一个元素
            path.removeLast();
        }
    }
}
