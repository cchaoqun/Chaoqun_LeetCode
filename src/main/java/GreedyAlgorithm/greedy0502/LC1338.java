package GreedyAlgorithm.greedy0502;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/4-21:31
 */

public class LC1338 {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = arr.length;
        for(int i:arr){
            map.put(i, map.getOrDefault(i, 0)+1);
            if(map.get(i)>=len/2){
                return 1;
            }
        }
        int[] res = new int[map.size()];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            res[index++] = entry.getValue();
        }
        Arrays.sort(res);
        int sum = 0;
        int count = 0;
        for(int i=res.length-1; i>0; i--){
            sum += res[i];
            count++;
            if(sum>=len/2){
                return count;
            }
        }
        return len/2;
    }
}
