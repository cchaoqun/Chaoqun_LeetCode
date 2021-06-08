package Algorithm_HW.Week2;

/**498. 对角线遍历
 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。



 示例:

 输入:
 [
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
 ]

 输出:  [1,2,4,7,5,3,6,8,9]

 解释:



 说明:

 给定矩阵中的元素总数不会超过 100000 。
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/5-11:34
 */

public class LC498 {
    public int[] findDiagonalOrder(int[][] mat) {
        /*
        m = mat.length
        n = mat[0].length
        起点: row=0 col=0
        坐标点的和 |X+Y| 相等的为一个对角线

        向右上走到达边界要么向右要么向下, 向下一定不会越界, 而向右会越界
        所以先考虑不会越界的情况,
        坐标点和 |X+Y|=偶数, 左下到右上遍历
            col=n-1  到达最右列, 向下走
                row++
            row=0 到达最上层, 向右走
                col++
            other 向右上角走
                row--
                col++
        坐标点和 |X+Y|=奇数, 右上到左下遍历
            row=m-1  达到最下层, 向右走
                col++
            col=0  到达最左层, 向下走
                row++
            others  向左下角走
                row++
                col--
         */
        int m = mat.length;
        int n = mat[0].length;
        //当前位置坐标
        int row = 0;
        int col = 0;
        int[] res = new int[m*n];
        for(int i=0; i<m*n; i++){
            res[i] = mat[row][col];
            //当前坐标和为偶数, 需要从左下到右上遍历
            if((row+col)%2==0){
                //到达右界, 下移
                if(col==n-1){
                    row++;
                }else if(row==0){
                    //到达上界, 右移
                    col++;
                }else{
                    //未到达边界, 向右上移动
                    row--;
                    col++;
                }
            }else{
                //坐标和为奇数
                if(row==m-1){
                    //到达下界, 右移
                    col++;
                }else if(col==0){
                    //到达左界, 下移
                    row++;
                }else{
                    //未到达边界, 左下移动
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}
