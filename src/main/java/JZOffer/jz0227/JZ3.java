package JZOffer.jz0227;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @Description: 剑指 Offer 03. 数组中重复的数字
找出数组中重复的数字。


在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

示例 1：

输入：
[2, 3, 1, 0, 2, 5, 3]
输出：2 或 3


限制：

2 <= n <= 100000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 11:18
 */
public class JZ3 {
    //排序双指针
//    public int findRepeatNumber(int[] nums) {
//        int n = nums.length;
//        Arrays.sort(nums);
//        for(int i=0; i<n-1; ++i){
//            if(nums[i]==nums[i+1]){
//                return nums[i];
//            }
//        }
//        return -1;
//    }

    //Set
//    public int findRepeatNumber(int[] nums){
//        Set<Integer> set = new HashSet<>();
//        for(int i=0; i<nums.length; ++i){
//            //set.add(num) if set did not contain num return true else return false
//            if(!set.add(nums[i])){
//                //set contains nums[i]
//                return nums[i];
//            }
//        }
//        return -1;
//    }

    //原地交换, 排序后,如果没有重复, i应该在nums[i]处
    public int findRepeatNumber(int[] nums){
        int temp;
        for(int i=0; i<nums.length; ++i){
            //i下标对应的数字nums[i] != i
            //只有当i下标的数字交换到i才结束,进入下一个
            while(nums[i] != i){
                //如果nums[i]等于以nums[i]为下标处数组对应的数字
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                //不等于,则交换两者
                temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return -1;
    }
}
