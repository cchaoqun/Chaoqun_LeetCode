package DynamicProgram.dp0317;
/*
 * @Description: 494. 目标和
给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。



示例：

输入：nums: [1, 1, 1, 1, 1], S: 3
输出：5
解释：

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。


提示：

数组非空，且长度不会超过 20 。
初始的数组的和不会超过 1000 。
保证返回的最终结果能被 32 位整数存下。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/17 20:40
 */
public class LC494 {


    //递归
    int sum;
    public int findTargetSumWays(int[] nums, int S) {
        this.sum = 0;
        dfs(nums, S, 0, 0);
        return sum;

    }

    public void dfs(int[] nums, int target, int index, int path){
        if(index==nums.length){
            if(path==target){
                ++sum;
            }
            return;
        }
        dfs(nums,target,index+1,path+nums[index]);
        dfs(nums,target,index+1,path-nums[index]);
    }
}

class LC494_M2{

    public int findTargetSumWays(int[] nums, int S){

        //dp[i][j]=前i个数,目标和为j的所有可能情况
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0]+1000] = 1;
        //防止nums[0]=0
        dp[0][-nums[0]+1000] += 1;
        for(int i=1; i<nums.length; ++i){
            for(int sum=-1000; sum<=1000; ++sum){
                if(dp[i-1][sum+1000]>0){
                    //当前选择+nums[i],则前i个数的总目标和为sum+1000+nums[i]
                    // 当前【0，i]个数，目标和为sum+1000+nums[i]的个数 加上 【0，i-1]个数目标和为sum+1000的个数
                    dp[i][sum+1000+nums[i]] += dp[i-1][sum+1000];
                    //当前选择-nums[i]
                    // 当前【0，i]个数，目标和为sum+1000-nums[i]的个数 加上 【0，i-1]个数目标和为sum+1000的个数
                    dp[i][sum+1000-nums[i]] += dp[i-1][sum+1000];
                }
            }
        }
        return S>1000? 0:dp[nums.length-1][S+1000];
    }
}
