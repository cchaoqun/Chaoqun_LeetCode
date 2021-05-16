package GreedyAlgorithm.greedy0509;

import java.util.Arrays;

/**
 * 1727. 重新排列后的最大子矩阵
 * 给你一个二进制矩阵 matrix ，它的大小为 m x n ，你可以将 matrix 中的 列 按任意顺序重新排列。
 *
 * 请你返回最优方案下将 matrix 重新排列后，全是 1 的子矩阵面积。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：matrix = [[0,0,1],[1,1,1],[1,0,1]]
 * 输出：4
 * 解释：你可以按照上图方式重新排列矩阵的每一列。
 * 最大的全 1 子矩阵是上图中加粗的部分，面积为 4 。
 * 示例 2：
 *
 *
 *
 * 输入：matrix = [[1,0,1,0,1]]
 * 输出：3
 * 解释：你可以按照上图方式重新排列矩阵的每一列。
 * 最大的全 1 子矩阵是上图中加粗的部分，面积为 3 。
 * 示例 3：
 *
 * 输入：matrix = [[1,1,0],[1,0,1]]
 * 输出：2
 * 解释：由于你只能整列整列重新排布，所以没有比面积为 2 更大的全 1 子矩形。
 * 示例 4：
 *
 * 输入：matrix = [[0,0],[0,0]]
 * 输出：0
 * 解释：由于矩阵中没有 1 ，没有任何全 1 的子矩阵，所以面积为 0 。
 *
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m * n <= 105
 * matrix[i][j] 要么是 0 ，要么是 1 。
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/9-21:27
 */

public class LC1727 {

    public int largestSubmatrix(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //计算以当前行为底, 连续向上的1的个数
                if(matrix[i][j]==1){
                    matrix[i][j] += matrix[i-1][j];
                }
            }
        }
        int res = 0;
        for(int i=0; i<m; i++){
            Arrays.sort(matrix[i]);
            for(int j=n-1; j>=0;j--){
                //当前为底的向上的最长连续1的个数*(n-1-j+1)从最右列到当前列数字个数
                //因为当前列已经排序了, 当前列右边的列向上1的个数一定大于等于当前列
                res = Math.max(res, matrix[i][j]*(n-j));
            }
        }
        return res;
    }

}
