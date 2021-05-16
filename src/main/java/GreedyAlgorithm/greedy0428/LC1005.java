package GreedyAlgorithm.greedy0428;

import java.util.PriorityQueue;

/**
 * 1005. K 次取反后最大化的数组和
 * 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 *
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 * 示例 2：
 *
 * 输入：A = [3,-1,0,2], K = 3
 * 输出：6
 * 解释：选择索引 (1, 2, 2) ，然后 A 变为 [3,1,0,2]。
 * 示例 3：
 *
 * 输入：A = [2,-3,-1,5,-4], K = 2
 * 输出：13
 * 解释：选择索引 (1, 4) ，然后 A 变为 [2,3,-1,5,4]。
 *
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * 1 <= K <= 10000
 * -100 <= A[i] <= 100
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/28-16:27
 */

public class LC1005 {
    //优先队列
    public int largestSumAfterKNegations(int[] A, int K) {
        //小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b)->(a-b));
        for(int a:A){
            pq.offer(a);
        }
        //每次取顶堆顶数字取反再放回去
        while(K>0){
            int curMin = pq.poll();
            curMin *= -1;
            pq.offer(curMin);
            K--;
        }
        //求和
        int sum = 0;
        for(int i:pq){
            sum += i;
        }
        return sum;
    }
}

class LC1005_M2{
    public int largestSumAfterKNegations(int[] A, int K){
        int[] mapA = new int[201];
        // -100<A[i]<100 将A[i] 映射到 [0,200]上
        for(int a:A){
            mapA[a+100]++;
        }
        int i=0;
        while(K>0){
            //找到最小数
            while(mapA[i]==0){
                i++;
            }
            //变成相反数
            mapA[i]--;
            mapA[200-i]++;
            //最小索引>100, 说明都大于0, 下一次需要从对称的位置开始找, 因为本次操作mapA[200-i]位置有数在[0,100]
            if(i>100){
                i = 200-i;
            }
            K--;
        }
        int sum = 0;
        for(int j=0; j<mapA.length; j++){
            //j-100 该数字的大小, 还原到-100,100区间
            //mapA[j] 为该数字出现的次数
            sum += (j-100)*mapA[j];
        }
        return sum;
    }
}
