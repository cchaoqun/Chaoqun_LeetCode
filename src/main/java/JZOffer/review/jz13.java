package JZOffer.review;

import java.util.LinkedList;
import java.util.Queue;

/**剑指 Offer 13. 机器人的运动范围
 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？



 示例 1：

 输入：m = 2, n = 3, k = 1
 输出：3
 示例 2：

 输入：m = 3, n = 1, k = 0
 输出：1
 提示：

 1 <= n,m <= 100
 0 <= k <= 20
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/21-15:13
 */

public class jz13 {
    class Range{
        int row;
        int col;
        public Range(){}
        public Range(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        /**
         int res = 0;
         从 i=0 j=0开始 BFS遍历表格
         i j可达, res++ 将 i+1, j i,j+1放入队列 放入队列都需要标记为已经访问过 避免重复
         不可达 跳过,
         */
        Queue<Range> queue = new LinkedList<>();
        int res = 0;
        visited = new boolean[m][n];
        queue.offer(new Range(0,0));
        while(!queue.isEmpty()){
            for(int i=queue.size(); i>0; i--){
                Range cur = queue.poll();
                boolean check = valid(cur.row, cur.col, k);
                if(check){
                    visited[cur.row][cur.col] = true;
                    res++;
                    if(inArea(m,n,cur.row+1, cur.col) && !visited[cur.row+1][cur.col]){
                        visited[cur.row+1][cur.col] = true;
                        queue.offer(new Range(cur.row+1, cur.col));
                    }
                    if(inArea(m,n,cur.row, cur.col+1) && !visited[cur.row][cur.col+1]){
                        visited[cur.row][cur.col+1] = true;
                        queue.offer(new Range(cur.row, cur.col+1));
                    }
                }
            }
        }
        return res;

    }
    private boolean inArea(int m, int n, int i, int j){
        return 0<=i && i<m && 0<=j && j<n;
    }

    private boolean valid(int i, int j, int k){
        return sum(i)+sum(j)<=k;
    }

    private int sum(int i){
        int res = 0;
        while(i!=0){
            res += i%10;
            i/=10;
        }
        return res;
    }
}

class jz13_M2{
    boolean[][] visited;
    int[][] dir = {{1,0},{0,1}};
    int res;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        res = 0;
        dfs(0,0,m,n,k);
        return res;
    }

    private void dfs(int row, int col, int m, int n, int k){
        if(!inArea(m,n,row,col) || visited[row][col] || !valid(row, col, k)){
            return ;
        }
        if(valid(row, col, k)){
            visited[row][col] = true;
            res++;
            for(int i=0; i<dir.length; i++){
                dfs(row+dir[i][0], col+dir[i][1], m,n,k);
            }
        }
    }

    private boolean inArea(int m, int n, int i, int j){
        return 0<=i && i<m && 0<=j && j<n;
    }

    private boolean valid(int i, int j, int k){
        return sum(i)+sum(j)<=k;
    }

    private int sum(int i){
        int res = 0;
        while(i!=0){
            res += i%10;
            i/=10;
        }
        return res;
    }
}
