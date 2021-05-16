package NumList.List0131;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @Description: 229. 求众数 II
 *
给定一个大小为n的整数数组，找出其中所有出现超过⌊ n/3 ⌋次的元素。

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。

示例1：
输入：[3,2,3]
输出：[3]
*
示例 2：
输入：nums = [1]
输出：[1]
*
示例 3：
输入：[1,1,1,3,3,2,2,2]
输出：[1,2]
*
提示：
1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/majority-element-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/31 21:54
 */
public class LC229 {
    public static void main(String[] args) {
        int[] nums = {1,2};
        List<Integer> res = majorityElement(nums);
        System.out.println(res);
    }

    //排序,双指针
//    public static List<Integer> majorityElement(int[] nums) {
//        int n = nums.length;
//        ArrayList<Integer> res = new ArrayList<>();
//        if(n==0){
//            return res;
//        }
//        Arrays.sort(nums);
//        int cur = 0;
//        int next = 0;
//        for(int i=0; i<n; i++){
//            while(next<n && nums[next]==nums[cur]){
//                next++;
//            }
//            if(next-cur>n/3){
//                res.add(nums[cur]);
//            }
//            if(next<n){
//                cur = next;
//            }else{
//                break;
//            }
//        }
//        return res;
//    }

    //摩尔投票
    public static List<Integer> majorityElement(int[] nums){
        List<Integer> res = new ArrayList<>();
        int cand1 = nums[0], cand2 = nums[0], count1=0, count2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==cand1){
                count1++;
            }else if(nums[i]==cand2){
                count2++;
            }else if(count1==0){
                cand1 = nums[i];
                count1++;
            }else if(count2==0){
                cand2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==cand1){
                count1++;
            }else if(nums[i]==cand2){
                count2++;
            }
        }
        if(count1>nums.length/3){
            res.add(cand1);
        }
        if(count2>nums.length/3){
            res.add(cand2);
        }
        return res;
    }
}
