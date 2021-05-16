package JZOffer.jz0301;
/*
 * @Description: 剑指 Offer 29. 顺时针打印矩阵
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
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/1 15:10
 */
public class JZ29 {

    public int[] spiralOrder(int[][] matrix) {
        //模拟打印顺序

        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return new int[0];
        }
        int m = matrix.length, n = matrix[0].length;
        int[] res = new int[m*n];
        int l = 0, r = n-1, t = 0, b = m-1, count = 0;
        while(count<m*n){
            //left -> right
            for(int i=l; i<=r; ++i){
                res[count] = matrix[t][i];
                ++count;
            }
            //上层边界下移一行
            ++t;
            if(t>b){
                //上层边界>下层边界
                break;
            }
            //top -> bottom
            for(int i=t; i<=b; ++i){
                res[count] = matrix[i][r];
                ++count;
            }
            //右侧边界左移一列
            --r;
            if(r<l){
                //右边界<左边界
                break;
            }
            //right -> left
            for(int i=r; i>=l; --i){
                res[count] = matrix[b][i];
                ++count;
            }
            //下层边界上移一层
            --b;
            if(b<t){
                //下边界<上边界
                break;
            }
            //bottom -> top
            for(int i=b; i>=t; --i){
                res[count] = matrix[i][l];
                ++count;
            }
            //左边界右移一层
            ++l;
            if(l>r){
                //左边界>有边界
                break;
            }
        }
        return res;
    }
}
