package DynamicProgram.dp0320;
/*
 * @Description: 1314. 矩阵区域和
给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：

i - K <= r <= i + K, j - K <= c <= j + K
(r, c) 在矩阵内。


示例 1：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
输出：[[12,21,16],[27,45,33],[24,39,28]]
示例 2：

输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
输出：[[45,45,45],[45,45,45],[45,45,45]]


提示：

m == mat.length
n == mat[i].length
1 <= m, n, K <= 100
1 <= mat[i][j] <= 100
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/20 23:14
 */
public class LC1314 {
    public int[][] matrixBlockSum(int[][] mat, int k){
        int m = mat.length;
        int n = mat[0].length;
        int[][] area = new int[m+1][n+1];
        for(int i=1; i<=m; ++i){
            for(int j=1; j<=n; ++j){
                //[0,0]为左上角,[i,j]为右下角的矩形的所有位置的和
                //[0,0]到[i,j] = [i-1,j] + [i,j-1] 两个位置到[0,0]的面积 因为重合了[i-1,j-1]到[0,0]的面积
                //同时还要加上本身[i,j]在mat矩阵中的位置,因为area矩阵比mat多了一行一列,所以坐标有1的偏移
                area[i][j] = area[i-1][j] + area[i][j-1] - area[i-1][j-1] + mat[i-1][j-1];
            }
        }
        //res[i][j] = [i,j] 到 [0,0]的矩形面积
        int[][] res = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                //重合区间左上端点取较大值,因为再往左和上越来越小就出界了
                int x0 = Math.max(0, i-k);
                int y0 = Math.max(0, j-k);
                //右下端点取较小值,因为往下和右越来越大会出界
                int x1 = Math.min(m-1, i+k);
                int y1 = Math.min(n-1, j+k);
                res[i][j] = cal(x0,y0,x1,y1, area);
            }
        }
        return res;
    }

    //计算[x0,y0] [x1,y1]两点间矩阵的和
    public int cal (int x0, int y0, int x1, int y1, int[][] area){
        //mat矩阵对应位置在area矩阵中对应位置都偏移了1
        x0++;
        y0++;
        x1++;
        y1++;
        //       [0,0]到[x1,y1]   矩形左下角左边一个位置  矩形右上角上面一个位置  矩形左上角左上的位置
        //这样三个矩形的才能获得[x0,y0]到[x1,y1]的位置
        int res = area[x1][y1] - area[x0-1][y1] - area[x1][y0-1] + area[x0-1][y0-1];
        return res;
    }

}
