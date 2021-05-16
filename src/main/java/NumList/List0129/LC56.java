package NumList.List0129;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * @Description: 56. 合并区间
 *
给出一个区间的集合，请合并所有重叠的区间。
示例 1:
输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
*
示例2:
输入: intervals = [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。


提示：
intervals[i][0] <= intervals[i][1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/29 11:55
 */
public class LC56 {

    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        if(m==0 || m==1){
            return intervals;
        }
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //记录当前区间进行比较的区间行数
        int lastRegion = 0;
        for(int i=1; i<m; i++){
            //需要合并的情况为两区间存在交集
            //1.两者存在交集
            if(intervals[i][0]<=intervals[lastRegion][1]){
                //两区间合并,左端点为上一个区间的左端点
                //右端点为当前区间的右端点与比较区间右端点中的最大值
                intervals[lastRegion][1] = Math.max(intervals[i][1],intervals[lastRegion][0]);
                //合并后,待比较区间行数不变,只是端点发生变化
            }
            //2.包含关系,无需改变待比较区间
            //3.不需要合并的情况当前区间左端点大于待比较区间右端点
            if(intervals[i][0] > intervals[lastRegion][1]){
                //将当前区间复制到待比较区间下一行
                intervals[lastRegion+1][0] = intervals[i][0];
                intervals[lastRegion+1][1] = intervals[i][1];
                //下一个区间的待比较区间变成当前区间
                lastRegion++;
            }
        }
        int[][] merge = new int[lastRegion+1][2];
        int i=0;
        while(i<=lastRegion){
            merge[i] = Arrays.copyOf(intervals[i],2);
            i++;
        }
        return merge;
    }


//    public int[][] merge(int[][] intervals){
//        int m = intervals.length;
//        if(m==0 || m==1){
//            return intervals;
//        }
//        //排序
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//        List<int[]> res = new ArrayList<>();
//        res.add(intervals[0]);
//        for(int i=1; i<m; i++){
//            //获取res最后一个数组
//            int[] peek = res.get(res.size()-1);
//            int[] cur = intervals[i];
//            //合并
//            if(cur[0]<=peek[1]){
//                //合并取件右端点为两者中的最大值
//                peek[1] = Math.max(cur[1], peek[1]);
//                res.add(peek);
//            }else{
//                //直接添加
//                res.add(cur);
//            }
//
//        }
//        return res.toArray(new int[res.size()][2]);
//
//    }
}
