package NumList.List0128;

import java.util.Arrays;

/*
 * @Description: 31. 下一个排列
 *
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。

示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]
*
示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]
*
示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]
*
示例 4：
输入：nums = [1]
输出：[1]

提示：

1 <= nums.length <= 100
0 <= nums[i] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/28 15:30
 */
public class LC31 {

    public static void main(String[] args) {
        int[] nums = {1,5,1};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    //使用了Arrays.sort()方法
//    public static void nextPermutation(int[] nums) {
//        int n = nums.length;
//        if(n==0 || n==1){
//            return;
//        }
//
//        //存储比nums[p1]大的最小值
//        int minGreat = Integer.MAX_VALUE;
//        //记录最小值的下标
//        int minIndex = -1;
//        //判断是否找到下一个字典序
//        boolean flag = false;
//        //找到p1后续元素中比nums[p1]大的最小值
//        for(int p1=n-2; p1>=0; p1--){
//            //保证当前p1指向的元素与上一次不同
//            if(p1<n-2 && nums[p1]==nums[p1+1]){
//                continue;
//            }
//            //指针在p1后续向右移动
//            int p2 = p1+1;
//            while(p2<n){
//                if(nums[p2]>nums[p1] && nums[p2]<minGreat){
//                    //表示存在
//                    flag = true;
//                    //更新最小值
//                    minGreat = nums[p2];
//                    minIndex = p2;
//                }
//                p2 += 1;
//            }
//            //更新数组
//            if(flag){
//                int temp = nums[p1];
//                nums[p1] = minGreat;
//                nums[minIndex] = temp;
//                //对p1后续数组进行升序排序，保证找到的字典序最小
//                Arrays.sort(nums, p1+1, n);
//                return;
//            }
//        }
//        //遍历完未结束，表示原数组已经降序排列，对数组升序排列后结束
//        Arrays.sort(nums);
//    }

    public static void nextPermutation(int[] nums){
        int n = nums.length;
        if(n==0 || n==1){
            return;
        }
        //p1从倒数第二个元素开始
        int p1 = n-2;
        //找到第一个nums[p1]<nums[p1+1]的组合
        //这样保证p1+1后续全部为降序
        while(p1>=0 && nums[p1]>=nums[p1+1]){
            p1 -= 1;
        }
        //如果p1=-1说明原数组为降序,将数组反转顺序
        if(p1==-1){
            reverse(nums,0);
            return;
        }
        //找到nums[p1] < nums[p1+1]的组合
        //说明[p1+1,n-1]为降序
        //从后往前找到第一个nums[p2]>nums[p1],并交换
        //这样[p1+1,n-1]仍然为降序，对这一部分反转即可
        int p2 = n-1;
        while(p2>=p1+1 && nums[p2]<=nums[p1]){
            p2 -= 1;
        }
        //交换最小的大于nums[p1]的元素
        swap(nums,p1,p2);
        //对p1后续进行反转顺序
        reverse(nums,p1+1);
    }

    //交换两个下标对应的元素
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //将数组特定部分颠倒顺序
    public static void reverse(int[] nums, int start){
        int left = start, right = nums.length-1;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
}
