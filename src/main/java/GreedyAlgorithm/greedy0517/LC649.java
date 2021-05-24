package GreedyAlgorithm.greedy0517;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/17-15:06
 */

public class LC649 {
    public String predictPartyVictory(String senate) {
        String R = "Radiant";
        String D = "Dire";
        int n = senate.length();
        Deque<Integer> queue1 = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();
        char[] arr = senate.toCharArray();
        //按顺序记录  R D在字符串出现的下标
        for(int i=0; i<n; i++){
            if(arr[i]=='R'){
                queue1.offer(i);
            }else{
                queue2.offer(i);
            }
        }
        //直到有一方阵营全部被ban掉
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            //每次两个队列头部下标出列
            int curR = queue1.poll();
            int curL = queue2.poll();
            //在前面的会ban掉出现在后面的地方阵营,
            //并且前面的下一轮还可以继续行使权力
            if(curR<curL){
                queue1.offer(curR+n);
            }else{
                queue2.offer(curL+n);
            }
        }
        return queue1.isEmpty()?D:R;
    }
}
