package NumList.List0129;

import java.util.*;

/*
 * @Description:57
 *
给出一个无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
示例2：

输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/insert-interval
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/29 13:30
 */
public class LC57 {
    public static void main(String[] args) {
        int[][] intervals = new int[3][2];
        intervals[0] = new int[]{1,5};
        intervals[1] = new int[]{8,10};
        intervals[2] = new int[]{12,15};
        int[] newIntervals = {16,16};
        for(int[] array: insert(intervals, newIntervals)){
            System.out.println(Arrays.toString(array));
        }
    }

//    public static int[][] insert(int[][] intervals, int[] newInterval) {
//        int m = intervals.length;
//        List<int[]> res = new ArrayList<>();
//        if(m==0){
//            res.add(newInterval);
//            return res.toArray(new int[res.size()][]);
//        }
//
//        int left = newInterval[0], right = newInterval[1];
//        //找到插入的左右区间行数
//        int start = find(intervals,0,left,true);
//        int end = find(intervals,start,right,false);
//
//        if(end<start){
//            //当前区间不与其他区间相交
//            res.add(newInterval);
//            for(int i=0; i<m; i++){
//                res.add(intervals[i]);
//            }
//        }else{
//            //将合并区间以前的原始区间添加到res
//            for(int i=0; i<start; i++){
//                res.add(intervals[i]);
//            }
//
//            //考虑新区间覆盖最后一个区间或者完全大于最后一个区间的情况
//            if(end==m){
//                //完全大于最后一个区间
//                if(start==m){
//                    //将新区间插入到整个区间的最后
//                    res.add(newInterval);
//                }else{
//                    //新区间右端点大于原始区间的右端点
//                    left = Math.min(intervals[start][0], left);
//                    res.add(new int[]{left,right});
//                }
//            }else{
//                //新区建在原始区间的中间
//                left = Math.min(intervals[start][0], left);
//                right = Math.max(intervals[end][1], right);
//                int[] merged = {left,right};
//                //将插入区间添加到res
//                res.add(merged);
//                //将合并区间以后的原始区间添加到res
//                for(int i=end+1; i<m; i++){
//                    res.add(intervals[i]);
//                }
//            }
//        }
//
//        //按照区间的左端点排序
//        Collections.sort(res, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//        return res.toArray(new int[res.size()][]);
//
//
//    }
//
//    //找到二维数组中第一个index<intervals[][1] 的行数
//    //start代表搜索的起始行数
//    public static int find(int[][] intervals, int start, int index, boolean findLeft){
//        for(int i=start; i<intervals.length; i++){
//            if(index<=intervals[i][1]){
//                if(findLeft){
//                    return i;
//                }else{
//                    if(index<intervals[i][0]){
//                        return i-1;
//                    }else{
//                        return i;
//                    }
//                }
//
//            }
//
//        }
//        //比所有的都大
//        return intervals.length;
//    }

    public static int[][] insert(int[][] intervals, int[] newInterval){
        int m = intervals.length;
        List<int[]> res = new ArrayList<>();
        if(m==0){
            res.add(newInterval);
            return res.toArray(new int[res.size()][]);
        }
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        for(int[] cur:intervals){
            if(cur[0]>right){
                //如果还没被放入集合,添加到集合
                if(!placed){
                    res.add(new int[]{left,right});
                    placed = true;
                }
                //区间在当前区间左边,当前区间可以添加到集合
                res.add(cur);
            }else if(cur[1]<left){
                //区间在当前区间右侧,当前区间可以添加到集合
                res.add(cur);
            }else{
                //有交集
                left = Math.min(cur[0],left);
                right = Math.max(cur[1],right);
            }
        }
        if(!placed){
            //在所有区间右边
            res.add(new int[]{left,right});
        }
        return res.toArray(new int[res.size()][]);

    }
}
