package HashTable.hashtable0212;

import java.util.HashMap;

/*
 * @Description: 36. 有效的数独
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
示例 2:

输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
说明:

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 14:55
 */
public class LC36 {

    //HashMap实现
    public boolean isValidSudoku(char[][] board) {
        //创建行列3*3盒子的对应的9个HashMap
        HashMap<Integer,Integer>[] row = new HashMap[9];
        HashMap<Integer,Integer>[] col = new HashMap[9];
        HashMap<Integer,Integer>[] box = new HashMap[9];
        for(int i=0; i<9; ++i){
            row[i] = new HashMap<Integer, Integer>();
            col[i] = new HashMap<Integer, Integer>();
            box[i] = new HashMap<Integer, Integer>();
        }
        //遍历二维字符数组
        for(int i=0; i<9; ++i){
            for(int j=0; j<9; ++j){
                if(board[i][j] != '.'){
                    //当前数字
                    int cur = (int)board[i][j];
                    //确定box的下标
                    //box 下标 = i/3+j/3
                    int boxIndex = i/3*3+j/3;
                    //将对应行列box的hashmap的对应数字的次数+1
                    row[i].put(cur,row[i].getOrDefault(cur,0)+1);
                    col[j].put(cur,col[j].getOrDefault(cur,0)+1);
                    box[boxIndex].put(cur,box[boxIndex].getOrDefault(cur,0)+1);
                    //检查当前数字cur在三个hashMap中是否存在大于1
                    if(row[i].get(cur)>1 || col[j].get(cur)>1 || box[boxIndex].get(cur)>1){
                        return false;
                    }

                }
            }
        }
        return true;
    }

    //二维int数组实现
//    public boolean isValidSudoku(char[][] board){
//        int[][] row = new int[9][9];
//        int[][] col = new int[9][9];
//        int[][] box = new int[9][9];
//
//        for(int i=0; i<9; ++i){
//            for(int j=0; j<9; ++j){
//                if(board[i][j] != '.'){
//                    //当前数字
//                    int cur = (int)(board[i][j] - '0');
//                    //box对应的下标
//                    int boxIndex = i/3*3 + j/3;
//                    //对应数字所在位子+1
//                    row[i][cur-1] += 1;
//                    col[cur-1][j] += 1;
//                    box[boxIndex][cur-1] += 1;
//                    if(row[i][cur-1]>1 || col[cur-1][j]>1 || box[boxIndex][cur-1]>1){
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }

//    //二维boolean数组实现
//    public boolean isValidSudoku(char[][] board){
//        boolean[][] row = new boolean[9][9];
//        boolean[][] col = new boolean[9][9];
//        boolean[][] box = new boolean[9][9];
//
//        for(int i=0; i<9; ++i){
//            for(int j=0; j<9; ++j){
//                if(board[i][j] != '.'){
//                    //当前数字
//                    int cur = (int)(board[i][j] - '0');
//                    //box对应的下标
//                    int boxIndex = i/3*3 + j/3;
//                    if(!row[i][cur-1] && !col[cur-1][j] && !box[boxIndex][cur-1]){
//                        //当前数字cur对应位置的三个数组都为默认的false,之前未出现过
//                        row[i][cur-1] = col[cur-1][j] = box[boxIndex][cur-1] = true;
//                    }else{
//                        //至少有一个cur对应的位置之前出现过,有重复
//                        return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }
}
