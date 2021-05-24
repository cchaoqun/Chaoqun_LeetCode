package Divide_Conquer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/21-12:08
 */

public class Interview1714 {
    //快速选择
    Random random = new Random();
    public int[] smallestK(int[] arr, int k) {
        if(k==0){
            return new int[0];
        }
        int res = quickSelect(arr, 0, arr.length-1, k);
        return Arrays.copyOfRange(arr, 0, res+1);
    }

    public int quickSelect(int[] arr, int lo, int hi, int k){
        if(lo>=hi){
            return lo;
        }
        int pivot = partition(arr, lo, hi);
        if(pivot==k-1){
            return pivot;
        }
        return pivot>k-1 ? quickSelect(arr,lo,pivot-1,k):quickSelect(arr,pivot+1, hi,k);
    }

    public int partition(int[] arr, int lo, int hi){
        int pivot = random.nextInt(hi-lo+1)+lo;
        int cur = arr[pivot];
        int index = lo;
        swap(arr, lo, pivot);
        for(int i=lo+1; i<=hi; i++){
            if(arr[i]<=cur){
                index++;
                swap(arr,i,index);
            }
        }
        swap(arr, index, lo);
        return index;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

class Interview1714_M2{
    //大根堆
    public int[] smallestK(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);
        if(k==0){
            return new int[0];
        }
        for(int i=0; i<k; i++){
            heap.offer(arr[i]);
        }
        int[] res = new int[k];
        for(int i=k; i<arr.length; i++){
            if(heap.peek()>arr[i]){
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        for(int i=0; i<k; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}




























