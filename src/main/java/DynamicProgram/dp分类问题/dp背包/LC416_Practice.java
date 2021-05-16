package DynamicProgram.dp分类问题.dp背包;
/*
 * @Description: 416. 分割等和子集
给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].


示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/28 17:04
 */
public class LC416_Practice {



    /**二维dp
     * 需要将数组分成两堆,并且和都等于sum
     * 如果sum是奇数一定不能分成两堆相等,
     * target = sum / 2
     * dp[i][j]= [nums[0], nums[i]]中能不能分成一堆元素的和为j
     * 状态转移 当前元素nums[i]不选, [nums[0],nums[i-1]]中是否有分成和为j
     *         当前元素nums[i]选  [nums[0],nums[i-1]]中是否有分成和为j-nums[i]
     * 每一轮结束,判断dp[i][target],只要找到一种就可以返回
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums){
        int n = nums.length;
        int sum = 0;
        int target = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum%2 != 0){
            return false;
        }
        target = sum / 2;
        boolean[][] dp = new boolean[n][target+1];
        //初始化第一行,只有一个元素nums[0],目标需要大于nums[0]才可能选择
        if(nums[0]<=target){
            dp[0][nums[0]] = true;
        }
        //对于每个元素
        for(int i=1; i<n; i++){
            //遍历每个背包的重量
            for(int j=0; j<target+1; j++){
                //当前元素nums[i]不选 和之前一样 照抄上一行
                dp[i][j] = dp[i-1][j];
                //如果当前元素==j,前i个元素可以分成两组 和为j的元素组合
                if(nums[i]==j){
                    dp[i][j] = true;
                    continue;
                }
                //3.如果nums[i]<j 如果nums[i]>j, 当前元素一定不能选,否则元素和一定超出目标j
                if(nums[i]<j){
                    //dp[i-1][j],不选择当前元素nums[i], 之前[0,i-1]有元素的和构成j,
                    //dp[i][j-nums[i]] 选择当前元素,剩下的target=j-nums[i] 之前[0,i-1]能够成
                    //只要上述两种情况之一成立当前dp[i][j]=true;
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
            if(dp[i][target]){
                return true;
            }
        }
        return dp[n-1][target];

    }
}
class LC416_P_M2{
    public boolean canPartition(int[] nums){
        int n = nums.length;
        int sum = 0;
        int target = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum%2 != 0){
            return false;
        }
        target = sum / 2;
        boolean[] dp = new boolean[target+1];
        //因为当nums[i]=target的时候, dp[target-nums[i]] = dp[0] 应该为true
        dp[0] = true;
        if(nums[0]<=target){
            dp[nums[0]] = true;
        }
        for(int i=1; i<n; i++){
            for(int j=target; j>=nums[i]; j--){
                if(dp[target]){
                    return true;
                }
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
