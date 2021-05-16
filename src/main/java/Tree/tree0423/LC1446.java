package Tree.tree0423;

import java.util.*;

/**
 * 1466. 重新规划路线
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 *
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 *
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 *
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 *
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 2：
 *
 *
 *
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 *
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 *
 *
 * 提示：
 *
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/23-22:18
 */

public class LC1446 {
    public int minReorder(int n, int[][] connections) {
        int res = 0;
        // key=结点值  value=结点所在的层
        Map<Integer, Set<Integer>> nodeLevels = new HashMap<>();
        //visited[i] i层是否被遍历过
        boolean[] levelVisited = new boolean[n];
        //遍历每一层获得每个结点所在层数放在对应的set集合中
        for(int i=0; i<connections.length; i++){
            int node0 = connections[i][0];
            int node1 = connections[i][1];
            if(!nodeLevels.containsKey(node0)){
                nodeLevels.put(node0, new HashSet<Integer>());
            }
            if(!nodeLevels.containsKey(node1)){
                nodeLevels.put(node1, new HashSet<Integer>());
            }
            nodeLevels.get(node0).add(i);
            nodeLevels.get(node1).add(i);
        }
        //从0开始BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            //获取当前结点所在层数
            for(int i:nodeLevels.get(cur)){
                //如果当前层已经被遍历 continue
                if(levelVisited[i]){
                    continue;
                }
                //标记当前层已经被遍历
                levelVisited[i] = true;
                //当前层的起点和终点
                int n1 = connections[i][0];
                int n2 = connections[i][1];

                //如果当前层起点等于当前出队的结点, 说明是沿着结点0出来的方向, 需要被转换方向
                res += (cur==n1)?1:0;
                //如果当前起点=出队结点, 下一个应该遍历是当前层的终点
                //如果当前层终点为出队结点, 下一个应该遍历的是当前层的起点
                n1=(cur==n1)?n2:n1;
                queue.offer(n1);

            }
        }
        return res;
    }
}
