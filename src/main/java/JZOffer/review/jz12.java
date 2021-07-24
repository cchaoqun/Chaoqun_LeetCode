package JZOffer.review;

/**剑指 Offer 12. 矩阵中的路径
 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。

 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。



 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。





 示例 1：

 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 输出：true
 示例 2：

 输入：board = [["a","b"],["c","d"]], word = "abcd"
 输出：false


 提示：

 1 <= board.length <= 200
 1 <= board[i].length <= 200
 board 和 word 仅由大小写英文字母组成
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/21-14:12
 */

public class jz12 {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    boolean[][] visited;
    /**
     找到word的第一个字符开始dfs遍历
     遍历过得位置标记为已经访问过
     四周的位置只要在边界并且没有访问过就可以继续遍历 index+1 index代表word中的字符下标
     终止的条件是 index=word.length()-1 并且对应位置的字符==word.charAt(len-1)
     只要任意一条路径返回true 说明找到了这个word

     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j]==word.charAt(0)){
                    boolean res = dfs(board,i,j,0,word);
                    if(res){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, int index, String word){
        if(index<word.length() && board[row][col]!=word.charAt(index)){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        int m = board.length;
        int n = board[0].length;
        visited[row][col] = true;
        boolean res = false;
        for(int i=0; i<dir.length; i++){
            int newRow = row+dir[i][0];
            int newCol = col+dir[i][1];
            if(inArea(m,n,newRow, newCol) && !visited[newRow][newCol]){
                boolean cur = dfs(board, newRow, newCol, index+1, word);
                if(cur){
                    res = cur;
                    break;
                }
            }
        }
        visited[row][col] = false;
        return res;
    }

    private boolean inArea(int m, int n, int row, int col){
        return 0<=row && row<m && 0<=col && col<n;
    }
}
