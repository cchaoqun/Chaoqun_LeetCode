package JZOffer.review;

/**剑指 Offer 05. 替换空格
 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。



 示例 1：

 输入：s = "We are happy."
 输出："We%20are%20happy."


 限制：

 0 <= s 的长度 <= 10000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/21-14:34
 */

public class jz05 {
    public String replaceSpace(String s) {
        StringBuffer sb  = new StringBuffer();
        String rep = "%20";
        for(char c : s.toCharArray()){
            if(c==' '){
                sb.append(rep);
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
