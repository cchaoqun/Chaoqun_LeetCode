package DynamicProgram.dp0316背包问题;
/*
 * @Description: 377. 组合总和 Ⅳ
给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:

nums = [1, 2, 3]
target = 4

所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。
进阶：
如果给定的数组中含有负数会怎么样？
问题会产生什么变化？
我们需要在题目中添加什么限制来允许负数的出现？
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/16 18:20
 */
public class LC377 {

    //动态规划
    public int combinationSum4(int[] nums, int target) {
        //dp[i] = nums数组中元素能够构成和为i的方法总数
        int[] dp = new int[target+1];
        //dp[0]代表刚好某个taget==某个元素,所以target-nums[x] = 0, 这样就只有一种方法,即dp[0]=1
        dp[0] = 1;
        for(int i=1; i<=target; ++i){
            //对于[1,target]中的每个target计算对于的和的种类
            for(int num:nums){
                //如果当前元素小于当前targeti
                if(num<=i){
                    //i对应的组合方法+ num+dp[i-num]==>(取当前num,剩下i-num为target的方法即当前组合方法总数)
                    dp[i] += dp[i-num];
                }
            }
        }
        //返回 i=target对应的组合种类
        return dp[target];
    }
}
