package GreedyAlgorithm.greedy0429;

/**
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 *
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * 示例 2：
 *
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= flowerbed.length <= 2 * 104
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/29-16:15
 */

public class LC605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        //dp[i][0]到i位置不种树最多能够种的数量
        //dp[i][1]到i位置种树最多能够种的数量
        //状态转移.
        //  当前位置或者左右有1, dp[i][0]=dp[i][1] = Math.max(dp[i-1][0],dp[i-1][1])前一个位置中的最大种植数量
        //当前位置可以种树,有两种选择,种或者不种
        //  不种:dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1])
        //  种: dp[i][1] = dp[i-1][0]+1;

        int[][] dp = new int[len][2];
        if(flowerbed[0]==0 ){
            //前面两个都为0
            if(len>=2 && flowerbed[1]==0){
                dp[0][1] = 1;
            }
            if(len==1){
                //只有一个0
                dp[0][1] = 1;
            }
        }
        for(int i=1; i<len; i++){
            //左右中有1的情况跳过
            if(flowerbed[i-1]==1 || flowerbed[i]==1 ||  (i+1<len && flowerbed[i+1]==1)){
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
                dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]);
                continue;
            }
            //状态转移
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
            dp[i][1] = dp[i-1][0]+1;
        }
        //返回最后能够种的最大数量是否>=n
        return Math.max(dp[len-1][0], dp[len-1][1])>=n;
    }
}


class LC605_M2{
    public boolean canPlaceFlowers(int[] flowerbed, int n){
        for(int i=0, len = flowerbed.length; i<len && n>0; ){
            //当前位置为1 下一个可以种的位置为 i+2
            if(flowerbed[i]==1){
                i+=2;
            }else if(i==len-1 || flowerbed[i+1]==0){
                //当前为最后一个位置并且当前位置==0 可以种植
                //当前位置为0, 后面一个位置也为0, 可以种
                n--;
                //当前位置种完了以后, 下一个可以种的位置为i+2
                i+=2;
            }else{
                //当前位置为0, 但是后面一个位置i+1为1, 下一个可以种的位置为 i+1后面两个位置 i+1+2
                i+=3;
            }
        }
        //最后如果树都种完了,n<=0
        return n<=0;
    }
}
