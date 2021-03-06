package JZOffer.jz0228;
/*
 * @Description: 剑指 Offer 15. 二进制中1的个数
请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。



示例 1：

输入：00000000000000000000000000001011
输出：3
解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
示例 2：

输入：00000000000000000000000010000000
输出：1
解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
示例 3：

输入：11111111111111111111111111111101
输出：31
解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。


提示：

输入必须是长度为 32 的 二进制串 。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/28 14:45
 */
public class JZ15 {

    // n & n-1
//    public int hammingWeight(int n) {
//        int sum = 0;
//        while(n!=0){
//            //n & n-1 刚还可以消去最右边的1
//            n = n & (n-1);
//            //每消去1个1,总数增加1
//            ++sum;
//
//        }
//        return sum;
//    }

    //n & 1 =0 最右边一位为0 >>>无符号右移1位
    //n & 1 =1 sum+=1 最右边一位为1, >>>1
    public int hammingWeight(int n){
        int sum = 0;
        while(n != 0){
            //最右边一位为1
            if((n&1)==1){
                ++sum;
            }
            //无符号右移
            n >>>= 1;
        }
        return sum;
    }
}
