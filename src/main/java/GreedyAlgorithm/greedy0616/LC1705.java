package GreedyAlgorithm.greedy0616;

import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/16-13:27
 */

public class LC1705 {
    public int eatenApples(int[] apples, int[] days) {
        /**
         int[] expire = {i+days[i],apples[i]} 表示day[i]天有apples[i]个苹果过期
         每天都查看堆顶的元素的过期日期, 和剩余苹果数量
         如果没过期, 吃掉一个苹果, 如果还有剩余就再入堆
         */
        PriorityQueue<int[]> heap = new PriorityQueue<>((n1, n2)->(n1[0]-n2[0]));
        int n = apples.length;
        int count = 0;
        int i=0;
        for(; i<n; i++){
            //第i天长出的苹果入堆
            if(apples[i]!=0){
                heap.offer(new int[]{i+days[i], apples[i]});
            }
            //腐烂的苹果出堆(腐烂的天数<=当前天数)
            while(!heap.isEmpty() && heap.peek()[0]<=i){
                heap.poll();
            }
            //如果还有未腐烂的苹果, 从堆顶取出最早腐烂的苹果吃一个
            if(!heap.isEmpty()){
                int[] top = heap.poll();
                top[1]--;
                count++;
                //如果不是第二天就过期 并且还有剩余的苹果 入堆
                if(top[0]>i+1 && top[1]>0){
                    heap.offer(top);
                }
            }
        }
        //如果还有剩余的苹果并且没有过期可以继续吃
        while(!heap.isEmpty()){
            while(!heap.isEmpty() && heap.peek()[0]<=i){
                heap.poll();
            }
            if(!heap.isEmpty()){
                int[] top = heap.poll();
                top[1]--;
                count++;
                if(top[0]>i+1 && top[1]>0){
                    heap.offer(top);
                }
            }
            i++;
        }

        return count;

    }
}
