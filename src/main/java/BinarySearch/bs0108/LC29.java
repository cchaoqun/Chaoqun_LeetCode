package BinarySearch.bs0108;
/*
 * @Description: 29. 两数相除
给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数dividend除以除数divisor得到的商。

整数除法的结果应当截去（truncate）其小数部分，
例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
示例2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

提示：
被除数和除数均为 32 位有符号整数。
除数不为0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231− 1]
本题中，如果除法结果溢出，则返回 231− 1。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/8 14:53
 */
public class LC29 {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 2;
        long res = divide(dividend,divisor);
        System.out.println(res);

    }

    public static int divide(int dividend, int divisor) {
        //当dividend=Integer.MIN_VALUE，divisor=-1时，结果越界，将该情况特殊处理
        if(dividend==Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        //由于在Java中，当t=Integer.MIN_VALUE时（t取相反数依旧是它本身）
        //此时可能存在越界问题，因此都用负数进行计算

        boolean flag = (dividend<0&&divisor<0 || dividend>0&&divisor>0);
        int res = 0;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);
        //依次减
//        while(dividend<=divisor){
//            dividend -= divisor;
//            res++;
//        }
        //每次减去 2^n个divisor

        while(dividend<=divisor){
            int temp = divisor;
            int c = 1;
            //判断dividend是否可以减去temp*2, 如果可以temp=temp*2 c=c*2 直到dividend-temp>temp
            //减去本次的c*divisor 剩下的dividend在循环判断可以减去多少个c*divisor
            while(dividend-temp<=temp){
                temp = temp<<1;
                c = c<<1;
            }
            dividend -= temp;
            res += c;
        }

        return flag? res:-res;

    }

}
