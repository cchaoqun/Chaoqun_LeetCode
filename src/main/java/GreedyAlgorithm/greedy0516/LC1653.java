package GreedyAlgorithm.greedy0516;

/**
 * 1653. 使字符串平衡的最少删除次数
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b'​​​​ 。
 *
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。我们称 s 平衡的 当不存在下标对 (i,j) 满足 i < j 且 s[i] = 'b' 同时 s[j]= 'a' 。
 *
 * 请你返回使 s 平衡 的 最少 删除次数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 *
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 *
 *
 * 提示：
 *
 * 1 <= s.length <= 105
 * s[i] 要么是 'a' 要么是 'b'​ 。​
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/16-19:42
 */

public class LC1653 {
    public int minimumDeletions(String s){
        int b = 0;
        int res = 0;
        int len = s.length();
        char[] arr = s.toCharArray();
        for(int i=0; i<len; i++){
            if(arr[i]=='b'){
                //arr[i] == 'b' [0,i-1]是平衡的, dp[i] = dp[i-1]
                b++;
            }else{
                //arr[i] == 'a' dp[i] = Math.min(res+1, b)
                //1.删除'a' res = res+1 [0,i-1]已经平衡了, 加上当前删除的1次
                //2.保留'a' res = b(删除之前所有的b) 删掉之前所有的b才能平衡
                res = Math.min(res+1, b);
            }
        }
        return res;
    }

}



























