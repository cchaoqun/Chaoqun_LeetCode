package NumList.List0201;

import java.util.Arrays;

/*
 * @Description:
给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

进阶：
你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?


示例 1：
输入：nums = [3,0,1]
输出：2
解释：n = 3，因为有 3 个数字，所以所有的数字都在范围 [0,3] 内。2 是丢失的数字，因为它没有出现在 nums 中。
*
示例 2：
输入：nums = [0,1]
输出：2
解释：n = 2，因为有 2 个数字，所以所有的数字都在范围 [0,2] 内。2 是丢失的数字，因为它没有出现在 nums 中。
*
示例 3：
输入：nums = [9,6,4,2,3,5,7,0,1]
输出：8
解释：n = 9，因为有 9 个数字，所以所有的数字都在范围 [0,9] 内。8 是丢失的数字，因为它没有出现在 nums 中。
*
示例 4：
输入：nums = [0]
输出：1
解释：n = 1，因为有 1 个数字，所以所有的数字都在范围 [0,1] 内。1 是丢失的数字，因为它没有出现在 nums 中。


提示：

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
nums 中的所有数字都 独一无二

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/missing-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/1 22:17
 */
public class LC268 {

    //排序
//    public int missingNumber(int[] nums) {
//        int n = nums.length;
//        Arrays.sort(nums);
//        for (int i=0; i<n; i++){
//            if(nums[i]!=i){
//                return nums[i];
//            }
//        }
//        return n;
//    }

    //数学【0，n]的和为 n(n+1)/2 减去 sum(nums)就是缺失的数
    public int missingNumber(int[] nums){
        int sum = 0;
        for(int i=1; i<=nums.length; i++){
            //0~n求和
            sum += i;
            //减去nums中所有的数
            sum -= nums[i-1];
        }
        return sum;
    }

    //HashMap，数组
//    public int missingNumber(int[] nums){
//        int[] flag = new int[nums.length+1];
//        for(int num:nums){
//            flag[num] = 1;
//        }
//        for(int i=0; i<=nums.length; i++){
//            if(flag[i]!=1){
//                return i;
//            }
//        }
//        return -1;
//    }
}
