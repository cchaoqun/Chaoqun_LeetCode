package JZOffer.review;

/**剑指 Offer 64. 求1+2+…+n
 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。



 示例 1：

 输入: n = 3
 输出: 6
 示例 2：

 输入: n = 9
 输出: 45


 限制：

 1 <= n <= 10000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/30-15:04
 */

public class jz64 {
    int res = 0;
    public int sumNums(int n) {
        /**
         短路
         */
        boolean cur = n>=1 && sumNums(n-1)>0;
        res += n;
        return res;
    }
}
