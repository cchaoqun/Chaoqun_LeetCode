package Algorithm_HW.Week4;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/28-10:54
 */

public class LC1863 {
    int res;
    public int subsetXORSum(int[] nums) {
        res = 0;
        backtrack(nums, 0, 0);
        return res;
    }

    private void backtrack(int[] nums, int path, int start){
        if(start==nums.length){
            this.res += path;
            return;
        }
        //不选当前元素
        backtrack(nums, path, start+1);
        //选当前元素
        backtrack(nums, path^nums[start] ,start+1 );
    }
}
