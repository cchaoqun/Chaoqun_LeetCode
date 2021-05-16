package DynamicProgram.dp0324;
/*
 * @Description:931. 下降路径最小和
给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。



示例 1：

输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
输出：13
解释：下面是两条和最小的下降路径，用加粗标注：
[[2,1,3],      [[2,1,3],
 [6,5,4],       [6,5,4],
 [7,8,9]]       [7,8,9]]
示例 2：

输入：matrix = [[-19,57],[-40,-5]]
输出：-59
解释：下面是一条和最小的下降路径，用加粗标注：
[[-19,57],
 [-40,-5]]
示例 3：

输入：matrix = [[-48]]
输出：-48


提示：

n == matrix.length
n == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/24 17:32
 */
public class LC931 {

    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //dp[i][j]到达该位置所需要的最小路径和
        //n+2,是因为左右各加一列,方便左右两边边界位置的转化
        int[][] dp = new int[m][n+2];
        //初始第一行为matrix对应的数据
        for(int j=0; j<n; ++j){
            dp[0][j+1] = matrix[0][j];
        }
        //将左右两列初始化为101,表示该位置不可以到达,因为这里每一个元素都<=100
        for(int i=0; i<m; ++i){
            dp[i][0] = 101;
            dp[i][n+1] = 101;
        }
        for(int i=1; i<m; ++i){
            for(int j=1; j<=n; ++j){
                //从第二行开始
                //每个位置只能从上一列的三个位置过来
                //取上一列的这三个位置的最小值+当前位置在matrix中的值
                dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i-1][j+1])+matrix[i][j-1];
            }
        }
        int minPath = Integer.MAX_VALUE;
        //遍历最后一行,最小值为下降路径的最小和
        for(int i=1; i<=n; ++i){
            minPath = Math.min(minPath, dp[m-1][i]);
        }
        return minPath;
    }
}
