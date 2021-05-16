package DynamicProgram.dp0326;
/*
 * @Description: 718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。



示例：

输入：
A: [1,2,3,2,1]
B: [3,2,1,4,7]
输出：3
解释：
长度最长的公共子数组是 [3, 2, 1] 。


提示：

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/26 15:40
 */
public class LC718 {
    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        //dp[i][j] = A中i位置开始, B中j位置开始的最长公共子数组的长度
        int[][] dp = new int[lenA+1][lenB+1];
        int res = 0;
        for(int i=lenA-1; i>=0; i--){
            for(int j=lenB-1; j>=0; j--){
                if(A[i]==B[j]){
                    dp[i][j] = dp[i+1][j+1] + 1;
                }else{
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}

