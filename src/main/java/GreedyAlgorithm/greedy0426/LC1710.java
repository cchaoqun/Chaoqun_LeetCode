package GreedyAlgorithm.greedy0426;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/26-16:12
 */

public class LC1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //按照数组第二个元素从小到大排序
        Arrays.sort(boxTypes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o2[1]-o1[1];
            }
        });
        int count = 0;
        for(int[] i:boxTypes){
            //当前箱子个数<容量, 全部装
            if(i[0]<truckSize){
                count += i[0]*i[1];
                //减去箱子数量
                truckSize -= i[0];
            }else{
                //当前箱子个数>=剩余容量
                //剩余空间全部装当前类型的箱子
                count += truckSize*i[1];
                return count;
            }
        }
        return count;

    }
}
