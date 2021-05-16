package JZOffer.jz0227;
/*
 * @Description: 剑指 Offer 10- I. 斐波那契数列
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
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 14:21
 */
public class JZ10_I {

    //递归
//    public int fib(int n) {
//        if(n==0){
//            return 0;
//        }else if(n==1 || n==2){
//            return 1;
//        }
//        return (int)((fib(n-1)+fib(n-2)) % (1E9 + 7));
//    }

    //迭代
    public int fib(int n){
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int i = 2;
        while(i<=n){
            f2 = (f1+f0) % 1000000007;
            f0 = f1;
            f1 = f2;
            ++i;
        }
        return f2;
    }
}
