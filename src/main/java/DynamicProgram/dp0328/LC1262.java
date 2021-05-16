package DynamicProgram.dp0328;
/*
 * @Description: 1262. 可被三整除的最大和
给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。



示例 1：

输入：nums = [3,6,5,1,8]
输出：18
解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
示例 2：

输入：nums = [4]
输出：0
解释：4 不能被 3 整除，所以无法选出数字，返回 0。
示例 3：

输入：nums = [1,2,3,4,4]
输出：12
解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。


提示：

1 <= nums.length <= 4 * 10^4
1 <= nums[i] <= 10^4
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/28 18:17
 */
public class LC1262 {

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        //dp[i][j]到第i个数为值,和 % 3 = j的最大和
        int[][] dp = new int[n+1][3];
        //第0个数不存在, 0%3 = 0
        dp[0][0] = 0;
        //当第一个num%3= 1||2的数出现的时候,这两列才有意义
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++){
            //当前元素nums[i-1]%3的余数
            //当前余数为 curRe
            //我们希望找到前i-1个数中和%3=3-curRe+(0,1,2)的最大值
            //这样加起来刚好余数等于对应的(0,1,2)
            //例如当前余数curRe=1,需要求出的选择当前元素和%3=2的最大和
            //希望找到前i-1个中 和%3=1的和,这样两个余数1+1=2为我们需要求得
            //一般公式为 (3-curRe+(0,1,2))%3就是前一个我们需要的状态
            int curRe = nums[i-1] % 3;
            //如果curRe=0, 比较前i-1个数中和%3=0的总和+nums[i-1]
            //(3-0)%3=0              (i-1个数中总和%3=0, 当前数%3=0,加起来刚好=0)
            //如果curRe=1, 比较前i-1个数中和%3=0的总和 || 前i-1个数中和%3=2+nums[i-1]
            //(3-1)%3=2            (i-1个数中总和%3=2, 当前数%3=1,加起来刚好=0)
            //如果curRe=2, 比较前i-1个数中和%3=0的总和 || 前i-1个数中和%3=1+nums[i-1]
            //(3-2)%3=1             (i-1个数中总和%3=1, 当前数%3=2,加起来刚好=0)
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][(3-curRe+0)%3]+nums[i-1]);
            //一下两种情况依次类推
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][(3-curRe+1)%3]+nums[i-1]);
            dp[i][2] = Math.max(dp[i-1][2], dp[i-1][(3-curRe+2)%3]+nums[i-1]);
        }
        return dp[n][0];
    }
}
