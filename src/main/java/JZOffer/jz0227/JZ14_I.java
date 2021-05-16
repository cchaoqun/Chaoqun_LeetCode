package JZOffer.jz0227;
/*
 * @Description: 剑指 Offer 14- I. 剪绳子
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 16:23
 */
public class JZ14_I {


//    public static int cuttingRope(int n) {
//        if(n<=3){
//            return n-1;
//        }
//
//        int a = n /3, b = n % 3;
//        if(b==0){
//            return (int)Math.pow(3,a);
//        }else if(b==1){
//            return (int)Math.pow(3,a-1)*4;
//        }
//        return (int)Math.pow(3,a)*2;
//
//    }

    //动态规划
    public static int cuttingRope(int n){
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i=3; i<=n; ++i){
            //保证i-j>=2, i-j=1没有意义,剩下1不能增加最后的乘积
            for(int j=1; j<=i-2; ++j){
                //长度为i的最大乘积为下面三个当中的最大
                //i减去j后的长度的最大乘积乘以减去的j,
                // i减去j后剩余长度乘以j,
                // 以及之前算过的最大值
                dp[i] = Math.max(Math.max(dp[i-j], i-j)*j, dp[i]);
            }
        }
        return dp[n];
    }


}
