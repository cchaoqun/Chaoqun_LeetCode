package Algorithm_HW.Week2;

/**79 · 最长公共子串
 算法
 中等
 通过率
 34%

 题目题解笔记讨论排名
 描述
 给出两个字符串，找到最长公共子串，并返回其长度。

 子串的字符应该连续的出现在原字符串中，这与子序列有所不同。

 样例
 样例 1：

 输入：

 字符串A = "ABCD"
 字符串B = "CBCE"
 输出：

 2
 解释：

 最长公共子串是 "BC"

 样例 2：

 输入：

 字符串A = "ABCD"
 字符串B = "CBCE"
 输出：

 1
 解释：

 最长公共子串是 'A' 或 'C' 或 'B'

 挑战
 O(n x m) 时间复杂度和空间复杂度
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/5-11:34
 */

public class LinCode79 {
    public int longestCommonSubstring(String A, String B) {
        if(A==null || B==null || A.length()==0 || B.length()==0){
            return 0;
        }
        return Math.max(helper(A,B), helper(B,A));

    }

    //计算以A的每个字符开头, B都从第0个字符开始匹配, 返回匹配到的最长的连续子串
    private int helper(String A, String B){
        int a = A.length();
        int b = B.length();
        //最长连续子串长度
        int maxDp = 0;
        //遍历A的i位置开始, 与B的0位置开始匹配
        for(int i=0; i<a; i++){
            //当前i位置开始匹配的最长子串长度
            int curDp = 0;
            //A从i位置开始
            int p1 = i;
            //B每次都从0位置开始
            int p2 = 0;
            //保证两个下标都不越界
            while(p1<a && p2<b){
                //两个位置相同长度+1
                if(A.charAt(p1) == B.charAt(p2)){
                    curDp++;
                }else{
                    //不同就从0开始
                    curDp = 0;
                }
                //更新最长长度
                maxDp = Math.max(maxDp, curDp);
                //两个指针都后移
                p1++;
                p2++;
            }
        }
        return maxDp;
    }
}
