package BinarySearch.bs0108;

/*
 * @Description: 74. 搜索二维矩阵
编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：

每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。


 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/8 9:43
 */
public class LC74 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][4];
        matrix[0] = new int[]{1,3,5,7};
        matrix[1] = new int[]{10,11,16,20};
        matrix[2] = new int[]{23,30,34,60};
        boolean res = searchMatrix(matrix,0);
        System.out.println(res);
    }

    //从左下角开始搜索
//    public static boolean searchMatrix(int[][] matrix, int target) {
//        int i = matrix.length-1;
//        int j = 0;
////        int[] res = new int[]{-1,-1};
//        //索引不越界
//        while(i>=0 && j<matrix[0].length){
//            //target>当前值,该列元素都小于target 右移
//            if(target>matrix[i][j]){
//                j++;
//            }else if(target<matrix[i][j]){
//                //target<当前值,该行元素都大于target上移
//                i--;
//            }else{
////                res[0] = i;
////                res[1] = j;
////                System.out.println(Arrays.toString(res));
//                return true;
//            }
//        }
////        System.out.println(Arrays.toString(res));
//        return false;
//    }

    //直接在整个矩阵二分,因为每行第一个整数大于上一行最后一个
    //一维数组的长度为matrix.length=m * matrix[0].length=n
    //一位数组下标k 对应二维数组的下标为 i=k/n j=k%n k = i*n+j
//    public static boolean searchMatrix(int[][] matrix, int target){
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int left = 0;
//        //一位数组的长度,不需要创建一维数组
//        int right = m*n;
//        while(left<right){
//            int mid = left+(right-left)/2;
//            //i行下标 j列下标
//            int i = mid/n;
//            int j = mid%n;
//            if(target == matrix[i][j]){
//                return true;
//            }else if(target<matrix[i][j]){
//                right = mid;
//            }else if(target>matrix[i][j]){
//                left = mid+1;
//            }
//        }
//        return false;
//    }

    //先对最后一列二分找到大于等于target的最小值所在行，再对该行二分
    public static boolean searchMatrix(int[][] matrix, int target){
        if(matrix==null || matrix.length==0 || matrix[0].length == 0){
            return false;
        }
        int i = colBinartSearch(matrix,target);
        if(i>= matrix.length){
            return false;
        }
        int j = rowBinarySearch(matrix,target,i);
        if(matrix[i][j] == target){
            return true;
        }else{
            return false;
        }
    }

    //在最后一列找到第一行>=target的行
    public static int colBinartSearch(int[][] matrix, int target){
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = m;
        while(l<r){
            int mid = l+(r-l)/2;
            if(matrix[mid][n-1]>=target){
                r = mid;
            }else if(matrix[mid][n-1]<target){
                l = mid+1;
            }
        }
        return l;

    }

    //在最后一列找到第一个>=target的行上进行二分 找到列
    public static int rowBinarySearch(int[][] matrix, int target, int i){
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = n;
        while(l<r){
            int mid = l+(r-l)/2;
            if(matrix[i][mid]>=target){
                r = mid;
            }else if(matrix[i][mid]<target){
                l = mid+1;
            }
        }
        return l;
    }

}
