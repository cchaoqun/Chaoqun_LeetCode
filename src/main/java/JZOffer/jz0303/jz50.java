package JZOffer.jz0303;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @Description: 剑指 Offer 50. 第一个只出现一次的字符
在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = ""
返回 " "


限制：

0 <= s 的长度 <= 50000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 17:46
 */
public class jz50 {

    //哈希表
    public char firstUniqChar(String s) {
        if(s==null){
            return ' ';
        }
        //<字符, 字符是否出现了一次>
        Map<Character, Boolean> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for(char c:arr){
            //第一次每个字符value都为true
            //以后只要遇到重复,覆盖的value都为false,因为始终containsKey()
            map.put(c,!map.containsKey(c));
        }
        for(char c:arr){
            //遍历原始数组,第一个为true的即为第一次出现一次的字符
            if(map.get(c)){
                return c;
            }
        }
        return ' ';
    }

    //有序哈希表
//    public char firstUniqChar(String s){
//        if(s==null){
//            return ' ';
//        }
//        //<字符, 字符是否出现了一次>
//        Map<Character, Boolean> map = new LinkedHashMap<>();
//        char[] arr = s.toCharArray();
//        for(char c:arr){
//            //第一次每个字符value都为true
//            //以后只要遇到重复,覆盖的value都为false,因为始终containsKey()
//            map.put(c,!map.containsKey(c));
//        }
//        //有序哈希表是按照插入顺序排序,遇到的第一个出现一次的即为所求字符
//        for(Map.Entry<Character, Boolean> entry: map.entrySet()){
//            if(entry.getValue()){
//                return entry.getKey();
//            }
//        }
//        return ' ';
//    }
}
