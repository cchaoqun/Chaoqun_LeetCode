package Algorithm_HW.Week1;

import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/2-14:54
 */

public class LC703 {
}

class KthLargest {

    private int k;
    private int[] nums;
    //大顶堆 保存最小到k-1大的数, 堆顶为k-1大的数
    private PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
    //小顶堆 保存k到最大的k个数, 对顶为第k大的数
    private PriorityQueue<Integer> cache = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;
        //初始化大顶堆
        for(int i:nums){
            pq.offer(i);
        }
        //从大顶堆出队k个数到小顶堆表示当前数组中最大的k个数(如果有k个数的话)
        while(cache.size()<k && !pq.isEmpty()){
            cache.offer(pq.poll());
        }

    }

    public int add(int val) {
        //小顶堆数量<k表示所有数都在小顶堆, 直接放入小顶堆
        if(cache.size()<this.k){
            cache.offer(val);
        }else if(cache.size()==k){
            //小顶堆有最大的k个数, 比较当前添加的val与当前第k大的数的关系
            if(val<=cache.peek()){
                //val<=第k大的数, 放入大顶堆, 不影响最大的k个数
                pq.offer(val);
            }else{
                //val>第k大的数, 小顶堆堆顶元素放入大顶堆, 当前val放入小顶堆
                pq.offer(cache.poll());
                cache.offer(val);
            }
        }
        //每次一定是返回小顶堆的堆顶元素
        return cache.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */