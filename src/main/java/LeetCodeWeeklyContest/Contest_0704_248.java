package LeetCodeWeeklyContest;

import org.junit.jupiter.api.Test;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/4-10:29
 */

public class Contest_0704_248 {

    @Test
    public void test(){
        int res = 1000000007;
        System.out.println(res);
    }

    public int countGoodNumbers(long n) {
        /**
         偶数位置可以放  "0"，"2"，"4"，"6"，"8"
         奇数位置可以放  "2", "3", "5", "7"
         长度为n 下标为 [0,n-1] 偶数位置 n+1 / 2 奇数位置 n / 2
         奇数位置 为 4^(n/2)
         偶数位置 为 5^(n+1/2)
         n = 4 4^2 = 16
         5^2 = 25
         */
        long ans = 1;
        ans = ans * quickPower(4, (n/2)) % 1000000007;
        ans = ans * quickPower(5, (n+1)/2) % 1000000007;
        return (int) ans;
    }

    private long quickPower(int num, long n){
        long ans = 1;
        long x = num;
        while(n>0){
            if((n&1)==1){
                // 大坑 不要用 *= 这样两个数相乘的结果没有%1e9+7 导致越界了, 把乘数列出来, 然后结果%1e9+7 再赋给ans
                ans = (ans*x)%1000000007;
            }
            x = x * x % 1000000007;
            n >>= 1;
        }
        return ans;
    }
}

class M2{
    public int countGoodNumbers(long n) {
        /**
         偶数位置可以放  "0"，"2"，"4"，"6"，"8"
         奇数位置可以放  "2", "3", "5", "7"
         长度为n 下标为 [0,n-1] 偶数位置 n+1 / 2 奇数位置 n / 2
         奇数位置 为 4^(n/2)
         偶数位置 为 5^(n+1/2)
         n = 4 4^2 = 16
         5^2 = 25
         */
        long con = 1000000007;
        long even = 5;
        long odd = 4;
        long res = 1;
        long temp = (n+1)/2%con;
        while(temp>0){
            if((temp&1)==1){
                res = res * even % con;
            }
            even *= even%con;
            temp >>= 1;
        }
        temp = n/2%con;
        long res2 = 1;
        while(temp>0){
            if((temp&1)==1){
                if(odd%con!=0){
                    res2 = res*odd%con;
                }
                res2 %= con;
            }
            odd *= odd%con;
            temp >>= 1;
        }
        res =res*res2%con;
        return (int)res;
    }
}
