package NumList.List0130;
/*
 * @Description: 79. 单词搜索
 *
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。

示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false

提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/30 15:15
 */
public class LC79 {

    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0] = new char[]{'A','B','C','E'};
        board[1] = new char[]{'S','F','C','S'};
        board[2] = new char[]{'A','D','E','E'};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        if(board==null || m==0 || n==0){
            return false;
        }

        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
        int pw = 0;
        boolean[][] isVisited = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //查看从每个位置出发是否能构成word
                if(dfs(board,word,isVisited, direction, pw,i,j)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, String word, boolean[][] isVisited, int[][] direction, int pw, int row, int col){
        if(pw==word.length()-1){
            return word.charAt(pw)==board[row][col];
        }
        //当前元素等于指针指向的字符
        if(board[row][col] == word.charAt(pw)){
            //访问当前元素
            isVisited[row][col] = true;
            //向四个方向递归
            for(int k=0; k<4; k++){
                //更新坐标
                int newRow = row + direction[k][0];
                int newCol = col + direction[k][1];
                //坐标在范围内,并且新坐标未被访问过,则递归
                if(inArea(board,newRow,newCol) && !isVisited[newRow][newCol]){
                    if(dfs(board,word,isVisited, direction,pw+1,newRow,newCol)){
                        return true;
                    }
                }
            }
            //当前顺序下的当前元素不能构成相应的word,重置
            isVisited[row][col] = false;
        }

        //当前元素不等于指针指向的元素
        return false;
    }

    public static boolean inArea(char[][] board, int row, int col){
        if(row<0 || row>=board.length || col<0 || col>=board[0].length){
            return false;
        }else{
            return true;
        }
    }
}
