package Math.math0211;
/*
 * @Description: 231. 2的幂
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

示例 1:

输入: 1
输出: true
解释: 20 = 1
示例 2:

输入: 16
输出: true
解释: 24 = 16
示例 3:

输入: 218
输出: false
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/11 12:41
 */
public class LC231 {
    public static void main(String[] args) {
        int n = 127;
        boolean res = isPowerOfTwo(n);
        System.out.println(res);
    }

//    public static boolean isPowerOfTwo(int n) {
//        int rem = 0;
//        //n不停除以2,每次保留除以2的余数,如果最后余数为1则为2幂次方
//        while(n != 0){
//            rem += n % 2;
//            n /= 2;
//        }
//        return rem == 1;
//    }

    //位运算
    public static boolean isPowerOfTwo(int n){
        //2^x最高位为1其他位为0
        //2^x-1最高位为0其他位为1
        //如果 n & n-1为0则为2的幂次方
        return n>0 && (n & (n-1)) == 0;
    }
}
