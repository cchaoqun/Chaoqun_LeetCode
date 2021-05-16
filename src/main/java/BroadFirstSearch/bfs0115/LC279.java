package BroadFirstSearch.bfs0115;
/*
 * @Description: 279. 完全平方数
 *
给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
*
示例1:
输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
*
示例 2:
输入: n = 13
输出: 2
解释: 13 = 4 + 9.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-squares
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 9:36
 */

import java.util.Arrays;

public class LC279 {
    public static void main(String[] args) {
        int res = numSquares(12);
    }

    //DP 记录之前的中间解不需要每次都重新计算
    public static int numSquares(int n) {
        //创建dp数组,保存的是每个下标对应的n的解
        int[] dp = new int[n+1];
        //初始化dp[0] = 0;并将其他位置的值初始化为最大值
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        //创建完全平方数的数组,需要的最大值为n的平方根+1
        int maxSqureNum = (int)Math.sqrt(n)+1;
        int[] squreNum = new int[maxSqureNum];
        for(int i=1; i<=maxSqureNum; i++){
            squreNum[i-1] = i*i;
        }

        //计算dp数组,dp[n]对应的就时结果
        for(int i=1; i<=n; i++){
            for(int sq=0; sq<squreNum.length; sq++){
                if(squreNum[sq]>i){
                    //如果完全完全平方数>n, n-完全平方数<0 此时当前n的解已经找到,应该break,
                    break;
                }
                //当前n的结果应该是当前的值与n减去一个小于n的完全平方的解+1的最小值,
                //这个完全平方数依次递增只要他还小于n
                dp[i] = Math.min(dp[i],dp[i-squreNum[sq]]+1);
            }
        }
        return dp[n];
    }

    //简洁dp
//    public static int numSquares(int n){
//        int[] dp = new int[n+1];
//        for(int i=1; i<=n; i++){
//            //最坏情况 n个1
//            dp[i] = i;
//            for(int j=1; i-j*j>=0; j++){
//                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
//            }
//        }
//        return dp[n];
//    }
}
