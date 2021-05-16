package DynamicProgram.dp0319;
/*
 * @Description:
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/19 19:20
 */
public class interview17_16 {

    public int massage(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        //dp[i][0] = 第i个预约不接的总预约时间
        //dp[i][1] = 第i个预约接的总预约时间
        int[][] dp = new int[nums.length][2];
        //初始化
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for(int i=1; i<nums.length; ++i){
            //当前接受,前一个不能接受
            dp[i][1] = dp[i-1][0]+nums[i];
            //当前不接,前一个不接/接种的较大值
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
        }
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }
}

class interview17_16_M2{
    //常数空间优化,只保留前两天的状态
    public int massage(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        //常量空间
        //dp 代表最后的最长预约时间
        //a代表前两天的最大预约时间
        //b代表前一天的最大预约时间
        //如果当前天选昨天不能选,则一定等于前两天的状态dp=a+nums[i]
        //如果当天不选,则等于昨天的状态,dp=b
        //dp = Math.max(b, a+nums[i])
        //初始化
        int a = 0;
        int b = 0;
        int dp = 0;
        for(int i=0; i<nums.length; ++i){
            dp = Math.max(a+nums[i], b);
            a = b;
            b = dp;
        }
        return b;
    }
}
