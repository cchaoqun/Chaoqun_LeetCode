package BinarySearch;

import java.util.Arrays;

/*
 * @Description: 1337. 矩阵中战斗力最弱的 K 行
给你一个大小为m* n的矩阵mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。

请你返回矩阵中战斗力最弱的k行的索引，按从最弱到最强排序。

如果第i行的军人数量少于第j行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。

军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 15:38
 */
public class LC1337 {
    public static void main(String[] args) {
        int[][] mat = new int[5][5];
        mat[0] = new int[]{1,1,1,1,1};
        mat[1] = new int[]{1,1,1,1,1};
        mat[2] = new int[]{1,1,1,1,1};
        mat[3] = new int[]{1,1,1,1,1};
        mat[4] = new int[]{1,1,1,1,1};
        int[] res = kWeakestRows(mat, 3);
        System.out.println(Arrays.toString(res));
    }

    //二分查找
    //将士兵个数*1000+行下标加入数组
    //数组排序后,数组元素%1000得到原来对应的行下标
//    public static int[] kWeakestRows(int[][] mat, int k) {
//        int m = mat.length;
//        int n = mat[0].length;
//        int[] list = new int[m];
//        int[] res = new int[k];
//        for(int i=0; i<m; i++){
//            list[i] = countOne(mat[i])*1000+i;
//        }
//        Arrays.sort(list);
//        for(int j=0; j<k; j++){
//            res[j] = list[j]%1000;
//        }
//        return res;
//    }
//
//    public static int countOne(int[] num){
//        if(num.length == 0){
//            return 0;
//        }
//        //二分查找每行第一个0的位置
//        int left = 0;
//        int right = num.length;
//        while(left<right){
//            int mid = (left+right)/2;
//            if(num[mid] == 0){
//                right = mid;
//            }else{
//                left = mid+1;
//            }
//        }
//
//        return left;
//    }

    //按列查找
    public static int[] kWeakestRows(int[][] mat, int k){
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[k];
        Arrays.fill(res,-1);
        int index = 0;
        //按列查找
        for(int i=0; i<n;i++){
            for(int j=0; j<m; j++){
                //判断res数组是否已经装满k个行下标
                if(res[k-1]!=-1){
                    break;
                }
                //判断该行是否已经放入
                if(containRow(res,j)){
                    continue;
                }
                if(mat[j][i] == 0){
                    res[index++] = j;
                }
            }
        }
        //如果遍历完,res数组未放慢,按顺序放入即可
        if(index!=k){
            for(int i=0; i<m; i++){
                if(index==k){
                    break;
                }
                if(!containRow(res,i)){
                    res[index++] = i;
                }
            }

        }
        return res;
    }
    //判断该行是否已经被放入结果数组
    public static boolean containRow(int[] arr, int index){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == index){
                return true;
            }
        }
        return false;
    }
}
