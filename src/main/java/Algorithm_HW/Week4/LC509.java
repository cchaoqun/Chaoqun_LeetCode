package Algorithm_HW.Week4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/21-17:12
 */

public class LC509 {
    //recursion
    public int fib (int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}

class LC509_M2{
    //cache
    public int fib (int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0,0);
        cache.put(1,1);
        return helper(n, cache);

    }

    private int helper(int n, Map<Integer, Integer> cache){
        //缓存存在直接返回缓存的值
        if(cache.get(n)!=null){
            return cache.get(n);
        }
        //计算 n-1 n-2
        int n1 = helper(n-1, cache);
        int n2 = helper(n-2, cache);
        //当前结果n1+n2放入缓存
        cache.put(n, n1+n2);
        //返回当前结果
        return n1+n2;
    }
}

class LC509_M3{
    //dp
    public int fib (int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        //f(n-2)
        int n1 = 0;
        //f(n-1)
        int n2 = 1;
        //f(n)
        int n3 = 1;
        int index = 2;
        while(index<=n){
            //f(n) = f(n-2)+f(n-1)
            n3 = n1+n2;
            //更新f(n-2) = f(n-1)
            //f(n-1) = f(n)
            n1 = n2;
            n2 = n3;
            index++;
        }
        return n3;
    }
}

class LC509_M4{
    //dp O(n)空间
    public int fib (int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        //dp[i] = fib(i)
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
