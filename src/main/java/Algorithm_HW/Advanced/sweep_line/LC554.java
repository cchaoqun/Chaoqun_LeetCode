package Algorithm_HW.Advanced.sweep_line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/13-16:04
 */

public class LC554 {
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
    public int leastBricks(List<List<Integer>> wall) {
        List<Node> nodes = new ArrayList<>();
        int sum = 0;
        for(List<Integer> range : wall){
            int edge = 0;
            for(int i=0; i<range.size(); i++){
                nodes.add(new Node(edge, START));
                edge += range.get(i);
                nodes.add(new Node(edge, END));
            }
            sum = edge;
        }
        Collections.sort(nodes, (a, b)->{
            if(a.time == b.time){
                //先让结束的在前面, 这样到达一个临界点 可以得到最小的再开始这个位置开始的同一块转
                return a.flag-b.flag;
            }
            return a.time - b.time;
        });
        int current = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<nodes.size(); i++){
            // 跳过左边界
            if(nodes.get(i).time==0){
                current++;
                continue;
            }
            // 已经到达右边界 不考虑
            if(nodes.get(i).time==sum){
                break;
            }
            if(nodes.get(i).flag==START){
                current++;
            }else{
                current--;
                res = Math.min(res, current);
            }
        }
        // 如果res每更新过, 说明每一行都只有一块砖, current就是结果
        return res==Integer.MAX_VALUE?current:res;
    }
}
