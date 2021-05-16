package JZOffer.jz0305;
/*
 * @Description: 剑指 Offer 58 - II. 左旋转字符串
字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。



示例 1：

输入: s = "abcdefg", k = 2
输出: "cdefgab"
示例 2：

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"


限制：

1 <= k < s.length <= 10000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/5 11:00
 */
public class jz58_II {
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        n = n % len;
        //reverse the whole string
        String sAll = reverseWords(s);
        //pivot index len-1-pivot+1 = n =>pivot = len-n
        int pivot = len-n;
        //reverse left
        String sLeft = reverseWords(sAll.substring(0,pivot));
        //reverse right
        String sRight = reverseWords(sAll.substring(pivot,len));
        //concatenate
        return sLeft+sRight;
    }

    public String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; --i){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

}
