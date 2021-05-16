package BinarySearch.bs0108;
/*
 * @Description: 50. Pow(x, n)
实现pow(x, n)，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例2:

输入: 2.10000, 3
输出: 9.26100
示例3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 <x< 100.0
n是 32 位有符号整数，其数值范围是[−231,231− 1]

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/8 10:45
 */
public class LC50 {
    public static void main(String[] args) {
        double x = 2;
        int N = -1;
        double res = myPow(x,N);
        System.out.println(res);
    }

    public static double myPow(double x, int n){
        long N = n;
        //N<0 先计算x^(-N) 再取倒数
        return N>=0 ? quickMul(x,N):1.0/quickMul(x,-N);
    }

    public static double quickMul(double x, long N){
        if(N==0){
            return 1;
        }
        //先递归计算 x^(N/2)
        double y = quickMul(x, N/2);
        //如果 N/2 == 0 return y*y else y*y*x
        return N%2==0 ? y*y:y*y*x;
    }


}
