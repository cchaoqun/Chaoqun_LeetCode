package DynamicProgram.dp0115;
/*
 * @Description: 53. 最大子序和
 *
给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
*
示例:
输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释:连续子数组[4,-1,2,1] 的和最大，为6。
*
进阶:
如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-subarray
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 12:45
 */
public class LC53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(nums);
        System.out.println(res);
    }

    /*
     * 动态规划的是首先对数组进行遍历，当前最大连续子序列和为 sum，结果为 ans
     * 如果 sum > 0，则说明 sum 对结果有增益效果，则 sum 保留并加上当前遍历数字
     * 如果 sum <= 0，则说明 sum 对结果无增益效果，需要舍弃，则 sum 直接更新为当前遍历数字
     * 每次比较 sum 和 ans的大小，将最大值置为ans，遍历结束返回结果
     */
    //dp
//    public int maxSubArray(int[] nums) {
//        if(nums.length == 0){
//            return 0;
//        }
//        //之前元素的最大子序和
//        int sum = 0;
//        //结果
//        int res = nums[0];
//        for(int i=0; i<nums.length; i++){
//            //判断之前元素和 sum>=0 ?
//            if(sum>0){
//                //之前元素和对于结果的增加有益,保留并且把当前元素加上
//                sum += nums[i];
//            }else{
//                //sum<=0 对于总和无益,舍弃之前,并从当前元素开始
//                sum = nums[i];
//            }
//            //比较当前最大子序和与结果的大小,将较大值保存到ans
//            res = Math.max(res,sum);
//        }
//        return res;
//    }

    //简洁dp
    public static int maxSubArray(int[] nums){
        int sum = 0, ans = nums[0];
        for(int i=0; i<nums.length; i++){
            //如果之前的最大子序和加上当前元素<当前元素 将最大子序和变成当前元素
            sum = Math.max(sum+nums[i], nums[i]);
            //比较当前元素操作之后最大子序和与之前的结果
            ans = Math.max(ans,sum);
        }
        return ans;
    }
}
