package NumList.List0129;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
 * @Description: 75. 颜色分类
 *
给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。


示例 1：
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]
*
示例 2：
输入：nums = [2,0,1]
输出：[0,1,2]
*
示例 3：
输入：nums = [0]
输出：[0]
*
示例 4：
输入：nums = [1]
输出：[1]


提示：

n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-colors
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/29 16:30
 */
public class LC75 {


    //两次遍历
//    public static void sortColors(int[] nums) {
//        int n = nums.length;
//        if(n==0 || n==1){
//            return;
//        }
//        int one = 0, two = 0, three = 0;
//        for(int i=0; i<n; i++){
//            if(nums[i]==0){
//                one++;
//            }else if(nums[i]==1){
//                two++;
//            }else{
//                three++;
//            }
//        }
//        Arrays.fill(nums, 0, one, 0);
//        Arrays.fill(nums, one, one+two, 1);
//        Arrays.fill(nums, one+two, n, 2);
//    }

    //一次遍历,双指针 p0 p1
    public static void sortColors(int[] nums){
        int n = nums.length;
        if(n==0 || n==1){
            return;
        }
        int p0 = 0, p1 = 0;
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                //如果等于1将当前元素与p1指针位置元素交换
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                //p1指针后移
                ++p1;
            }else if(nums[i] == 0){
                //将当前元素与p0位置元素交换
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if(p0<p1){
                    //交换出去的为1,需要将当前交换后的元素与p1指针位置元素交换
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                //两个指针都后移一位
                ++p0;
                ++p1;
            }
        }
    }

    //p0 p2
//    public void sortColors(int[] nums) {
//        int n = nums.length;
//        int p0 = 0, p2 = n - 1;
//        for (int i = 0; i <= p2; ++i) {
//            //如果交换到前面的仍然是2则继续交换到不为2为止
//            while (i <= p2 && nums[i] == 2) {
//                int temp = nums[i];
//                nums[i] = nums[p2];
//                nums[p2] = temp;
//                --p2;
//            }
//            if (nums[i] == 0) {
//                int temp = nums[i];
//                nums[i] = nums[p0];
//                nums[p0] = temp;
//                ++p0;
//            }
//        }
//    }

}
