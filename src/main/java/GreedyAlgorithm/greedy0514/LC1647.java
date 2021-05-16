package GreedyAlgorithm.greedy0514;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 1647. 字符频次唯一的最小删除次数
 * 如果字符串 s 中 不存在 两个不同字符 频次 相同的情况，就称 s 是 优质字符串 。
 *
 * 给你一个字符串 s，返回使 s 成为 优质字符串 需要删除的 最小 字符数。
 *
 * 字符串中字符的 频次 是该字符在字符串中的出现次数。例如，在字符串 "aab" 中，'a' 的频次是 2，而 'b' 的频次是 1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aab"
 * 输出：0
 * 解释：s 已经是优质字符串。
 * 示例 2：
 *
 * 输入：s = "aaabbbcc"
 * 输出：2
 * 解释：可以删除两个 'b' , 得到优质字符串 "aaabcc" 。
 * 另一种方式是删除一个 'b' 和一个 'c' ，得到优质字符串 "aaabbc" 。
 * 示例 3：
 *
 * 输入：s = "ceabaacb"
 * 输出：2
 * 解释：可以删除两个 'c' 得到优质字符串 "eabaab" 。
 * 注意，只需要关注结果字符串中仍然存在的字符。（即，频次为 0 的字符会忽略不计。）
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s 仅含小写英文字母
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/14-22:27
 */

public class LC1647 {
    public int minDeletions(String s) {
        int[] alpha = new int[26];
        //统计所有可能出现的频率
        for(char c:s.toCharArray()){
            alpha[c-'a']++;
        }
        //按照出现频率升序排序
        Arrays.sort(alpha);
        int count = 0;
        int pre = alpha[25];
        //从次高位开始,依次与前一个比较
        for(int i=24; i>=0; i--){
            //当前为0, 后面都为0
            if(alpha[i]==0){
                break;
            }
            //当前出现频次>=前一个
            if(alpha[i]>=pre){
                //因为之前的可能已经缩减到了0,当前位置应该在保证>0的情况下尽可能大
                //pre更新为当前可能的最大值
                pre = Math.max(0,pre-1);
                //当前需要减少多少个到达pre
                count+=alpha[i]-pre;
            }else{
                //当前<pre, 更新pre为当前值
                pre = alpha[i];
            }
        }
        return count;
    }

}

class LC1647_M2{
    public int minDeletions(String s){
        int[] alpha = new int[26];
        //统计所有可能出现的频率
        for(char c:s.toCharArray()){
            alpha[c-'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int i:alpha){
            //遍历每一个非0的数字
            if((i^1)!=0){
                //如果set里面存在,就一直自减.
                //后续不会加入0到set,所以如果减到了0一定不会加入set
                while(set.contains(i)){
                    i--;
                    res++;
                }
                //不等于0才将当前频率加入
                if((i^1)!=0){
                    set.add(i);
                }
            }
        }
        return res;
    }
}


























