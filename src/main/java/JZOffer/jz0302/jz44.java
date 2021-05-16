package JZOffer.jz0302;
/*
 * @Description: 剑指 Offer 44. 数字序列中某一位的数字
数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。

请写一个函数，求任意第n位对应的数字。



示例 1：

输入：n = 3
输出：3
示例 2：

输入：n = 11
输出：0


限制：

0 <= n < 2^31
注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/2 22:14
 */
public class jz44 {
    public int findNthDigit(int n) {
        long start = 1;
        int digit = 1;
        long count = 9;
        while(n>count){
            n -= count;
            start *= 10;
            digit += 1;
            count = start * 9 * digit;
        }
        //(n-1)/2为start开始后面的多少位实际数字
        //num为n所在位置的对应实际digit位数字
        long num = start + (n-1)/digit;
        //确定所在位数
        int res = (n-1) % digit;
        return Long.toString(num).charAt(res) - '0';
    }
}
