package DepthFirstSearch.dfs0112;

/*
 * @Description: 200. 岛屿数量
给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
*
示例 1：
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1
*
示例 2：
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3
*
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-islands
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/12 11:58
 */
public class LC200 {

    //DFS
    public int numIslands(char[][] grid) {
        if(grid.length==0 && grid[0].length==0){
            return 0;
        }
        //遍历矩阵
        int count= 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    //碰到1,则递归
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid, int i, int j){
        //如果越界或者碰到'0'则返回
        if(i<0
                ||i>=grid.length
                ||j<0
                ||j>=grid[0].length
                ||grid[i][j]=='0'){
            return;
        }
        //将碰到的1置为0
        grid[i][j] = '0';
        //递归上下左右
        dfs(grid,i-1,j);//上
        dfs(grid,i+1,j);//下
        dfs(grid,i,j-1);//左
        dfs(grid,i,j+1);//右
    }

//    //BFS
//
//    public int numIslands(char[][] grid){
//        if(grid==null||grid[0].length==0){
//            return 0;
//        }
//        int count = 0;
//        for(int i=0; i<grid.length; i++){
//            for(int j=0; j<grid[0].length; j++){
//                if(grid[i][j]=='1'){
//                    bfs(grid,i,j);
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    public void bfs(char[][] grid, int i, int j){
//        Queue<int[]> queue = new LinkedList<>();
//        queue.add(new int[]{i,j});
//        while(!queue.isEmpty()){
//            int[] curr = queue.poll();
//
//            i=curr[0];j=curr[1];
//            if(0<=i && i<grid.length
//                    && 0<=j && j<grid[0].length
//                    && grid[i][j]=='1'){
//                //满足条件才置为'0'
//                grid[i][j] = '0';
//                queue.offer(new int[]{i+1,j});
//                queue.offer(new int[]{i-1,j});
//                queue.offer(new int[]{i,j+1});
//                queue.offer(new int[]{i,j-1});
//            }
//        }
//    }

}
