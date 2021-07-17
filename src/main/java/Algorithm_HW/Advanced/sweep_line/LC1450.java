package Algorithm_HW.Advanced.sweep_line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/13-15:32
 */

public class LC1450 {
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
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        List<Node> nodes = new ArrayList<>();
        for(int i=0; i<startTime.length; i++){
            nodes.add(new Node(startTime[i], START));
            nodes.add(new Node(endTime[i], END));
        }
        Collections.sort(nodes, (a, b)->{
            if(a.time==b.time){
                return b.flag - a.flag;
            }
            return a.time-b.time;
        });
        int current = 0;
        for(Node node : nodes){
            if(node.time==queryTime){
                if(node.flag==START){
                    current++;
                }else{
                    return current;
                }
            }
            else if(node.time < queryTime){
                if(node.flag==START){
                    current++;
                }else{
                    current--;
                }
            }else{
                break;
            }
        }
        return current;

    }
}
