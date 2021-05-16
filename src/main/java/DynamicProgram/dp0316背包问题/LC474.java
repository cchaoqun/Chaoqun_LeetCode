package DynamicProgram.dp0316背包问题;
/*
 * @Description: 474. 一和零
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。

请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。

如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。



示例 1：

输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
示例 2：

输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2 。


提示：

1 <= strs.length <= 600
1 <= strs[i].length <= 100
strs[i] 仅由 '0' 和 '1' 组成
1 <= m, n <= 100
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/16 22:21
 */
public class LC474 {

    //3维dp
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        //dp[i][j][k] = 输入字符串在[0,i]区间 能够使用 j个0 k个1 的字符串的最大数量
        int[][][] dp = new int[len+1][m+1][n+1];
        //初始化dp[0][m][n]
        //为了避免分类讨论，通常多设置一行。这里可以认为，第 0 个字符串是空串。第 0 行默认初始化为 0。

        for(int i=1; i<len+1; ++i){
            //strs[i]对应的0,1的个数
            int[] count = countOne(strs[i-1]);
            int zero = count[0];
            int one = count[1];
            for(int j=0; j<=m; ++j){
                for(int k=0; k<=n; ++k){
                    //照抄上一行,当前元素不选则和上一行相同
                    dp[i][j][k] = dp[i-1][j][k];
                    if(zero<=j && one<=k){
                        //dp[i-1][j][k]=不选strs[i]和上一行相同
                        //dp[i-1][j-zero][k-one]+1=选当前元素,
                        // 剩下的0,1目标数量为 j-zero, k-one,并且从之前的[0,i-1]中选择
                        //两种选择取得到的结果较大值
                        dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zero][k-one]+1);
                    }
                }
            }
        }
        return dp[len][m][n];

    }

    public int[] countOne(String str){
        //res[0]=str中0的个数
        //res[1]=str中1的个数
        int[] res = new int[2];
        for(char c:str.toCharArray()){
            res[c-'0']++;
        }
        return res;
    }
}

class LC474_M2{
    //二维dp
    //因为每一行的元素只与上一行上方或者左上方的元素有关,可以从后往前遍历
    public int findMaxForm(String[] strs, int m, int n){
        int len = strs.length;
        int[][] dp = new int[m+1][n+1];
        for(int i=0; i<len; ++i){
            //当前元素的0,1的个数
            int[] count = countOne(strs[i]);
            int zero = count[0];
            int one = count[1];
            //从后往前,并且0,1目标的数量大于当前元素0,1的数量
            for(int j=m; j>=zero; --j){
                for(int k=n; k>=one; --k){
                    //不选择当前元素=dp[j][k]
                    //选择当前元素= 剩下0的数量为j-zero,1的数量为k-one
                    dp[j][k] = Math.max(dp[j][k], dp[j-zero][k-one]+1);
                }
            }
        }
        return dp[m][n];
    }

    public int[] countOne(String str){
        //res[0]=str中0的个数
        //res[1]=str中1的个数
        int[] res = new int[2];
        for(char c:str.toCharArray()){
            res[c-'0']++;
        }
        return res;
    }
}
