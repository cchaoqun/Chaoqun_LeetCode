package Algorithm_HW.Week1;

import java.util.Arrays;

/**
 * 593. 有效的正方形
 * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
 *
 * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 *
 * 示例:
 *
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 *
 *
 * 注意:
 *
 * 所有输入整数都在 [-10000，10000] 范围内。
 * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
 * 输入点没有顺序。
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/1-14:13
 */

public class LC593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //计算所有两点间的距离的平方
        int d12 = dist(p1,p2);
        int d13 = dist(p1,p3);
        int d14 = dist(p1,p4);
        int d23 = dist(p2,p3);
        int d24 = dist(p2,p4);
        int d34 = dist(p3,p4);
        //从小到大排序
        int[] arr = new int[]{d12,d13,d14,d23,d24,d34};
        Arrays.sort(arr);
        //四条周长的边相等 且不为零
        for(int i=1; i<4; i++){
            if(arr[i]!=arr[i-1] || arr[i]==0){
                return false;
            }
        }
        //两条对角线相等
        if(arr[4]!=arr[5]){
            return false;
        }
        //两条边长的平方和等于对角线的平方
        if(arr[3]*2 != arr[4]){
            return false;
        }
        return true;

    }

    //计算两点之间距离的平方
    private int dist(int[] a, int[] b){
        return (a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]);
    }
}
