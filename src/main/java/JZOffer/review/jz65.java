package JZOffer.review;

/**剑指 Offer 65. 不用加减乘除做加法
 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。



 示例:

 输入: a = 1, b = 1
 输出: 2


 提示：

 a, b 均可能是负数或 0
 结果不会溢出 32 位整数
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/30-15:12
 */

public class jz65 {
    public int add(int a, int b){
        /**
         * a^b = 这一位上的非进位和 0^1=1 1^1=0 0^0=0
         * a&b = 这一位上的进位和 1&1=1 才会进位
         *
         *
         */
        while(b!=0){
            //对下一位的进位
            int carry = (a&b)<<1;
            //这一位的非进位和
            a ^= b;
            b = carry;
        }
        return a;
    }
}
