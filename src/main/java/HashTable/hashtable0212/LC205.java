package HashTable.hashtable0212;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 205. 同构字符串
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。



示例 1:

输入：s = "egg", t = "add"
输出：true
示例 2：

输入：s = "foo", t = "bar"
输出：false
示例 3：

输入：s = "paper", t = "title"
输出：true


提示：

可以假设 s 和 t 长度相同。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 21:28
 */
public class LC205 {


    //HashSet
//    public boolean isIsomorphic(String s, String t) {
//        Map<Character, Character> s2t = new HashMap<>();
//        Map<Character, Character> t2s = new HashMap<>();
//        for(int i=0; i<s.length(); ++i) {
//            char sChar = s.charAt(i);
//            char tChar = t.charAt(i);
//            if(s2t.containsKey(sChar) && s2t.get(sChar)!=tChar){
//                return false;
//            }
//            if(t2s.containsKey(tChar) && t2s.get(tChar)!=sChar){
//                return false;
//            }
//            s2t.put(sChar, tChar);
//            t2s.put(tChar, sChar);
//        }
//        return true;
//    }

    //数组
    public boolean isIsomorphic(String s, String t){
        char[] st = t.toCharArray();
        char[] ts = s.toCharArray();
        //两个字符串对应位置的字符在对应整数数组中的数字都是 下标+1
        //判断是否是双射只需查看两个字符在对应整数数组中的值是否相同
        int[] indexS = new int[256];
        int[] indexT = new int[256];
        for(int i=0; i<s.length(); ++i){
            if(indexS[st[i]]!=indexT[ts[i]]){
                return false;
            }
            indexS[st[i]] = i+1;
            indexT[ts[i]] = i+1;
        }
        return true;
    }
}
