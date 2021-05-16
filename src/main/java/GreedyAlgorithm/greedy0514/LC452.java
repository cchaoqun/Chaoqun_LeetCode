package GreedyAlgorithm.greedy0514;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 *
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 *
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 *
 *
 * 示例 1：
 *
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 * 示例 2：
 *
 * 输入：points = [[1,2],[3,4],[5,6],[7,8]]
 * 输出：4
 * 示例 3：
 *
 * 输入：points = [[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 示例 4：
 *
 * 输入：points = [[1,2]]
 * 输出：1
 * 示例 5：
 *
 * 输入：points = [[2,3],[2,3]]
 * 输出：1
 *
 *
 * 提示：
 *
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/14-21:40
 */

public class LC452 {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0){
            return 0;
        }
        int len = points.length;
        //左端点不同,按左端点升序排序
        //左端点相同, 按右端点降序排序
        Arrays.sort(points, new Comparator<int[]>(){
            @Override
            public int compare(int[] n1, int[] n2){
                if(n1[0]==n2[0]){
                    //比较大小而不是n2[1]-n1[1]
                    //极端情况, n2接近Integer.MAX n1接近Integer.MIN 造成整型移除
                    return n1[1]>n2[1]?-1:1;
                }else{
                    //同理比较大小
                    return n1[0]>n2[0]?1:-1;
                }
            }
        });
//        for(int[] i:points){
//            System.out.println(Arrays.toString(i));
//        }
        //当前的最小公共区域
        int left = points[0][0];
        int right = points[0][1];
        int count = 1;
        for(int i=1; i<len; i++){
            int curL = points[i][0];
            int curR = points[i][1];
            //之前公共区域与当前区间没有交集, 需要增加一支箭
            //并且更新当前公共区域为当前的左右端点
            if(right<curL){
                count++;
                left = curL;
                right = curR;
            }else {
                //有交集
                //左端点变成其中的较大值
                //右端点变成其中的较小值
                left = Math.max(left, curL);
                right = Math.min(right, curR);
            }
        }
        return count;

    }
}
class LC452_M2{
    //按右端点升序排序
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int len = points.length;
        Arrays.sort(points, (p1, p2)->p1[1]>p2[1]?1:-1);

        int pre = points[0][1];
        int count = 1;
        for(int i=1; i<len; i++){
            //当前区间与之前区间右端点不重合
            if(pre<points[i][0]){
                count++;
                pre = points[i][1];
            }
        }
        return count;
    }
}