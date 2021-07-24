package JZOffer.review;

/**剑指 Offer 29. 顺时针打印矩阵
 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。



 示例 1：

 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[1,2,3,6,9,8,7,4,5]
 示例 2：

 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 输出：[1,2,3,4,8,12,11,10,9,5,6,7]


 限制：

 0 <= matrix.length <= 100
 0 <= matrix[i].length <= 100
 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-13:05
 */

public class jz29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int t = 0, b=m-1, l=0,r=n-1;
        int cnt = 0;
        int[] res = new int[m*n];
        while(cnt<m*n){
            //左-右
            for(int i=l; i<=r && cnt<m*n; i++){
                res[cnt++] = matrix[t][i];
            }
            t++;
            //上-下
            for(int i=t; i<=b && cnt<m*n; i++){
                res[cnt++] = matrix[i][r];
            }
            r--;
            //右-左
            for(int i=r; i>=l && cnt<m*n; i--){
                res[cnt++] = matrix[b][i];
            }
            b--;
            //下-上
            for(int i=b; i>=t && cnt<m*n; i--){
                res[cnt++] = matrix[i][l];
            }
            l++;
        }
        return res;
    }
}
