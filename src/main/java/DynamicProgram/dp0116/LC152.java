package DynamicProgram.dp0116;
/*
 * @Description: 152. 乘积最大子数组
 *
给你一个整数数组 nums，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
并返回该子数组所对应的乘积。

示例 1:
输入: [2,3,-2,4]
输出: 6
解释:子数组 [2,3] 有最大乘积 6。
*
示例 2:
输入: [-2,0,-1]
输出: 0
解释:结果不能为 2, 因为 [-2,-1] 不是子数组。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/16 11:22
 */
public class LC152 {
    /*
     * @Description:
     * 考虑当前位置如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，这样就可以负负得正，
     * 并且我们希望这个积尽可能「负得更多」，即尽可能小。
     * 如果当前位置是一个正数的话，我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
     * 于是这里我们可以再维护一个 fmin,它表示以第 ii 个元素结尾的乘积最小子数组的乘积，
     * 那么我们可以得到这样的动态规划转移方程：
     * fmax(i) = max(nums[i]*fmax(i-1), nums[i], nums[i]*fmin(i-1)
     * fmin(i) = min(nums[i]*fmin(i-1), nums[i], nums[i]*fmax(i-1)
     * ans = max(fmax(i),ans)

     */
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        //初始化三个变量,因为每次的最大值只与前i-1个元素的最大乘积和最小乘积有关,无需维护数组
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        for(int i=1; i<nums.length; i++){
            //维护变量保存上一个的最大最小乘积
            int mxf = maxF, mnf = minF;
            maxF = Math.max(mxf*nums[i], Math.max(nums[i], mnf*nums[i]));
            minF = Math.min(mnf*nums[i], Math.min(nums[i], mxf*nums[i]));
            ans = Math.max(maxF,ans);
        }
        return ans;

    }
}
