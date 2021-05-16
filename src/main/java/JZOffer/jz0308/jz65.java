package JZOffer.jz0308;
/*
 * @Description:剑指 Offer 65. 不用加减乘除做加法
写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。



示例:

输入: a = 1, b = 1
输出: 2


提示：

a, b 均可能是负数或 0
结果不会溢出 32 位整数
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/8 22:18
 */
public class jz65 {

//    public int add(int a, int b) {
//        //没有进位，则停止循环
//        while(b!=0){
//            //进位和 （carry)
//            int c = (a&b)<<1;
//            //原位和 sum
//            a ^= b;
//            b = c;
//        }
//        return a;
//    }

    public int add(int a, int b){
        if(b==0){
            return a;
        }
        return add(a^b, (a&b)<<1);
    }
}
