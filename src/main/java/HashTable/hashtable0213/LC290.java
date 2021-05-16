package HashTable.hashtable0213;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Description: 290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/13 10:35
 */
public class LC290 {
    public static void main(String[] args) {


        String pattern = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd";
        String s = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        boolean res = wordPattern(pattern, s);
        System.out.println(res);

    }

    //两个map
//    public static boolean wordPattern(String pattern, String s) {
//        String[] str = s.split(" ");
//        if(str.length!=pattern.length()){
//            return false;
//        }
//        HashMap<String, String> pMap = new HashMap<>();
//        HashMap<String, String> sMap = new HashMap<>();
//        for(int i=0; i<pattern.length(); ++i){
//            String curp = pattern.substring(i,i+1);
//            String curs = str[i];
//            if(pMap.containsKey(curp) && !pMap.get(curp).equals(curs)){
//                return false;
//            }
//            if(sMap.containsKey(curs) && !sMap.get(curs).equals(curp)){
//                return false;
//            }
//            pMap.put(curp,curs);
//            sMap.put(curs,curp);
//        }
//        return true;
//    }

    //一个map
    public static boolean wordPattern(String pattern, String s){
        String[] str = s.split(" ");
        Map<Object, Integer> map = new HashMap<>();
        if(pattern.length()!=str.length){
            return false;
        }
        /**
         *  for 循环中使用 int 类型得到错误答案的原因：
         * int 类型转化 Integer 时相当于 new Integer()，在小于 127 时从常量池中取，是同一个对象，
         * 大于等于 128 用 == 判断，得到false
         *
         * 解决办法：
         * 使用 Integer 类型
         * 用 equals 代替 ==
         */
        for(Integer i=0; i<pattern.length(); ++i){
            /*
                如果key不存在，插入成功，返回null；如果key存在，返回之前对应的value。

                以pattern = "abba", str = "dog cat cat dog"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("dog",3)返回0，两者相等，
                结果为 true。

                以pattern = "abba", str = "dog cat cat fish"为例，
                第1次：map.put('a',0)返回null，map.put("dog",0)返回null，两者相等；
                第2次：map.put('b',1)返回null，map.put("cat",1)返回null，两者相等；
                第3次：map.put('b',2)返回1，map.put("cat",2)返回1，两者相等；
                第4次：map.put('a',3)返回0，map.put("fish",3)返回null，两者不相等，
                结果为 false。
            */
            //当前pattern对应的字符
            char curp = pattern.charAt(i);
            //map.put()返回的如果当前key存在,返回之前对应的value, 不存在返回 null
            //每次总是放入两个双射的char和String, value都是i, 如果两个key之前对应的value不相等,说明不是是双射
            //@return the previous value associated with <tt>key</tt>, or
            //     *         <tt>null</tt> if there was no mapping for <tt>key</tt>.
            //     *         (A <tt>null</tt> return can also indicate that the map
            //     *         previously associated <tt>null</tt> with <tt>key</tt>.)

            if(map.put(curp, i) != map.put(str[i], i)){
                return false;
            }
        }
        return true;
    }
}
