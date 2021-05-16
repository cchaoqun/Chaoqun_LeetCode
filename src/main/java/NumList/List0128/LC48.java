package NumList.List0128;
/*
 * @Description: 48. 旋转图像
给定一个 n×n 的二维矩阵表示一个图像。

将图像顺时针旋转 90 度。

说明：

你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

示例 1:
给定 matrix =
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],
原地旋转输入矩阵，使其变为:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]
*
示例 2:
给定 matrix =
[
  [ 5, 1, 9,11],
  [ 2, 4, 8,10],
  [13, 3, 6, 7],
  [15,14,12,16]
],

原地旋转输入矩阵，使其变为:
[
  [15,13, 2, 5],
  [14, 3, 4, 1],
  [12, 6, 8, 9],
  [16, 7,10,11]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/rotate-image
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/28 22:02
 */
public class LC48 {



    // matrix[row][col] 旋转90度到达 matrix[col][n-row-1]
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n/2; i++){
            for(int j=0; j<(n+1)/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                //n-i-1,n-j-1 旋转90度到的位置
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                //n-j-1,i 旋转90度到的位置
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                //i,j 旋转90度到的位置
                matrix[j][n-i-1] = temp;
            }
        }
    }

    //先水平翻转再沿着对角线翻转
//    public void rotate(int[][] matrix){
//        int n = matrix.length;
//        //水平翻转
//        for(int i=0; i<n/2; i++){
//            for(int j=0; j<n; j++){
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[n-i-1][j];
//                matrix[n-i-1][j] = temp;
//            }
//        }
//
//        //沿对角线翻转
//        for(int i=0; i<n; i++){
//            for(int j=i+1; j<n; j++){
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//    }

}
