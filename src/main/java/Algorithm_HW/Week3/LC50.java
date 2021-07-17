package Algorithm_HW.Week3;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/12-10:39
 */

public class LC50 {
    /**
     * Step1 Function定义
     *      double Power(x,n) 返回x的n次方
     * Step2 Base Case
     *      n = 1 return x
     * Step3 Subproblem
     *      Power(x,n-1)
     *      Power(x,n-2)
     *      Power(x,n-3)
     * Step4 Recursion Rule
     *      return x*Power(x,n-1)
     *      return x*x*Power(x,n-2)
     *      return n%2 == 0?Power(x,n/2)*Power(x,n/2) : Power(x,n/2)*Power(x,n/2)*x
     */
    public double myPow(double x, int n){
        //TODO 为什么要转化成 long? 会不会越界?
        //转换成long
        long N = n;
        //如果n<0 n转化成正数, x转换成倒数
        return n>=0? quickMul(x, N) : quickMul(1.0/x, -N);
    }

    public double quickMul(double x, long N){
        //N==0 直接返回1
        if(N==0){
            return 1;
        }
        //计算 x^(N/2) 因为X^(N) = x^(N/2)*x^(N/2)
        double half = quickMul(x, N/2);
        //如果N为奇数 还需要再乘以x, 否则half*half即可
        return N%2==0? half*half: half*half*x;
    }
}

class LC50_M2{
    public double myPow(double x, int n){
        //转化成long
        long N = n;
        //n<0 n取反, x变成倒数
        if(N<0){
            x = 1.0/x;
            N = -N;
        }

        double res = 1.0;
        //将n看成二进制, 二进制每一位都对应了 对应位的2的多少次幂
        //不断的将N右移一位, 遇到最低位有1, 将res*对应的权重, x_contribute就是对应位置的权重, 每个循环后就变成原来的平方
        /**
         * x ^ (n)
         * 如果n可以写成二进制对应了一个 01010101...0100序列的
         *      n可以写成 2^(i_1) + 2^(i_2) +...+ 2^(i_n)
         *  N & 1 == 1 说明当前N二进制最低位有1, 对应的原来的N的二进制序列的weight是 x_contribution
         *  那就需要将 x_contribution乘到结果中 等于我们得到了一个 x^(2^(i-1))
         */
        double x_contribute = x;
        while(N>0){
            if((N&1)==1){
                res *= x_contribute;
            }
            x_contribute *= x_contribute;
            N >>=1;
        }
        return res;
    }
}
