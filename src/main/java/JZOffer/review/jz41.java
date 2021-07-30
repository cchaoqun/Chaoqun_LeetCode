package JZOffer.review;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;
import java.util.TreeMap;

/**剑指 Offer 41. 数据流中的中位数
 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。

 例如，

 [2,3,4] 的中位数是 3

 [2,3] 的中位数是 (2 + 3) / 2 = 2.5

 设计一个支持以下两种操作的数据结构：

 void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 double findMedian() - 返回目前所有元素的中位数。
 示例 1：

 输入：
 ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 [[],[1],[2],[],[3],[]]
 输出：[null,null,null,1.50000,null,2.00000]
 示例 2：

 输入：
 ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 [[],[2],[],[3],[]]
 输出：[null,null,2.00000,null,2.50000]


 限制：

 最多会对 addNum、findMedian 进行 50000 次调用。
 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/27-13:23
 */

public class jz41 {

    @Test
    public void test(){
        TreeMap<Integer, Integer> map = new TreeMap<>();

    }
}
class MedianFinder {
    /**
     小顶堆 保存较大的一半数据 A 堆大小 m
     大顶堆 保存较小的一般数据 B 堆大小 n
     添加num
     m == n 先将num加入B B堆顶出堆加入A 保证了A中的数据一定大于B
     m != n 先将num加入A A堆顶出堆加入B

     median
     m == n A,B 堆顶元素和/2
     m != n A堆顶元素
     */
    //小的一半数据
    PriorityQueue<Integer> small = new PriorityQueue<>((a, b)->b-a);
    //大的一半数据
    PriorityQueue<Integer> big = new PriorityQueue<>((a,b)->a-b);

    /** initialize your data structure here. */
    public MedianFinder() {
        small = new PriorityQueue<>((a,b)->b-a);
        big = new PriorityQueue<>((a,b)->a-b);
    }

    public void addNum(int num) {
        if(small.size()==big.size()){
            small.offer(num);
            big.offer(small.poll());
        }else{
            big.offer(num);
            small.offer(big.poll());
        }
    }

    public double findMedian() {
        if(small.size()==big.size()){
            return (small.peek()+big.peek())*1.0/2;
        }else{
            return big.peek()*1.0;
        }
    }
}