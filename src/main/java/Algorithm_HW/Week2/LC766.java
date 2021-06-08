package Algorithm_HW.Week2;

/**766. 托普利茨矩阵
 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。

 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。



 示例 1：


 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 输出：true
 解释：
 在上述矩阵中, 其对角线为:
 "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 各条对角线上的所有元素均相同, 因此答案是 True 。
 示例 2：


 输入：matrix = [[1,2],[2,2]]
 输出：false
 解释：
 对角线 "[1, 2]" 上的元素不同。


 提示：

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 20
 0 <= matrix[i][j] <= 99


 进阶：

 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/8-21:49
 */

public class LC766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        /*
        左上到右下的对角线的左上角的起点都在第一行和第一列
        并且右下的元素都是左上的元素 row+1 col+1得到的
        只需要遍历第一行和第一列对每个元素在保证下标不越界的范围内row+1 col+1
        如果所有的对角线都相同则返回true, 否则直接返回false
        */
        int m = matrix.length;
        int n = matrix[0].length;
        //遍历第一行
        for(int i=0; i<n; i++){
            //对应对角线的第一个值
            int val = matrix[0][i];
            //对角线上下一个元素的位置
            int row = 1;
            int col = i+1;
            while(row<m && col<n){
                if(matrix[row][col]!=val){
                    return false;
                }
                row++;
                col++;
            }
        }
        //遍历第一列
        for(int i=1; i<m; i++){
            //当前对角线的第一个值
            int val = matrix[i][0];
            //对角线下一个元素的位置
            int row = i+1;
            int col = 1;
            while(row<m && col<n){
                if(matrix[row][col]!=val){
                    return false;
                }
                row++;
                col++;
            }
        }
        return true;
    }
}

class LC766_M2{
    public boolean isToeplitzMatrix(int[][] matrix){
        /*
            按格子遍历, 每一个元素的值都与 [i-1, j-1]相同
         */
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(matrix[i-1][j-1]!=matrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}





























