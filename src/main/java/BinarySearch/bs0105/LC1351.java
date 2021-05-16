package BinarySearch;
/*
 * @Description: 统计有序矩阵中的负数
给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
请你统计并返回 grid 中 负数 的数目。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/4 20:06
 */
public class LC1351 {
    public static void main(String[] args) {
        int[][] matrix = new int[4][4];
        matrix[0] = new int[]{4,3,2,-1};
        matrix[1] = new int[]{3,2,1,-1};
        matrix[2] = new int[]{1,1,-1,-2};
        matrix[3] = new int[]{-1,-1,-2,-3};
        int res = countNegatives(matrix);
        System.out.println(res);
    }
    //从左下角开始查找
//    public static int countNegatives(int[][] grid) {
//        //获取矩阵的行数
//        int row = grid.length;
//        //获取矩阵的列数
//        int column = grid[0].length;
//        //记录当前元素的列
//        int col_index = 0;
//        //记录负数的个数
//        int count = 0;
//        //每一行都是非递增顺序排列,从最后一行开始查找
//        for(int i=row-1; i>=0; i--){
//            while(col_index<column && grid[i][col_index]>=0){
//                col_index++;
//            }
//            //该行没有负数,则因为每行每列都非递增,则该行以上都>0
//            if(col_index == column){
//                return count;
//            }
//            //该行有 column-col_index个负数
//            count += column-col_index;
//        }
//        return count;
//    }

    //右上角开始查找
//    public static int countNegatives(int[][] grid){
//        int count = 0;
//        if(grid.length==0 || grid[0].length==0){
//            return 0;
//        }
//        //行列的索引
//        int i = 0;
//        int j = grid[0].length - 1;
//        while(true){
//            //退出循环条件, 越界
//            if(i>grid.length-1 || j<0){
//                break;
//            }
//            if(grid[i][j] < 0){
//                //该列一下所有元素都为负数
//                count += grid.length-i;
//                //左移一列
//                j--;
//            }else{
//                //下移一行
//                i++;
//            }
//        }
//        return count;
//    }

    //优化二分查找
    //下一行的right指针设置为上一次结束的位置
    public static int countNegatives(int[][] grid){
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        int ind = n;
        for(int i = 0; i<m; i++){
            if(ind == 0){
                break;
            }
            //第i行最后一列>=0 进入下一行
            if(grid[i][ind-1] >= 0){
                continue;
            }
            int left = 0;
            int right = ind;
            while(left<right){
                int mid = (left+right)/2;
                if(grid[i][mid] < 0){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }
            //当left==right 退出循环
            //从退出位置到该行末尾以及这些位置的以下的行都<0
            res += (ind-left)*(m-i);
            //下一行遍历的右指针设置成该行结束的位置
            ind = left;
        }
        return res;
    }
}
