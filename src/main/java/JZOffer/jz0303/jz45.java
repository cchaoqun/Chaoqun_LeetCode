package JZOffer.jz0303;


import java.util.Arrays;
import java.util.Comparator;

/*
 * @Description: 剑指 Offer 45. 把数组排成最小的数
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
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 13:47
 */
public class jz45 {
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    //普通冒泡排序
//    public String minNumber(int[] nums) {
//        //将较小的数字每次放到最后
//        for(int i=0; i<nums.length-1; ++i){
//            //默认第一个数为最大值
//            int maxVal = nums[0];
//            int maxIndex = 0;
//            for(int j=1; j<nums.length-i; ++j){
//                //如果遇到比maxVal,就更新值与下标
//                if(bigger(nums[j],maxVal)){
//                    maxVal = nums[j];
//                    maxIndex = j;
//                }
//            }
//            //最后将最大值交换到本轮的最后一个位置
//            swap(nums ,maxIndex,nums.length-1-i);
//        }
//        StringBuilder sb = new StringBuilder();
//        for(int n:nums){
//            sb.append(n);
//        }
//        return sb.toString();
//    }
//
//    void swap(int[] nums, int i, int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//
//    //比较两个数字拼接后的字符串大小 n1+n2 是否大于 n2+n1
//    boolean bigger(int n1, int n2){
//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//        //比较两个数字的组合字符串的大小
//        sb1.append(n1).append(n2);
//        sb2.append(n2).append(n1);
//        for(int i=0; i<sb1.length(); ++i){
//            //逐个字符比较, n1+n2 > n2+n1 返回true
//            if(sb1.charAt(i)-'0' >sb2.charAt(i)-'0'){
//                return true;
//            }else if(sb1.charAt(i)-'0'<sb2.charAt(i)-'0'){
//                return false;
//            }
//        }
//        //相等返回false
//        return false;
//    }

    //自定义排序
//    public String minNumber(int[] nums){
//        String[] str = new String[nums.length];
//        for(int i=0; i<nums.length; ++i){
//            str[i] = String.valueOf(nums[i]);
//        }
//        Arrays.sort(str,new LargerNumberComparator());
//        StringBuilder sb = new StringBuilder();
//        for(String s:str){
//            sb.append(s);
//        }
//        return sb.toString();
//    }
//
//    private class LargerNumberComparator implements Comparator<String>{
//        public int compare(String s1, String s2){
//            String ss1 = s2+s1;
//            String ss2 = s1+s2;
//            return ss1.compareTo(ss2);
//        }
//    }

    //快排
    public String minNumber(int[] nums){
        String[] str = new String[nums.length];
        //将数组转变成字符串数组
        for(int i=0; i<nums.length; ++i){
            str[i] = String.valueOf(nums[i]);
        }
        //对字符串数组进行选择排序
        quickSort(str,0,str.length-1);
        //拼接后返回
        StringBuilder sb = new StringBuilder();
        for(String s:str){
            sb.append(s);
        }
        return sb.toString();
    }
    //快速排序,从[start,end]区间开始
    void quickSort(String[] nums, int start, int end){
        //左端点>=右端点,数组已经有序
        if(start>=end){
            return;
        }
        //当前排序区间的左端点
        String pivot = nums[start];
        //临时变量左右端点下标
        int left = start;
        int right = end;
        //当左指针小于右指针,还有元素未遍历到
        while(left<right){
            //将与当前区间左端组合较大的字符串放到右边
            //nums[right] + pivot > pivot+nums[right] right--;
            while((nums[right]+nums[start]).compareTo(nums[start]+nums[right])>=0 && left<right){
                --right;
            }
            //将与当前区间左端组合较小的字符串放到左边
            //nums[left]+pivot <= pivot+nums[left] left++
            while((nums[left]+nums[start]).compareTo(nums[start]+nums[left])<=0 && left<right){
                ++left;
            }
            //将右边碰到的较小的字符串与左边碰到的较大的字符串交换
            String temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            //更新left right之后继续直到两指针相遇
        }

        //当前比较的pivot=nums[start]仍然在区间最左边,将其交换到最右边的<pivot的值的位置
        nums[start] = nums[left];
        nums[left] = pivot;

        //pivot值已经放到了应该放的位置(left),pivot将区间分成两部分
        //[start,left-1] 的值都小于pivot
        //[left+1,right] 的值都大于pivot
        //递归的进行排序
        quickSort(nums,start,left-1);
        quickSort(nums,left+1,end);
    }
}
