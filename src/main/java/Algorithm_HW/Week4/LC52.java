package Algorithm_HW.Week4;

import org.junit.jupiter.api.Test;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/28-11:25
 */

public class LC52 {

    @Test
    public void test(){
        System.out.println((char)('1'+1));
    }

    int res;
    public int totalNQueens(int n) {
        int[] row = new int[n];
        int[] col = new int[n];
        //主对角线 X-Y相等 [-(n-1): n-1] 一共 2n-1 需要将其映射到 [0:2(n-1)] 每个+(n-1)
        int[] diag1 = new int[2*(n-1)+1];
        //副对角线 X+Y相等 [0:2(n-1)]
        int[] diag2 = new int[2*(n-1)+1];
        res = 0;
        backtrack(row, col, diag1, diag2, n, 0);
        return res;
    }

    private void backtrack(int[] row, int[] col, int[] diag1, int[] diag2, int n, int path){
        if(path==n){
            res++;
            return;
        }
        //当前行
        for(int i=0; i<n; i++){
            //主次对角线对应的值
            int d1 = path-i+(n-1);
            int d2 = path+i;
            //当前行不等放的情况
            if( col[i]==1 || diag1[d1]==1 || diag2[d2]==1){
                continue;
            }
            //当前位置可以放
            //第path行放在了第i列
            row[path] = i;
            //标记第i, d1, d2对应的列 对角线不能放
            col[i] = 1;
            diag1[d1] = 1;
            diag2[d2] = 1;
            //尝试在下一行放
            backtrack(row, col, diag1, diag2, n, path+1);
            //当前位置不放
            row[i] = 0;
            col[i] = 0;
            diag1[d1] = 0;
            diag2[d2] = 0;
        }
    }
}
