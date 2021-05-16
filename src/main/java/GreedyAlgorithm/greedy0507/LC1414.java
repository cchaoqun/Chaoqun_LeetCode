package GreedyAlgorithm.greedy0507;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1414. 和为 K 的最少斐波那契数字数目
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 *
 * 斐波那契数字定义为：
 *
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 *
 *
 *
 * 示例 1：
 *
 * 输入：k = 7
 * 输出：2
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 * 示例 2：
 *
 * 输入：k = 10
 * 输出：2
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 * 示例 3：
 *
 * 输入：k = 19
 * 输出：3
 * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 *
 *
 * 提示：
 *
 * 1 <= k <= 10^9
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/7-21:39
 */

public class LC1414 {
    public int findMinFibonacciNumbers(int k) {
        int f0 = 1;
        int f1 = 1;
        List<Integer> fib = new ArrayList<>(Arrays.asList(f0,f1));
        //构建斐波那契数列
        while(f0+f1<=k){
            int f2 = f0+f1;
            fib.add(f2);
            f0 = f1;
            f1 = f2;
        }
        int ans = 0;
        //遍历斐波那契数列, 遇到小于等于k的值 就从k减去 ans++
        for(int i=fib.size()-1; i>=0; i--){
            if(fib.get(i)<=k){
                ans++;
                k -= fib.get(i);
            }
            if(k==0){
                return ans;
            }
        }
        return ans;
    }

    @Test
    public void test(){
        findMinFibonacciNumbers(19);
    }
}
