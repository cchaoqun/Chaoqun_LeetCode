package GreedyAlgorithm.greedy0507;

/**
 * 1400. 构造 K 个回文字符串
 * 给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
 *
 * 如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "annabelle", k = 2
 * 输出：true
 * 解释：可以用 s 中所有字符构造 2 个回文字符串。
 * 一些可行的构造方案包括："anna" + "elble"，"anbna" + "elle"，"anellena" + "b"
 * 示例 2：
 *
 * 输入：s = "leetcode", k = 3
 * 输出：false
 * 解释：无法用 s 中所有字符构造 3 个回文串。
 * 示例 3：
 *
 * 输入：s = "true", k = 4
 * 输出：true
 * 解释：唯一可行的方案是让 s 中每个字符单独构成一个字符串。
 * 示例 4：
 *
 * 输入：s = "yzyzyzyzyzyzyzy", k = 2
 * 输出：true
 * 解释：你只需要将所有的 z 放在一个字符串中，所有的 y 放在另一个字符串中。那么两个字符串都是回文串。
 * 示例 5：
 *
 * 输入：s = "cr", k = 7
 * 输出：false
 * 解释：我们没有足够的字符去构造 7 个回文串。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 中所有字符都是小写英文字母。
 * 1 <= k <= 10^5
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/7-21:33
 */

public class LC1400 {
    public boolean canConstruct(String s, int k) {
        int[] alpha = new int[26];
        //统计每个字符出现的次数
        for(char c:s.toCharArray()){
            //原来为0 变成1
            //原来为1 变成0
            //出现2次的时候对于回文串无影响,变成0
            alpha[c-'a']^=1;
        }
        int odd = 0;
        //统计出现次数为奇数的字母个数
        for(int i:alpha){
            //如果为1说明出现奇数次
            //如果为0出现偶数次
            //直接加上对应位置的数字即可
            odd+=i;
        }
        //每个回文串至多有1个字母出现1次 即 奇数次
        //出现奇数次的字母必须小于等于k
        //总字符串长度至少要达到k次才能被分成k个字符串
        return odd<=k && s.length()>=k;
    }
}
