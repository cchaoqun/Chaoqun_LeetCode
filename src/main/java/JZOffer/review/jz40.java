package JZOffer.review;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/26-21:21
 */

public class jz40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->b-a);
        for(int i=0; i<k; i++){
            heap.offer(arr[i]);
        }
        for(int i=k; i<arr.length; i++){
            if(arr[i]<heap.peek()){
                heap.poll();
                heap.offer(arr[i]);
            }
        }
        int[] res = new int[k];
        int index = 0;
        while(!heap.isEmpty()){
            res[index++] = heap.poll();
        }
        return res;
    }
}

class jz40_M2{
    Random random = new Random();
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[0];
        }
        quickSelect(arr, 0, arr.length-1, k-1);
        int[] res = Arrays.copyOfRange(arr, 0, k);
        return res;

    }
    void quickSelect(int[] arr, int l, int r, int target){
        if(l>=r){
            return;
        }
        int pivot = partition(arr, l, r);
        if(pivot==target){
            return;
        }else if(pivot<target){
            quickSelect(arr, pivot+1, r,target);
        }else{
            quickSelect(arr, l, pivot-1,target);
        }
    }

    int partition(int[] arr, int l, int r){
        int pivot = random.nextInt(r-l+1)+l;
        int val = arr[pivot];
        int index = l;
        swap(arr, l, pivot);
        for(int i=l+1; i<=r; i++){
            if(arr[i]<val){
                index++;
                swap(arr, i, index);
            }
        }
        swap(arr, index, l);
        return index;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}