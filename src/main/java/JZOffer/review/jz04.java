package JZOffer.review;

/**剑指 Offer 04. 二维数组中的查找
 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。



 示例:

 现有矩阵 matrix 如下：

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 给定 target = 5，返回 true。

 给定 target = 20，返回 false。



 限制：

 0 <= n <= 1000

 0 <= m <= 1000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/21-13:43
 */

public class jz04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        /**
         站在矩阵的左下角 i= m-1 j=0
         当前元素 > target i--;
         当前元素 < target j++;
         越界的时候不存在
         */
        if(matrix==null || matrix.length==0 ||  matrix[0].length==0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = m-1;
        int col = 0;
        while(row>=0 && col<n){
            if(matrix[row][col]<target){
                col++;
            }else if(matrix[row][col]>target){
                row--;
            }else{
                return true;
            }
        }
        return false;
    }
}
