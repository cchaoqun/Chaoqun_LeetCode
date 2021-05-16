package NumList.List0129;
/*
 * @Description: 73. 矩阵置零
给定一个m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例1:

输入:
[
 [1,1,1],
 [1,0,1],
 [1,1,1]
]
输出:
[
 [1,0,1],
 [0,0,0],
 [1,0,1]
]
示例2:

输入:
[
 [0,1,2,0],
 [3,4,5,2],
 [1,3,1,5]
]
输出:
[
 [0,0,0,0],
 [0,4,5,0],
 [0,3,1,0]
]
进阶:

一个直接的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/set-matrix-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/29 15:55
 */
public class LC73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        if(matrix==null || m==0 || n==0){
            return;
        }
        //记录第一列是否需要变成0
        boolean zeroCol = false;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    if(j==0){
                        //如果第一列中有数据为0,将标记设置为true,后续根据标记的布尔值判断第一列是否需要变为0
                        zeroCol = true;
                        //将该行第一个数据设置成0
                        matrix[i][0] = 0;
                    }else{
                        //如果matrix[0][0]==0 那么确认第一行需要设置成0
                        //将该行第一个元素设置为0
                        matrix[i][0] = 0;
                        //将该列第一个元素设置为0
                        matrix[0][j] = 0;
                    }

                }
            }
        }
        //遍历第一行,将对应列设置为0
        for(int i=1; i<n; i++){
            if(matrix[0][i]==0){
                //对应列设置为0
                for(int j=1;j<m;j++){
                    matrix[j][i]=0;
                }
            }
        }
        //遍历第一列,将对应行设置为0
        for(int i=1; i<m; i++){
            if(matrix[i][0]==0){
                for(int j=1; j<n; j++){
                    matrix[i][j] = 0;
                }

            }
        }
        //判断第一行是否需要变成0
        if(matrix[0][0] == 0){
            //将第一行设为0
            for(int i=0; i<n; i++){
                matrix[0][i]=0;
            }

        }
        //判断第一列是否需要变成0
        if(zeroCol){
            //将第一列设为0;
            for(int j=0; j<m; j++){
                matrix[j][0]=0;
            }
        }
    }
}
