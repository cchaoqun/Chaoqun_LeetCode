package GreedyAlgorithm.greedy0525;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/25-15:53
 */

public class LC1053 {

    public int[] prevPermOpt1(int[] arr){
        for(int i=arr.length-1; i>0; i--){
            if(arr[i]<arr[i-1]){
                for(int j=arr.length-1; j>i-1; j--){
                    if(arr[j]<arr[i-1] && arr[j]!=arr[j-1]){
                        swap(arr, j, i-1);
                    }
                }
            }
        }
        return arr;
    }

    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
