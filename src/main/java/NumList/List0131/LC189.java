package NumList.List0131;

import javax.imageio.stream.ImageInputStream;
import java.util.Arrays;

/*
 * @Description: 189. 旋转数组
给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。

进阶：

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
你可以使用空间复杂度为O(1) 的原地算法解决这个问题吗？
*
示例 1:
输入: nums = [1,2,3,4,5,6,7], k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
*
示例2:
输入：nums = [-1,-100,3,99], k = 2
输出：[3,99,-1,-100]
解释:
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]


提示：

1 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/31 19:14
 */
public class LC189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }


    //额外数组空间
//    public static void rotate(int[] nums, int k) {
//        int n = nums.length;
//
//        if(n==0 || k % n== 0){
//            return;
//        }
//        int[] arr = new int[n];
//        for(int i=0; i<n; i++){
//            arr[(i+k)%n] = nums[i];
//        }
//        System.arraycopy(arr,0,nums,0,n);
//    }


    //翻转数组
    //1.翻转整个数组
    //2.翻转[0,(k mod n) - 1]
    //3.翻转[k mod n, n-1]
//    public static void rotate(int[] nums, int k){
//        int n = nums.length;
//        k = k % n;
//        if(k==0 || n==1 || n==0){
//            return;
//        }
//        //1.翻转整个数组
//        rotate(nums,0, n-1);
//        //2.翻转[0,(k mod n) - 1]
//        rotate(nums,0,k-1);
//        //3.翻转[k mod n, n-1]
//        rotate(nums,k,n-1);
//    }
//
//    public static void rotate(int[] nums, int start, int end){
//        while(start<end){
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }


    //环形替换
    public static void rotate(int[] nums, int k){
        int n = nums.length;
        k = k % n;
        int count = gcd(k,n);
        for(int start=0; start<count; start++){
            int current = start;
            int prevNum = nums[start];
            do{
                int next = (current+k) % n;
                int nextNum = nums[next];
                int temp = nums[next];
                nums[next] = prevNum;
                prevNum = temp;
                current = next;
            }while(start!=current);
        }
    }

    public static int gcd(int m, int n){
        return n>0?gcd(n, m%n):m;
    }
}
