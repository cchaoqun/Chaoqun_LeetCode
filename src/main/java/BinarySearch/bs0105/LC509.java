package BinarySearch;

/*
 * @Description: 斐波那契数列
 *
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that
each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n > 1.
Given n, calculate F(n).

Constraints:
0 <= n <= 30
*
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fibonacci-number


 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/4 19:31
 */
public class LC509 {
    //Solution #1
    public int fib(int n){
        //创建存储斐波那契数列的数组
        int[] fib = new int[40];
        //定义前两个元素值
        fib[0] = 0;
        fib[1] = 1;
        //创建斐波那契数组
        for(int i=2; i<fib.length; i++){
            fib[i] = fib[i-1] + fib[i-2];
        }
        //返回n对应的斐波那契数
        return fib[n];
    }

    //Solution #2
    public int fib2(int n){
        if(n==0){
            return 0;
        }
        if(n==1 || n==2){
            return 1;
        }
        int pre = 1, cur = 1;
        for(int i=3; i<=n; i++){
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
