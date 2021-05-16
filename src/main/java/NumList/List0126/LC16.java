package NumList.List0126;

import java.util.Arrays;

/*
 * @Description: 16. 最接近的三数之和
给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。
返回这三个数的和。假定每组输入只存在唯一答案。

示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

提示：
3 <= nums.length <= 10^3
-10^3<= nums[i]<= 10^3
-10^4<= target<= 10^4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/3sum-closest
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/26 20:27
 */
public class LC16 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,8,16,32,64,128};
        int res = threeSumClosest(nums,82);
        System.out.println(res);
    }



    //三指针
    //first从0-length-1
    //second从first+1向右
    //third 从length-1向左
    public static int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int minSum = 0;
        //将数组排序
        Arrays.sort(nums);
        //第一个指针从0开始
        for(int first=0; first<n; ++first){
            //如果当前值与上一次的相同则跳到下一个循环
            if(first>0 && nums[first]==nums[first-1]){
                continue;
            }
            int second = first+1;
            int third = n-1;
            while(second<third){
                //当前三数之和
                int curSum = nums[first]+nums[second]+nums[third];
                //三数和与target的差值
                int diff = Math.abs(curSum-target);
                if(diff == 0){
                    return target;
                }
                if(diff<minDiff){
                    //更新最小差值
                    minDiff = diff;
                    //更新最小差值组成元素的和
                    minSum = curSum;

                }
                if(curSum > target){
                    third--;
                    while(third>second && nums[third]==nums[third+1]){
                        //当三数之和>target,将第三个指针向左移动到下一个不相等的数的位置
                        third--;
                    }
                }else{
                    second++;
                    while(second<third && nums[second]==nums[second-1]){
                        //当三数之和<target,将第二个指针向右移动到下一个不相等的数的位置
                        second++;
                    }
                }

            }

        }
        return minSum;
    }
}
