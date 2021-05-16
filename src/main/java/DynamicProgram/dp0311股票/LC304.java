package DynamicProgram.dp0311股票;
/*
 * @Description: 304. 二维区域和检索 - 矩阵不可变
给定一个二维矩阵，计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。

Range Sum Query 2D
上图子矩阵左上角 (row1, col1) = (2, 1) ，右下角(row2, col2) = (4, 3)，该子矩形内元素的总和为 8。



示例：

给定 matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12


提示：

你可以假设矩阵不可变。
会多次调用 sumRegion 方法。
你可以假设 row1 ≤ row2 且 col1 ≤ col2 。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/11 18:47
 */
public class LC304 {
    //dp[i][j] = (0,0)~(i-1,j-1)矩形的面积和
//    int[][] dp;
//    public NumMatrix(int[][] matrix) {
//        if(matrix!=null && matrix.length!=0 && matrix[0].length!=0){
//            int row = matrix.length;
//            int col = matrix[0].length;
//            this.dp = new int[row+1][col+1];
//            for(int i=1; i<row+1; ++i){
//                for(int j=1; j<col+1; ++j){
//                    //状态转移方程
//                    dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+matrix[i-1][j-1];
//                }
//            }
//        } else{
//            dp = new int[1][1];
//        }
//    }
//
//    public int sumRegion(int row1, int col1, int row2, int col2) {
//        if(dp.length==1){
//            return 0;
//        }
//        int row3 = row1-1;
//        int col3 = col2;
//        int row4 = row2;
//        int col4 = col1-1;
//        int row11 = row1-1;
//        int col11 = col1-1;
//        return dp[row2+1][col2+1]-dp[row3+1][col3+1]-dp[row4+1][col4+1]+dp[row11+1][col11+1];
//    }
}
