package Algorithm_HW.Week4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/21-18:24
 */

public class LC54 {
    //尾递归
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<Integer>();
        return helper(matrix, 0,0,m-1, n-1, list);
    }

    private List<Integer> helper(int[][] matrix, int r1, int c1, int r2, int c2, List<Integer> list){
        if(r1>r2 || c1>c2){
            return list;
        }
        if(r1==r2){
            for(int i=c1; i<=c2; i++){
                list.add(matrix[r1][i]);
            }
            return list;
        }
        if(c1==c2){
            for(int i=r1; i<=r2; i++){
                list.add(matrix[i][c1]);
            }
            return list;
        }
        for(int i=c1; i<c2; i++){
            list.add(matrix[r1][i]);
        }
        for(int i=r1; i<r2; i++){
            list.add(matrix[i][c2]);
        }
        for(int i=c2; i>c1; i--){
            list.add(matrix[r2][i]);
        }
        for(int i=r2; i>r1; i--){
            list.add(matrix[i][c1]);
        }
        return helper(matrix, r1+1, c1+1, r2-1, c2-1, list);
    }
}
