package Algorithm_HW.Advanced.sweep_line;

import Algorithm_HW.Advanced.sweep_line.MyCalendarTwo.Item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/11-9:36
 */

public class MyCalendarThree {
    private static final int START = 1;
    private static final int END = -1;
    List<Item> intervals;
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

    public MyCalendarThree() {
        this.intervals = new ArrayList<>();
    }

    public int book(int start, int end) {
        intervals.add(new Item(start, end));
        return maxOverlapBooks(intervals);
    }


    public int maxOverlapBooks(List<Item> intervals) {
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

class MyCalendarThree_M2{
    //TreeMap 写法
    TreeMap<Integer, Integer> map;

    public MyCalendarThree_M2() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0)+1);
        map.put(end, map.getOrDefault(end, 0)-1);
        int cur = 0;
        int res = 0;
        for(Integer key : map.keySet()){
            cur += map.get(key);
            res = Math.max(cur, res);
        }
        return res;
    }
}
