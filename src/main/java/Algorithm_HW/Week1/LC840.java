package Algorithm_HW.Week1;

/**840. 矩阵中的幻方
 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。

 给定一个由整数组成的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。



 示例：

 输入: [[4,3,8,4],
 [9,5,1,9],
 [2,7,6,2]]
 输出: 1
 解释:
 下面的子矩阵是一个 3 x 3 的幻方：
 438
 951
 276

 而这一个不是：
 384
 519
 762

 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 提示:

 1 <= grid.length <= 10
 1 <= grid[0].length <= 10
 0 <= grid[i][j] <= 15
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/2-13:34
 */

public class LC840 {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m<3||n<3){
            return 0;
        }
        //幻方的数量
        int sum = 0;
        //从[2,2]开始, 计算以[i,j]为右下角的3*3方格是否为一个有效的幻方
        //即计算 [i-2,j-2] -> [i,j]
        for(int i=2; i<m; i++){
            for(int j=2; j<n; j++){
                sum += valid(grid,i,j);
            }
        }
        return sum;
    }

    //判断[i,j]为右下角的3*3方格是否
    //只存在1-9不重复的数
    //每行没列,两个对角线的和相等
    //返回0, 这不是一个幻方, 1是一个幻方
    private int valid(int[][] grid, int i, int j){
        //方格左上角顶点坐标
        int row = i-2;
        int col = j-2;
        //判断9个数是否是1-9不重复的9个数
        int[] exists = new int[9];
        for(int k=0; k<9; k++){
            //当前坐标
            int curRow = row+k/3;
            int curCol = col+k%3;
            //当前数
            int cur = grid[curRow][curCol];
            //是否在[1,9]的闭区间
            if(cur<1 || cur>9){
                return 0;
            }
            //重复数字
            if(exists[cur-1]==1){
                return 0;
            }
            //对应数字出现过,[1,9]->[0,8]
            exists[cur-1]++;
        }
        //第一行,列的和
        int row0 = grid[row][col]+grid[row][col+1]+grid[row][col+2];
        int col0 = grid[row][col]+grid[row+1][col]+grid[row+2][col];
        //判断后面的两行两列是否和与第一行,列相等
        for(int m=1; m<3; m++){
            int r = grid[row+m][col]+grid[row+m][col+1]+grid[row+m][col+2];
            int c = grid[row][col+m]+grid[row+1][col+m]+grid[row+2][col+m];
            if(r!=row0 || c!=col0){
                return 0;
            }
        }
        //比较对角线
        int diag1 = grid[row][col]+grid[row+1][col+1]+grid[row+2][col+2];
        int diag2 = grid[row][col+2]+grid[row+1][col+1]+grid[row+2][col];
        return diag1==diag2?1:0;
    }
}
