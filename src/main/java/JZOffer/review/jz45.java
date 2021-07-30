package JZOffer.review;

import java.util.Arrays;
import java.util.Random;

/**剑指 Offer 45. 把数组排成最小的数
 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。



 示例 1:

 输入: [10,2]
 输出: "102"
 示例 2:

 输入: [3,30,34,5,9]
 输出: "3033459"


 提示:

 0 < nums.length <= 100
 说明:

 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/27-14:26
 */

public class jz45 {
    /**
     x+y < y+x x更小应该排在前面
     */
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] arr = new String[len];
        for(int i=0; i<len; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (a+b).compareTo(b+a));
        StringBuffer sb = new StringBuffer();
        for(String str : arr){
            sb.append(str);
        }
        return sb.toString();
    }


}

class jz45_m2{
    Random rand = new Random();
    public void swap(String[] nums, int i, int j){
        String temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] arr = new String[len];
        for(int i=0; i<len; i++){
            arr[i] = String.valueOf(nums[i]);
        }
        quickSort(arr, 0, len-1);

        StringBuffer sb = new StringBuffer();
        for(String str : arr){
            sb.append(str);
        }
        return sb.toString();
    }
    private void quickSort(String[] arr, int l, int r){
        if(l>=r){
            return;
        }
        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot-1);
        quickSort(arr, pivot+1, r);
    }

    private int partition(String[] arr, int l, int r){
        int pivot = rand.nextInt(r-l+1)+l;
        String str = arr[pivot];
        int index = l;
        swap(arr, l, pivot);
        for(int i=l+1; i<=r; i++){
            if((arr[i]+str).compareTo(str+arr[i])<=0){
                index++;
                swap(arr, i, index);
            }
        }
        swap(arr, index, l);
        return index;
    }


}































