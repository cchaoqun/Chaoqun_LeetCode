package BitManipulation.bitmanipulation0221;
/*
 * @Description: 260. 只出现一次的数字 III
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。



进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？



示例 1：

输入：nums = [1,2,1,3,2,5]
输出：[3,5]
解释：[5, 3] 也是有效的答案。
示例 2：

输入：nums = [-1,0]
输出：[-1,0]
示例 3：

输入：nums = [0,1]
输出：[1,0]
提示：

2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
除两个只出现一次的整数外，nums 中的其他数字都出现两次
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/22 0:46
 */
public class LC260 {

    public int[] singleNumber(int[] nums) {
        //将所有数字按位异或得到一个结果x 一定是只出现一次的两个数a b按位异或的结果,因为出现两次的数字都抵消了
        int dffOr = 0;
        for(int num:nums){
            dffOr ^= num;
        }
        //找到diffOr中任意一个位置为1的数字,
        int diff = 1;
        while((diff&dffOr)==0){
            diff <<= 1;
        }
        //该位置为1表示 ab在该位置上不同,那么a b与该数字按位异或的结果不同
        //其他出现两次的数字在该位置的数字相同一定被分到相同的组
        //将所有数字与diff亦或,分到一组的一起亦或,
        int[] res = new int[2];
        for(int num:nums){
            if((num&diff)==0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }
}
