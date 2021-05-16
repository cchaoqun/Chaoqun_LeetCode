package BinarySearch.bs0107;

/*
 * @Description: 378. 有序矩阵中第K小的元素
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 14:49
 */
public class LC378 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0] = new int[]{1,  5,  9};
        matrix[1] = new int[]{10, 11, 13};
        matrix[2] = new int[]{12, 13, 15};
        int res = kthSmallest(matrix,8);
        System.out.println(res);
    }


    //对原二维数组进行排序,并放入一个一维数组,下标为k-1的元素即为第K小的元素
//    public static int kthSmallest(int[][] matrix, int k) {
//        int[] res = new int[matrix.length*matrix[0].length];
//        int index = 0;
//        for(int[] row:matrix){
//            for(int ele:row){
//                res[index++] = ele;
//            }
//        }
//        //对一维数组排序
//        Arrays.sort(res);
//        return res[k-1];
//    }

    //二分
    public static int kthSmallest(int[][] matrix, int k){
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while(left<right){
            int mid = left + (right-left)/2;
            if(check(matrix,n,mid,k)){
                //在左边 <=mid元素的个数 >=k, 那么k<=mid mid要缩小,
                right = mid;
            }else{
                //在右边 <=mid元素的个数 <k 那么 k>mid mid要增大
                left = mid+1;
            }
        }
        return left;

    }

    /*
     * @Description:
     *
     * @param matrix 二维数组
     * @param mid 猜测的位于数组元素值范围间的值
     * @param n 数组的列数
     * @param k 第k小的数
     * @return 左上角小于等于mid的元素个数是否大于K
     * @author Chaoqun
     * @creed: Talk is cheap,show me the code
     * @date 2021/1/7 15:22
     */
    public static boolean check(int[][] matrix, int n, int mid, int k){
        //从左下角开始判断
        int i = n-1;
        int j = 0;
        //记录小于mid的元素个数
        int sum = 0;
        while(i>=0 && j<n){
            if(matrix[i][j] <= mid){
                //小于等于mid,当前列的元素都<mid
                sum += i+1;
                //右移
                j++;
            }else{
                //大于mid,当前行都大于mid 上移
                i--;
            }
        }
        //退出循环,已经越界
        //比较<=mid的元素个数与k的关系
        return sum >= k;
    }

}
