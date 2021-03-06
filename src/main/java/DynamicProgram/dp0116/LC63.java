package DynamicProgram.dp0116;
/*
 * @Description: 63. 不同路径 II
 *
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
网格中的障碍物和空位置分别用 1 和 0 来表示。
*
示例 1：
输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
*
示例 2：
输入：obstacleGrid = [[0,1],[0,0]]
输出：1

提示：
m ==obstacleGrid.length
n ==obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] 为 0 或 1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-paths-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/16 14:23
 */
public class LC63 {


    //dp
    //if(dp[i][j]!=1) dp[i][j] = 从起点到达该位置的路径和 = dp[i-1][j] + dp[i][j-1]
    //if(dp[i][j]==1) dp[i][j] = 0
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m==0 || n==0){
            return 0;
        }
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        //dp
        int[][] dp = new int[m+1][n+1];
        //第一个位置初始化借助该位置,如果原矩阵第一个位置不为1,则dp[1][1]
        dp[0][1] = 1;
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(obstacleGrid[i-1][j-1] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }

//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid.length;
//        int n = obstacleGrid[0].length;
//        if(m==0 || n==0){
//            return 0;
//        }
//        if(obstacleGrid[0][0]==1){
//            return 0;
//        }
//        //dp
//        int[]dp = new int[n+1];
//        dp[1] = 1;
//        for(int i=1; i<=m; i++){
//            for(int j=1; j<=n; j++){
//                if(obstacleGrid[i-1][j-1] == 1){
//                    dp[j] = 0;
//                }else{
//                    dp[j] = dp[j]+dp[j-1];
//                }
//            }
//        }
//        return dp[n];
//    }
}
