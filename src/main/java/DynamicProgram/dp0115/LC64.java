package DynamicProgram.dp0115;

/*
 * @Description: 64. 最小路径和
 *
给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。
*
示例 1：
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
*
示例 2：
输入：grid = [[1,2,3],[4,5,6]]
输出：12

提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 16:03
 */
public class LC64 {
    public static void main(String[] args) {
        int[][] grid = new int[2][2];
        grid[0] = new int[]{1,2};
        grid[1] = new int[]{1,1};
        int res = minPathSum(grid);
        System.out.println(res);
    }

    //dp
    //dp[i][j] = 从左上角到当前位置的最小路径和+当前位置的值(grid[i][j])
    //dp = grid.length+1  * grid[0].length=1
    //第一行和第一列为Integer.MAX_VALUE
    //dp[0][1] = dp[1][0] = 0
//    public static int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        if(m==0 || n==0){
//            return 0;
//        }
//        //定义dp数组
//        int[][] dp = new int[m+1][n+1];
//        //初始化第一行和第一列
//        Arrays.fill(dp[0],Integer.MAX_VALUE);
//        for(int i=0; i<m+1; i++){
//            dp[i][0] = Integer.MAX_VALUE;
//        }
//        //初始化grid[0][0]上方和左边的值为0,因为状态 转移的过程会用到
//        dp[0][1] = 0;
//        dp[1][0] = 0;
//        //从左到右从上到下遍历dp,为dp赋值
//        for(int i=1; i<m+1; i++){
//            for(int j=1; j<n+1; j++){
//                //当前位置的最小路径和等于当前位置上方和左方的最小值+当前位置的值
//                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i-1][j-1];
//            }
//        }
//        return dp[m][n];
//    }

    //直接在原数组上操作
    public static int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n==0){
            return 0;
        }
        //第一列与第一行只可能分别从左上角沿着第一行或者第一列走过来
        //路径时确定过得
        //遍历第一行
        for(int i=1; i<n; i++){
            grid[0][i] += grid[0][i-1];
        }
        //遍历第一列
        for(int i=1; i<m; i++){
            grid[i][0] += grid[i-1][0];
        }
        //从(1,1)开始遍历
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}
