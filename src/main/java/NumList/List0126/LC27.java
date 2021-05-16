package NumList.List0126;

import java.util.Arrays;

/*
 * @Description: 27. 移除元素
 *
给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

示例 1:
给定 nums = [3,2,2,3], val = 3,
函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
你不需要考虑数组中超出新长度后面的元素。
*
示例2:
给定 nums = [0,1,2,2,3,0,4,2], val = 2,
函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
注意这五个元素可为任意顺序。
你不需要考虑数组中超出新长度后面的元素。

说明:
为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
你可以想象内部操作如下:
// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
  print(nums[i]);
}

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-element
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/26 22:41
 */
public class LC27 {
    public static void main(String[] args) {
        int[] nums = {1};
        int res = removeElement(nums,1);
        System.out.println(res);
        System.out.println(Arrays.toString(nums));
    }


    public static int removeElement(int[] nums, int val){
        int n = nums.length;
        //指针
        int i = 0;
        while(i<n){
            if(nums[i] == val){
                //将需要删除的元素赋值为最后一个元素
                nums[i] = nums[n-1];
                //删除数组最后一个元素
                n--;
            }else{
                //不是需要的元素,指针后移
                i++;
            }
        }
        return n;
    }

    //双指针
//    public static int removeElement(int[] nums, int val){
//        //慢指针代表数组长度
//        int i = 0;
//        //快指针,碰到不是目标的值就复制到慢指针的位置
//        for (int j=0; j<nums.length; j++){
//            if(nums[j]!=val){
//                nums[i] = nums[j];
//                //慢指针后移
//                i++;
//            }
//        }
//        return i;
//    }
}
