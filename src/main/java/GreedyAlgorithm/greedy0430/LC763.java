package GreedyAlgorithm.greedy0430;

import java.util.ArrayList;
import java.util.List;

/**
 * 763. 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/30-17:51
 */

public class LC763 {
    public List<Integer> partitionLabels(String S) {
        //代表每个字母在字符串中最后一次出现的位置
        int[] farRight = new int[26];
        char[] arr = S.toCharArray();
        //初始化数组
        for(int i=0; i<S.length(); i++){
            farRight[arr[i]-'a'] = i;
        }

        int index = 0;
        //当前需要包括的区间的最右端点
        int right = -1;
        //前一个区间的最右端点
        int left = -1;
        List<Integer> res = new ArrayList<>();
        while(index<arr.length){
            //通过当前字符在字符串出现的最右位置, 更新当前需要包括的区间的最右端点
            int curRight = farRight[arr[index]-'a'];
            right = Math.max(right, curRight);
            //如果当前位于当前需要包括的区间的右端点, [left+1, right] 为一个可以分割的区间
            if(index==right){
                //添加区间大小
                res.add(right-left);
                //更新left为当前区间的最右端点
                left = right;
            }
            index++;
        }
        return res;
    }
}
