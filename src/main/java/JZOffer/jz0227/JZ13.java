package JZOffer.jz0227;
/*
 * @Description: 剑指 Offer 13. 机器人的运动范围
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
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 15:47
 */
public class JZ13 {

    int count = 0;
    //标记当前位置是否访问过
    boolean[][] isVisited;
    int m, n;
    //只需要向右和向下查看即可
    int[][] offset = {{1,0},{0,1}};
    //递归
    public int movingCount(int m, int n, int k) {
        //初始化
        this.m = m;
        this.n = n;
        isVisited = new boolean[m][n];
        //递归
        dfs(0,0,k);
        return count;
    }
    public void dfs(int row, int col, int k){
        //越界 || 数位和不小于k || 当前位置访问过,则返回
        if(!inArea(m,n,row,col) || !isValid(row, col, k) || isVisited[row][col]){
            return;
        }
        //当前位置符合条件
        if(isValid(row, col ,k)){
            //当前位置置为访问过
            isVisited[row][col] = true;
            //可到达位置数量+1
            ++count;
            //向右向下递归
            for(int i=0; i<2; ++i){
                int newRow = row+offset[i][0];
                int newCol = col+offset[i][1];
                dfs(newRow, newCol,k);
            }
        }
    }

    //坐标数位和是否<=k
    public boolean isValid(int row, int col, int k){
        int sum = 0;
        while(row!=0 || col!=0){
            sum += row %10 + col % 10;
            row /= 10;
            col /= 10;
        }
        return sum <= k;
    }

    //坐标是否越界
    public boolean inArea(int m, int n, int row, int col){
        return 0<=row && row<m && 0<=col && col<n;
    }

}
