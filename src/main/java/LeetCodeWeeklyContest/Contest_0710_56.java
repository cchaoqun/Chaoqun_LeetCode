package LeetCodeWeeklyContest;

import org.junit.jupiter.api.Test;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/10-22:29
 */

public class Contest_0710_56 {
    @Test
    public void test(){

    }

}

class P2{

    @Test
    public void test(){
        char[][] maze = {{'+','+','+'},{'.','.','.'},{'+','+','+'}};
        int[] entrance = {1,0};
        int res = nearestExit(maze, entrance);
    }

    int[][] offset = {{-1,0},{1,0},{0,-1},{0,1}};
    int res = Integer.MAX_VALUE;
    boolean[][] visited;
    int m;
    int n;
    public int nearestExit(char[][] maze, int[] entrance) {
        /**

         出口的定义 row col
         maze[row][col] = "."
         row==0 || row==m-1
         col == 0 || col==n-1
         row!= entrance[0] && col!=entrance[1]

         */
        int m = maze.length;
        int n = maze[0].length;
        visited = new boolean[m][n];
        dfs(maze, entrance, entrance[0], entrance[1],0);
        return res==Integer.MAX_VALUE?-1:res;
    }

    private void dfs(char[][] maze, int[] entrance, int row, int col, int dist){
        if(dist>=res){
            return;
        }
        if(!inArea(maze, row, col) || maze[row][col]=='+' || visited[row][col]){
            return;
        }
        if(row==0 || row==m-1 || col==0 || col==n-1){
            if(row!=entrance[0] || col!=entrance[1]){
                res = Math.min(res, dist);
                return;
            }

        }
        visited[row][col] = true;
        for(int i=0; i<4; i++){
            int newRow = row+offset[i][0];
            int newCol = col+offset[i][1];
            dfs(maze, entrance, newRow, newCol, dist+1);
        }
    }

    private boolean inArea(char[][] maze, int row, int col){
        int m = maze.length;
        int n = maze[0].length;
        return 0<=row && row<m && 0<=col && col<n;
    }

}

class P3{
    @Test
    public void test(){
        char[][] maze = {{'+','+','.','+'},{'.','.','.','+'},{'+','+','+','.'}};
        int[] entrance = {1,2};
        int res = nearestExit(maze, entrance);
    }
    int res = Integer.MAX_VALUE;
    int x ;
    int y;
    int m ;
    int n ;
    int[][] offset = {{-1,0},{1,0},{0,-1},{0,1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        x = entrance[0];
        y = entrance[1];
        m = maze.length;
        n = maze[0].length;
        boolean[][] dp = new boolean[m][n];
        // dp[entrance[0]][entrance[1]] = false;
        // dp[x][y] = 1;
        dfs(maze, dp, entrance[0], entrance[1], 0);
        return res==Integer.MAX_VALUE?-1:res;
    }

    private void dfs(char[][] maze, boolean[][] dp, int row, int col, int dist){
        if(dist>=res){
            return;
        }
        if(row<0 || row>=maze.length || col<0 || col>maze[0].length){
            return;
        }
        if(maze[row][col]=='+'){
            return;
        }
        if(dp[row][col] ){
            return;
        }

        if(row==0 || row==m-1 || col==0 || col==n-1){
            if(row!=x && col!=y){
                res = Math.min(res, dist);
                return;
            }

        }
        dp[row][col] = true;
        dfs(maze,dp, row-1,col,dist+1);
        dfs(maze,dp, row+1,col,dist+1);
        dfs(maze,dp, row,col-1,dist+1);
        dfs(maze,dp, row,col+1,dist+1);


    }
}
