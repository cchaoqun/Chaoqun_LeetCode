package JZOffer.jz0228;
/*
 * @Description: 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。



示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。


提示：

0 <= nums.length <= 50000
1 <= nums[i] <= 10000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/28 17:47
 */
public class JZ21 {

    //头尾双指针
    public int[] exchange(int[] nums) {

        int even = 0, odd = nums.length-1;
        //两指针不相交
        while(even < odd){
            //even从左向右找到第一个偶数
            while(even<odd && nums[even]%2!=0){
                ++even;
            }
            //odd从右向左找到第一个奇数
            while(even<odd && nums[odd]%2==0){
                --odd;
            }
            //交换
            int temp = nums[odd];
            nums[odd] = nums[even];
            nums[even] = temp;
            //两指针移动一位
            ++even;
            --odd;
        }
        return nums;
    }


    //快慢指针
//    public int[] exchange(int[] nums){
//        if(nums.length<=1){
//            return nums;
//        }
//        //slow指向下一个奇数应该存放的位置
//        //fast向后找到下一个奇数与slow交换
//        int slow = 0, fast = 1;
//        while(fast<nums.length){
//            //当slow指向奇数时,两个指针同时后移
//            while(fast<nums.length && nums[slow]%2!=0){
//                ++slow;
//                ++fast;
//            }
//            //fast向后寻找奇数
//            while(fast<nums.length && nums[fast]%2==0){
//                ++fast;
//            }
//            //slow fast指向的位置元素交换
//            if(fast<nums.length){
//                int temp = nums[fast];
//                nums[fast] = nums[slow];
//                nums[slow] = temp;
//                //两个指针继续后移
//                ++slow;
//                ++fast;
//            }
//        }
//        return nums;
//    }
}
