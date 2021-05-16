package NumList.List0130;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 78. 子集
给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*
示例 2：
输入：nums = [0]
输出：[[],[0]]


提示：

1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/30 11:27
 */
public class LC78 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3};
        List<List<Integer>> res =  subsets(nums);
        System.out.println(res);
        System.out.println(res.size());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> nullset = new ArrayList<>();

        if(n==0){
            res.add(nullset);
            return res;
        }
        //用栈来保存子集
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(nums,0,path,res);
        return res;
    }

    public static void dfs(int[] nums, int index, ArrayDeque<Integer> path, List<List<Integer>> res){
        if(index>nums.length){
            return;
        }
        res.add(new ArrayList<>(path));

        for(int i=index; i<nums.length; i++){
            path.addLast(nums[i]);
            System.out.println("子集递归前=>"+path);
            dfs(nums,i+1,path,res);
            //重置
            path.removeLast();
            System.out.println("子集递归后=>"+path);
        }

    }
}
