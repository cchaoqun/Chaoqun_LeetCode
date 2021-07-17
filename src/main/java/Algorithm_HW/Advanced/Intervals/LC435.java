package Algorithm_HW.Advanced.Intervals;

import java.util.Arrays;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/5-12:02
 */

public class LC435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        /**
         区间按照起始端点排序
         int res = 0;
         遍历, 排序后的区间, 手上拿一个pre和下一个比较cur
         如果两个区间不重合
         pre.end <= cur.start
         更新pre为当前区间
         如果两个区间重合
         pre.end>cur.start
         保留右端点更小的那个, 更大的那个移除
         res++
         */
        if(intervals==null || intervals.length==0){
            return 0;
        }
        Arrays.sort(intervals, (a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int res = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1; i<intervals.length; i++){
            //当前区间
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            // 重合
            if(end>curStart){
                // 保留右端点更小的区间
                if(end > curEnd){
                    start = curStart;
                    end = curEnd;
                }
                // 需要删除一个右端更大的区间
                res++;
            }else {
                // 不重合, 更新区间
                start = curStart;
                end = curEnd;
            }
        }
        return res;
    }
}
