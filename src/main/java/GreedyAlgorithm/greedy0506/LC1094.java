package GreedyAlgorithm.greedy0506;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/6-20:56
 */

public class LC1094 {
    //记录每个位置的总负载
    //如果存在某个位置的负载>capacity, return false
    public boolean carPooling(int[][] trips, int capacity) {
        int[] alltrips = new int[1001];
        for(int i=0; i<trips.length; i++){
            for(int j=trips[i][1]; j<trips[i][2]; j++){
                alltrips[j] += trips[i][0];
                if(alltrips[j]>capacity){
                    return false;
                }
            }
        }
        return true;
    }

}

class LC1094_M2{
    public boolean carPooling(int[][] trips, int capacity){
        int[] capacityChange = new int[1001];
        for(int[] trip:trips){
            //当前trip 在 trip[1] 造成总的capacity减少了 trip[0]
            capacityChange[trip[1]] -= trip[0];
            //在 trip[2]位置造成总的capacity增加了 trip[0]
            capacityChange[trip[2]] += trip[0];
        }

        for(int i:capacityChange){
            //遍历每个位置, 对总的capacity做对应的增加减少, 如果存在小于0的情况,return false
            capacity += i;
            if(capacity<0){
                return false;
            }
        }
        return true;
    }
}
