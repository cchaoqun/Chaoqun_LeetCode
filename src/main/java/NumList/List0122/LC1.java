package NumList.List0122;

import java.util.Arrays;
import java.util.HashMap;

/*
 * @Description: 1. 两数之和
 *
给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 的那两个整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案
*
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
*
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
*
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]


提示：

2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/22 17:08
 */
public class LC1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,4};
        int[] res = twoSum(nums,6);
        System.out.println(Arrays.toString(res));
    }

    public static int[] twoSum(int[] nums, int target){
        //用hashmap存储数组下标和对应的元素值
        HashMap<Integer,Integer> numMap = new HashMap<>();
        //先将第一个元素放入numMap
        numMap.put(nums[0],0);
        //遍历数组元素,查看target-nums[i]是否在map中
        for(int i=1; i<nums.length; ++i){
            //target-nums[i]
            int rest = target - nums[i];
            //判断另一部分是否存在
            if(numMap.containsKey(rest)){
                int[] res = new int[]{i,numMap.get(rest)};
                Arrays.sort(res);
                return res;
            }
            //不存在则将当前元素以及下标放入numMap
            numMap.put(nums[i],i);
        }
        return new int[2];
    }
}
