package LeetCodeWeeklyContest;

import org.junit.jupiter.api.Test;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/18-10:26
 */

public class Contest_0718_250 {
    @Test
    public void test(){
        System.out.println(1^2);
    }
//    public long maxPoints(int[][] points) {
//        int m = points.length;
//        int n = points[0].length;
//        int[][] res = new int[2][n];
//        int max = 0;
//        for(int i=0; i<n; i++){
//            res[0][i] = points[0][i];
//            max = Math.max(max, res[0][i]);
//        }
//        int flag = 0;
//        //当前行
//        for(int i=1; i<m; i++){
//            flag = 1-flag;
//            //当前行的每一列如果选择的话得到的最大分数
//            for(int k=0; k<n; k++){
//                //res[i][k] 位置的最大分数取决于 上一行每列选择当前位置的最大分数
//
//                for(int j=0; j<n; j++){
//                    res[flag][k] = Math.max(res[1-flag][j]+points[i][k]-Math.abs(k-j), res[flag][k]);
//                }
//                max = Math.max(max, res[flag][k]);
//            }
//        }
//        return max;
//    }

    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        int max = 0;
        for(int i=0; i<n; i++){
            max = Math.max(max, points[0][i]);
        }
        for(int i=1; i<m; i++){
            for(int j=0; j<n; j++){

                int cur = points[i][j];
                for(int k=0; k<n; k++){
                    points[i][j] = Math.max(points[i-1][k]+cur-Math.abs(k-j), points[i][j]);
                }
                max = Math.max(max, points[i][j]);
            }
        }
        return max;
    }

    public int[] maxGeneticDifference(int[] parents, int[][] queries) {
        /**
         parents[i] = 代表值为i的结点的父节点
         */
        int len = queries.length;
        int[] res = new int[len];
        int index = 0;
        for(int[] cur : queries){
            res[index++] = find(parents, cur);
        }
        return res;
    }

    private int find(int[] parents, int[] query){
        int val = query[1];
        int node = query[0];
        int max = node^val;
        int parent = parents[node];
        while(parent!=-1){
            max = Math.max(max, val^parent);
            parent = parents[parent];
        }
        return max;
    }
}

