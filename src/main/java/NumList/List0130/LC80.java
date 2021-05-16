package NumList.List0130;

import java.util.Arrays;

/*
 * @Description: 80. 删除排序数组中的重复项 II
 *
给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。



说明：

为什么返回数值是整数，但输出的答案是数组呢？

请注意，输入数组是以“引用”方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下：

// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
for (int i = 0; i < len; i++) {
  print(nums[i]);
}


示例 1：

输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 你不需要考虑数组中超出新长度后面的元素。
示例 2：

输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。 你不需要考虑数组中超出新长度后面的元素。


提示：

0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums 按递增顺序排列

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/30 16:28
 */
public class LC80 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,3,3,4,5,5,5,6,6,7,7,8};
        int res = removeDuplicates(nums,3);
        System.out.println(res + " " +Arrays.toString(nums));
    }


    //双指针
    //模板, 一个升序数组允许一个元素最多出现k次,原地修改
    public static int removeDuplicates(int[] nums, int k) {
        int n = nums.length;
        if(n==0 || n==1 || n==2){
            return n;
        }
        //快慢指针
        int start = 1;
        int next = 1;
        int count = 1;
        for(;start<n; start++){
            //当前元素和前一个元素相同
            if(nums[start]==nums[start-1]){
                //记录相同元素的个数
                count++;
            }else{
                //不相同,说明第一次遇到了一个新的元素,出现次数为1
                count = 1;
            }
            //判断当前元素出现的次数
            //只有在count<=k的时候,才将对应元素移动到应该覆盖的位置,否则只是
            //start向后移动,直到遇到新的元素将新元素覆盖并且向后移动j
            if(count<=k){
                //当前元素出现次数小于等于2,将其移动到next指向的位置
                nums[next] = nums[start];
                //将两个指针同时向后移动,start指针移动在循环里实现了
                next++;
            }
        }
        return next;
    }
}
