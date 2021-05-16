package DynamicProgram.dp0325;
/*
 * @Description: 1504. 统计全 1 子矩形
给你一个只包含 0 和 1 的 rows * columns 矩阵 mat ，请你返回有多少个 子矩形 的元素全部都是 1 。



示例 1：

输入：mat = [[1,0,1],
            [1,1,0],
            [1,1,0]]
输出：13
解释：
有 6 个 1x1 的矩形。
有 2 个 1x2 的矩形。
有 3 个 2x1 的矩形。
有 1 个 2x2 的矩形。
有 1 个 3x1 的矩形。
矩形数目总共 = 6 + 2 + 3 + 1 + 1 = 13 。
示例 2：

输入：mat = [[0,1,1,0],
            [0,1,1,1],
            [1,1,1,0]]
输出：24
解释：
有 8 个 1x1 的子矩形。
有 5 个 1x2 的子矩形。
有 2 个 1x3 的子矩形。
有 4 个 2x1 的子矩形。
有 2 个 2x2 的子矩形。
有 2 个 3x1 的子矩形。
有 1 个 3x2 的子矩形。
矩形数目总共 = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24 。
示例 3：

输入：mat = [[1,1,1,1,1,1]]
输出：21
示例 4：

输入：mat = [[1,0,1],[0,1,0],[1,0,1]]
输出：5


提示：

1 <= rows <= 150
1 <= columns <= 150
0 <= mat[i][j] <= 1
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/25 17:10
 */
public class LC1504 {
    public int numSubmat(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int sum = 0;
        //统计矩形高度>1的个数
        for(int m=0; m<row; m++){
            //统计
            //m=0的情况下统计了每行所有1*...的矩形的个数
            for(int i=m; i<row; i++){
                int curSum = 0;
                for(int j=0; j<col; j++){
                    //遇到0,当前和变成0
                    if(mat[i][j]==0){
                        curSum = 0;
                    }else{
                        //遇到1连续1个数+1
                        curSum += 1;
                        //当前1连续和加到总和上
                        //3个连续的1 可以生成 3个1*1, 2个1*2, 1个1*3
                        sum += curSum;
                    }
                }
            }
            //压缩,&运算如果上下两行对应列都是1,可以构成一个2*1
            //如果右两列连续都是1,可以构成一个2*2
            //&运算以后,如果有两个连续的1,等价于一个2*2
            for(int i=row-1; i>m; i--){
                for(int j=0; j<col; j++){
                    mat[i][j] &= mat[i-1][j];
                }
            }
        }
        return sum;
    }
}
