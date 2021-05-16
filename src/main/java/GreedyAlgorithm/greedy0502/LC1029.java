package GreedyAlgorithm.greedy0502;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1029. 两地调度
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 *
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 *
 *
 *
 * 示例：
 *
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 *
 * 最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
 *
 *
 * 提示：
 *
 * 1 <= costs.length <= 100
 * costs.length 为偶数
 * 1 <= costs[i][0], costs[i][1] <= 1000
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/2-17:04
 */

public class LC1029 {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //按照o[0]-o[1]排序, 表示对于一个人 去A比去B花费少的放在前面
                //这样前面一半的人去A, 后面一半的人去B
                return o1[0]-o1[1]-(o2[0]-o2[1]);
            }
        });
        int A = costs.length/2;
        int sum = 0;
        for(int i=0; i<A; i++){
            sum += costs[i][0] + costs[i+A][1];
        }
        return sum;
    }
}
