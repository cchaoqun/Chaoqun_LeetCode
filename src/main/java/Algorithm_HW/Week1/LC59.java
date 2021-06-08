package Algorithm_HW.Week1;

/**
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：[[1]]
 *
 *
 * 提示：
 *
 * 1 <= n <= 20
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/31-14:01
 */

public class LC59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        //count代表下一个需要放入矩阵的数,
        int count = 1;
        int top = 0;
        int bottom = n-1;
        int left = 0;
        int right = n-1;

        while(count<=n*n){
            //左->右
            for(int i=left; i<=right && count<=n*n; i++){
                matrix[top][i] = count++;
            }
            top++;

            //上->下
            for(int i=top; i<=bottom && count<=n*n; i++){
                matrix[i][right] = count++;
            }
            right--;

            //右->左
            for(int i=right; i>=left && count<=n*n; i--){
                matrix[bottom][i] = count++;
            }
            bottom--;

            //下->上
            for(int i=bottom; i>=top && count<=n*n;i-- ){
                matrix[i][left] = count++;
            }
            left++;
        }
        return matrix;
    }
}
