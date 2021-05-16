package String.str0204;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * @Description: 20. 有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
 

示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
示例 4：

输入：s = "([)]"
输出：false
示例 5：

输入：s = "{[]}"
输出：true
 

提示：

1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/4 13:59
 */
public class LC20 {
    public static void main(String[] args) {
        String s = "([)]";
        isValid(s);
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if(n%2!=0){
            return false;
        }
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        Stack<Character> str = new Stack<>();
        for(char c: s.toCharArray()){
            if(map.containsKey(c)){
                if(str.size()==0 || str.peek()!=map.get(c)){
                    return false;
                }
                str.pop();
            }else{
                str.push(c);
            }
        }
        return str.isEmpty();

    }
}
