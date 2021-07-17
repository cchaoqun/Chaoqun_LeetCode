package company.bytedance;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-14:29
 */

public class LC200 {
    int sum;
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        this.visited = new boolean[m][n];
        this.sum = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //当前位置为 1 并且没被访问过采取把当前位置所在岛屿标记为访问过
                if(grid[i][j]=='1' && !visited[i][j]){
                    dfs(grid, i, j);
                    sum++;
                }
            }
        }
        return sum;
    }

    private void dfs(char[][] grid, int i, int j){
        //超出边界 或者 遇到0 或者遇到访问过的就返回
        if(!inArea(grid, i, j) || visited[i][j] || grid[i][j]=='0'){
            return ;
        }
        //当前结点标记为已经访问
        visited[i][j] = true;
        //四周扩散
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }

    private boolean inArea(char[][] grid, int i, int j){
        return 0<=i && i<grid.length && 0<=j && j<grid[0].length;
    }
}
