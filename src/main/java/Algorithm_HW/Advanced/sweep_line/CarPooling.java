package Algorithm_HW.Advanced.sweep_line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/13-15:19
 */

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips==null || trips.length==0){
            return true;
        }
        return maxOverlap(trips)<=capacity;
    }

    private static final int START = 1;
    private static final int END = -1;
    class Node{
        int time;
        int flag;
        int count;
        public Node(int time, int flag, int count){
            this.time = time;
            this.flag = flag;
            this.count = count;
        }
    }
    private int maxOverlap(int[][] intervals){
        List<Node> nodes = new ArrayList<>();
        int current = 0;
        int res = 0;
        for(int[] cur : intervals){
            nodes.add(new Node(cur[1], START, cur[0]));
            nodes.add(new Node(cur[2], END, cur[0]));
        }
        Collections.sort(nodes, (a, b)->{
            if(a.time==b.time){
                return a.flag - b.flag;
            }
            return a.time - b.time;
        });
        for(Node node : nodes){
            if(node.flag == START){
                current += node.count;
                res = Math.max(res, current);
            }else{
                current -= node.count;
            }
        }
        return res;
    }
}
class CarPooling_M2{
    public boolean carPooling(int[][] trips, int capacity) {
        if(trips==null || trips.length==0){
            return true;
        }
        int max = 0;
        for(int[] trip : trips){
            max = Math.max(trip[2], max);
        }
        int[] res = new int[max+1];
        //差分数组
        for(int[] trip:trips){
            //上车
            res[trip[1]] += trip[0];
            //下车
            res[trip[2]] -= trip[0];
        }
        for(int i=1; i<=max; i++){
            //差分数组的prefix sum就是当前位置的车上总人数
            res[i] += res[i-1];
            if(res[i]>capacity){
                return false;
            }
        }
        return true;
    }
}