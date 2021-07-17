package company.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/1-14:12
 */

public class LC56 {
    //右端点排序
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1){
            return intervals;
        }
        Arrays.sort(intervals, (a, b)->a[1]==b[1]?b[0]-a[0]:b[1]-a[1]);

        List<int[]> list = new ArrayList<>();
        int preRight = intervals[0][1];
        int preLeft = intervals[0][0];
        for(int i=1; i<intervals.length; i++){
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];
            if(preLeft>curRight){
                list.add(new int[]{preLeft, preRight});
                preLeft = curLeft;
                preRight = curRight;
            }else {
                preLeft = Math.min(preLeft, curLeft);
                preRight = Math.max(preRight, curRight);

            }
            if(i==intervals.length-1){
                list.add(new int[]{preLeft, preRight});
            }
        }
        int[][] res = new int[list.size()][2];
        int index = 0;
        for(int[] cur:list){
            res[index][0] = cur[0];
            res[index][1] = cur[1];
            index++;
        }
        return res;
    }
}
