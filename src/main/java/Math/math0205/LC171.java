package Math.math0205;
/*
 * @Description: 171. Excel表列序号
给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/excel-sheet-column-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 19:05
 */
public class LC171 {
    public static void main(String[] args) {
        String s = "ZY";
        int res = titleToNumber(s);
        System.out.println(res);
    }

    public static int titleToNumber(String s) {
        int mul = 1, index = s.length()-1, res = 0;
        while(index>=0){
            int cur = s.charAt(index)-'A'+1;
            res += cur * mul;
            mul *= 26;
            --index;
        }
        return res;
    }
}
