package DepthFirstSearch.dfs0112;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 130. 被围绕的区域
 *
给定一个二维的矩阵，包含'X'和'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的'O' 用 'X' 填充。

示例:
X X X X
X O O X
X X O X
X O X X
运行你的函数后，矩阵变为：
X X X X
X X X X
X X X X
X O X X
解释:
被围绕的区间不会存在于边界上，换句话说，任何边界上的'O'都不会被填充为'X'。
任何不在边界上，或不与边界上的'O'相连的'O'最终都会被填充为'X'。
如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/surrounded-regions
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/12 12:53
 */
public class LC130 {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        solve(board);
        for(char[] link:board){
            System.out.println(Arrays.toString(link));
        }
    }

    //DFS
//    public static void solve(char[][] board) {
//        if(board.length==0){
//            return;
//        }
//        //遍历边界行列将于边界上的'O'连接的元素置为'A'
//        for(int i=0; i<board.length; i++){
//            dfs(board,i,0);
//            dfs(board,i,board[0].length-1);
//        }
//        for(int i=0; i<board[0].length; i++){
//            dfs(board,0,i);
//            dfs(board,board.length-1,i);
//
//        }
//        for(int i=0; i<board.length; i++){
//            for(int j=0; j<board[0].length; j++){
//                if(board[i][j]=='A'){
//                    //表示该元素与边界上的'O'联通,将该元素还原为'O'
//                    board[i][j] = 'O';
//                }else if(board[i][j]=='O'){
//                    //该元素未与边界的'O'联通,将该元素置为'X'
//                    board[i][j] = 'X';
//                }
//            }
//        }
//    }
//
//    public static void dfs(char[][] board, int i, int j){
//        if(i<0
//                ||i>board.length-1
//                ||j<0
//                ||j>board[0].length-1
//                ||board[i][j]!='O'){//必须是!='O' 上一个别递归到的元素变成了'A' 如果写成=='X' 这个元素递归到上一个递归过的元素会进入死递归
//            return;
//        }
//        board[i][j] = 'A';
//        dfs(board,i-1,j);
//        dfs(board,i+1,j);
//        dfs(board,i,j-1);
//        dfs(board,i,j+1);
//    }

    //BFS
    public static void solve(char[][] board){
        if(board.length==0){
            return;
        }
        //遍历两边的列,让连接到边界'O'的'O'置为'A'
        for(int i=0; i<board.length; i++){
            bfs(board,i,0);
            bfs(board,i,board[0].length-1);
        }
        //遍历上下的行,让连接到边界'O'的'O'置为'A'
        for(int i=0; i<board[0].length; i++){
            bfs(board,0,i);
            bfs(board,board.length-1,i);
        }
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                //'A'说明该点之前是'O'但是与边界的'O'联通
                if(board[i][j]=='A'){
                    //将其置回'O'
                    board[i][j] = 'O';
                }else if(board[i][j]=='O'){
                    //该'O'没有与边界的'O'联通,置为'X'
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void bfs(char[][] board, int i, int j){
        Queue<int[]> queue = new LinkedList<>();
        if(board[i][j]=='O'){
            queue.add(new int[]{i,j});
            board[i][j] = 'A';
        }
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            if(0<=x-1 && board[x-1][y]=='O'){
                queue.add(new int[]{x-1,y});
                board[x-1][y] = 'A';
            }
            if(x+1<board.length && board[x+1][y]=='O'){
                queue.add(new int[]{x+1,y});
                board[x+1][y] = 'A';
            }
            if(0<=y-1 && board[x][y-1]=='O'){
                queue.add(new int[]{x,y-1});
                board[x][y-1] = 'A';
            }
            if(y+1<board[0].length && board[x][y+1]=='O'){
                queue.add(new int[]{x,y+1});
                board[x][y+1] = 'A';
            }
        }
    }
}
