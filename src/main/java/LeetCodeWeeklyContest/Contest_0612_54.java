package LeetCodeWeeklyContest;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/** Contest 0612
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/12-22:28
 */

public class Contest_0612_54 {

    //1
    public boolean isCovered(int[][] ranges, int left, int right) {
        Set<Integer> set = new HashSet<>();
        for(int i=left; i<=right; i++){
            set.add(i);
        }
        for(int[] range:ranges){
            if(range[0]>right || range[1]<left){
                continue;
            }
            for(int i=range[0]; i<=range[1] && !set.isEmpty(); i++){
                set.remove(i);
            }
            if(set.isEmpty()){
                return true;
            }
        }
        return false;
    }

    //2
    public int chalkReplacer(int[] chalk, int k) {
        long remained = 0;
        int n = chalk.length;
        for(int i=0; i<n; i++){
            remained += chalk[i];
            if(remained>k){
                return i;
            }
        }
        if(k>=remained){
            remained = k % remained;
        }
        int index = 0;
        while(remained>=chalk[index] ){
            remained -= chalk[index];
            index++;
            index %= n;
        }
        return index;
    }

    //test for 3
    @Test
    public void test(){
        int[][] grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        int res = largestMagicSquare(grid);
        System.out.println(res);
    }

    //3
    public int largestMagicSquare(int[][] grid) {
        //行前缀和
        //row[i][j] 第i行[0,j]元素的和
        //列前缀和
        //col[i][j] 第j列[0,i]元素的和
        int m = grid.length;
        int n = grid[0].length;
        int[][] row = new int[m][n];
        int[][] col = new int[m][n];

        //压缩第一行
        row[0][0] = grid[0][0];
        col[0][0] = grid[0][0];
        for(int j=1; j<n; j++){
            row[0][j] = grid[0][j] + row[0][j-1];
        }
        //压缩第一列
        for(int i=1; i<m; i++){
            col[i][0] =grid[i][0] + col[i-1][0];
        }
        //压缩剩余的行列
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                row[i][j] = grid[i][j] + row[i][j-1];
                col[i][j] = grid[i][j] + col[i-1][j];

            }
        }
        int maxSize = 1;
        //求幻方
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                //当前坐标[i][j]的幻方取决于坐标长度的较小值
                int size = Math.min(i,j);
                //从i,j向左上角寻找可能的最大幻方直到size=2
                while(size>0){
                    //当前左上角坐标为[i-size][j-size] 右下角坐标为[i][j]的正方形构成一个幻方
                    if(valid(row,col,grid,i,j,size)){
                        maxSize = Math.max(maxSize, size+1);
                    }
                    size--;
                }

            }
        }
        return maxSize;


    }

    private boolean valid(int[][] row, int[][] col, int[][] grid, int i, int j, int size){
        //左上角顶点坐标 i-size, j-size
        int leftRow = i-size;
        int leftCol = j-size;
        //行列如果相等都等于幻方第一行第一列的sum
        int rowSum = row[leftRow][j] - row[leftRow][leftCol] + grid[leftRow][leftCol];
        int colSum = col[i][leftCol] - col[leftRow][leftCol] + grid[leftRow][leftCol];
        //判断行列
        for(int m=1; leftRow+m<= i; m++){
            int curRow = row[leftRow+m][j] - row[leftRow+m][leftCol] + grid[leftRow+m][leftCol];
            int curCol = col[i][leftCol+m] - col[leftRow][leftCol+m] + grid[leftRow][leftCol+m];
            if(curRow!=rowSum || curCol!=colSum){
                return false;
            }
        }
        //判断对角线
        int rightCol = j;
        //主对角线和
        int diag1 = 0;
        //次对角线和
        int diag2 = 0;
        for(int k=0; k+leftRow<=i; k++){
            diag1 += grid[leftRow+k][leftCol+k];
            diag2 += grid[leftRow+k][rightCol-k];
        }
        return diag1==diag2 && diag1==rowSum;
    }
}
