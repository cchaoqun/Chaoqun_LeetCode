package Sort.sort0526;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/26-22:41
 */

public class LC1356 {
    public int[] sortByBits(int[] arr) {
        int[][] res = new int[arr.length][2];
        for(int i=0; i<arr.length; i++){
            res[i][1] = one(arr[i]);
            res[i][0] = arr[i];
        }
        Arrays.sort(res,(o1,o2)->o1[1]==o2[1]?o1[0]-o2[0]:o1[1]-o2[1]);
        int[] cur = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            cur[i] = res[i][0];
        }
        return cur;
    }

    public int one(int i){
        int res= 0;
        while(i>0){
            if((i&1)==1){
                res+=1;
            }
            i>>=1;
        }
        return res;
    }
}
