package NumList.List0129;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 54. 螺旋矩阵
 *
给定一个包含m x n个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例1:
输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
*
示例2:
输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/spiral-matrix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/29 9:22
 */
public class LC54 {


    //递归
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        if(m==0 || n==0){
            return res;
        }
        //顺时针遍历矩阵的顺序,第i圈
        //1.上 (i,i) -> (i,n-1-i)
        //2.右 (i,n-1-i) -> (m-1-i,n-1-i)
        //3.下 (m-1-i,n-1-i) -> (m-1-i,i)
        //4.左 (m-1-i,i) -> (i+1,i)
        //下一圈的起始点 (i+1,i+1)
        //将访问过得数字变成Integer.MAX_VALUE, 代替isVisited矩阵
        //维护count变量,访问一个元素count++, count==m*n时结束

        int count = m * n;
        //记录第几轮
        int i = 0;
        visitLoop(matrix,count,0,res);
        return res;
    }

    public static void visitLoop(int[][] matrix, int count, int start, List<Integer> res){
        int m = matrix.length, n = matrix[0].length;
        //1.上 (i,i) -> (i,n-1-i)
        for(int i=start; i<n-start; ++i){
            //如果当前未被访问过
            if(matrix[start][i] != Integer.MAX_VALUE){
                res.add(matrix[start][i]);
                count -= 1;
                matrix[start][i] = Integer.MAX_VALUE;
            }
        }
        //2.右 (i,n-1-i) -> (m-1-i,n-1-i)
        for(int i=start; i<m-start; ++i){
            //如果当前未被访问过
            if(matrix[i][n-1-start] != Integer.MAX_VALUE){
                res.add(matrix[i][n-1-start]);
                count -= 1;
                matrix[i][n-1-start] = Integer.MAX_VALUE;
            }
        }
        //3.下 (m-1-i,n-1-i) -> (m-1-i,i)
        for(int i=n-1-start; i>start-1; --i){
            //如果当前未被访问过
            if(matrix[m-1-start][i] != Integer.MAX_VALUE){
                res.add(matrix[m-1-start][i]);
                count -= 1;
                matrix[m-1-start][i] = Integer.MAX_VALUE;
            }
        }
        //4.左 (m-1-i,i) -> (i+1,i)
        for(int i=m-1-start; i>start; --i){
            //如果当前未被访问过
            if(matrix[i][start] != Integer.MAX_VALUE){
                res.add(matrix[i][start]);
                count -= 1;
                matrix[i][start]= Integer.MAX_VALUE;
            }
        }
        if(count==0){
            //遍历完所有元素,结束
            return;
        }
        //递归到下一层
        visitLoop(matrix,count,start+1, res);
    }


    //非递归
//    public static List<Integer> spiralOrder(int[][] matrix){
//        int m = matrix.length, n = matrix[0].length;
//        List<Integer> res = new ArrayList<>();
//        if(matrix==null || m==0 || n==0){
//            return res;
//        }
//
//        int top = 0, bottom = m-1, left = 0, right = n-1;
//        while(left<=right && top<=bottom){
//            for(int i=left; i<=right; i++){
//                res.add(matrix[top][i]);
//            }
//            for(int i=top+1; i<=bottom; i++){
//                res.add(matrix[i][right]);
//            }
//            if(left<right && top<bottom){
//                for(int i=right-1; i>=left; i--){
//                    res.add(matrix[bottom][i]);
//                }
//                for(int i=bottom-1; i>top; i--){
//                    res.add(matrix[i][left]);
//                }
//            }
//            left++;
//            right--;
//            top++;
//            bottom--;
//        }
//        return res;
//    }

}
