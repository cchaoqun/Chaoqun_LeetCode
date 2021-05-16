package NumList.List0129;
/*
 * @Description: 59. 螺旋矩阵 II
给定一个正整数n，生成一个包含 1 到n^2所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/29 10:51
 */
public class LC59 {


    public int[][] generateMatrix(int n) {
        if(n==0){
            return null;
        }
        int[][] spiral = new int[n][n];
        int count = 1;
        int top = 0, bottom = n-1, left = 0, right = n-1;
        //判定条件为 count<=n*n 解决了n为奇数时中心点无法访问到的情况
        while(count<=n*n){
            //每次访问完一层以后就向内收缩一层
            //最上层从左到右
            for(int i=left; i<=right; i++){
                spiral[top][i] = count++;
            }
            //最上层下移一层
            top++;
            //最右层从上到下
            for(int i=top; i<=bottom; i++){
                spiral[i][right] = count++;
            }
            //最右层左移一层
            right--;
            //最下层从右到左
            for(int i=right; i>=left; i--){
                spiral[bottom][i] = count++;
            }
            //最下层上移一层
            bottom--;
            //最左层从下到上
            for(int i=bottom; i>=top; i--){
                spiral[i][left] = count++;
            }
            //最左层右移一层
            left++;

        }
        return spiral;
    }
}
