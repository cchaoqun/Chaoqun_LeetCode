package Algorithm_HW.Advanced.sweep_line;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/11-9:36
 */

public class MeetingRoom_II {
    /**
     sweep line
     标记每个会议的开始时间与 START END 对应构成一个 Node starTime, START endTime,END
     Node 包含 time flag
     加入到两个allMixedNodes<Node>
     sort
     a.time==b.time? a.flag-b.flag: a.time-b.time
     currentMeet = 0 表示当前正在进行的会议的个数
     res = 0 表示最多需要同时进行的会议个数
     遇到 node.flag = STATR
     currentMeet++
     res = Math.max(res, currentMeet);
     否则
     currentMeet--
     return res
     */
    private static final int START = 1;
    private static final int END = -1;
    class Node{
        int time;
        int flag;
        public Node(int time, int flag){
            this.time = time;
            this.flag = flag;
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        if(intervals==null || intervals.length==0){
            return 0;
        }
        //当前正在进行的meet
        int currentMeet = 0;
        //最多同时进行的会议数量
        int res = 0;
        List<Node> nodes = new ArrayList<>();
        for(int[] cur : intervals){
            // START 代表这是一个会议的开始时间
            nodes.add(new Node(cur[0], START));
            // END 代表这是一个会议的结束时间
            nodes.add(new Node(cur[1],END));
        }
        // nodes排序
        Collections.sort(nodes, (a, b)->{
            // 两个node时间相同
            if(a.time==b.time){
                // 比较是end还是start end优先放在前面
                // 因为如果一个会议的结束时间end 和下一个会议的开始时间start相同
                // 需要先结束会议再开始 currentMeet 先 +1 再 -1
                return a.flag-b.flag;
            }
            // 时间小的放前面
            return a.time-b.time;
        });
        for(Node node : nodes){
            //当前是一个会议的开始时间, 那么正在进行的会议数量一定+1
            if(node.flag==START){
                currentMeet++;
                //更新最多同时进行的会议数量
                res = Math.max(res, currentMeet);
            }else{
                // 当前是一个会议结束时间, 那么正在进行的会议数量一定-1
                currentMeet--;
            }
        }
        // 返回结果
        return res;
    }
}

class method2{
    /**
     PQ 解法
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
    public int minMeetingRooms(int[][] intervals){
        if(intervals==null || intervals.length==0){
            return 0;
        }
        //最多的需要开的会议
        int res = 0;
        // 当前可用的空的会议室
        int avail = 0;
        // 根据会议开始时间排序
        Arrays.sort(intervals, (a,b)->(a[0]-b[0]));
        // 保留当前正在进行的会议的结束时间, 堆顶为最早结束的会议时间
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i=0; i<intervals.length; i++){
            //当前会议开始结束时间
            int start = intervals[i][0];
            int end = intervals[i][1];
            // 当前会议开始之前结束的会议的会议室可以空出来
            while(!heap.isEmpty() && heap.peek()<=start){
                avail++;
                heap.poll();
            }
            // 如果有空的会议室直接用
            if(avail>0){
                avail--;
            }else{
                // 没有空的会议室 需要额外开
                res++;
            }
            // 当前会议结束时间入堆
            heap.offer(end);
        }
        return res;
    }
}



















