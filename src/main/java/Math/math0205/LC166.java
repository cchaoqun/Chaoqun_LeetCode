package Math.math0205;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 166. 分数到小数
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。

如果小数部分为循环小数，则将循环的部分括在括号内。

如果存在多个答案，只需返回 任意一个 。

对于所有给定的输入，保证 答案字符串的长度小于 104 。

 

示例 1：

输入：numerator = 1, denominator = 2
输出："0.5"
示例 2：

输入：numerator = 2, denominator = 1
输出："2"
示例 3：

输入：numerator = 2, denominator = 3
输出："0.(6)"
示例 4：

输入：numerator = 4, denominator = 333
输出："0.(012)"
示例 5：

输入：numerator = 1, denominator = 5
输出："0.2"
 

提示：

-231 <= numerator, denominator <= 231 - 1
denominator != 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/fraction-to-recurring-decimal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 17:40
 */
public class LC166 {
    public static void main(String[] args) {
        String res = fractionToDecimal(112,545891263);
        System.out.println(res);
    }

    public static String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        //分子分母只有一个小于0的时候
        if(numerator<0 ^ denominator<0){
            sb.append("-");
        }
        //转化成绝对值计算,防止Integer.MIN_VALUE变成正数溢出,先变成Long
        long nu = Math.abs(Long.valueOf(numerator));
        long de = Math.abs(Long.valueOf(denominator));
        //处理整数部分
        sb.append(String.valueOf(nu/de));
        //计算余数
        long re = nu % de;
        if(re==0){
            //刚好整除
            return sb.toString();
        }
        //处理小数部分
        sb.append(".");
        //哈希表记录余数出现的位置,如果相同的余数第二次出现就将循环部分放进括号返回
        Map<Long,Integer> map = new HashMap<>();
        while(re!=0){
            if(map.containsKey(re)){
                //余数上一次出现的位置插入左括号
                sb.insert(map.get(re),"(");
                //末尾接上右括号,括号里为循环部分
                sb.append(")");
                break;
            }
            //记录余数在结果中的位置
            map.put(re,sb.length());
            re *= 10;
            //除以分母的结果
            sb.append(String.valueOf(re/de));
            //变成除以分母的余数
            re %= de;
        }
        return sb.toString();
    }
}
