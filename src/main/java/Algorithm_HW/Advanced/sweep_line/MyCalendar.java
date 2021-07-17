package Algorithm_HW.Advanced.sweep_line;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/11-9:36
 */

public class MyCalendar {
    /**
     每次插入我们需要先检查这个区间与我们已有的区间是否有重合
     没有就需要放入区间的集合
     有重合
     [      floorKey.End]      [ceillingKey              ]
     [start                           end]
     map.get(map.floorKey) > start
     ceillingKey < end
     使用数据结构treeMap 可以最快的获得最大的小于当前start的key 检查key的end是否>start
     可以最快的获得最小的大于当前start的key检查 key是否<end

     */
    TreeMap<Integer, Integer> map;
    public MyCalendar() {
        this.map = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        if(map.size()==0){
            map.put(start, end);
            return true;
        }
        //获取floorKey
        Integer floorKey = map.floorKey(start);
        // 存在floorKey并且floorKey对应的end>start
        if(floorKey!=null &&  map.get(floorKey)>start){
            return false;
        }
        //获取ceillingKey
        Integer ceilingKey = map.ceilingKey(start);
        //存在ceilingkey并且ceilingKey<end
        if(ceilingKey!=null && ceilingKey<end){
            return false;
        }
        map.put(start, end);
        return true;

    }
}
