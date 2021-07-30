package JZOffer.review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**剑指 Offer 58 - I. 翻转单词顺序
 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。



 示例 1：

 输入: "the sky is blue"
 输出: "blue is sky the"
 示例 2：

 输入: "  hello world!  "
 输出: "world! hello"
 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 示例 3：

 输入: "a good   example"
 输出: "example good a"
 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


 说明：

 无空格字符构成一个单词。
 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 注意：本题与主站 151 题相同：https://leetcode-cn.com/problems/reverse-words-in-a-string/
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/29-17:21
 */

public class jz58_I {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" "); // 删除首尾空格，分割字符串
        StringBuilder res = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) { // 倒序遍历单词列表
            if(strs[i].equals("")) continue; // 遇到空单词则跳过
            res.append(strs[i] + " "); // 将单词拼接至 StringBuilder
        }
        return res.toString().trim(); // 转化为字符串，删除尾部空格，并返回
    }



}

class jz58_I_M2{
    public String reverseWords(String s) {
        if(s==null || s.length()==0){
            return "";
        }
        List<String> list = new ArrayList<>();
        int len = s.length();
        int r=len-1;
        while(r>=0){
            while(r>=0 && s.charAt(r)==' '){
                r--;
            }

            int l = r;
            while(l>=0 && s.charAt(l)!=' '){
                l--;
            }
            list.add(s.substring(l+1, r+1));
            r = l;
        }
        StringBuffer sb = new StringBuffer();
        for(String str : list){
            sb.append(str+" ");
        }
        return sb.toString().trim();
    }
}
