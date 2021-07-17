package Algorithm_HW.Advanced.Intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/4-10:03
 */

public class LC253 {
    public int minMeetingRooms(int[][] intervals) {
        /**
         1. 根据会议开始时间排序
         res = 需要的总会议室
         avail = 当前可用的会议室
         2. 手上拿一个interval, 查看堆顶结束时间是否到了
         没到
         当前interval需要一个单独的会议室
         avail = 0
         res ++
         avail > 0
         avail --
         到了
         当前interval 可以重复利用空出来的会议室
         当前会议室结束时间入堆

         */
        if(intervals==null || intervals.length==0){
            return 0;
        }
        int res = 0;
        int avail = 0;
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->(a-b));
        for(int i=0; i<n; i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];
            //当前会议开始前 结束的会议室空出来的会议室
            while(!heap.isEmpty() && heap.peek()<=curStart){
                heap.poll();
                avail++;
            }
            if(avail>0){
                avail--;
            }else{
                res++;
            }
            heap.offer(curEnd);
        }
        return res;

    }
}
