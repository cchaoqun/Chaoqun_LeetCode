package String.str0204;
/*
 * @Description: 43. 字符串相乘
给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
示例 2:

输入: num1 = "123", num2 = "456"
输出: "56088"
说明：

num1 和 num2 的长度小于110。
num1 和 num2 只包含数字 0-9。
num1 和 num2 均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/multiply-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/4 19:02
 */
public class LC43 {
    public static void main(String[] args) {
        String num1 = "498828660196", num2 = "840477629533";
        String res = multiply(num1,num2);
        System.out.println(res);

    }

    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int n1 = num1.length(), n2 = num2.length();
        int[] res = new int[n1+n2];
        for(int i=n2-1; i>=0; i--){
            int dig = num2.charAt(i)-'0';
            for(int j=n1-1; j>=0; j--){
                int dig2 = num1.charAt(j)-'0';
                //将对应位置两个个位数相乘的结果放入对应数组的位置
                res[i+j+1] += dig * dig2;
            }
        }
        //从后往前依次将每个位置多出的数进行进位操作
        for(int i=n1+n2-1; i>0; i--){
            res[i-1] += res[i]/10;
            res[i] = res[i]%10;
        }
        StringBuilder sb = new StringBuilder();
        //只有第一位可能为0
        int start = res[0]==0?1:0;
        while(start<n1+n2){
            sb.append(res[start]);
            start++;
        }
        return sb.toString();

    }
}
