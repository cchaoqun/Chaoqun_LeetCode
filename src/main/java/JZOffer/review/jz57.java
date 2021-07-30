package JZOffer.review;

import java.util.HashSet;
import java.util.Set;

/**剑指 Offer 57. 和为s的两个数字
 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。



 示例 1：

 输入：nums = [2,7,11,15], target = 9
 输出：[2,7] 或者 [7,2]
 示例 2：

 输入：nums = [10,26,30,31,47,60], target = 40
 输出：[10,30] 或者 [30,10]


 限制：

 1 <= nums.length <= 10^5
 1 <= nums[i] <= 10^6
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/29-16:24
 */

public class jz57 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> visited = new HashSet<>();
        for(int num : nums){
            int want = target-num;
            if(visited.contains(want)){
                return new int[]{num, want};
            }
            visited.add(num);
        }
        return new int[]{-1,-1};
    }
}
class jz57_M2{
    //双指针
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int l=0, r=len-1;
        while(l<r){
            int sum = nums[l]+nums[r];
            if(sum==target){
                return new int[]{nums[l], nums[r]};
            }else if(sum > target){
                r--;
            }else{
                l++;
            }
        }
        return new int[]{-1,-1};
    }
}






























