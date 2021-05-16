package DynamicProgram.dp0321;
/*
 * @Description:1277. 统计全为 1 的正方形子矩阵
给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。



示例 1：

输入：matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
输出：15
解释：
边长为 1 的正方形有 10 个。
边长为 2 的正方形有 4 个。
边长为 3 的正方形有 1 个。
正方形的总数 = 10 + 4 + 1 = 15.
示例 2：

输入：matrix =
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
输出：7
解释：
边长为 1 的正方形有 6 个。
边长为 2 的正方形有 1 个。
正方形的总数 = 6 + 1 = 7.


提示：

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1
 *
 * @param null
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/21 11:02
 */
public class LC1277 {

    public int countSquares(int[][] matrix) {
        int sum = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        //dp[i][j] = 在matirx矩阵中 matrix[i-1][j-1]结尾的所形成的最大矩阵的边长
        int[][] dp = new int[m+1][n+1];
        //dp[i][j] = 0, continue
        //dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1
        //sum += dp[i][j]
        for(int i=1; i<m+1; ++i){
            for(int j=1; j<n+1; ++j){
                if(matrix[i-1][j-1]!=0){
                    //当前位置为右下角所形成得矩阵取决于上面的长度 左边的长度,对角线的长度中的最小值加上当前的1
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    //如果dp[i][j] = 3, 当前位置可以形成 边长分别为1,2,3的矩阵
                    sum += dp[i][j];
                }
            }
        }
        return sum;
    }
}
