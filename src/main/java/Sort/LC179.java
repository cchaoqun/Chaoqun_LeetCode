package Sort;

import java.util.Arrays;
import java.util.Comparator;

/*
 * @Description: 179. 最大数
给定一组非负整数 nums，重新排列它们每个数字的顺序（每个数字不可拆分）使之组成一个最大的整数。

注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。



示例 1：

输入：nums = [10,2]
输出："210"
示例 2：

输入：nums = [3,30,34,5,9]
输出："9534330"
示例 3：

输入：nums = [1]
输出："1"
示例 4：

输入：nums = [10]
输出："10"


提示：

1 <= nums.length <= 100
0 <= nums[i] <= 109
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/15 13:24
 */
public class LC179 {


//    public String largestNumber(int[] nums) {
//        //找到每一轮的最小值放到最后的一个位置
//        for(int i=0; i<nums.length-1; ++i){
//            //当前最小值
//            int minval = nums[0];
//            int minIndex = 0;
//            for(int j=1; j<nums.length-i; ++j){
//                if(bigger(minval, nums[j])){
//                    minval = nums[j];
//                    minIndex = j;
//                }
//            }
//            //交换
//            nums[minIndex] = nums[nums.length-1-i];
//            nums[nums.length-1-i] = minval;
//        }
//        //多个0的情况,最高位为0,则返回 "0"
//        if(nums[0]==0){
//            return "0";
//        }
//        //按顺序拼接字符串返回
//        StringBuilder res = new StringBuilder();
//        for(int n:nums){
//            res.append(n);
//        }
//        return res.toString();
//    }
//
//    //希望较高位越大越好
//    public boolean bigger(int n1, int n2){
//        //两种组合,查看哪种的数最大
//        String s1 = n1+""+n2, s2 = n2+""+n1;
//        int i = 0;
//        for(i=0; i<s1.length(); ++i){
//            if((s1.charAt(i)-'0') > (s2.charAt(i)-'0')){
//                return true;
//            }else if((s1.charAt(i)-'0') < (s2.charAt(i)-'0')){
//                return false;
//            }
//        }
//        return false;
//    }

    private class LargerNumberComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            String s1 = o1+o2, s2 = o2+o1;
            return s2.compareTo(s1);
        }
    }

    public String largestNumber(int[] nums){
        //数组转化成字符串数组
        String[] str = new String[nums.length];
        for(int i=0; i<nums.length; ++i){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str,new LargerNumberComparator());
        if(str[0].equals("0")){
            return "0";
        }
        String res = "";
        for(int i=0; i<str.length; ++i){
            res += str[i];
        }
        return res;

    }
}
