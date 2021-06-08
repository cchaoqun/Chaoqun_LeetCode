package Algorithm_HW.Week1;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/31-13:12
 */

public class LC48 {

    /*
    正常情况下,翻转90度, 第i行会变成倒数第i列 即 matrix[row][col] = matrix[col][n-1-row]
    我们需要思考怎样通过原始的坐标得到新的坐标
    变化为     row->col
              col->n-1-row
    n-1-row 和 row的关系是水平对称的,
    首先尝试水平翻转所有元素
        matrix[row][col] -> matrix[n-1-row][col] 与我们希望得到的matrix[col][n-1-row]
        刚好是横纵坐标相反的关系, 那么通过主对角线翻转, 刚好可以使得横纵坐标交换
    主对角线翻转
        matrix[n-1-row][col] -> matrix[col][n-1-row]

     */

    public void rotate(int[][] matrix){
        int n = matrix.length;
        //水平翻转
        for(int i=0; i<n/2; i++){
            for(int j=0; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }

        //对角线翻转
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
