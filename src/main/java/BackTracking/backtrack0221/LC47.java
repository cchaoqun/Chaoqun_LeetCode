package BackTracking.backtrack0221;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * @Description: 47. 全排列 II
给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。



示例 1：

输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]
示例 2：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


提示：

1 <= nums.length <= 8
-10 <= nums[i] <= 10
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/21 10:35
 */
public class LC47 {
    public static void main(String[] args) {
        int[] nums = {1,1,3};
        LC47 cur = new LC47();
        List<List<Integer>> res = cur.permuteUnique(nums);
        System.out.println(res);
    }

    //排序, boolean数组确定是否访问过,
//    public static List<List<Integer>> permuteUnique(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//        boolean[] isVisited = new boolean[nums.length];
//        //排序,确保了每一层不会添加重复的元素
//        Arrays.sort(nums);
//        dfs(nums,res,path,isVisited);
//        return res;
//
//    }
//
//    public static void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] isVisited){
//        if(path.size()==nums.length){
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for(int i=0; i<nums.length; ++i){
//            //进入下一层的时候,如果当前元素在之前的层已经访问了,则跳过
//            if(isVisited[i]){
//                continue;
//            }
//            //i>0保证i-1不越界
//            //当前元素和本层前一个元素相同,每一层添加的元素不能重复
//            //nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
//            if(i>0 && nums[i]==nums[i-1] && !isVisited[i-1]){
//                continue;
//            }
//            //当前位置已经访问
//            isVisited[i] = true;
//            //当前元素添加到路径
//            path.add(nums[i]);
//            System.out.println("  递归前==>"+path);
//            dfs(nums, res, path,isVisited);
//            //重置
//            path.remove(path.size()-1);
//            System.out.println("递归后==>"+path);
//            isVisited[i] = false;
//        }
//    }

    //存放结果的list结合,全局变量,递归函数无需传入参数
    List<List<Integer>> res = new ArrayList<>();
    //同上,但是主函数中需要初始化
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums){
        //初始化
        this.nums = nums;
        //递归,从第一个位置开始
        dfs(0);
        return res;
    }

    //递归函数
    void dfs(int x){
        //当到达最后一个位置时,0~n-2位置的数都已经固定好了,直接返回整个数组对应的顺序即可
        if(x==nums.length-1){
            //新建一个list,将当前顺序下数组中的数依次添加
            List<Integer> temp = new ArrayList<>();
            for(int i:nums){
                temp.add(i);
            }
            //添加到res
            res.add(temp);
            return;
        }
        //存在重复元素,则同一个位置不应该出现相同的数字,遇到不同的数字添加到这一个位置对应的set中,每次都检查当前位置对应的数字是否出现在set中
        HashSet<Integer> set = new HashSet<>();
        //i从x位置开始,因为0~x-1位置的数字都已经固定好了
        //例如x=0, 第一个位置有nums.length-1个可能的情况,(无重复元素的情况下)
        for(int i=x; i<nums.length; ++i){
            //当前元素已经出现在了该位置对应的set中,说明是重复元素,直接跳过
            if(set.contains(nums[i])){
                continue;
            }
            //该元素未出现,则添加到set
            set.add(nums[i]);
            //交换i,x位置对应的数字,这一步是将nums[i]固定到x位置上
            swap(i,x);
            //递归取固定下一个位置的值
            dfs(x+1);
            //递归回来,在固定x位置=nums[i]情况下所有的可能顺序都已经添加完了
            //进入下一个循环,继续寻找x位置可以存在的数字的情况
            //所以这里需要回复之前的交换
            swap(i,x);
        }
    }

    void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
