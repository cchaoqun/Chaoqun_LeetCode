package Algorithm_HW.Week4;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/28-12:19
 */

public class LC37 {
    /**
     row[][] col[][] matrix[][] 不能重复 '.' 才可以尝试放入数字
     每遍历到一个 '.' 尝试在这一行row[][] col[][] matrix[][] 放入一个没有的数字
     当前位置 pos ==> i = pos/9 j = pos%9 [i,j]
     for(int k=0; k<9; k++){
         row[i][k] == 0;
         col[j][k] == 0;
         matrix[i/3 * 3 + j/3][k] == 0;
     同时满足才可以放入这个k
     }
     */
    public void solveSudoku(char[][] board) {
        // 行 列 3*3 的块 是否包含1-9的数字
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] matrix = new int[9][9];
        //初始化这三个数组
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    //当前的数字
                    int cur = board[i][j]-'0';
                    // cur-1是因为 数组下标的 i属于[0:8] 映射到 [1:9]
                    //对应行列标记为这个数字已经存在
                    row[i][cur-1] = 1;
                    col[j][cur-1] = 1;
                    //对应的3*3块这个数字已经存在
                    //当前所在的block 3*3
                    int blockId = i/3*3+j/3;
                    //当前所在的block已经有了 cur
                    matrix[blockId][cur-1] = 1;
                }
            }
        }
        //递归+回溯去尝试每个位置每种可能的情况
        backtrack(board, row, col, matrix, 0);



    }

    private boolean backtrack(char[][] board, int[][] row, int[][] col, int[][] matrix, int pos){
        //pos代表的坐标
        int i = pos / 9;
        int j = pos % 9;
        //block对应的下标[0:8]
        int block = i/3*3+j/3;
        //所有的位置都放过了 返回true
        if(pos==81){
            // for(char[] c:board){
            //     System.out.println(Arrays.toString(c));
            // }
            return true;
        }
        //当前位置不是 '.' 到下一个位置
        if(board[i][j]!='.'){
            return backtrack(board, row, col, matrix, pos+1);
        }else{
            //当前是 '.'
            //对于当前位置尝试放入一个元素
            for(int k=0; k<9; k++){
                //当前尝试放入的数字是 k+1 对应标记数组的下标k
                //必须保证当前位置[i,j] 所在的行row[i][k] 列col[j][k] block matrix[block][k] 都没有放过k+1 否则不可以放
                if(row[i][k]==1 || col[j][k]==1 || matrix[block][k]==1){
                    continue;
                }
                //在[i,j]可以放 k+1这个数字
                //标记行列block数组k+1这个数字已经出现过
                row[i][k]=1;
                col[j][k]=1;
                matrix[block][k]=1;
                //放入
                board[i][j] = (char)('1'+k);
                //递归去找下一个位置需要放的值
                boolean res = backtrack(board, row, col, matrix, pos+1);
                //递归回来如果当前位置放k+1可以就不用继续尝试其他的值
                if(res){
                    return true;
                }
                //当前位置不可以放k+1 重置这些数组k位置, board放回'.' 继续尝试当前位置的下一个值
                row[i][k]=0;
                col[j][k]=0;
                matrix[block][k]=0;
                board[i][j] = '.';
            }
            return false;
        }


    }
}
