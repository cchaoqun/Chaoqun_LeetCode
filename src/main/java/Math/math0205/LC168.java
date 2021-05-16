package Math.math0205;
/*
 * @Description: 168. Excel表列名称
给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
示例 1:

输入: 1
输出: "A"
示例 2:

输入: 28
输出: "AB"
示例 3:

输入: 701
输出: "ZY"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/excel-sheet-column-title
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 18:18
 */
public class LC168 {
    public static void main(String[] args) {
        int n = 26;
        String res = convertToTitle(n);
        System.out.println(res);
    }

    public static String convertToTitle(int n) {
        String res = "";
        while(n!=0){
            //26进制中每位上只能包含0-25,n--就可以将1-26映射到0-25
            //因为本题'A'=1 ,-1以后0对应着'A',否则余数为0时没有对应字符
            n--;
            res = Character.valueOf((char)(n%26+'A')).toString() + res;
            n = n / 26;

        }
        return res;
    }


}
