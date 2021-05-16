package JZOffer.jz0227;
/*
 * @Description: 剑指 Offer 10- II. 青蛙跳台阶问题
一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

示例 1：

输入：n = 2
输出：2
示例 2：

输入：n = 7
输出：21
示例 3：

输入：n = 0
输出：1
提示：

0 <= n <= 100
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 14:37
 */
public class JZ10_II {

    public int numWays(int n) {
        int n0 = 1, n1 = 1, n2 = 0;
        if(n==0||n==1){
            return 1;
        }
        int i = 2;
        while(i<=n){
            //跳到n2级台阶的跳法=跳到n2-2 + 跳到n2-1的方法总和
            n2 = (n0+n1) % 1000000007;
            n0 = n1;
            n1 = n2;
            ++i;
        }
        return n2;
    }
}
