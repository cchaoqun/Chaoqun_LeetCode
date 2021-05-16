package String.str0204;

import java.util.*;

/*
 * @Description: 49. 字母异位词分组
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/group-anagrams
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/4 19:45
 */
public class LC49 {

    //利用字符串每个字符出现的次数编码每个字符串的特殊编码作为key,字母异位词具有相同的编码
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        //遍历数组中每个字符串
        for(int i=0; i<strs.length; i++){
            //每个字符串通过数组统计每个字符出现的次数
            int[] c = new int[26];
            String cur = strs[i];
            for(int j=0; j<strs[i].length(); j++){
                c[cur.charAt(j)-'a']++;
            }
            //通过StringBuilder构建当前字符串的特殊编码
            StringBuilder sb = new StringBuilder();
            //统计出现的字符以及出现的次数
            for(int k=0; k<26; k++){
                if(c[k]!=0){
                    //先添加字符再添加出现次数
                    sb.append((char)(k+'a')).append(c[k]);
                }
            }
            //字母异位词获取对应的list集合将字符串添加进去
            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(cur);
            }else{
                //第一次出现
                List<String> list = new ArrayList<>();
                list.add(cur);
                map.put(sb.toString(), list);
            }
        }
        List<List<String>> res = new ArrayList<>();
        //遍历hashmap中的list集合依次添加进去
        for(List<String> list:map.values()){
            res.add(list);
        }
        return res;
    }

    //排序
//    public List<List<String>> groupAnagrams(String[] strs){
//        Map<String,List<String>> map = new HashMap<>();
//        for(String str:strs){
//            //生成字符串对应字符数组
//            char[] cha = str.toCharArray();
//            //排序,异位词排序后的结果相同
//            Arrays.sort(cha);
//            //转化成字符串作为该异位词的key
//            String key = new String(cha);
//            //如果没有则创建一个新list
//            List<String> list = map.getOrDefault(key,new ArrayList<String>());
//            list.add(str);
//            map.put(key,list);
//        }
//        return new ArrayList<List<String>>(map.values());
//    }
}
