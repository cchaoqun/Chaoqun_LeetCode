package DynamicProgram.dp0327;

import java.util.Arrays;

/*
 * @Description: 650. 只有两个键的键盘
最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作：

Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。
Paste (粘贴) : 你可以粘贴你上一次复制的字符。
给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。

示例 1:

输入: 3
输出: 3
解释:
最初, 我们只有一个字符 'A'。
第 1 步, 我们使用 Copy All 操作。
第 2 步, 我们使用 Paste 操作来获得 'AA'。
第 3 步, 我们使用 Paste 操作来获得 'AAA'。
说明:

n 的取值范围是 [1, 1000] 。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/27 20:07
 */
public class LC650 {
    public int minSteps(int n) {
        //dp[i]= 获得i个A所需要的最小的操作次数
        int[] dp = new int[n+1];
        //初始化为最大值,因为我们需要求的是最小次数
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 0;
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i-1; j++){
                if(i%j==0){
                    //dp[j]=达到j个A所需要的最小次数,
                    //j以后,copy All, 剪切板上为j个A
                    //i/j = i中含有的j的个数,dp[j]代表已经有了一个j,剩下(i/j-1)个j
                    //还需要paste (i/j-1)次, 加上之前copy all 获得j个A的1次操作
                    //一共是i/j次操作
                    dp[i] = Math.min(dp[i], dp[j]+i/j);
                }
            }
        }
        return dp[n];
    }
}
