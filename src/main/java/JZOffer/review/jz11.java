package JZOffer.review;

/**剑指 Offer 11. 旋转数组的最小数字
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。

 示例 1：

 输入：[3,4,5,1,2]
 输出：1
 示例 2：

 输入：[2,2,2,0,1]
 输出：0
 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/21-13:56
 */

public class jz11 {
    public int minArray(int[] numbers) {
        /**
         int len = numbers.length;
         numbers[0] < number[len-1] min = number[0] 升序数组
         二分
         旋转数组 假设最小的元素坐标为x
         [x:len-1]的元素一定都是 <= numbers[len-1]的
         [0:x-1]的元素一定都是 >= numbers[len-1]的
         每次取到的中点都与右端点比较
         如果 num[mid] > num[r] l = mid+1
         如果 num[mid] < num[r] r = mid
         如果 num[mid] == num[r] r--; 因为至少有两个一样的num[mid] 右边界左缩进一个位置

         */
        if(numbers==null || numbers.length==0){
            return -1;
        }
        int len = numbers.length;
        if(numbers[0] < numbers[len-1]){
            return numbers[0];
        }
        int l = 0;
        int r = len-1;
        while(l<r){
            int mid = (l+r)>>>1;
            if(numbers[mid]>numbers[r]){
                l = mid+1;
            }else if(numbers[mid]<numbers[r]){
                r = mid;
            }else{
                r--;
            }
        }
        return numbers[l];
    }
}
