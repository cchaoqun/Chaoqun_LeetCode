package Algorithm_HW.Advanced.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/5-13:28
 */

public class LC1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int start = toBeRemoved[0];
        int end = toBeRemoved[1];

        for(int i=0; i<intervals.length; i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            // 不重叠
            if(curEnd <= start || curStart >= end){
                res.add(Arrays.asList(curStart, curEnd));
                continue;
            }
            // intervals对应的区间被toBeRemoved区间包括
            if(curStart>=start && curEnd<=end){
                continue;
            }
            //左边
            if(curStart<start){
                res.add(Arrays.asList(curStart,start));
            }
            //右边
            if(curEnd>end){
                res.add(Arrays.asList(end, curEnd));
            }
        }
        return res;
    }
}
