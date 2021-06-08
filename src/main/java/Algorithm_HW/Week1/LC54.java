package Algorithm_HW.Week1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/31-13:25
 */

public class LC54 {

    public static List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        /*
        上下左右可以允许到达的边界,
        按顺序 左->右 上->下 右->左 下->上
        每遍历完一列或者一行, 对应的行列数向中间收缩
        并且剩余可遍历个数减去当前行列遍历过的元素

        直到所有的元素全部都被遍历过就结束循环
        */
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        int count = m*n;
        while(count>0){
            //左->右
            for(int i=left; i<=right && count>0; i++){
                list.add(matrix[top][i]);
                count--;
            }
            //遍历完顶行, 下降一行
            top++;

            //上->下
            for(int i=top; i<=bottom && count>0; i++){
                list.add(matrix[i][right]);
                count--;
            }
            //遍历完最右行, 左移一列
            right--;

            //右->左
            for(int i=right; i>=left && count>0; i--){
                list.add(matrix[bottom][i]);
                count--;
            }
            //遍历完最底行, 上移一行
            bottom--;

            //下->上
            for(int i=bottom; i>=top && count>0; i--){
                list.add(matrix[i][left]);
                count--;
            }
            //遍历完最左列, 右移一列
            left++;
        }
        return list;
    }
}
