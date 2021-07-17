package Algorithm_HW.Week3;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/19-11:32
 */

public class LC73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if(matrix==null || m==0 || n==0){
            return;
        }
        /**
         维护两个数组, row[] col[] 值为1 代表这一行或者这一列需要被置为0 否则不需要
         遍历一遍二维矩阵, matrix[i][j] == 0, 将row[i] col[j] 标记为1
         如果对应的位置已经为1 无需置为1
         遍历结束以后, 根据 row[] col[] 将值为1的行列置为0
         */
        int[] row = new int[m];
        int[] col = new int[n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j]==0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j] = 0;
                }
            }
        }
//        //行置0
//        for(int i=0; i<m; i++){
//            if(row[i]==1){
//                for(int j=0; j<n; j++){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        //列置0
//        for(int j=0; j<n; j++){
//            if(col[j]==1){
//                for(int i=0; i<m; i++){
//                    matrix[i][j] = 0;
//                }
//            }
//        }

    }
}
