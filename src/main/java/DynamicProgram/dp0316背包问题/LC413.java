package DynamicProgram.dp0316背包问题;
/*
 * @Description: 413. 等差数列划分
如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，以下数列为等差数列:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
以下数列不是等差数列。

1, 1, 2, 5, 7


数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。

如果满足以下条件，则称子数组(P, Q)为等差数组：

元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。

函数要返回数组 A 中所有为等差数组的子数组个数。



示例:

A = [1, 2, 3, 4]

返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/16 19:08
 */
public class LC413 {

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length<=2){
            return 0;
        }
        //dp[i] = 以nums[i]结尾的等差数列的个数
        int[] dp = new int[nums.length];
        //构成等差数列至少需要3个数
        dp[0] = 0;
        dp[2] = 0;
        //总等差数列个数
        int sum = 0;
        for(int i=2; i<nums.length; ++i){
            //nums[i-2,i]构成等差数列
            if((nums[i-1]-nums[i-2])==(nums[i]-nums[i-1])){
                /**
                 * nums[i-2], nums[i-1], nums[i]构成等差数列
                 * 在以nums[i-1]结尾的数组的基础上增加了...nums[i-2], nums[i-1], nums[i]这个等差数列
                 * ...代表nums[i-2]前面可能存在的前序等差数列
                 */
                dp[i] = dp[i-1]+1;
                sum += dp[i];
            }
        }
        return sum;

    }
}
