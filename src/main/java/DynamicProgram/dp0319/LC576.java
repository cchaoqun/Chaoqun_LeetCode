package DynamicProgram.dp0319;
/*
 * @Description: 576. 出界的路径数
给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。



示例 1：

输入: m = 2, n = 2, N = 2, i = 0, j = 0
输出: 6
解释:

示例 2：

输入: m = 1, n = 3, N = 3, i = 0, j = 1
输出: 12
解释:



说明:

球一旦出界，就不能再被移动回网格内。
网格的长度和高度在 [1,50] 的范围内。
N 在 [0,50] 的范围内。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/19 17:11
 */
public class LC576 {

    public int findPaths(int m, int n, int N, int i, int j) {
        //dp[i][j][k] = 从(i,j)出发走k步出界的方法总数
        //上下左右各加一层为1,代表出界的情况
        long[][][] dp = new long[m+2][n+2][N+1];
        //左右两列
        for(int ii=0; ii<m+2; ++ii){
            dp[ii][0][0] = 1;
            dp[ii][n+1][0] = 1;
        }
        //上下两列
        for(int jj=0; jj<n+2; ++jj){
            dp[0][jj][0] = 1;
            dp[m+1][jj][0] = 1;
        }
        //从走0步开始到N,计算每个位置对应的出界的路线数,因为某个位置N步依赖于周围四个位置走N-1步的方法数
        for(int kk=0; kk<=N; ++kk){
            for(int ii=1; ii<m+1; ++ii){
                for(int jj=1; jj<n+1; ++jj){
                    if(kk-1>=0){
                        //当前位置走kk步出界方法数,=走一步到周围四个位置对应的走kk-1步出界的方法数
                        dp[ii][jj][kk] = (dp[ii-1][jj][kk-1]
                                +dp[ii][jj-1][kk-1]
                                +dp[ii+1][jj][kk-1]
                                +dp[ii][jj+1][kk-1]) % 1000000007;
                    }
                }
            }
        }
        int res = 0;
        //每个位置走如果走N-1步能出界走N步也能出界,因此需要求出每个位置走1~N步出界的所有方法总和
        for(int k=1; k<=N; ++k){
            //每次更新都需要取模,防止太大
            res = (int)((res + dp[i+1][j+1][k]) % 1000000007);
        }
        return res;
    }
}
