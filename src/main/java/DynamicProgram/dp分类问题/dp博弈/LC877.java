package DynamicProgram.dp分类问题.dp博弈;

import java.util.Arrays;

/*
 * @Description: 877. 石子游戏
亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。

游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。

亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。

假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。



示例：

输入：[5,3,4,5]
输出：true
解释：
亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。


提示：

2 <= piles.length <= 500
piles.length 是偶数。
1 <= piles[i] <= 500
sum(piles) 是奇数。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/20 22:35
 */
public class LC877 {

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        //dp[i][j] = 当前为[i,j]区间时, 先手能拿到的相对分数的最大值
        //自己拿到的石头数为正,对方拿到的石头数为负数
        //自己拿到的-对方拿到的为得分
        int[][] dp = new int[n][n];
        for(int i=0; i<n; ++i){
            dp[i][i] = piles[i];
        }
        for(int i=n-2; i>=0; --i){
            for(int j=i+1; j<n; ++j){
                //当前区间[i,j],
                //如果选piles[i], 剩下[i+1,j],另一个人拿的时候的最大相对分数为dp[i+1][j]
                //如果选piles[j], 剩下[i,j-1],另一个人拿的时候的最大相对分数为dp[i][j-1]
                dp[i][j] = Math.max(piles[i]-dp[i+1][j], piles[j]-dp[i][j-1]);
            }
        }
        //alex先手,首先面对的是整个石头堆[0,n-1],这个时候的相对分数最大值大于0则会赢得比赛
        return dp[0][n-1] > 0;

    }
}

class LC877_M2{
    //记忆化递归
    public boolean stoneGame(int[] piles){
        int n = piles.length;
        //memo[i][j] 区间[i,j]得到的最大分数
        int[][] memo = new int[n][n];
        for(int i=0; i<n; ++i){
            //比较值可能为负数,这里先初始化最小值
            Arrays.fill(memo[i],Integer.MIN_VALUE);
            //区间只有一个元素
            memo[i][i] = piles[i];
        }
        int res = dfs(piles, 0, n-1, memo);
        return res > 0 ;
    }

    /**
     *
     * @param piles 石头堆
     * @param left 区间左端点
     * @param right 区间右端点
     * @param memo 区间对应的最大分数
     * @return [left,right]区间的先手的最大分数
     */
    public int dfs(int[] piles, int left, int right, int[][] memo){
        //区间只有一个元素,得分为对应元素
        if(left==right){
            return piles[left];
        }
        //当前区间之前已经递归得到过,直接返回
        if(memo[left][right]!=Integer.MIN_VALUE){
            return memo[left][right];
        }
        //选左端点, 剩下[left+1,right]
        int chooseL = piles[left] - dfs(piles, left+1, right, memo);
        //选右端点, 剩下[left, right-1]
        int chooseR = piles[right] - dfs(piles, left, right-1, memo);
        //取两种选择中的最大值
        int res = Math.max(chooseL, chooseR);
        //当前区间的最大分数
        memo[left][right] = res;
        return res;
    }
}