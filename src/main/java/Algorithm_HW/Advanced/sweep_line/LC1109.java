package Algorithm_HW.Advanced.sweep_line;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/19-20:13
 */

public class LC1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        if(bookings==null || bookings.length==0){
            return new int[0];
        }
        //最后一个预定的航班号
        int max = 0;
        for(int[] cur : bookings){
            max = Math.max(max, cur[1]);
        }
        // max+2因为max预定的航班座位会在max+1天取消
        int[] res = new int[max+2];
        for(int[] cur : bookings){
            //相当于在cur[0]航班预定
            res[cur[0]] += cur[2];
            //在cur[1]+1航班取消预定, 因为 [cur[0], cur[1]]都预定了 在cur[1]+1才取消预定
            res[cur[1]+1] -= cur[2];
        }
        //只需要n个航班的信息
        int[] result = new int[n];
        //需要保证i<n并且小于最后一个预定航班的航班号是max+1
        for(int i=0; i<n && i<max+1; i++){
            // res下标从1开始, 差分数组求前缀和就是各个位置上原始值即座位总和
            res[i+1] += res[i];
            // result下标从0开始, 有1的偏差
            result[i] =res[i+1];
        }
        return result;
    }
}
