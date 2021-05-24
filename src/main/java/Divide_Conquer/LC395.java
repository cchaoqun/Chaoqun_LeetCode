package Divide_Conquer;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 *
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/21-12:33
 */

public class LC395 {

    public int longestSubstring(String s, int k) {
        //整个字符串都满足
        if(k==0 || k==1){
            return s.length();
        }
        //统计每个字符出现的次数
        int[] count = new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        //遍历每个出现的字符
        for(int i=0; i<26; i++){
            //出现的字符
            if(count[i]!=0){
                //当前字符的出现次数<k, 包含当前字符的子串一定不符合,
                //将字符串按照当前字符切分, 再对切分的每个子字符串递归求最长的满足要求的长度
                if(count[i]<k){
                    //当前s切分后最长长度
                    int res = 0;
                    //按照当前字符切分字符串并对每个切分后的字符串递归求最长长度
                    for(String str:s.split((char)('a'+i)+"")){
                        res = Math.max(longestSubstring(str, k), res);
                    }
                    //返回结果
                    return res;
                }
            }
        }
        //当前字符串每个字符出现次数都>=k, 返回整个字符串的长度
        return s.length();
    }
}
