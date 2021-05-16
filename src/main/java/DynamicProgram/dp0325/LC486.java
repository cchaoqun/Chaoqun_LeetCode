package DynamicProgram.dp0325;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 486. 预测赢家
给定一个表示分数的非负整数数组。 玩家 1 从数组任意一端拿取一个分数，随后玩家 2 继续从剩余数组任意一端拿取分数，然后玩家 1 拿，…… 。每次一个玩家只能拿取一个分数，分数被拿取之后不再可取。直到没有剩余分数可取时游戏结束。最终获得分数总和最多的玩家获胜。

给定一个表示分数的数组，预测玩家1是否会成为赢家。你可以假设每个玩家的玩法都会使他的分数最大化。



示例 1：

输入：[1, 5, 2]
输出：False
解释：一开始，玩家1可以从1和2中进行选择。
如果他选择 2（或者 1 ），那么玩家 2 可以从 1（或者 2 ）和 5 中进行选择。如果玩家 2 选择了 5 ，那么玩家 1 则只剩下 1（或者 2 ）可选。
所以，玩家 1 的最终分数为 1 + 2 = 3，而玩家 2 为 5 。
因此，玩家 1 永远不会成为赢家，返回 False 。
示例 2：

输入：[1, 5, 233, 7]
输出：True
解释：玩家 1 一开始选择 1 。然后玩家 2 必须从 5 和 7 中进行选择。无论玩家 2 选择了哪个，玩家 1 都可以选择 233 。
     最终，玩家 1（234 分）比玩家 2（12 分）获得更多的分数，所以返回 True，表示玩家 1 可以成为赢家。


提示：

1 <= 给定的数组长度 <= 20.
数组里所有分数都为非负数且不会大于 10000000 。
如果最终两个玩家的分数相等，那么玩家 1 仍为赢家。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/25 15:29
 */
public class LC486 {
    //dp
    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;
        //dp[i][j] = nums[i:j]当前状态下先手获得的相对分数的最大值
        //如果取i dp[i][j] = nums[i] - dp[i+1][j]
        //如果取j dp[i][j] = nums[j] - dp[i][j-1]
        int[][] dp = new int[len][len];
        //对角线表示只有一个,先取的相对分数就是唯一的值,因为第二个人没有分数可拿
        for(int i=0; i<len; i++){
            dp[i][i] = nums[i];
        }
        for(int i=len-2; i>=0; i--){
            for(int j=i+1; j<len; j++){
                //如果只剩两个分数,当前先手的相对分数为两个数中较大的减去较小的
                if(j==(i+1)){
                    dp[i][j] = nums[i]>nums[j]?nums[i]-nums[j] : nums[j]-nums[i];
                }else{
                    //否则,为边界分数-剩余分数中先手的相对分数
                    dp[i][j] = Math.max(nums[i]-dp[i+1][j], nums[j]-dp[i][j-1]);
                }
            }
        }
        //返回当前为nums[0:len-1]所得的相对分数是否>=0
        return dp[0][len-1]>=0;
    }
}
class LC486_M2{

    //记忆化递归
    int[][] memo;
    public boolean PredictTheWinner(int[] nums){
        int len = nums.length;
        //memo[i][j] = Integer.MIN_VALUE 之前没有遍历到,
        //memo[i][j] != Integer.MIN_VALUE 之前遍历到.
        // 直接返回当前[i:j]先手的相对分数最大值
        memo = new int[len][len];
        for(int i=0; i<len; i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        int res = dfs(0, nums.length-1, nums);
        return res>=0;
    }

    //[start:end]区间对应的相对分数最大值
    public int dfs(int start, int end, int[] nums){
        //只剩一个分数可拿,返回该分数
        if(start==end){
            return nums[start];
        }
        //之前那遍历到
        if(memo[start][end]!=Integer.MIN_VALUE){
            //之前遍历到过,直接返回
            return memo[start][end];
        }
        //取左边界
        int pickL = nums[start] - dfs(start+1, end, nums);
        //取右边界
        int pickR = nums[end] - dfs(start, end-1, nums);
        //结果取两种情况较大值
        int res = Math.max(pickL, pickR);
        //将当前结果存入记忆矩阵
        memo[start][end] = res;
        return res;
    }
}
