package GreedyAlgorithm.greedy0515;

import java.util.Arrays;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/15-13:44
 */

public class LC435 {
    //按照左端排序
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0){
            return 0;
        }
        //根据区间左端点升序排列
        Arrays.sort(intervals, (o1, o2)->o1[0]-o2[0]);
        int len = intervals.length;
        //前一个区间的右端点
        int pre = intervals[0][1];
        int count = 0;
        for(int i=1; i<len; i++){
            //前区间与当前区间有交集
            if(pre>intervals[i][0]){
                //更新后区间的右端点为两个区间右端点的较小值, 这样保证重合的可能性尽可能小
                pre = Math.min(intervals[i][1], pre);
                //需要删除一个
                count++;
            }else{
                //没有交集, 更新右端点为当前区间的右端点即可
                pre = intervals[i][1];
            }
        }
        return count;
    }
}

class LC435_M2{
    public int eraseOverlapIntervals(int[][] intervals){
        if(intervals==null || intervals.length==0){
            return 0;
        }
        //根据区间右端点升序排列
        Arrays.sort(intervals, (o1, o2)->o1[1]-o2[1]);
        int pre = intervals[0][1];
        int n = intervals.length;
        int count = 0;
        for(int i=1; i<n; i++){
            if(intervals[i][0]>=pre){
                count++;
                pre = intervals[i][1];
            }
        }
        return n-count;
    }
}


























