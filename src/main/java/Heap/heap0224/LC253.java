package Heap.heap0224;

import java.util.Arrays;
import java.util.PriorityQueue;

/**253. 会议室 II
 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。



 示例 1：

 输入：intervals = [[0,30],[5,10],[15,20]]
 输出：2
 示例 2：

 输入：intervals = [[7,10],[2,4]]
 输出：1


 提示：

 1 <= intervals.length <= 104
 0 <= starti < endi <= 106
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/4-14:28
 */

public class LC253 {
    public int minMeetingRooms(int[][] intervals) {
        /*
        按照开始时间从小到大排列
        开始时间相同的按照结束时间从小到大排列
         */
        Arrays.sort(intervals, (t1, t2)->(t1[0]==t2[0]?t1[1]-t2[1]:t1[0]-t2[0]));
        //保存之前使用的会议室结束使用的时间 从小到大
        PriorityQueue<Integer> end = new PriorityQueue<>();
        //可用的会议室的数量
        int available = 0;
        //总使用的会议室
        int sum = 0;
        for(int[] meet:intervals){
            //当前的时间
            int curTime = meet[0];
            //之前使用过的会议室如果当前时间已经使用完了, 就出队, 并且可用的会议室数量+1
            while(!end.isEmpty() && end.peek()<=curTime){
                available++;
                end.poll();
            }
            //判断当前是否有可用的会议室
            if(available==0){
                //没有就需要再开一个会议室
                sum++;
            }else{
                //有可用的, 可用的数量-1
                available--;
            }
            //当前会议结束时间入堆
            end.offer(meet[1]);
        }
        return sum;

    }
}
