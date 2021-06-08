package Heap.heap0224;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**面试题 17.09. 第 k 个数
 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。

 示例 1:

 输入: k = 5

 输出: 9
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/4-13:57
 */

public class interview1709 {
    //三指针, pi=指针指向大小为k的数组中的位置, 并且这个位置应该乘以i
    public int getKthMagicNumber(int k) {
        if(k<=0){
            return 0;
        }
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        int[] res = new int[k];
        res[0] = 1;
        for(int i=1; i<k; i++){
            //每次比较三个指针指向的位置的数字乘以对应的权重(3,5,7)得到的最小值
            int cur = Math.min(res[p3]*3, Math.min(res[p5]*5, res[p7]*7));
            //得到的最小值对应的指针后移一位
            if(cur==res[p3]*3){
                p3++;
            }
            if(cur==res[p5]*5){
                p5++;
            }
            if(cur==res[p7]*7){
                p7++;
            }
            //当前位置的值就是本轮的最小值
            res[i] = cur;
        }
        return res[k-1];

    }
}

class interview1709_M2{
    //三指针, pi=指针指向大小为k的数组中的位置, 并且这个位置应该乘以i
    public int getKthMagicNumber(int k) {
        //小根堆
        PriorityQueue<Long> heap = new PriorityQueue<>();
        //保存前k个最小的不重复的数字
        Set<Long> set = new HashSet<>();
        heap.offer(1L);
        while(true){
            //出堆最小的元素
            Long cur = heap.poll();
            //当前出堆元素不存在与set,保证不重复(3*5 5*3)
            if(!set.contains(cur)){
                //放入set
                set.add(cur);
                //乘以3  5 7并且放入heap
                heap.offer(cur*3);
                heap.offer(cur*5);
                heap.offer(cur*7);
            }
            //现在set已经放入了前k个最小的数, 当前的cur就是第k个
            if(set.size()==k){
                return cur.intValue();
            }
        }

    }
}
