package JZOffer.review;

/**剑指 Offer 14- I. 剪绳子
 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

 示例 1：

 输入: 2
 输出: 1
 解释: 2 = 1 + 1, 1 × 1 = 1
 示例 2:

 输入: 10
 输出: 36
 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 提示：

 2 <= n <= 58
 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/22-17:13
 */

public class jz14_i {
    /**
     尽量把n分成大小相等的3相乘
     */
    public int cuttingRope(int n) {
        if(n<4){
            return n-1;
        }
        // n = a*3+b
        int a = n/3;
        int b = n%3;
        //刚好分成a个3
        if(b==0){
            return (int)Math.pow(3,a);
        }
        //a个3 和 1个 1  分成 3^(a-1) * 4 > 3^a
        if(b==1){
            return (int)Math.pow(3,a-1)*4;
        }
        //a个3 和 1个2 只能 3^a*2
        return (int)Math.pow(3,a)*2;
    }
}
