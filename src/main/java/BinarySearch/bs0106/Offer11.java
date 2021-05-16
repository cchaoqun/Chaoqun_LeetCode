package BinarySearch.bs0106;
/*
 * @Description: 剑指 Offer 11. 旋转数组的最小数字

 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 输入：[3,4,5,1,2]
输出：1
* 输入：[2,2,2,0,1]
输出：0
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 12:30
 */
public class Offer11 {
    public static void main(String[] args) {
        int[] numbers = {1,3,5};
        int res = minArray(numbers);
        System.out.println(res);
    }

//    public static int minArray(int[] numbers) {
//        //最小值左边的值都>=最小值右边的值
//        int left = 0;
//        int right = numbers.length-1;
//        int mid = left+(right-left)/2;
//        //已经递增排序
//        if(numbers[left]<numbers[right]){
//            return numbers[left];
//        }
//        while(left<=right){
//            //二分后的数组为有序递增的
//            if(numbers[left]<numbers[right]){
//                return numbers[left];
//            }
//            mid = left+(right-left)/2;
//            if(numbers[mid]<numbers[left]){
//                //在左半区间
//                right = mid;
//                left++;
//            }else if(numbers[mid] > numbers[left]){
//                //在右半区间
//                left = mid+1;
//            }else {
//                //忽略左区间端点
//                left += 1;
//            }
//        }
//        return numbers[mid];
//    }

    public static int minArray(int[] numbers) {
        //最小值左边的值都>=最小值右边的值
        int left = 0;
        int right = numbers.length-1;

        while(left<right){
            int mid = left+(right-left)/2;
            if(numbers[mid]<numbers[right]){
                //在左半区间
                right = mid;
            }else if(numbers[mid] > numbers[right]){
                //在右半区间
                left = mid+1;
            }else {
                //忽略右区间端点
                right-=1;
            }
        }
        return numbers[left];
    }


}
