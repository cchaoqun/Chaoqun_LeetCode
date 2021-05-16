package BinarySearch;

import java.util.Arrays;

/*
 * @Description: 167. 两数之和 II - 输入有序数组
给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。

函数应该返回这两个下标值 index1 和 index2，其中 index1必须小于index2。

说明:

返回的下标值（index1 和 index2）不是从零开始的。
你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 16:55
 */
public class LC167 {
    public static void main(String[] args) {
        int[] numbers = new int[]{5,25,75};
        int[] res = twoSum(numbers,100);
        System.out.println(Arrays.toString(res));


    }
    //二分查找
//    public static int[] twoSum(int[] numbers, int target) {
//        for(int i=0; i<numbers.length; i++){
//            int rest = target-numbers[i];
//            int left = i+1;
//            int right = numbers.length-1;
//            while(left<=right){
//                int mid = (left+right)/2;
//                int temp = numbers[mid];
//                if(rest == temp){
//                    return new int[]{i+1,mid+1};
//                }else if(rest > temp){
//                    left = mid+1;
//                }else{
//                    right =mid-1;
//                }
//            }
//        }
//        return new int[]{-1,-1};
//    }

    //双指针
//    public static int[] twoSum(int[] numbers, int target){
//        int left = 0;
//        int right = numbers.length-1;
//        while(left<right){
//            int sum = numbers[left]+numbers[right];
//            if(sum==target){
//                return new int[]{left+1,right+1};
//            }else if(sum<target){
//                left++;
//            }else{
//                right--;
//            }
//        }
//        return new int[]{-1,-1};
//    }

    //二分+双指针
    public static int[] twoSum(int[] numbers, int target){
        int p2 = binarySearch(numbers,target - numbers[0]);
        int p1 = 0;

        while(p1<p2 && numbers[p1]+numbers[p2] != target){
            while(p1<p2 && numbers[p1]+numbers[p2] > target){
                p2--;
            }
            while(p1<p2 && numbers[p1]+numbers[p2] < target){
                p1++;
            }
        }
        return new int[]{p1+1,p2+1};
    }

    public static int binarySearch(int[] num, int target){
        int left = 0;
        int right = num.length-1;
        while(left<right){
            int mid = (left+right)/2;
            int temp = num[mid];
            if(target==temp){
                return mid;
            }else if(target<temp){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}
