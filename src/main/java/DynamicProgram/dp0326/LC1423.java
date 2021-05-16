package DynamicProgram.dp0326;

import java.util.Arrays;

/*
 * @Description: 1423. 可获得的最大点数
几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。

每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。

你的点数就是你拿到手中的所有卡牌的点数之和。

给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。



示例 1：

输入：cardPoints = [1,2,3,4,5,6,1], k = 3
输出：12
解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
示例 2：

输入：cardPoints = [2,2,2], k = 2
输出：4
解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
示例 3：

输入：cardPoints = [9,7,7,9,7,7,9], k = 7
输出：55
解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
示例 4：

输入：cardPoints = [1,1000,1], k = 1
输出：1
解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
示例 5：

输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
输出：202


提示：

1 <= cardPoints.length <= 10^5
1 <= cardPoints[i] <= 10^4
1 <= k <= cardPoints.length
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/26 15:10
 */
public class LC1423 {
    //前缀和
    //所取的卡牌一定是在两侧,所以左边取的卡片点数+右边取的卡片点数的最大值
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        //preSum[i] = cardPoints[0,i)
        int[] preSum = new int[len+1];
        //求出前缀和数组
        for(int i=1; i<=len; i++){
            preSum[i] = preSum[i-1]+cardPoints[i-1];
        }
        int res = 0;
        for(int i=0; i<=k; i++){
            //i代表在左边抽取的卡片数量
            //右边抽取的数量为k-i
            int left = preSum[i];
            int right = preSum[len]-preSum[len-(k-i)];
            res= Math.max(left+right, res);
        }
        return res;
    }

}


class LC1423_M3{
    //记忆化递归超时
    long[][] memo;
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        memo = new long[len][len];
        for(int i=0; i<len; i++){
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        int res = (int)dfs(cardPoints, 0, len-1, k);
        return res;
    }

    public long dfs(int[] cardPoints, int left, int right, int k){
        //只能选一张牌
        if(k==1){
            //返回左右中的较大值
            return Math.max(cardPoints[left], cardPoints[right]);
        }
        //当前状态之前遍历到过,直接返回
        if(memo[left][right]!=Integer.MIN_VALUE){
            return memo[left][right];
        }
        //选左
        long pickL = cardPoints[left]+dfs(cardPoints, left+1, right, k-1);
        //选右
        long pickR = cardPoints[right]+dfs(cardPoints,left, right-1, k-1);
        long res = Math.max(pickL, pickR);
        //当前状态的结果存储起来
        memo[left][right] = res;
        return res;

    }
}
