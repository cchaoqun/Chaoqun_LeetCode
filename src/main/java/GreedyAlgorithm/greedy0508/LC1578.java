package GreedyAlgorithm.greedy0508;

/**
 * 1578. 避免重复字母的最小删除成本
 * 给你一个字符串 s 和一个整数数组 cost ，其中 cost[i] 是从 s 中删除字符 i 的代价。
 *
 * 返回使字符串任意相邻两个字母不相同的最小删除成本。
 *
 * 请注意，删除一个字符后，删除其他字符的成本不会改变。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abaac", cost = [1,2,3,4,5]
 * 输出：3
 * 解释：删除字母 "a" 的成本为 3，然后得到 "abac"（字符串中相邻两个字母不相同）。
 * 示例 2：
 *
 * 输入：s = "abc", cost = [1,2,3]
 * 输出：0
 * 解释：无需删除任何字母，因为字符串中不存在相邻两个字母相同的情况。
 * 示例 3：
 *
 * 输入：s = "aabaa", cost = [1,2,3,4,1]
 * 输出：2
 * 解释：删除第一个和最后一个字母，得到字符串 ("aba") 。
 *
 *
 * 提示：
 *
 * s.length == cost.length
 * 1 <= s.length, cost.length <= 10^5
 * 1 <= cost[i] <= 10^4
 * s 中只含有小写英文字母
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/8-15:08
 */

public class LC1578 {
    public int minCost(String s, int[] cost) {
        int curMax = 0;
        int curSum = 0;
        int len = cost.length;
        char[] arr = s.toCharArray();
        int minCost = 0;
        for(int i=0; i<len; i++){
            //当前元素与后一个元素不同
            if(i+1<len && arr[i]!=arr[i+1]){
                //跳过
                continue;
            }
            //存在相同元素,
            //找出连续相同元素中的最大值,
            curMax = cost[i];
            //计算连续相同元素的花费和
            curSum = cost[i];
            //从当前元素的后一个开始
            int j = i+1;
            while(j<len && arr[j]==arr[i]){
                curSum += cost[j];
                curMax = Math.max(curMax, cost[j]);
                j++;
            }
            //从连续和中减去最大的留下这样花费一定是最小的
            curSum -= curMax;
            minCost += curSum;
            //索引更新到当前连续相同元素的最后一个
            //如果已经是数组最后一个元素 i++就跳出了循环
            i = j-1;
        }
        return minCost;
    }
}

class LC1578_M2{
    public int minCost(String s, int[] cost){
        int i = 0;
        int len = cost.length;
        int minCost = 0;
        while(i<len){
            char cur = s.charAt(i);
            int curSum = 0;
            int curMax = 0;

            while(i<len && s.charAt(i)==cur){
                curSum += cost[i];
                curMax = Math.max(curMax, cost[i]);
                i++;
            }
            minCost += curSum - curMax;

        }
        return minCost;
    }

}