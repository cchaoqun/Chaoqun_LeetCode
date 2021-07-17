package Algorithm_HW.Advanced.sweep_line;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/11-9:36
 */

public class MyCalendarTwo {
    /*
["MyCalendarTwo","book","book","book","book","book","book"]
[[],[10,20],[50,60],[10,40],[5,15],[5,10],[25,55]]

time:10flag:1
time:20flag:-1
--
time:10flag:1
time:20flag:-1
time:50flag:1
time:60flag:-1
--
time:10flag:1
time:20flag:-1
time:50flag:1
time:60flag:-1
--
time:5flag:1
time:10flag:1
time:15flag:-1
time:20flag:-1
time:50flag:1
time:60flag:-1
--
time:5flag:1
time:10flag:1
time:15flag:-1
time:20flag:-1
time:50flag:1
time:60flag:-1
--
time:5flag:1
time:10flag:1
time:15flag:-1
time:20flag:-1
time:25flag:1
time:50flag:1
time:55flag:-1
time:60flag:-1
--





     */
    @Test
    public void test() {
        int[][] op = {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        for(int[] cur: op){
            book(cur[0], cur[1]);
        }
    }




    List<Item> intervals;

    public MyCalendarTwo() {
        this.intervals = new ArrayList<>();
    }



    public boolean book(int start, int end) {
        Item item = new Item(start, end);
        intervals.add(item);
        if(minOverlapBooks(intervals)<=2){
            return true;
        }
        intervals.remove(intervals.size()-1);
        return false;
    }


    private static final int START = 1;
    private static final int END = -1;
    class Node{
        int time;
        int flag;
        public Node(int time, int flag){
            this.time = time;
            this.flag = flag;
        }
        public void print(){
            System.out.println("time:"+time+"flag:"+flag);
        }
    }
    class Item {
        int start;
        int end;
        public Item(int start, int end){
            this.start = start;
            this.end = end;
        }

    }

    public int minOverlapBooks(List<Item> intervals) {
        if(intervals==null || intervals.size()==0){
            return 0;
        }
        //当前正在进行的meet
        int currentMeet = 0;
        //最多同时进行的会议数量
        int res = 0;
        List<Node> nodes = new ArrayList<>();
        for(Item item : intervals){
            // START 代表这是一个会议的开始时间
            nodes.add(new Node(item.start, START));
            // END 代表这是一个会议的结束时间
            nodes.add(new Node(item.end,END));
        }

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

class MyCalendarTwo1{
    @Test
    public void test() {
        int[][] op = {{10,20},{50,60},{10,40},{5,15},{5,10},{25,55}};
        for(int[] cur: op){
            book(cur[0], cur[1]);
        }
    }
    TreeMap<Integer, Integer> intervals;
    TreeMap<Integer, Integer> doubleBooking;
    public MyCalendarTwo1() {
        this.intervals = new TreeMap<>();
        this.doubleBooking = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        if(hasOverlap(start, end, doubleBooking)){
            return false;
        }
        if(!intervals.isEmpty()){
            Integer floorKey = intervals.floorKey(start);
            if(floorKey != null){
                int floorEnd = intervals.get(floorKey);
                if(floorEnd > start){ // overlap and update doublebooking
                    doubleBooking.put(start, Math.min(end, floorEnd));
                    // 先把 start and end 扩大，继续和ceilKey比 看会不会造成 doublebooking
                    start = floorKey;
                    end = Math.max(end, floorEnd);
                    intervals.remove(floorKey);
                }
            }
            Integer ceilKey = intervals.ceilingKey(start);
            while(ceilKey != null && ceilKey < end){ // ceilKey and ceilend still in [start   end]
                int ceilEnd = intervals.get(ceilKey);
                // overlap and update doublebooking
                doubleBooking.put(ceilKey, Math.min(end, ceilEnd));
                end = Math.max(end, ceilEnd);
                intervals.remove(ceilKey);
                ceilKey = intervals.ceilingKey(start);
            }
        }
        intervals.put(start, end);
        return true;
    }
    private boolean hasOverlap(int start, int end, TreeMap<Integer, Integer> map){
        Integer floorKey = map.floorKey(start);
        if(floorKey != null){
            int floorEnd = map.get(floorKey);
            if(floorEnd > start){
                return true; // has overlap
            }
        }
        Integer ceilKey = map.ceilingKey(start);
        if(ceilKey != null){
            if(end > ceilKey){
                return true;
            }
        }
        return false;
    }
}