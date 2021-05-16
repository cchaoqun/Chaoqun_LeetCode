package String.str0204;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 12. 整数转罗马数字
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

示例 1:

输入: 3
输出: "III"
示例 2:

输入: 4
输出: "IV"
示例 3:

输入: 9
输出: "IX"
示例 4:

输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
示例 5:

输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
 

提示：

1 <= num <= 3999

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/integer-to-roman
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/4 10:45
 */
public class LC12 {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }


//    public static String intToRoman(int num) {
//        Map<Integer,String> table = new HashMap<>();
//        table.put(1,"I");
//        table.put(4,"IV");
//        table.put(5,"V");
//        table.put(9,"IX");
//        table.put(10,"X");
//        table.put(40,"XL");
//        table.put(50,"L");
//        table.put(90,"XC");
//        table.put(100,"C");
//        table.put(400,"CD");
//        table.put(500,"D");
//        table.put(900,"CM");
//        table.put(1000,"M");
//        int n = (num+"").length();
//        String res = "";
//        int temp = 10;
//        for(int i=0; i<n; i++){
//            int digit = num%10;
//            int cur = digit*(temp/10);
//            String str = "";
//            if(digit==1 || digit==4 || digit==5 || digit==9){
//                str = table.get(cur);
//            }else if(digit<4){
//                for(int j=1; j<=digit; j++){
//                    str += table.get(cur/digit);
//                }
//            }else if(digit<9){
//                str += table.get(5*(temp/10));
//                for(int j=6; j<=digit; j++){
//                    str += table.get(cur/digit);
//                }
//            }
//            res = str+res;
//            temp *= 10;
//            num = num/10;
//
//        }
//        return res;
//    }

    //贪心算法,每次都将最大的可能罗马数字放入字符串中,
    public static String intToRoman(int num){
        StringBuilder stringBuilder = new StringBuilder();
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for(int i=0; i<value.length && num>=0; i++){
            while(value[i]<=num){
                num -= value[i];
                stringBuilder.append(romans[i]);
            }
        }
        return stringBuilder.toString();
    }
}
