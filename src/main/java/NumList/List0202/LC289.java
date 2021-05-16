package NumList.List0202;

import java.util.Arrays;

/*
 * @Description: 289. 生命游戏
根据百度百科，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。

给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。
每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。
每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：

如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
给你 m x n 网格面板 board 的当前状态，返回下一个状态。
*
示例 1：
输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
*
示例 2：
输入：board = [[1,1],[1,0]]
输出：[[1,1],[1,1]]

提示：

m == board.length
n == board[i].length
1 <= m, n <= 25
board[i][j] 为 0 或 1

进阶：

你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：
你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
本题中，我们使用二维数组来表示面板。
原则上，面板是无限的，但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/game-of-life
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/2 17:19
 */
public class LC289 {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for(int[] arr:board){
            System.out.println(Arrays.toString(arr));
        }

    }

    //如果原来是1现在死亡则变成-1
    //如果原来是0现在复活则变成2
    //这样一个值可以表示当前以及上一轮的状态
    //abs()==1 表示原来是1 count++
    //当前值==2表示原来是0
    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        if(board==null || m==0 || n==0){
            return;
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //当前位置周围活细胞数
                int count = countLives(board,i,j);
                //活细胞并且周围细胞数<2 || >3则死亡
                if((board[i][j] == 1) && (count<2 || count>3)){
                    board[i][j] = -1;
                }else if(board[i][j] == 0){
                    //死细胞周围细胞数==3复活
                    if(count==3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] > 0){
                    board[i][j] = 1;
                }else{
                    board[i][j] = 0;
                }
            }
        }
    }
    //计算周围8个位置的活细胞数(上一轮的状态)
    public static int countLives(int[][] board, int i, int j){
        int[] neighbors = {-1,0,1};
        int count = 0;
        for(int k=0; k<3; k++){
            for(int p=0; p<3; p++){
                if(!(neighbors[k]==0 && neighbors[p]==0)){
                    int row = i + neighbors[k];
                    int col = j + neighbors[p];
                    if(inArea(row,col,board) && Math.abs(board[row][col])==1){
                        count += 1;
                    }
                }
            }
        }
        return count;
    }

    //查看对应坐标是否在数组范围内
    public static boolean inArea(int i, int j, int[][] board){
        int m = board.length;
        int n = board[0].length;
        if(0<=i && i<m && 0<=j && j<n){
            return true;
        }else{
            return false;
        }
    }
}
