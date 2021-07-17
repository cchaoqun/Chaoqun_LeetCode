package Heap.heap0224;

import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/11-17:58
 */

public class LC295 {
}

class MedianFinder {

    //最大堆, 保存前半部分元素
    PriorityQueue<Integer> maxHeap;
    //最小堆, 保存后半部分元素
    PriorityQueue<Integer> minHeap;
    int count;
    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        maxHeap = new PriorityQueue<>((a,b)->b-a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        //先放入最大堆,
        maxHeap.offer(num);
        //最大堆堆顶入最小堆
        minHeap.offer(maxHeap.poll());
        //元素总数为奇数
        if((count&1)!=0){
            //最大堆需要比最小堆多一个
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        //总数为奇数
        if((count&1)!=0){
            //返回最大堆堆顶元素
            return 1.0*maxHeap.peek();
        }else{
            //返回两个堆顶元素的均值
            return (1.0*maxHeap.peek()+minHeap.peek())/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
