package DynamicProgram.dp0316背包问题;
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
 * @date 2021/3/16 19:52
 */
public class LC416 {

    //二维dp[nums.length][sum(nums)/2+1]
    public boolean canPartition(int[] nums) {
        //求出数组个元素之和
        int sum = 0;
        int n = nums.length;
        for(int num:nums){
            sum += num;
        }
        //如果可以分成两个数组且和相等,和 一定等于sum/2,所以sum是奇数则一定不行
        if(sum%2!=0){
            return false;
        }
        int target = sum / 2;
        //dp[i][j]=nums[0,i]中是否存在某些元素的和==j
        boolean[][] dp = new boolean[n][target+1];
        //当前只有nums[0]这一个元素且为正整数,不能构成0
        dp[0][0] = false;
        //初始化第0行,因为只有一个元素nums[0],只有当j=nums[0],才可以构成
        if(nums[0]<target+1){
            dp[0][nums[0]] = true;
        }
        //从第1行开始
        for(int i=1; i<n; ++i){
            for(int j=0; j<target+1; ++j){
                //1.只要不选当前元素,则dp[i][j]=dp[i-1][j],所以首先照抄上一行元素
                dp[i][j] = dp[i-1][j];

                //2.如果当前元素nums[i] == 目标j, 置为true
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
            //如果target这一列为true,则[0~n-1]中必然有能够构成target的元素集合,提前剪枝
            if(dp[i][target]){
                return true;
            }
        }
        //nums[0~n-1] 中的元素是否有一些能够组成target;
        return dp[n-1][target];
    }
}

class LC416_M2{

    //一维dp[sum(nums)/2+1]
    public boolean canPartition(int[] nums){
        int n = nums.length;
        //求数组元素和
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        if(sum%2 != 0){
            return false;
        }
        //sum/2
        int target = sum / 2;

        /**一维数组的优化
         * 二维数组的情况下,dp[i][j]只与上一行头顶元素以及头顶元素前面的元素有关
         * 并且每次都是先照抄上一行,所以一维数组,到了下一轮的时候,个位置就已经是上一轮的最后结果
         * 可以省略照抄上一行的这一个个步骤
         * 同时考虑到值与上一行头顶或者之前元素有关,所以从后往前遍历,
         * 确保了决定了当前位置结果的上一行元素可以获得
         */
        boolean[] dp = new boolean[target+1];
        //dp[0]=true
        //虽然不符状态的定义,但是不影响状态的转移,
        //因为当nums[i]=target的时候, dp[target-nums[i]] = dp[0] 应该为true
        dp[0] = true;
        //初始化第0行
        if(nums[0]<target+1){
            dp[nums[0]] = true;
        }
        for(int i=1; i<n; ++i){
            //对于当前元素nums[i],目标需要>nums[j],否则当前元素一定不能选,对于元素也就更上一轮相同
            for(int j=target; j>=nums[i]; --j){
                if(dp[target]){
                    //提前剪枝
                    return true;
                }
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}

