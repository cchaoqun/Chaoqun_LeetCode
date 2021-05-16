package JZOffer.jz0303;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Description: 剑指 Offer 48. 最长不含重复字符的子字符串
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。



示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。


提示：

s.length <= 40000
注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 16:30
 */
public class jz48 {

    //res,遇到重复元素,删除
//    public int lengthOfLongestSubstring(String s) {
//        if(s==null || s.length()==0){
//            return 0;
//        }
//        //不重复的元素添加到res集合中
//        List<Character> res = new ArrayList<>();
//        //字符串转化成字符数组
//        char[] arr = s.toCharArray();
//        //第一个元素添加
//        res.add(arr[0]);
//        //当前最大长度为1
//        int maxLen = 1;
//        //从第二个字符开始遍历
//        for(int i=1; i<arr.length; ++i){
//            //当前元素未出现在res,直接添加
//            if(!res.contains(arr[i])){
//                res.add(arr[i]);
//            }else{
//                //当前元素出现在res
//                while(res.get(0)!=arr[i]){
//                    //从头开始一直删除到和arr[i]相同的字符
//                    res.remove(0);
//                }
//                //把相同的字符也删掉
//                res.remove(0);
//                //当前字符添加
//                res.add(arr[i]);
//            }
//            //更新长度
//            maxLen = Math.max(maxLen,res.size());
//        }
//        return maxLen;
//    }

    //hashmap
    public int lengthOfLongestSubstring(String s){
        if(s==null || s.length()==0){
            return 0;
        }
        int i = 0;
        int maxLen = 1;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        map.put(arr[0], 0);
        for(int j=1; j<arr.length; ++j){
            if(map.containsKey(arr[j])){
                //更新左边界,为离当前j最近的重复元素下标
                //get可以获取的原因为,即使有多个重复的arr[i],因为每个元素都会被放入map
                //覆盖后得到的一定是离得最近的
                //存在重复元素,左边界应该重复元素后面一个位置
                i = Math.max(i, map.get(arr[j])+1);
            }
            //更新map
            map.put(arr[j],j);
            //更新长度  当前最大长度 与更新后[i,j]区间的长度
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}
