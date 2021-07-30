package JZOffer.review;

import org.junit.jupiter.api.Test;

/**剑指 Offer 43. 1～n 整数中 1 出现的次数
 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。

 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。



 示例 1：

 输入：n = 12
 输出：5
 示例 2：

 输入：n = 13
 输出：6


 限制：

 1 <= n < 2^31
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/27-13:45
 */

public class jz43 {
    /**
     n = xn xn-1 xn-2 ... x1
     对于 ni
     high = xn xn-1...xi+1
     low = xi-1 xi-2 ... x1
     cur = xi
     digit = 10^(i-1)
     cur = 0
     res = high * digit
     cur = 1
     res = high * digit + low+1
     cur > 1
     res = high * dight + dight
     */

    public int countDigitOne(int n) {
        int res = 0;
        int digit = 1;
        int high = 0;
        int low = 0;
        int cur = 0;
        while(n!=0){
            high = n/10;
            cur = n%10;
            if(cur==0){
                res += high*digit;
            }else if(cur==1){
                res += high*digit + low+1;
            }else{
                res += high*digit + digit;
            }
            low = cur*digit+low;
            digit *= 10;

            n /= 10;
        }
        return res;
    }
    @Test
    public void test(){
        countDigitOne(12);
    }
}
