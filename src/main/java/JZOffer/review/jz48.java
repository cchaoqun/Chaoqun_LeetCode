package JZOffer.review;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/27-15:45
 */

public class jz48 {
    /**
     * 滑动窗口
     * i , j 代表当前最长不重复字符串的起始结束为止
     * 如果j代表的字符重复了
     *      从i开始遍历直到找到这个重复的字符 重复字符的位置为k
     *      从set里面删除包括重复字符在内的所有字符
     *      起始位置变成k+1
     * 如果没有重复
     *      当前字符加入set
     *      结束位置变成j
     * 更新最长的长度 res = max(res, j-i+1)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0 ){
            return 0;
        }
        int i=0, j=1, res = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        while(j<s.length()){
            char cur = s.charAt(j);
            if(set.contains(cur)){
                while(s.charAt(i)!=cur){
                    set.remove(s.charAt(i));
                    i++;
                }
                i++;
            }else{
                set.add(cur);
                res = Math.max(res, j-i+1);
            }
            j++;
        }
        return res;
    }
}
class jz48_M2{
    public int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();
        //当前不重复子串的前一个位置
        int i = -1;
        int res= 0;
        for(int j=0; j<s.length(); j++){
            //遇到重复的元素, 更新左指针到与当前元素重复的位置
            if(map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j)));
            }
            //当前元素放入map覆盖之前重复的元素, map中的元素对应的位置一定是当前最靠右的
            map.put(s.charAt(j), j);
            //更新长度
            res = Math.max(res,j-i);
        }
        return res;
    }
}































