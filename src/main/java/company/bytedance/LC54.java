package company.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-14:30
 */

public class LC54 {

    public List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0, bottom=m-1, left=0, right=n-1;
        int num = m*n;
        List<Integer> list = new ArrayList<>();
        while(num>0){
            //左到右
            for(int i=left; i<=right && num>0; i++){
                list.add(matrix[top][i]);
                num--;
            }
            top++;
            //上到下
            for(int i=top; i<=bottom && num>0; i++){
                list.add(matrix[i][right]);
                num--;
            }
            right--;
            //右到左
            for (int i = right; i>=left && num>0 ; i--) {
                list.add(matrix[bottom][i]);
                num--;
            }
            bottom--;
            //下到上
            for (int i = bottom; i >=top && num>0 ; i--) {
                list.add(matrix[i][left]);
                num--;
            }
            left++;
        }
        return list;
    }
}

class LC54_M2{
    public List<Integer> spiralOrder(int[][] matrix){
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        return dfs(matrix, 0,0,m-1,n-1,list);

    }

    private List<Integer> dfs(int[][] matrix, int x1, int y1, int x2, int y2, List<Integer> list){
        if(x1>x2 || y1>y2){
            return list;
        }
        if(x1==x2){
            for(int i=y1; i<=y2; i++){
                list.add(matrix[x1][i]);
            }
            return list;
        }
        if(y1==y2){
            for(int i=x1; i<=x2; i++){
                list.add(matrix[i][y1]);
            }
            return list;
        }
        //左-->右
        for(int i=y1; i<y2; i++){
            list.add(matrix[x1][i]);
        }
        //上-->下
        for(int i=x1; i<x2; i++){
            list.add(matrix[i][y2]);
        }
        //右-->左
        for (int i = y2; i >y1 ; i--) {
            list.add(matrix[x2][i]);
        }
        //下-->上
        for(int i=x2; i>x1; i--){
            list.add(matrix[i][y1]);
        }

        return dfs(matrix, x1+1, y1+1, x2-1, y2-1,list);

    }
}





















