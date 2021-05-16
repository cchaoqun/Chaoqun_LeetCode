package String.str0202;

import java.util.*;

/*
 * @Description: 3. 无重复字符的最长子串
 *
给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。

示例1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
*
示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
*
示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
    请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
*
示例 4:
输入: s = ""
输出: 0
*
提示：
0 <= s.length <= 5 * 104
s由英文字母、数字、符号和空格组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/2 18:25
 */
public class LC3 {

    public static void main(String[] args) {
        String str = "pwwkew";
        int res = lengthOfLongestSubstring(str);
        System.out.println(res);



    }

    //遇到重复就一直将重复之前的元素全部删除
//    public static int lengthOfLongestSubstring(String s) {
//        int n = s.length();
//        if(n<=1){
//            return n;
//        }
//        //key=每个字符, value=字符对应下标
//        Map<Character,Integer> map = new HashMap<>();
//        char[] arr = s.toCharArray();
//        //最长无重复自串起始结束下标
//        int start = 0;
//        int end = 0;
//        //最长子串长度
//        int count = 0;
//        for(int i=0; i<n; i++){
//            //如果map包含当前字符串
//            if(map.containsKey(arr[i])){
//                //保留map中重复字符对应的下标
//                int temp = map.get(arr[i]);
//                //将当前子串从起始删除到重复子串的位置
//                for(int j=start; j<=temp; j++){
//                    map.remove(arr[j]);
//                }
//                //删除后子串的起始下标变成重复子串的后面一个位置
//                start = temp+1;
//            }
//            //将当前字符添加到map中
//            map.put(arr[i], i);
//            //更新子串结束下标为当前添加的字符下标
//            end = i;
//            count = Math.max(count, end-start+1);
//        }
//        return count;
//    }

    //HashSet
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int n = s.length();
        char[] arr = s.toCharArray();
        int end = -1, res = 0;
        //i作为左指针,每一轮更换字符串的起始字符为下一个
        for(int i=0; i<n; i++){
            //剩余子串长度小于当前最长无重复子串长度,则提前结束
            if(n-i<res){
                return res;
            }
            //每轮更换下一个元素为起始字符
            if(i != 0){

                set.remove(arr[i-1]);
            }
            //右指针指向的元素不包含在集合中,就添加进去,并且右指针后移
            while(end+1<n && !set.contains(arr[end+1])){
                set.add(arr[end+1]);
                ++end;
            }
            //本轮i为起始字符的无重复的子串长度与当前最长子串长度的较大值
            res = Math.max(res, end-i+1);
        }
        return res;
    }
}
