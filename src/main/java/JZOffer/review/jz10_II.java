package JZOffer.review;

/**剑指 Offer 10- II. 青蛙跳台阶问题
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
 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/21-13:49
 */

public class jz10_II {
    int mod = 1000000007;
    int[] memo;
    public int numWays(int n) {
        memo = new int[101];
        memo[0] = 1;
        memo[1] = 1;
        return search(n);
    }

    private int search(int n){
        if(memo[n]!=0){
            return memo[n];
        }
        int cur = (search(n-1) + search(n-2))%mod;
        memo[n] = cur;
        return memo[n];
    }
}

class jz10_II_M2{
    public int numWays(int n) {
        int mod = 1000000007;
        int f1 = 1;
        int f2 = 1;
        int cnt = 2;
        while(cnt<=n){
            int cur = (f1+f2)%mod;
            f1 = f2;
            f2 = cur;
            cnt++;
        }
        return f2;
    }
}
