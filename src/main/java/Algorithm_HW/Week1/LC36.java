package Algorithm_HW.Week1;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/29-11:45
 */

public class LC36 {

    //二维boolean数组实现
    public boolean isValidSudoku(char[][] board){
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i=0; i<9; ++i){
            for(int j=0; j<9; ++j){
                if(board[i][j] != '.'){
                    //当前数字
                    int cur = (int)(board[i][j] - '0');
                    //box对应的下标
                    int boxIndex = i/3*3 + j/3;
                    if(!row[i][cur-1] && !col[cur-1][j] && !box[boxIndex][cur-1]){
                        //当前数字cur对应位置的三个数组都为默认的false,之前未出现过
                        row[i][cur-1] = col[cur-1][j] = box[boxIndex][cur-1] = true;
                    }else{
                        //至少有一个cur对应的位置之前出现过,有重复
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

class LC36_M2{

    //二维boolean数组实现
    public boolean isValidSudoku(char[][] board){
        //遍历二维矩阵
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                //当前位置是数字才去判断
                if(board[i][j]!='.'){
                    //当前不满足 行 列 方块都不重复 return false;
                    if(!valid(board, i, j)){
                        return false;
                    }
                }
            }
        }
        //全部搜索完没有不符合的 全部满足
        return true;
    }

    private boolean valid(char[][] board, int row, int col){
        //[row,col]对应所在的小方格左上角坐标
        int startRow = row/3*3;
        int startCol = col/3*3;
        //遍历 0-9
        //查看[row,col]所在的这一行[row,i] 这一列[i,col] 方格[startRow+i/3, startRow+i%3]
        //如果位置不重合 元素值相等, 则存在重复, 返回false;
        for(int i=0; i<9; i++){
            //行 判断 row这一行是否有与board[row][col]相等的元素
            if(i!=col && board[row][col]==board[row][i]){
                return false;
            }
            //列 判断 col这一列是否有与board[row][col]相等的元素
            if(i!=row && board[row][col]==board[i][col]){
                return false;
            }
            //方格 判断[row, col]所在方格是否与board[row][col]相同的元素
            //当前位置坐标 startRow+i/3  startCol+j%3
            // mod div 3 因为当前小方格的列数为3
            //方格起始点为 [startRow, startCol] 将3*3方格看成一行长度为9的一维数组
            // i在一维数组中的index对应到二维 3*3的矩阵中的坐标为 [i/3, i%3] 再加上起始坐标
            int curRow = startRow+i/3;
            int curCol = startCol+i%3;
            //与当前位置不同,且值相等 则重合
            if(curRow!=row && curCol!=col && board[curRow][curCol]==board[row][col]){
                return false;
            }
        }
        return true;
    }
}
