package NumList.List0202;

import java.util.Arrays;

/*
 * @Description: 283. 移动零
给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]
说明:

必须在原数组上操作，不能拷贝额外的数组。
尽量减少操作次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/2 16:29
 */
public class LC283 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,0,3,12,0,2,0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }
        int p1 = 0, p2 = 0;
        while(p2<n){
            //遇到非零数字就与p1指针位置交换
            if(nums[p2]!=0){
                swap(nums,p1,p2);
                //p1指针后移
                p1++;
            }
            //p2指针后移
            p2++;
        }
    }

    public static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
