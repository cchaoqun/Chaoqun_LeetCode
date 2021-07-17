package Algorithm_HW.Advanced.Intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/4-15:55
 */

public class LC57 {
    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /**
         从左到右找到第一个与newInterval相交的区间, 合并后向右继续查找可能需要合并的区间
         不重叠的情况
         case 1: intervals[i][0]>newInteral[1]
         case 2: inetrvals[i][1]<newInterval[0]

         */
        if(intervals==null || intervals.length==0){
            return new int[][]{newInterval};
        }
        List<Interval> list = new ArrayList<>();
        //最开始手上拿的 newInterval~!!!!
        Interval newInter = new Interval(newInterval[0], newInterval[1]);
        for(int i=0; i<intervals.length; i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            //不重叠
            if(curStart>newInter.end ){
                list.add(new Interval(newInter.start, newInter.end));
                newInter.start = curStart;
                newInter.end = curEnd;
            }else if(curEnd<newInter.start){
                //不重叠
                list.add(new Interval(curStart, curEnd));
            }else{
                //重叠
                newInter.start = Math.min(newInter.start, curStart);
                newInter.end = Math.max(newInter.end, curEnd);
            }
        }
        //别忘了加最后手上的interval
        list.add(new Interval(newInter.start, newInter.end));
        int[][] res = new int[list.size()][2];
        int index = 0;
        for(Interval cur : list){
            res[index][0] = cur.start;
            res[index++][1] = cur.end;
        }
        return res;
    }
}
