package NumList.List0129;

import java.util.Arrays;

/*
 * @Description: 66. 加一
 *
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例1：
输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。
*
示例2：
输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。
*
示例 3：
输入：digits = [0]
输出：[1]

提示：

1 <= digits.length <= 100
0 <= digits[i] <= 9

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/29 15:15
 */
public class LC66 {
    public static void main(String[] args) {
        int[] digits = {9,9,9,9,9};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
//    public static int[] plusOne(int[] digits) {
//        int n = digits.length;
//        if(digits[n-1] != 9){
//            //不存在进位
//            digits[n-1] += 1;
//            return digits;
//        }
//        //从后向前找到第一个不等于9的位置
//        int i = n-1;
//        while(i>=0 && digits[i]==9){
//            //进位后变成0
//            digits[i] = 0;
//            i--;
//        }
//        //判断是否需要增加位数
//        if(i==-1){
//            //需要增加一位
//            int[] arr = new int[n+1];
//            //只需将第一位变成1,其他都为0
//            arr[0] = 1;
//            return arr;
//        }else{
//            //不需要增加位数.将不为9的数字+1
//            digits[i] += 1;
//            return digits;
//        }
//
//    }

    public static int[] plusOne(int[] digits){
        for(int i=digits.length-1; i>=0; i--){
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i] != 0){
                return digits;
            }
        }
        int[] arr = new int[digits.length+1];
        arr[0] = 1;
        return arr;
    }
}
