package Divide_Conquer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 973. 最接近原点的 K 个点
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：points = [[1,3],[-2,2]], K = 1
 * 输出：[[-2,2]]
 * 解释：
 * (1, 3) 和原点之间的距离为 sqrt(10)，
 * (-2, 2) 和原点之间的距离为 sqrt(8)，
 * 由于 sqrt(8) < sqrt(10)，(-2, 2) 离原点更近。
 * 我们只需要距离原点最近的 K = 1 个点，所以答案就是 [[-2,2]]。
 * 示例 2：
 *
 * 输入：points = [[3,3],[5,-1],[-2,4]], K = 2
 * 输出：[[3,3],[-2,4]]
 * （答案 [[-2,4],[3,3]] 也会被接受。）
 *
 *
 * 提示：
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/20-18:34
 */

public class LC973 {

    @Test
    public void test(){
        int[][] points = {{1,3},{2,-2}};
        int[][] res = kClosest(points, 1);
    }

    Random random = new Random();
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        //在区间[0,n-1]选择符合条件的下标
        int res = quickSelect(points, 0, n-1, k);
        return Arrays.copyOfRange(points, 0, res+1);
    }

    //在[left,right]区间选择下标等于index==k-1的下标
    public int quickSelect(int[][] points, int left, int right, int k){
        if(left>=right){
            return left;
        }
        int index = partition(points, left, right);
        if(index==k-1){
            //找到
            return index;
        }else if(index>k-1){
            //在左边
            return quickSelect(points, left, index-1, k);
        }else {
            //在右边
            return quickSelect(points, index+1, right, k);
        }
    }

    public int partition(int[][] points, int lo, int hi){
        //生成[0,hi-lo]区间的随机数, +lo ==> [lo, hi]区间的随机数
        int pivot = random.nextInt(hi-lo+1) + lo ;
        //当前随机数下标对应的距离
        int cur = dist(points, pivot);
        //将其换到左端点的位置
        swap(points, pivot, lo);
        //当前距离<=cur的下标最右为index=lo
        int index = lo;
        for(int i=lo+1; i<=hi; i++){
            //当前坐标的距离
            int curDist = dist(points,i);
            //当前距离小于pivot对应的距离
            if(curDist<=cur){
                //<cur的下标增加一个
                index++;
                swap(points, index, i);
            }
        }
        //index始终表示<=cur的位置中最右边的一个, 将其换到最右边
        swap(points, index,lo);
        return index;
    }

    public void swap(int[][] arr, int i, int j){
        int n1 = arr[i][0];
        int n2 = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = n1;
        arr[j][1] = n2;
    }

    public int dist(int[][] arr, int i){
        return arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1];
    }
}

class LC973_M2{
    //大根堆
    public int[][] kClosest(int[][] points, int k) {
        //大根堆, 从大到小排列
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((o1,o2)->dist(o2)-dist(o1));
        int n = points.length;
        //前k个数组入堆
        for(int i=0; i<k; i++){
            heap.offer(points[i]);
        }
        //比堆顶距离大的入堆
        for(int i=k; i<n; i++){
            int curDist = dist(points[i]);
            if(curDist<dist(heap.peek())){
                heap.poll();
                heap.offer(points[i]);
            }
        }

        int[][] res = new int[k][2];
        for(int i=0; i<k; i++){
            res[i][0] = heap.peek()[0];
            res[i][1] = heap.peek()[1];
            heap.poll();
        }
        return res;
    }

    public int dist(int[] o){
        return o[0]*o[0] + o[1]*o[1];
    }
}























