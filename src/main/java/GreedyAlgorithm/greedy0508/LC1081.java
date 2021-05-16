package GreedyAlgorithm.greedy0508;

/**
 * 1081. 不同字符的最小子序列
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 *
 * 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/8-16:16
 */

public class LC1081 {

    public String smallestSubsequence(String s){
        int len = s.length();
        //每个字符是否出现在栈内
        boolean[] visited = new boolean[26];
        //每个字符剩余出现的次数
        int[] showCount = new int[26];
        char[] str = s.toCharArray();
        for(char c:str){
            showCount[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<len; i++){
            //当前字符不在栈内
            if(!visited[str[i]-'a']){
                //栈顶元素大于当前元素
                while(sb.length()>0 && sb.charAt(sb.length()-1)>str[i]){
                    //判断栈顶字符是否在剩余的字符串中仍然存在, 需要保证每个字符出现一次
                    if(showCount[sb.charAt(sb.length()-1)-'a']>0){
                        //每个字符最多在栈内存在一次
                        visited[sb.charAt(sb.length()-1)-'a'] = false;
                        sb.deleteCharAt(sb.length()-1);
                    }else{
                        break;
                    }
                }
                //当前字符入栈
                sb.append(str[i]);
                //当前字符已经访问过
                visited[str[i]-'a'] = true;
            }
            //不论当前元素是否入栈, 剩余出现的次数都少了一次
            showCount[str[i]-'a']--;
        }
        return sb.toString();
    }
















}


























