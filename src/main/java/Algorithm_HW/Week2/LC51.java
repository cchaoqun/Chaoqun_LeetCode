package Algorithm_HW.Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**51. N 皇后
 n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。



 示例 1：


 输入：n = 4
 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 解释：如上图所示，4 皇后问题存在两个不同的解法。
 示例 2：

 输入：n = 1
 输出：[["Q"]]


 提示：

 1 <= n <= 9
 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/5-11:34
 */

public class LC51 {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        //列,两种对角线数组中为1代表这个位置出现了 0为未出现
        //每一列只能放一个皇后
        int[] col = new int[n];
        //diag1[i] x-y相同的在一组 共有2*n-1中可能 [-(n-1), n-1]
        //因为存在负数, 需要将[-(n-1), (n-1)] ----->映射到[0,2(n-1)] 每个计算的结果+(n-1)即可
        int[] diag1 = new int[2*n-1];
        //diag2[i] x+y相同的在一组 全为正数 不需要转换
        int[] diag2 = new int[2*n-1];
        //queen[i]第i行的皇后在第几列
        int[] queen = new int[n];
        backtrack(0, n,queen,col, diag1, diag2);
        return res;
    }

    private void backtrack( int row, int n, int[] queen, int[] col, int[] diag1, int[]diag2){
        //已经放完了所有的皇后,
        if(row==n){
            //生成对应的字符串
            List<String> cur = generateMatrix(queen, n);
            //放入结果list
            res.add(cur);
            return;
        }
        //当前第row行的皇后放在哪一列
        for(int i=0; i<n; i++){
            //===========当前列不能放的三种可能===========
            //这一列已经存在
            if(col[i]==1){
                continue;
            }
            //diag1的情况 x-y 需要加上n-1映射到[0,2(n-1)]的范围
            int d1 = row-i+n-1;
            //diag2的情况 x+y
            int d2 = row+i;
            //对应对角线已经有皇后了
            if(diag1[d1]==1 || diag2[d2]==1){
                continue;
            }
            //===========当前列可以放===========
            //第row行放在了第i列
            queen[row] = i;
            //第i列, d1, d2都有皇后了
            col[i] = 1;
            diag1[d1] = 1;
            diag2[d2] = 1;
            //递归去找第row+1行应该放在哪一列
            backtrack(row+1, n , queen, col, diag1, diag2);
            //第row行的皇后撤销
            queen[row] = 0;
            //对应列, 对角线都撤销
            col[i] = 0;
            diag1[d1] = 0;
            diag2[d2] = 0;

        }
    }

    //queen[i] 第i行的皇后放在了哪一列
    private List<String> generateMatrix(int[] queen, int n){
        List<String> cur = new ArrayList<>();
        //遍历每一行
        for(int i=0; i<n; i++){
            //每一行创建字符数组
            char[] cha = new char[n];
            //全部置空
            Arrays.fill(cha, '.');
            //对应列有皇后的放上Q
            cha[queen[i]] = 'Q';
            //变成String加入list
            cur.add(new String(cha));
        }
        return cur;
    }
}
