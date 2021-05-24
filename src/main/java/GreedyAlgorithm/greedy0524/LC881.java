package GreedyAlgorithm.greedy0524;

import java.util.Random;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/24-22:11
 */

public class LC881 {
    public int numRescueBoats(int[] people, int limit) {

        int len = people.length;
        //快排 双指针
        quickSort(people, 0, len-1);
        int p1 = 0;
        int p2 = len-1;
        int count = 0;
        while(p1<=p2){
            //当前最小的和最大的如果和>limit 最大的单独一趟, p2指针左移
            //否则两个可以一起乘船, p1++ p2--;
            int small = people[p1];
            int big = people[p2];
            if(small+big>limit){
                p2--;
            }else{
                p1++;
                p2--;
            }
            count++;
        }
        return count;
    }
    Random random = new Random();
    public void quickSort(int[] arr, int lo, int hi){
        if(lo>=hi){
            return;
        }
        int pivot = partition(arr, lo, hi);
        quickSort(arr, lo, pivot-1);
        quickSort(arr, pivot+1, hi);
    }

    public int partition(int[] arr, int lo, int hi){
        int pivot = random.nextInt(hi-lo+1)+lo;
        int cur = arr[pivot];
        swap(arr, lo, pivot);
        int index = lo;
        for(int i=lo+1; i<=hi; i++){
            if(arr[i]<=cur){
                index++;
                swap(arr, i, index);
            }
        }
        swap(arr, lo, index);
        return index;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

class LC881_M2{
    public int numRescueBoats(int[] people, int limit){
        int[] w = new int[limit+1];
        for(int i:people){
            //重量为i的人的个数
            w[i]++;
        }
        // p1 p2 代表重量
        int p1 = 0;
        int p2 = limit;
        int count = 0;
        while(p1<=p2){
            //从左向右找到第一个非0的重量
            while(p1<=p2 && w[p1]<=0){
                p1++;
            }
            //从右向左找到第一个非0的重量
            while(p1<=p2 && w[p2]<=0){
                p2--;
            }

            if(p1>p2){
                break;
            }
            //两人重量之和<=limit
            //p1 p2重量的人数减-
            if(p1+p2<=limit){
                w[p1]--;
            }
            w[p2]--;
            count++;
        }
        return count;
    }
}





























