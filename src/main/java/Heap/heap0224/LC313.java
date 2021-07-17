package Heap.heap0224;

/**313. 超级丑数
 编写一段程序来查找第 n 个超级丑数。

 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。

 示例:

 输入: n = 12, primes = [2,7,13,19]
 输出: 32
 解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
 说明:

 1 是任何给定 primes 的超级丑数。
 给定 primes 中的数字以升序排列。
 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
 第 n 个超级丑数确保在 32 位有符整数范围内。
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/9-1:37
 */

public class LC313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        //ptrs[i] 是primes[i]的质因子下一个要乘的res[]数组的值的下标
        //prime[i]下一个要比较的是 primes[i]*res[ptrs[i]]
        //初始都指向了第一个元素即 1
        int[] ptrs = new int[m];
        int[] res = new int[n];
        res[0] = 1;
        for(int i=1; i<n; i++){
            //第i个丑数
            int ugly = Integer.MAX_VALUE;
            //找出所有质因子和对应res[]中指向的值的乘积最小值
            for(int j=0; j<m; j++){
                //寻找primes[j]*res[ptrs[j]]的最小值
                ugly = Math.min(res[ptrs[j]]*primes[j], ugly);
            }
            //找到了最小值
            res[i] = ugly;
            for(int j=0; j<m; j++){
                //再遍历一遍, 比较是哪些质因子乘对应res[]中的值的结果相同, 将指针+1
                if(res[ptrs[j]]*primes[j]==ugly){
                    ptrs[j]++;
                    //这里不能遇到相同的就break
                    //如果存在某个质因子和对应指针指向的数相乘的结果相同, 需要把这些相同的质因子的指针都+1
                    //否则就会出现多个相同的数
                }
            }
        }
        return res[n-1];
    }
}
