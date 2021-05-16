package DynamicProgram;
/*
 * @Description: 1140. 石子游戏 II
亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。

亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。

在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。

游戏一直持续到所有石子都被拿走。

假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。



示例：

输入：piles = [2,7,9,4,4]
输出：10
解释：
如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。
如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
所以我们返回更大的 10。


提示：

1 <= piles.length <= 100
1 <= piles[i] <= 10 ^ 4
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/23 19:52
 */
public class LC1140 {
    public int stoneGameII(int[] piles){
        int len = piles.length;

        //后缀和数组
        //postSum[i] 表示piles[i:]的所有和
        int[] postSum = new int[len+1];
        postSum[len] = 0;
        for(int i=len-1; i>=0; --i){
            postSum[i] = postSum[i+1]+piles[i];
        }
        //dp[i][M]在piles[i]位置先手,选择M个石头所能获得的最大分数
        int[][] dp = new int[len][len+1];
        //前面的状态取决于后面的状态,从后往前
        for(int i=len-1; i>=0; --i){
            //对于每一种可能的情况M求出最大分数
            for(int M=1; M<=len; ++M){
                //当前对应的M最多能取2*M个石头堆,
                //如果取2*M个石头能把所有剩下的取完,当前最大分数就等于后续所有石堆分数的和
                if(i+2*M >= len){
                    dp[i][M] = postSum[i];
                    continue;
                }

                //当前不能全部取完 i+2M<len
                //当前可以取的石头个数在[1,2*M],
                //枚举每一种情况,
                //如果当前取j个石头,下一个人可以选择的石头从piles[i+j]开始
                //那么下一个人从piles[i+j]位置开始可以获得的最大分数就为dp[i+j][Math.max(j,M)]
                //下一个人可以取的石头数取决于当前所取石头数j和当前M中的较大者
                //后面一共剩下的分数为piles[i:]=postSum[i],减去下一个人可以获得最大分数
                //剩下的就是当前我在i位置,最多选2M个石头所能获得的最大分数
                for(int j=1; j<=2*M; j++){
                    dp[i][M] = Math.max(dp[i][M], postSum[i] - dp[i+j][Math.max(j,M)]);
                }
            }
        }
        return dp[0][1];
    }
}
