package Algorithm_HW.Advanced.Intervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/5-12:03
 */

public class LC436 {
    class Interval{
        int start;
        int end;
        int index;
        public Interval(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    @Test
    public void test(){
        TreeMap map = new TreeMap();
    }

    // 排序 查找
    public int[] findRightInterval(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        int n = intervals.length;
        int[] res = new int[n];
        for(int i=0; i<intervals.length; i++){
            // interval对象额外保存了索引
            list.add(new Interval(intervals[i][0], intervals[i][1], i));
        }
        // 按照start排序
        Collections.sort(list, (a,b)->(a.start-b.start));
        for(int i=0; i<list.size(); i++){
            int curEnd = list.get(i).end;
            int minIndex = -1;
            int minStart = Integer.MAX_VALUE;
            // 线性查找
//            // j=i 防止 start==end 区间只有一个点的情况
//            for(int j=i; j<n; j++){
//                // 向后找到第一个start>=curEnd的区间
//                if(list.get(j).start>=curEnd && list.get(j).start<minStart){
//                    // 更新最小start
//                    minStart = list.get(j).start;
//                    // 更新这个区间在原来数组中的下标
//                    minIndex = list.get(j).index;
//                    // 找到的第一个一定是最小的start 因为按照start排序了且start不重复
//                    break;
//                }
//            }
            //二分
            int lo=i, hi = n-1;
            while(lo<=hi){
                int mid = lo + ((hi-lo)>>1);
                if(list.get(mid).start>=curEnd){
                    minIndex = list.get(mid).index;
                    minStart = list.get(mid).start;
                    hi = mid-1;
                }else{
                    lo = mid+1;
                }
            }
            // 当前interval对应在原数组是下标为list.get(i).index
            res[list.get(i).index] = minIndex;
        }
        return res;
    }
}
