package HashTable.hashtable0212;

import java.util.Arrays;

/*
 * @Description: 136. 只出现一次的数字
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,1]
输出: 1
示例 2:

输入: [4,1,2,1,2]
输出: 4
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 16:07
 */
public class LC136 {
    //排序遍历
//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        for(int i=0; i<nums.length-1;){
//            if(nums[i] == nums[i+1]){
//                i += 2;
//            }else{
//                return nums[i];
//            }
//        }
//        return nums[nums.length-1];
//    }

    //位运算 异或 XOR
    // a XOR 0 = a
    // a XOR a = 0
    //满足交换律和结合律 a XOR b XOR a = b XOR (a XOR a) = b XOR 0 = b
    public int singleNumber(int[] nums){
        int ans = 0;
        for (int num : nums){
            ans ^= num;
        }
        return ans;
    }
}
