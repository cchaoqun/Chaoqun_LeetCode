package Sort.sort0527;

/**
 * 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 *
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/27-12:47
 */

public class LC922 {
    public int[] sortArrayByParityII(int[] nums) {
        //偶数指针
        int p0 = 0;
        //奇数指针
        int p1 = 1;
        while(true){
            //偶指针移动直到偶数位置为奇数
            while(p0<nums.length && (nums[p0]&1)==0){
                p0 += 2;
            }
            if(p0>=nums.length){
                break;
            }
            //奇数指针移动直到奇数位置为偶数
            while(p1<nums.length && (nums[p1]&1)==1){
                p1+=2;
            }
            //交换
            int temp = nums[p0];
            nums[p0] = nums[p1];
            nums[p1] = temp;
        }
        return nums;
    }
}
