package String.str0204;
/*
 * @Description: 58. 最后一个单词的长度
给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。

单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

 

示例 1：

输入：s = "Hello World"
输出：5
示例 2：

输入：s = " "
输出：0
 

提示：

1 <= s.length <= 104
s 仅有英文字母和空格 ' ' 组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/length-of-last-word
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/4 21:38
 */
public class LC58 {

    public int lengthOfLastWord(String s) {
        int n = s.length();
        if(s==null || n==0){
            return 0;
        }
        int end = n-1, count = 0;
        char[] arr = s.toCharArray();
        while(end>=0 && arr[end]==' '){
            end--;
        }
        if(end==-1){
            return 0;
        }
        while(end>=0 && arr[end]!=' '){
            end--;
            count += 1;
        }
        return count;
    }
}
