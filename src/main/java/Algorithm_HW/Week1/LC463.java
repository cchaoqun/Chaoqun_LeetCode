package Algorithm_HW.Week1;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/31-14:34
 */

public class LC463 {

    //DFS
    boolean[][] isVisited;
    int sum = 0;
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        isVisited = new boolean[m][n];
        dfs(grid, 0, 0);
        return sum;
    }

    private void dfs(int[][] grid, int row, int col){
        //递归终止条件, 超出边界或者已经被访问过
        if(!inArea(grid, row, col) || isVisited[row][col]){
            return;
        }
        //当前为岛屿才计算对于周长的贡献
        if(grid[row][col]==1){
            sum+=len(grid, row, col);
        }
        //标记当前位置为访问过
        isVisited[row][col] = true;
        //上下左右遍历
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }


    //判断当前坐标是否在边界内
    private boolean inArea(int[][] grid, int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        return 0<=row && row<m && 0<=col && col<n;
    }

    //计算当前位置对于总周长的贡献
    private int len(int[][] grid, int row, int col){
        //上下左右
        int[][] offset = {{-1,0},{1,0},{0,-1},{0,1}};
        int score = 0;
        for(int i=0; i<4; i++){
            int newRow = row+offset[i][0];
            int newCol = col+offset[i][1];
            //四个方向超出了边界 || 为水域就对周长贡献+1
            if(!inArea(grid, newRow, newCol) || grid[newRow][newCol]==0){
                score++;
            }
        }
        //返回总的贡献
        return score;
    }
}

class LC463_M2{
    //遍历
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        //遍历二维矩阵
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //当前为岛屿计算其对于周长的贡献
                if(grid[i][j]==1){
                    sum += len(grid, i, j);
                }
            }
        }
        return sum;
    }


    //判断当前坐标是否在边界内
    private boolean inArea(int[][] grid, int row, int col){
        int m = grid.length;
        int n = grid[0].length;
        return 0<=row && row<m && 0<=col && col<n;
    }

    //计算当前位置对于总周长的贡献
    private int len(int[][] grid, int row, int col) {
        //上下左右
        int[][] offset = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int score = 0;
        for (int i = 0; i < 4; i++) {
            int newRow = row + offset[i][0];
            int newCol = col + offset[i][1];
            //四个方向超出了边界 || 为水域就对周长贡献+1
            if (!inArea(grid, newRow, newCol) || grid[newRow][newCol] == 0) {
                score++;
            }
        }
        //返回总的贡献
        return score;
    }
}
