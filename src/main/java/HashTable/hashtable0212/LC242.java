package HashTable.hashtable0212;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
说明:
你可以假设字符串只包含小写字母。

进阶:
如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 22:13
 */
public class LC242 {

    //数组
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        //只包含小写字母
        int[] arr = new int[26];
        for(int i=0; i<s.length(); ++i){
            arr[s.charAt(i)-'a'] += 1;
        }
        for(int i=0; i<t.length(); ++i){
            arr[t.charAt(i)-'a'] -= 1;
            if(arr[t.charAt(i)-'a']<0){
                return false;
            }
        }

        return true;
    }

    //对于unicode HashMap
//    public boolean isAnagram(String s, String t){
//        if(s.length()!=t.length()){
//            return false;
//        }
//        Map<Character, Integer> map = new HashMap<>();
//        for(int i=0; i<s.length(); ++i){
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
//        }
//        for(int i=0; i<t.length(); ++i){
//            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
//            if(map.get(t.charAt(i))<0){
//                return false;
//            }
//        }
//        return true;
//    }

}
