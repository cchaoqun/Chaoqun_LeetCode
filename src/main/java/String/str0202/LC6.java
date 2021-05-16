package String.str0202;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 6. Z 字形变换
 *
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行Z 字形排列。

比如输入字符串为 "PAYPALISHIRING"行数为 3 时，排列如下：

P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);

示例 1：
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
*
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
*
示例 3：
输入：s = "A", numRows = 1
输出："A"

提示：
1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/2 22:28
 */
public class LC6 {
    public static void main(String[] args) {
        // numRows + numRows-2
        // 0, 2(numRows-1), 4(numsRows-1), 2*i(numRows-1)
        // 1, 2(numRows-2)+1, ... 2*i(numRows-2)
    }

    //按照字符串转变成Z的顺序扫描字符串,将对应字符添加到对应的行的StringBuilder中
    //当下标为 0||numRows-1时.改变添加的顺序
    //  如:一开始从row[0] -> row[numRows-1]
    //  到达row[numRows-1]后续反向添加到row[0] 如此往复
    //最后遍历存储各行字符的StringBuilder append 到StringBuilder中返回
    public String convert(String s, int numRows) {
        if(numRows<2){
            return s;
        }
        //存储每行的字符到对应的StringBuilder
        List<StringBuilder> list = new ArrayList<>();
        for(int i=0; i<numRows; i++){
            //给每行添加对应的StringBuilder
            list.add(new StringBuilder());
        }
        int flag = -1, i = 0;
        for(char c : s.toCharArray()){
            //将对应字符添加到对应StringBuilder中
            list.get(i).append(c);
            //判断是否到达拐点需要按相反方向顺序向StringBuilder中添加字符
            if(i==0 || i == numRows-1){
                flag = -flag;
            }
            //StringBuilder反向
            i += flag;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder sbb: list){
            sb.append(sbb);
        }
        return sb.toString();
    }
}
