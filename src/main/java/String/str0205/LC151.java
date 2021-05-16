package String.str0205;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * @Description: 151. 翻转字符串里的单词
给定一个字符串，逐个翻转字符串中的每个单词。

说明：

无空格字符构成一个 单词 。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 

示例 1：

输入："the sky is blue"
输出："blue is sky the"
示例 2：

输入："  hello world!  "
输出："world! hello"
解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入："a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
示例 4：

输入：s = "  Bob    Loves  Alice   "
输出："Alice Loves Bob"
示例 5：

输入：s = "Alice does not even like bob"
输出："bob like even not does Alice"
 

提示：

1 <= s.length <= 104
s 包含英文大小写字母、数字和空格 ' '
s 中 至少存在一个 单词

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-words-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 11:35
 */
public class LC151 {
    public static void main(String[] args) {
        String s = "  Bob    Loves  Alice   ";
        String res = reverseWords(s);
        System.out.println(res);
    }

    public static String reverseWords(String s) {
        //先将所有单词添加到Stack中
        Deque<String> stack = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            //遇到不是' '开始算一个单词
            if(arr[i]!=' '){
                int j=i;
                while(j<s.length() && arr[j]!=' '){
                    ++j;
                }
                //到下一个' '之间的一个单词入栈顶,这样自动逆序
                stack.push(s.substring(i,j));
                //索引移动到下一个空格的地方
                //结束本次循环i++移动到' '后一位接着判断下一个单词
                i=j;
            }
        }
        return String.join(" ",stack);
    }
}
