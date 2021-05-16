package TypicalProblem.TopK;

import java.util.Arrays;
import java.util.Random;

/*
 * @Description: 剑指 Offer 40. 最小的k个数
输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。



示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]


限制：

0 <= k <= arr.length <= 10000
0 <= arr[i] <= 10000
通过次数141,711提交次数247,486
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/2 18:56
 */
public class jz40 {

    //堆
//    public int[] getLeastNumbers(int[] arr, int k) {
//        int[] res = new int[k];
//        if(k==0){
//            return res;
//        }
//        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer num1, Integer num2) {
//
//                return num2-num1;
//            }
//        });
//        //先将前k个数字添加到大顶堆
//        for(int i=0; i<k; ++i){
//            queue.offer(arr[i]);
//        }
//        //如果当前数字<对顶数字,就出队对顶元素,当前元素入队
//        for(int i=k; i<arr.length; ++i){
//            if(arr[i] > queue.peek()){
//                queue.poll();
//                queue.offer(arr[i]);
//            }
//        }
//        int index = 0;
//        for(int i:queue){
//            res[index++] = i;
//        }
//        return res;
//    }

    //快速选择排序
    private Random random = new Random(System.currentTimeMillis());
    public int[] getLeastNumbers(int[] arr, int k){
        int len = arr.length;
        int[] res = new int[k];
        if(k==0 || arr.length==0){
            return res;
        }
        int left = 0;
        int right = len-1;
        while(true){
            //如果这个排序完的下标刚好为k-1,那么[0,k-1]刚好为k个最小的数
            int pivot = partition(arr,left, right);
            if(pivot==k-1){
                return Arrays.copyOfRange(arr, 0, k);
            }else if(pivot<k-1){
                //当前排序下标在k-1的左边,收缩左边界继续寻找k-1
                left = pivot+1;
            }else{
                //当前排序下标在k-1的右边,收缩右边界寻找k-1
                right = pivot-1;
            }
        }
    }

    //随机选择一个位置j的值将其放到他排序后应该在的位置,并且返回这个位置j
    //排序后,0~j-1的值都小于arr[j]但不一定是有序的
    //j+1, arr.length-1的值都大于arr[j]但不一定是有序的
    int partition(int[] arr, int left, int right){
        if(left<right){
            //在[left+1,right]区间随机选择一个下标
            //ran = left + 1 + [0,right-left-1] = [left+1,right]
            int ran = left+1+random.nextInt(right-left);
            //将随机选择的值与区间最左边的值交换
            swap(arr,left,ran);
        }
        int j=left;
        //当前需要找到位置的值
        int pivot = arr[left];
        for(int i=left+1; i<=right; ++i){
            //如果遇到小于pivot的值,将其放到左边
            if(arr[i]<pivot){
                j++;
                swap(arr, i, j);
            }
        }
        //现在[left+1,j]的值都小于pivot,并且arr[left]=pivot
        //将left与j位置的值交换后[left,j-1]的值都小于pivot
        swap(arr, j,left);
        //返回排序完成元素pivot的下标
        return j;
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
