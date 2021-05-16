package JZOffer.jz0227;
/*
 * @Description: 剑指 Offer 05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。



示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."


限制：

0 <= s 的长度 <= 10000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 11:51
 */
public class JZ5 {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int i=0, j=0;
        char space = ' ';
        String rep = "%20";
        for(;i<s.length() && j<s.length();){
            //当字符不为空格j指针后移
            while(j<s.length() && s.charAt(j)!=space){
                ++j;
            }
            //将不为空格一部分添加
            sb.append(s.substring(i,j));
            //判断越界条件
            if(j==s.length()){
                return sb.toString();
            }else{
                //j所在的位置为空格,添加一个替代空格字符串
                sb.append(rep);
                //两个指针同时移动到下一个位置
                ++j;
                i=j;
            }
        }
        return sb.toString();
    }
}
