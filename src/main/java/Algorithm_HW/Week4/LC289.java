package Algorithm_HW.Week4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/19-11:32
 */

public class LC289 {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        if(board==null || m==0 || n==0){
            return;
        }
        /**
         对于规则的简化
         活细胞
            周围有两个或者三个细胞, 该细胞存活
            其他情况死亡
         死细胞
            周围刚好有三个细胞 该细胞存活
            其他情况死亡
         反过来思考, 用每个细胞去更新周围相邻的8个细胞, 如果当前细胞为1 给周围的每个细胞加上10
         这样每个位置的
         十位数表示了原来这个细胞周围有多少个活细胞,
         个位数表示了这个细胞原始的状态
         当更新后这个位置的数是 21 或者 31 或者 30 这个位置才是1 其他情况都是0

         */
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //这个位置原本是1 就更新周围的8个数都+10
                if(board[i][j] % 10 == 1){
                    update(board, i, j);
                }
            }
        }
        //只有三种情况置为1
        Set<Integer> set = new HashSet<>();
        set.add(21);
        set.add(31);
        set.add(30);
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //满足条件置为1
                if(set.contains(board[i][j])){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }

    //更新 [a,b]坐标周围8个数在坐标范围内的位置+10
    public void update(int[][] matrix, int a, int b){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=a-1; i<=a+1; i++){
            for(int j=b-1; j<=b+1; j++){
                //越界或者和[a,b]重合的情况跳过
                if(i<0 || j<0 || i>=m || j>=n || (i==a && j==b)){
                    continue;
                }
                //更新
                matrix[i][j] += 10;
            }
        }
    }
}
