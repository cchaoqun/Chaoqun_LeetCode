package GreedyAlgorithm.greedy0615;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/15-21:36
 */

public class LC1353 {
    public int maxEvents(int[][] events) {
        /**
         将所有的会议按照startDay从小到大排序
         遍历每一天, 将所有这一天开始的时间都放入按照结束时间排序的最小堆
         while(如果当前天数>堆顶元素的值) 堆顶元素出堆
         如果当前天数<=堆顶元素的值, 堆顶出堆 count++
         */
        //最小堆保存了下一个最新结束的会议
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //会议按照开始时间从小到大排序
        Arrays.sort(events, (n1, n2)->(n1[0]-n2[0]));
        //会议的个数
        int size = events.length;
        //代表每一天
        int day = 1;
        //二维矩阵的行索引
        int index = 0;
        //可以参加会议的个数
        int count = 0;
        //当index<size || 堆中还有未结束的会议
        while(index<size || !heap.isEmpty()){
            //将结束时间在当前天数之前的会议出堆, 因为已经无法参加了
            while(!heap.isEmpty() && heap.peek()<day){
                heap.poll();
            }
            //只要会议中是以day开始都将其结束时间放入堆中
            while(index<size && events[index][0]==day){
                heap.add(events[index][1]);
                index++;
            }
            //这一天参加的会议室堆中结束时间最早的, 当前堆中的会议一定是结束时间在当天及以后的,因为小于day都已经出堆了
            if(!heap.isEmpty() && day<=heap.peek()){
                heap.poll();
                count++;
            }
            day++;
        }
        return count;

    }
}
