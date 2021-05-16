package DynamicProgram.dp0116;
/*
 * @Description: 213. 打家劫舍 II 198进阶题
 *
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。

示例1：
输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
*
示例 2：
输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
偷窃到的最高金额 = 1 + 3 = 4 。
*
示例 3：
输入：nums = [0]
输出：0

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/house-robber-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/16 13:21
 */
public class LC213 {

    //dp[i] 代表到i位置的最大金额
    //对于i, 可能的情况是
    //1.没偷i-1,这时可以偷i 最大值为dp[i-2]+nums[i]
    //2.偷了i-1,这时不可以偷,最大值为dp[i-1]
    //3.因为存在第一个和最后一个房子是相连的,存在两种情况
    //  3.1如果最后一间不能被偷,求数组nums[:n-2]的最大值 max(0:n-2)
    //  3.2如果第一个不能被偷,求数组nums[1:]的最大值,max(1:n-1)
    //  3.3最后结果为Math.max(max(0:n-2),max(1,n-1))
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        //借助myRob函数实现
        //情况1.最后一个不能被偷
        int ans1 = myRob(0,nums.length-2,nums);
        //情况2.第一个不能被偷
        int ans2 = myRob(1,nums.length-1,nums);
        return Math.max(ans1,ans2);
    }

    public int myRob(int start, int end, int[] nums){
        //利用滚动变量记录当前位置的前两个位置的dp值即可
        //dp[0]
        int first = 0;
        //dp[1]
        int second = 0;
        //dp[i]
        int ans = 0;
        for(int i=start; i<=end; i++){
            //状态转移方程 ans代表当前i的dp[i]
            ans = Math.max(first+nums[i], second);
            //数组滚动
            first = second;
            second = ans;
        }
        return ans;
    }
}
