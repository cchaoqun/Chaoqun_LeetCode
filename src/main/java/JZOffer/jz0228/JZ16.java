package JZOffer.jz0228;
/*
 * @Description: 剑指 Offer 16. 数值的整数次方
实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。



示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25


说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/28 15:09
 */
public class JZ16 {

    public double myPow(double x, int n) {
        if (x==0){
            return 0;
        }
        //n∈[−2147483648,2147483647], n=−2147483648, n = -n越界,所以需要将n变成long类型保存
        long b = n;
        double res = 1.0;
        //n<0, x转化成1/x, n转化成-n, 变成正数的情况计算
        if(b<0){
            b = -b;
            x = 1/x;
        }
        while(b>0){
            //(b&1) 位运算优先级低
            if((b&1)==1){
                //最右边位置为1
                res *= x;
            }

            x *= x;
            //删除最后一位
            b >>= 1;
        }
        return res;
    }
}
