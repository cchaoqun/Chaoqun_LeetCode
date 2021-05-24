package Divide_Conquer;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/21-13:04
 */

public class Interview1009 {
    //左下角
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //从左下角开始
        int row = m-1;
        int col = 0;
        //保证坐标在范围内
        while(row>=0 && col<n){
            //当前位置值
            int cur = matrix[row][col];
            //先判断当前元素>target的情况, 这种情况target一定在后面一行
            //移动列保证之前的列所有元素都>target
            if(cur>target){
                --row;
            }else if(cur<target){
                //再判断<target的情况
                ++col;
            }else{
                return true;
            }
        }
        return false;
    }
}

class Interview1009_M2{

    //右上角
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //从左下角开始
        int row = 0;
        int col = n-1;
        while(row<m && col>=0){
            int cur = matrix[row][col];
            if(cur>target){
                --col;
            }else if(cur<target){
                ++row;
            }else{
                return true;
            }
        }
        return false;
    }
}
