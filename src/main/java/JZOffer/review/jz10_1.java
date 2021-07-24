package JZOffer.review;

/**剑指 Offer 10- I. 斐波那契数列
 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

 F(0) = 0,   F(1) = 1
 F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。



 示例 1：

 输入：n = 2
 输出：1
 示例 2：

 输入：n = 5
 输出：5


 提示：

 0 <= n <= 100
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/21-13:27
 */

public class jz10_1 {
    //recursion + memo
    int mod = 1000000007;
    int[] memo = new int[101];
    public int fib(int n) {
        return cal(n);
    }

    private int cal(int n){
        if(n==0){
            return memo[n];
        }
        if(n==1 || n==2){
            memo[n] = 1;
            return 1;
        }

        if(memo[n]!=0){
            return memo[n];
        }
        int cur =cal(n-1)+cal(n-2);
        memo[n] = cur%mod;
        return memo[n];
    }
}
class jz10_1_M2{
    //迭代
    int mod = 1000000007;
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int f1 = 1;
        int f2 = 1;
        int res = 3;
        while(res<=n){
            int cur = (f1+f2)%mod;
            f1 = f2;
            f2 = cur;
            res++;
        }
        return f2;
    }
}
