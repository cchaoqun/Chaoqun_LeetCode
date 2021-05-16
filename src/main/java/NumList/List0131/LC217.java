package NumList.List0131;

import java.util.*;

/*
 * @Description: 217. 存在重复元素
 *
给定一个整数数组，判断是否存在重复元素。

如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false

示例 1:
输入: [1,2,3,1]
输出: true
*
示例 2:
输入: [1,2,3,4]
输出: false
*
示例3:
输入: [1,1,1,3,3,4,3,2,4,2]
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/31 21:06
 */
public class LC217 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        boolean res = containsDuplicate(nums);
        System.out.println(res);
    }

    //排序数组,
//    public static boolean containsDuplicate(int[] nums) {
//        int n = nums.length;
//        if(n<=1){
//            return false;
//        }
//        Arrays.sort(nums);
//        for(int i=0; i<n-1; i++){
//            if(nums[i]==nums[i+1]){
//                return true;
//            }
//        }
//        return false;
//    }

    //HashMap
    public static boolean containsDuplicate(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }else{
                set.add(nums[i]);
            }
        }
        return false;
    }
}
