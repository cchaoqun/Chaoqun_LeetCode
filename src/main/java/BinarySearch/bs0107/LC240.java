package BinarySearch.bs0107;
/*
 * @Description: 240. 搜索二维矩阵 II
编写一个高效的算法来搜索mxn矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

每行的元素从左到右升序排列。
每列的元素从上到下升序排列。


 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 20:57
 */
public class LC240 {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];
        matrix[0] = new int[]{1,4,7,11,15};
        matrix[1] = new int[]{2,5,8,12,19};
        matrix[2] = new int[]{3,6,9,16,22};
        matrix[3] = new int[]{10,13,14,17,24};
        matrix[4] = new int[]{18,21,23,26,30};
        int target = 16;
        boolean res = searchMatrix(matrix,target);
        System.out.println(res);


    }

    //利用矩阵的特性
    public static boolean searchMatrix(int[][] matrix, int target) {
        //从矩阵的左下角开始搜索
        int i = matrix.length-1;
        int j = 0;
        while(i>=0 && j<matrix[0].length){
            if(target == matrix[i][j]){
                return true;
            }else if(target < matrix[i][j]){
                //target<当前元素, 该行都>target 上移 二分
                i--;
            }else if(target > matrix[i][j]){
                //target>当前元素, 该列都<target 右移
                j++;
            }
        }
        return false;
    }
}
