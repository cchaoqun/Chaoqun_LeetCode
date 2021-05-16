package JZOffer.jz0227;
/*
 * @Description: 剑指 Offer 12. 矩阵中的路径
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。



示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false


提示：

1 <= board.length <= 200
1 <= board[i].length <= 200
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 14:45
 */
public class JZ12 {
    public static void main(String[] args) {
        int[][] offset = {{-1,0},{1,0},{0,-1},{0,1}};
        System.out.println(offset.length);
        System.out.println(offset[0].length);
    }

    //字符串对应的字符数组
    char[] wordArr;

    public boolean exist(char[][] board, String word) {
        //初始化字符串字符数组
        this.wordArr = word.toCharArray();
        //从每个位置出发,查找
        for(int i=0; i<board.length; ++i){
            for(int j=0; j<board[0].length; ++j){
                //存在
                if(dfs(board,0,i,j)){
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, int index, int row, int col){
        //下标越界或者不匹配
        if(!inArea(board,row,col) || board[row][col]!=wordArr[index]){
            return false;
        }
        //最后一个字符匹配
        if(index == wordArr.length-1){
            return true;
        }
        //先假设当前位置已经访问过,这里无需额外的二维数组,将当前临时改变成'/'递归回来再恢复即可
        board[row][col] = '\0';
        //递归的向上下左右四个方向寻找.将四个方向的寻找结果放到数组
        boolean result = dfs(board,index+1,row-1,col)
                ||dfs(board,index+1,row+1,col)
                ||dfs(board,index+1,row,col-1)
                ||dfs(board,index+1,row,col+1);
        //递归回来更新访问数组,如果四个方向都未找到,当前位置设置成未访问
        board[row][col] = wordArr[index];
        return result;

    }

    //判断坐标是否在返回内
    public boolean inArea(char[][] board, int row, int col){
        int m = board.length;
        int n = board[0].length;
        return (0<=row && row<m && 0<=col && col<n);
    }

}
