package DynamicProgram.dp0329;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @Description:873. 最长的斐波那契子序列的长度
如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：

n >= 3
对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。

（回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）



示例 1：

输入: [1,2,3,4,5,6,7,8]
输出: 5
解释:
最长的斐波那契式子序列为：[1,2,3,5,8] 。
示例 2：

输入: [1,3,7,11,12,14,18]
输出: 3
解释:
最长的斐波那契式子序列有：
[1,11,12]，[3,11,14] 以及 [7,11,18] 。


提示：

3 <= A.length <= 1000
1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
（对于以 Java，C，C++，以及 C# 的提交，时间限制被减少了 50%）
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/29 17:29
 */
public class LC873 {

    //HashMap
    public int lenLongestFibSubseq(int[] arr) {
        //key=arr[i] value=i
        Map<Integer, Integer> index = new HashMap<>();
        //key%n = j 以arr[j]结尾的最长的子序列长度 length=value
        Map<Integer, Integer> res = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            index.put(arr[i], i);
        }
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                int k = index.getOrDefault(arr[i]-arr[j], -1);
                //arr[k]+arr[j] = arr[i]
                if(k>=0 && k<j){
                    //保证k<j, 这样(k,j)可以被编码成k*n+j 以arr[j]结尾最长序列长度
                    //arr[j]结尾的序列长度+1(i)
                    int cand = res.getOrDefault(k*n+j, 2)+1;
                    //更新arr[i]结尾的序列长度
                    res.put(j*n+i, cand);
                    //更新最长长度
                    max = Math.max(max, cand);
                }
            }
        }
        return max;
    }
}

class LC873_M2{
    /**dp[i][j] = 以arr[i], arr[j]结尾的最长斐波那契子序列的长度
     * 寻找前一个数 arr[k]使得 arr[k]+arr[j] == arr[j]
     * 状态转移 dp[i][j] = dp[k][i] + 1(在以arr[k], arr[i]结尾的状态上+1)
     * 寻找arr[k] 通过创建HashMap<arr[i], i> O(1)时间内寻找
     *
     */
    public int lenLongestFibSubseq(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0; i<n; i++){
            map.put(arr[i], i);
        }
        int[][] dp = new int[n-1][n];
        //找到一个三个的序列就是长度为3,所以都初始化为2, +1变成3
        for(int i=0; i<n-1; i++){
            Arrays.fill(dp[i], 2);
        }
        int max = 0;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int k = map.getOrDefault(arr[j]-arr[i], -1);
                if(k>=0 && k<i){
                    dp[i][j] = dp[k][i]+1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max>=3? max:0;
    }
}
