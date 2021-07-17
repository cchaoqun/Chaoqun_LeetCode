package company.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/23-15:05
 */

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        //连续无重复子串的起始和结束坐标
        int start = 0, end = 0, maxLen = 1;
        char[] arr = s.toCharArray();
        //初始只有一个字符
        map.put(arr[0], 0);
        for(int i=1; i<arr.length; i++){
            //当前字符
            char cur = arr[i];
            //如果之前包含了当前字符, 需要判断是否需要更新连续子串的起始坐标
            if(map.containsKey(cur)){
                //与当前字符重复的字符在字符串中的位置
                int temp = map.get(cur);
                //如果重复字符在当前连续子串区间之前,则无需改变, 因为等于当前连续子串不包含当前字符 没有影响
                //如果重复的字符在当前连续子串中间, 需要更新起始坐标为重复字符的后一个位置,
                //  这样删除了包括重复字符在内的前面部分, 这样保证了当前字符不会重复
                if(temp>=start){
                    start = temp+1;
                }
            }
            //更新当前字符的最新位置
            map.put(cur, i);
            //每次都更新结束坐标为当前位置
            end = i;
            //更新最长坐标
            maxLen = Math.max(end-start+1, maxLen);
        }
        return maxLen;
    }
}

class LC3_M2{
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        //连续无重复子串的起始坐标
        int start = 0, maxLen = 0;
        char[] arr = s.toCharArray();
        for(int i=0; i<arr.length; i++){
            //当前字符
            char cur = arr[i];
            //如果之前包含了当前字符, 需要判断是否需要更新连续子串的起始坐标
            if(map.containsKey(cur)){
                //与当前字符重复的字符在字符串中的位置
                int temp = map.get(cur);
                //起始点一定是 更靠近右边的才能保证不重复
                start = Math.max(start, temp+1);
            }
            //更新当前字符的最新位置
            map.put(cur, i);
            //每次都更新结束坐标为当前位置
            //更新最长坐标
            maxLen = Math.max(i-start+1, maxLen);
        }
        return maxLen;
    }
}
