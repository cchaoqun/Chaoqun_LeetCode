package DynamicProgram.dp0326;
/*
 * @Description: 1664. 生成平衡数组的方案数
给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。

比方说，如果 nums = [6,1,7,4,1] ，那么：

选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。

请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。



示例 1：

输入：nums = [2,1,6,4]
输出：1
解释：
删除下标 0 ：[1,6,4] -> 偶数元素下标为：1 + 4 = 5 。奇数元素下标为：6 。不平衡。
删除下标 1 ：[2,6,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：6 。平衡。
删除下标 2 ：[2,1,4] -> 偶数元素下标为：2 + 4 = 6 。奇数元素下标为：1 。不平衡。
删除下标 3 ：[2,1,6] -> 偶数元素下标为：2 + 6 = 8 。奇数元素下标为：1 。不平衡。
只有一种让剩余数组成为平衡数组的方案。
示例 2：

输入：nums = [1,1,1]
输出：3
解释：你可以删除任意元素，剩余数组都是平衡数组。
示例 3：

输入：nums = [1,2,3]
输出：0
解释：不管删除哪个元素，剩下数组都不是平衡数组。


提示：

1 <= nums.length <= 105
1 <= nums[i] <= 104
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/26 16:46
 */
public class LC1664 {
    public int waysToMakeFair(int[] nums){
        int len = nums.length;
        //dp[i] = [0,i)个数中奇数和-偶数和的差
        int[] dp = new int[len+1];
        //计算奇偶差
        for(int i=1; i<=len; i++){
            dp[i] = dp[i-1]+(i%2==0?-nums[i-1]:nums[i-1]);
        }
        int res = 0;
        for(int i=1; i<=len; i++){
            //删除第i个数,nums中下标为i-1
            //i以前的奇偶数差为dp[i-1]
            //i以后的奇偶数差为dp[len]-dp[i],但是翻转之后,后面变成偶奇差
            //如果删除后奇偶数和相等则有奇偶差=0
            //所以i之前的奇偶差dp[i-1]-i以后的偶奇差 = 整体的奇偶差
            //=0则说明平衡
            boolean cur = (dp[i-1] - dp[len]-dp[i]) == 0;
            res = cur?res+1:res;
        }
        return res;
    }
}

class LC1664_M2{
    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        //oddSum[i] = 前i个数中奇数位置的和
        int[] oddSum = new int[len];
        //evenSum[i] = 前i个数中偶数位置的和
        int[] evenSum = new int[len];
        //初始化
        oddSum[0] = 0;
        evenSum[0] = nums[0];
        for(int i=1; i<len; i++){
            //判断当前位置为 odd/even
            int cur = i%2;
            //偶
            if(cur==0){
                //+nums[i
                evenSum[i] = evenSum[i-1]+nums[i];
                //奇不变
                oddSum[i]=oddSum[i-1];
            }else{
                oddSum[i] = oddSum[i-1]+nums[i];
                evenSum[i] = evenSum[i-1];
            }
        }
        //可能的方法总数
        int res = 0;
        //尝试抽取每个位置
        for(int i=0; i<len; i++){
            //判断当前奇偶
            int cur = i%2;
            //当前位置之前的奇数和,如果当前位置是奇数,需要减去当前位置的值
            int preOdd = cur==0?oddSum[i]:oddSum[i]-nums[i];
            //当前位置之前的偶数和,如果当前位置是偶数,需要减去当前位置的值
            int preEven = cur==0?evenSum[i]-nums[i]:evenSum[i];
            //当前位置之后的奇数和
            int postOdd = oddSum[len-1]-oddSum[i];
            //当前位置之后的偶数和
            int postEven = evenSum[len-1]-evenSum[i];
            //由于当前位置删除,后续的奇数位置变成偶数位置,偶数位置变成奇数位置,需要交叉相加
            int curOdd = preOdd+postEven;
            int curEven = preEven+postOdd;
            //如果删除后奇偶数和相等,则res+1
            res = curOdd==curEven? res+1:res;
        }
        return res;
    }
}
