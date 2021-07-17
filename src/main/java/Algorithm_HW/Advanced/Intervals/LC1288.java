package Algorithm_HW.Advanced.Intervals;

import java.util.Arrays;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/6-13:36
 */

public class LC1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        /**
         按照左端点排序, 左端点相同, 按照右端点从大到小排血
         遇到pre.end <= cur.end 并且 pre.start==cur.start
         res++
         否则
         pre.start = cur.start
         pre.end = cur.end
         */
        Arrays.sort(intervals, (a, b)->(a[0]==b[0]?b[1]-a[1]:a[0]-b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        int res = 0;
        for(int i=1; i<intervals.length; i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            if(end>=curEnd){
                res++;
            }else{
                start = curStart;
                end = curEnd;
            }
        }
        return intervals.length - res;
    }
}
