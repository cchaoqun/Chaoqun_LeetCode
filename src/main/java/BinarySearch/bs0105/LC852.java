package BinarySearch;

/*
 * @Description:
我们把符合下列属性的数组A称作山脉：

A.length >= 3
存在 0 < i< A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
给定一个确定为山脉的数组，返回任何满足A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]的 i的值。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 14:19
 */
public class LC852 {
    public static void main(String[] args) {
        int[] arr = {100,99,79,78,67,36,26,19};
        int res = peakIndexInMountainArray(arr);
        System.out.println(res);
    }

    //暴力遍历
//    public static int peakIndexInMountainArray(int[] arr) {
//        for(int i=1; i<arr.length; i++){
//            if(arr[i] > arr[i+1]){
//                return i;
//            }
//
//        }
//        return -1;
//    }

    //二分 left<=right 循环体内返回
//    public static int peakIndexInMountainArray(int[] arr){
//        int left = 0;
//        int right = arr.length-1;
//        while(left<=right){
//            int mid = (left+right)/2;
//            if(arr[mid] > arr[mid+1] && arr[mid]>arr[mid-1]){
//                return mid;
//            }else if (arr[mid] < arr[mid+1]){
//                left = mid+1;
//            }else{
//                right = mid-1;
//            }
//        }
//        return -1;
//    }

    //二分 left < right 循环体外返回, left=right退出
    public static int peakIndexInMountainArray(int[] arr){
        int left = 0;
        int right = arr.length;
        while(left<right){
            int mid = (left+right)/2;
            if (arr[mid] < arr[mid+1]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
