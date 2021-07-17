package Algorithm_HW.Advanced.Intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/5-11:22
 */

public class LC986 {
    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        /**
         两个区间列表已经排序
         双指针, a->first b->second 指向两个集合的下一个待比较的区间
         两个区间的交集为
         start = Math.max(f.start, s.start)
         end = Math.min(f.end, s.end)
         如果 start > end 说明两个区间没有交集
         需要移动指针的为 end更小的那个
         如果 start<=end 有交集
         需要移动的同样是end更小的那个
         如果两个区间的end相同, 指针都需要移动
         */
        if(firstList==null || firstList.length==0){
            return firstList;
        }
        if(secondList==null || secondList.length==0){
            return secondList;
        }
        // 保存重叠区间的list
        List<Interval> list = new ArrayList<>();
        // f--> firstList s-->secondList
        int f=0, s=0;
        int len1 = firstList.length;
        int len2 = secondList.length;
        // 两个区间都没遍历完
        while(f<len1 && s<len2){
            // firstList对应的待比较区间
            int s1 = firstList[f][0];
            int e1 = firstList[f][1];
            // secondList对应的待比较区间
            int s2 = secondList[s][0];
            int e2 = secondList[s][1];
            //重叠区间端点
            int start = Math.max(s1, s2);
            int end = Math.min(e1, e2);
            if(start<=end){
                //重叠
                // 重叠区间加入list
                list.add(new Interval(start, end));
            }
            // 右端点相同, 两个指针都需要移动
            if(e1==e2){
                f++;
                s++;
            }else if(e1<e2){// 右端点小的移动
                f++;
            }else{
                s++;
            }
        }
        int[][] res = new int[list.size()][2];
        int index = 0;
        for(Interval cur : list){
            res[index][0] = cur.start;
            res[index++][1] = cur.end;
        }
        return res;
    }
}
