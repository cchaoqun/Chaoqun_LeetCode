package Algorithm_HW.Week4;

import java.util.Arrays;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/25-12:02
 */
//TODO DP三维
//TODO 图论
public class LC329 {
    //缓存
    int[][] cache;
    //偏移量
    int[][] offset = {{-1,0}, {1,0},{0,-1},{0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        cache = new int[m][n];
        int maxGlobal = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                maxGlobal = Math.max(dfs(matrix, i, j), maxGlobal);
            }
        }
        return maxGlobal;
    }

    //找到 [i,j]坐标起点的最大长度
    private int dfs(int[][] matrix, int i, int j){
        //之前计算过 直接返回
        if(cache[i][j] != 0){
            return cache[i][j];
        }
        int curVal = matrix[i][j];
        int curMax = 0;
        //当前点起始最少1
        ++cache[i][j];
        for(int k=0; k<4; k++){

            int newRow = i+offset[k][0];
            int newCol = j+offset[k][1];
            //下一个坐标不越界,  比当前位置的值大
            if(inArea(matrix, newRow, newCol) && matrix[newRow][newCol]>curVal){
                cache[i][j] = Math.max(dfs(matrix, newRow, newCol)+1, cache[i][j]);
            }
        }
        return cache[i][j];
    }

    private boolean inArea(int[][] matrix, int i, int j){
        return 0<=i && i<matrix.length && 0<=j && j<matrix[0].length;
    }

}


