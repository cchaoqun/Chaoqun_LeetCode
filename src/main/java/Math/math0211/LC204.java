package Math.math0211;

import java.util.Arrays;

/*
 * @Description: 204. 计数质数
统计所有小于非负整数 n 的质数的数量。



示例 1：

输入：n = 10
输出：4
解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
示例 2：

输入：n = 0
输出：0
示例 3：

输入：n = 1
输出：0


提示：

0 <= n <= 5 * 10^6
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/11 11:15
 */
public class LC204 {
    public static void main(String[] args) {
        int res = countPrimes(10);
        System.out.println(res);
    }

    //暴力枚举[2,n-1]判断是否是质数
//    public static int countPrimes(int n) {
//        if (n<=2){
//            return 0;
//        }
//        int count = 0;
//        for(int i=2; i<=n-1; i++){
//            if(isPrime(i)){
//                ++count;
//            }
//        }
//        return count;
//    }

//    public static boolean isPrime(int n){
//        if(n<=1){
//            return false;
//        }
//        //检查[2,sqrt(n)]的区间
//        for (int i=2; i*i<=n-1; i++){
//            if(n % i == 0){
//                return false;
//            }
//        }
//        return true;
//    }

    //埃氏筛
    //如果 x 是质数，那么大于 x 的 x 的倍数 2x,3x,… 一定不是质数
    public static int countPrimes(int n){
        int[] prime = new int[n];
        int count = 0;
        Arrays.fill(prime, 1);
        for(int i=2; i<n; ++i){
            if(prime[i] == 1){
                ++count;
                if((long)i*i < n){
                    for(int j=i*i; j<n; j+=i){
                        //从 i*i开始标记为0
                        prime[j] = 0;
                    }
                }
            }
        }
        return count;
    }

    //线性筛
//    public static int countPrimes(int n){
//        List<Integer> primeList = new ArrayList<>();
//        int[] prime = new int[n];
//        int count = 0;
//        Arrays.fill(prime, 1);
//        for(int i=2; i<n; i++){
//            if(prime[i]==1){
//                //如果当前数是质数,将其添加list集合中,最后返回找到的质数个数即可
//                primeList.add(i);
//            }
//            for(int j=0; j<primeList.size() && i*primeList.get(j)<n; j++){
//                //将遇到的每个整数与之前遍历到的质数相乘并且<n的数都不是质数,标记为0
//                prime[i*primeList.get(j)] = 0;
//                //如果当前获得的质数primeList.get(j)能够被当前的整数i整除
//                if(i % primeList.get(j) == 0){
//                    break;
//                }
//            }
//        }
//        return primeList.size();
//    }
}
