package DynamicProgram.dp0315;
/*
 * @Description: 357. 计算各个位数不同的数字个数
给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。

示例:

输入: 2
输出: 91
解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/15 19:39
 */
public class LC357 {

    public int countNumbersWithUniqueDigits(int n) {
        //区间只有一个0
        if(n==0){
            return 1;
        }
        //一位数的情况 [0,9]
        if(n==1){
            return 10;
        }
        //初始化情况的res包括了n=1的情况
        int res = 10;
        //dp[i] = n=i的情况下,在不包括0的情况各位数字都不相同的情况数量
        int[] dp = new int[n+1];
        //dp[1] = [1,9]不包括0
        dp[1] = 9;
        for(int i=2; i<=n; ++i){
            /**
             * dp[2]:2位数,第一位数的种类为dp[i-1]=9, 第二位数只有9-(i-1)中情况(9-1)
             * dp[3]:3位数,第一第二位的数的情况为dp[2], 最高位因为前面i-1位已经从9位数中
             * 取了i-1位,上下可选的不重复的数字只有(9-(i-1))位
             * 综上 dp[i] = dp[i-1]*(9-(i-1))
             */
            //当前i位数不包括0的各位数字不重复的个数
            dp[i] = dp[i-1]*(9-(i-1));
            //结果加上当前位数下不为零的情况
            res += dp[i];
            //包括的0的情况
            /**
             * i=2, 2位数,0只能出现在个位数上有1=i-1种情况,剩下的最高位有dp[i-1]中情况
             * i=3, 3位数,0可以出现在个位十位数上2(i-1)个位置都可以,其中一个为0,
             * 剩下了两个位置,并且两个位置都不能为0,且不能重复,这就是dp[2] = dp[i-1]
             * 综上,i位数,包括的0的情况,可以有dp[i-1]*(i-1)
             * 在i位数中,除最高位有i-1个位置可以放0,有i-1种方法
             * 选择完0以后,剩下i-1位置必须没有0并且不能重复,这就是dp数组的定义即dp[i-1]
             * by multiplication rule dp[i-1]*(i-1)
             */
            res += dp[i-1]*(i-1);
        }
        return res;
    }
}
