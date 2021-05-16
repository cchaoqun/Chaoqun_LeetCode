package DynamicProgram.dp0116;

/*
 * @Description: 221. 最大正方形
 *
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。

示例 1：
输入：matrix =
* [["1","0","1","0","0"],
* ["1","0","1","1","1"],
* ["1","1","1","1","1"],
* ["1","0","0","1","0"]]
输出：4
*
示例 2：
输入：matrix = [["0","1"],["1","0"]]
输出：1
*
示例 3：
输入：matrix = [["0"]]
输出：0

提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] 为 '0' 或 '1'

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximal-square
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/16 10:50
 */
public class LC221 {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m==0 || n==0){
            return 0;
        }
        //定义dp数组
        //dp[i][j] = 以(i,j)为右下角的最大正方形边长
        //状态转移方程 dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+matrix[i-1][j-1](if matrix[i][j] != 0
        int[][] dp = new int[m+1][n+1];
        //定义遍历存储最大长度的值
        int maxLen = 0;
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                //判断是否==1
                if(matrix[i-1][j-1] == '1'){
                    //当前位置值为上,左上,左边位置中的最小值+1
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1])+1;
                    //如有需要,更新最大长度
                    maxLen = maxLen<dp[i][j]?dp[i][j]:maxLen;
                }
                //如果原矩阵该位置==0则保持0
            }
        }
        //返回正方形的面积
        return maxLen*maxLen;
    }
}
