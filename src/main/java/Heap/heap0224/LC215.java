package Heap.heap0224;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/*
 * @Description: 215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 18:14
 */
public class LC215 {

    //暴力排序
    //返回第 len-k 个元素
//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        Arrays.sort(nums);
//        return nums[len-k];
//    }

    private static Random random = new Random(System.currentTimeMillis());
    //快速选择排序
    public int findKthLargest(int[] nums, int k){
        int len = nums.length;
        //第k大的元素实际上是下标为len-k的数字
        int target = len - k;
        int left = 0;
        int right = len-1;
        while(true){
            int index = partition(nums, left, right);
            //如果随机选到的元素下标<target
            if(index<target){
                //target在区间右边
                left = index + 1;
            }else if(index>target){
                //target在区间左边
                right = index - 1;
            }else{
                //所求target,返回下标对应的数字
                return nums[index];
            }
        }
    }

    public int partition(int[] nums, int left, int right){
        if(right>left){
            //获取区间[1, right]中的随机坐标
            int randomIndex = left+1+random.nextInt(right-left);
            //将随机坐标对应的数据交换到left(0)
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int j = left;
        for(int i=left+1; i<=right; ++i){
            if(nums[i] < pivot){
                //小于pivot的数字都交换到数组的前面而不是与pivot交换
                ++j;
                swap(nums, j, i);
            }
        }
        //最后j就是pivot应该在的位置,将其交换到j
        swap(nums, left, j);
        //返回对应的下标
        return j;
    }

    //交换数组中两个下标对应的元素
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //优先队列

    //使用len个元素的小顶堆,出队len-k个元素,堆顶为第k大的元素
//    public int findKthLargest(int[] nums, int k){
//        int len = nums.length;
//        //使用一个含有len个元素的小顶堆
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, (a, b) -> a-b);
//        //先将len个元素全部添加进来形成小顶堆
//        for(int i=0; i<len; ++i){
//            minHeap.add(nums[i]);
//        }
//        //出队len-k 个元素,这样剩下的(len-(len-k))=k个元素形成的小顶堆顶就为第k大的元素
//        for(int i=0; i<len-k; ++i){
//            minHeap.poll();
//        }
//        return minHeap.peek();
//    }

    //使用len个元素的大顶堆,出队k-1个元素,k-1个大的元素都出队了,堆顶为第k大的元素
//    public int findKthLargest(int[] nums, int k){
//        int len = nums.length;
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a,b) -> b-a);
//        for(int i=0; i<len; ++i){
//            maxHeap.add(nums[i]);
//        }
//        for(int i=0; i<k-1; ++i){
//            maxHeap.poll();
//        }
//        return maxHeap.peek();
//    }

    //使用k个元素的小顶堆,遇到比顶大的元素出队一个入队一个
//    public int findKthLargest(int[] nums, int k){
//        int len = nums.length;
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a,b) -> a-b);
//        for(int i=0; i<k; ++i){
//            minHeap.add(nums[i]);
//        }
//        for(int i=k; i<len; ++i){
//            //看一眼堆顶元素
//            Integer topEle = minHeap.peek();
//            if(nums[i]>topEle){
//                minHeap.poll();
//                minHeap.add(nums[i]);
//            }
//
//        }
//        return minHeap.peek();
//    }

    //使用k+1个元素的小顶堆,k以后进来一个出去一个,让队列自己去维护大小关系,始终保持了队列有k个元素
//    public int findKthLargest(int[] nums, int k){
//        int len = nums.length;
//        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1, (a,b) -> a-b);
//        for(int i=0; i<k; ++i){
//            queue.add(nums[i]);
//        }
//        for(int i=k; i<len; ++i){
//            queue.add(nums[i]);
//            queue.poll();
//        }
//        return queue.peek();
//    }
}
class LC215_M2{
    public int findKthLargest(int[] nums, int k) throws Exception {
        MinHeap pq = new MinHeap(nums.length);
        for(int i=0; i<k; i++){
            pq.offer(nums[i]);
        }
        for(int i=k; i<nums.length; i++){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    @Test
    public void test() throws Exception {
        Random random = new Random();
        int[] test = new int[20];
        for(int i=0; i<20; i++){
            test[i] = random.nextInt(1000);
        }
        int res = findKthLargest(test,5);
        System.out.println(res);
        heapSort(test);
        System.out.println(Arrays.toString(test));

    }

    public void heapSort(int[] arr) throws Exception {
        MinHeap heap = new MinHeap(arr);
        for(int i=0; i<arr.length; i++){
            arr[i] = (int) heap.poll();
        }
    }
}

//小顶堆
class MinHeap{
    private int[] data;
    private int size;
    private int maxSize;

    public MinHeap(){

    }
    public MinHeap(int maxSize){
        this.maxSize = maxSize*2;
        this.size = 0;
        this.data = new int[this.maxSize];
    }

    public MinHeap(int[] arr){
        this(arr.length);
        this.size = arr.length;
        //所有元素入堆
        for(int i=0; i<arr.length; i++){
            this.data[i+1] = arr[i];
        }
        //保证堆满足有序的要求
        heapify();
    }

    //从最后一个元素开始percolate down, 保证有序
    public void heapify(){
        for(int i=size; i>=1; i--){
            shiftDown(i);
        }
    }

    //返回堆顶元素
    public int peek() throws Exception {
        if(size==0){
            throw new Exception("Empty heap");
        }
        return this.data[1];
    }

    //添加元素
    public void offer(int val) throws Exception {
        if(this.size==maxSize){
            throw new Exception("Full heap, can not offer");
        }
        size++;
        //添加到最后的位置
        this.data[size] = val;
        //然后向上与父节点交换直到合适的位置
        shiftUp(size);
    }

    //返回堆顶元素
    public int poll() throws Exception {
        if(this.size==0){
            throw new Exception("Empty heap, can not poll");
        }
        //要返回的元素
        int top = this.data[1];
        //最后一个元素放入堆顶
        this.data[1] = this.data[size];
        //减少了一个元素
        size--;
        //堆顶的元素向下与较小的子节点交换直到合适的位置
        shiftDown(1);
        return top;
    }

    //index所在的结点向上交换
    public void shiftUp(int index){
        //需要shiftup的结点
        int cur = this.data[index];
        //当存在父节点
        while(index/2 >=1){
            //当前结点值>父节点则无需交换了
            if(cur>=data[index/2]){
                break;
            }
            //父节点放入当前位置
            this.data[index] = this.data[index/2];
            //索引变成父节点
            index /= 2;
        }
        //当前index位置为cur应该放入的位置
        this.data[index] = cur;
    }

    //index位置向下与较小的子节点交换
    public void shiftDown(int index){
        int cur = this.data[index];
        //保证有子节点
        while(index*2<=size){
            //左子节点索引
            int son = index*2;
            //如果右子节点存在且<左子节点
            if(index*2+1<=size && this.data[son+1]<this.data[son]){
                son += 1;
            }
            //当前元素小于子节点中最小的那个不需要再交换了
            if(cur<=this.data[son]){
                break;
            }
            //较小的子节点放入当前位置,
            this.data[index] = this.data[son];
            //索引变成较小子节点的位置
            index = son;
        }
        this.data[index] = cur;
    }


}






















