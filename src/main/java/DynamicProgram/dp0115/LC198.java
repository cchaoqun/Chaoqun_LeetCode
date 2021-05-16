package DynamicProgram.dp0115;
/*
 * @Description: 198. 打家劫舍
 *
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，
计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1：
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
偷窃到的最高金额 = 1 + 3 = 4 。
*
示例 2：
输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
偷窃到的最高金额 = 2 + 9 + 1 = 12 。


提示：
0 <= nums.length <= 100
0 <= nums[i] <= 400

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 13:58
 */
public class LC198 {

    //dp[n]代表前n间房子的能偷到的金额的最大值
    //再次基础上再加一间房子,可能的情况
    //1.偷了n,不能偷n+1 dp[n+1] = dp[n]
    //2.没偷n,可以投n+1 dp[n+1] = dp[n-1] + nums[i]
    //dp 滚动数组,新加一个房子只与前两个的最大金额有关
    public int rob(int[] nums){
        int len = nums.length;
        if(len==0){
            return 0;
        }
        if(len==1){
            return nums[0];
        }
        if(len==2){
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[3];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i=2; i<len; i++){
            //前i个房子的最大金额
            dp[2] = Math.max(dp[1], dp[0] + nums[i]);
            //滚动数组,只保留dp[1] dp[2]
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }
//    public int rob(int[] nums){
//        int len = nums.length;
//        if(len==0){
//            return 0;
//        }
//        if(len==1){
//            return nums[0];
//        }
//        if(len==2){
//            return Math.max(nums[0], nums[1]);
//        }
//
//        int m = nums[0];
//        int n = Math.max(nums[0], nums[1]);
//        int r = 0;
//        for(int i=2; i<len; i++){
//            //前i个房子的最大金额
//            r = Math.max(n, m + nums[i]);
//            //滚动数组,只保留dp[1] dp[2]
//            m = n;
//            n = r;
//        }
//        return r;
//    }
}
