package GreedyAlgorithm.greedy0510;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1288. 删除被覆盖区间
 * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
 *
 * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
 *
 * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
 *
 *
 *
 * 示例：
 *
 * 输入：intervals = [[1,4],[3,6],[2,8]]
 * 输出：2
 * 解释：区间 [3,6] 被区间 [2,8] 覆盖，所以它被删除了。
 *
 *
 * 提示：​​​​​​
 *
 * 1 <= intervals.length <= 1000
 * 0 <= intervals[i][0] < intervals[i][1] <= 10^5
 * 对于所有的 i != j：intervals[i] != intervals[j]
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/10-20:57
 */

public class LC1288 {
    public int removeCoveredIntervals(int[][] intervals) {
        int len = intervals.length;
        //对起点进行升序排序，如果起点相同，则对终点进行降序排序。
        //将数组按照每个区间的左端从小到大排序
        //如果左端点相同, 按照右端点从大到小排序
        //这样前一个的区间不会小于当前区间
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0]==o2[0]?o2[1]-o1[1]:o1[0]-o2[0];
            }
        });
        // for(int i=0; i<len; i++){
        //     System.out.println(Arrays.toString(intervals[i]));
        // }


        int right = intervals[0][1];
        int count = len;
        for(int i=1; i<len; i++){
            //只需要比较右端点即可
            //左端点以及按照升序排列了
            if(intervals[i][1]<=right){
                count--;
            }else{
                right = intervals[i][1];
            }
        }
        return count;
    }
}
