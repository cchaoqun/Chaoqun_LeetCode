package Algorithm_HW.Advanced.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/4-15:55
 */

public class LC56 {
    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge(int[][] intervals) {
        /**
         1. 按照intervals[i][0]排序
         2. 手上拿一个区间cur, 根下一个区间next比较
         List<Interval> res = new ArrayList<>();
         重叠
         cur.end >= next.start
         cur.end = Math.max(cur.end, next.end);
         不重叠
         cur.end < next.start
         list.add(new Intervals(cur.start, cur.end))
         cur.start = next.start
         cur.end = next.end
         3. 别忘了把手上的最后一个interval放入list
         */
        if(intervals==null || intervals.length ==0){
            return intervals;
        }
        //按照起始端点排序
        Arrays.sort(intervals, (a, b)->(a[0]-b[0]));
        // 当前手上拿的区间
        Interval pre = new Interval(intervals[0][0], intervals[0][1]);
        // 存放不重叠区间的 list
        List<Interval> list = new ArrayList<>();
        for(int i=1; i<intervals.length; i++){
            //当前待比较区间
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            //重叠
            if(pre.end >= curStart){
                //更新右端点
                pre.end = Math.max(pre.end, curEnd);
            }else{
                // 不重叠, 之前的区间放入list
                list.add(new Interval(pre.start, pre.end));
                // 更新左右端点为当前区间的左右端点
                pre.start = curStart;
                pre.end = curEnd;
            }
        }
        // 别忘了把手上最后一个区间放入list
        list.add(new Interval(pre.start, pre.end));
        int[][] res = new int[list.size()][2];
        int index = 0;
        for(Interval cur:list){
            res[index][0] = cur.start;
            res[index++][1] = cur.end;
        }
        return res;
    }
}
