package Algorithm_HW.Week1;

/**
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 *
 * 例如，
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * 示例 1:
 *
 * 输入: "A"
 * 输出: 1
 * 示例 2:
 *
 * 输入: "AB"
 * 输出: 28
 * 示例 3:
 *
 * 输入: "ZY"
 * 输出: 701
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/29-8:23
 */

public class LC171 {

    /**
     * s 的每个位置从最高位到最低位依次代表 ... 26^3 26^2 26 1
     * @param s
     * @return
     */
    public static int titleToNumber(String s) {
        //每一位累计乘以26
        int step = 1;
        char[] arr = s.toCharArray();
        //从最低位开始(对应字符串的最后一位)
        int index = s.length()-1;
        int sum = 0;
        while(index>=0){
            //'A'=1 每一位上的字符*对应位置的权重
            sum += (arr[index--]-'A'+1)*step;
            step *= 26;

        }
        return sum;
    }
}
