package Algorithm_HW.Week2;

import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/9-0:59
 */

public class LC1329 {
    public int[][] diagonalSort(int[][] mat) {
        /*
        对角线上的元素 i-j相等
        所有对角线的起始点都在第一行和第一列
        下一个元素的坐标在 i+1, j+1
        按对角线遍历, 每个对角创建一个堆,

         */
        int m = mat.length;
        int n = mat[0].length;
        //对角线的堆, 每次遍历完以后堆都会空
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //第一行最后一条对角线无需遍历
        for(int i=0; i<n-1; i++){
            //对角线起始的坐标
            int row = 0;
            int col = i;
            while(row<m && col<n){
                heap.offer(mat[row++][col++]);
            }
            //重置坐标
            row = 0;
            col = i;
            //原地更新
            while(!heap.isEmpty()){
                mat[row++][col++] = heap.poll();
            }
        }
        //第一列 从第二行到倒数第二行
        for(int i=1; i<m-1; i++){
            //当前起始序坐标
            int row = i;
            int col = 0;
            //对角线元素入堆
            while(row<m && col<n){
                heap.offer(mat[row++][col++]);
            }
            //重置起始坐标
            row = i;
            col = 0;
            //原地更新
            while(!heap.isEmpty()){
                mat[row++][col++] = heap.poll();
            }
        }
        return mat;
    }
}
