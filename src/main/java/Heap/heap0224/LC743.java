package Heap.heap0224;

import java.util.*;

/**743. 网络延迟时间
 有 n 个网络节点，标记为 1 到 n。

 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。

 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。



 示例 1：



 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 输出：2
 示例 2：

 输入：times = [[1,2,1]], n = 2, k = 1
 输出：1
 示例 3：

 输入：times = [[1,2,1]], n = 2, k = 2
 输出：-1


 提示：

 1 <= k <= n <= 100
 1 <= times.length <= 6000
 times[i].length == 3
 1 <= ui, vi <= n
 ui != vi
 0 <= wi <= 100
 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/6-12:59
 */

public class LC743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        //Map统计每个结点的子节点以及子节点的距离
        Map<Integer, List<int[]>> graph = new HashMap<>();
        //按照从根结点到当前结点的距离从小到大排列
        PriorityQueue<int[]> heap = new PriorityQueue<>((arr1, arr2)->arr1[0]-arr2[0]);
        //map 保存每个结点和从根结点到当前结点的距离
        Map<Integer, Integer> dist = new HashMap<>();
        for(int[] cur:times){
            //结点对应的list不存在, 先创建
            if(!graph.containsKey(cur[0])){
                graph.put(cur[0], new ArrayList<int[]>());
            }
            //将当前结点cur[0]的子节点cur[1]已经cur[0]->cur[1]的距离放入graph
            graph.get(cur[0]).add(new int[]{cur[1], cur[2]});
        }
        //起始点放入heap
        heap.offer(new int[]{0,k});
        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            //根结点到当前结点的距离
            int d = cur[0];
            //当前结点的值
            int node =cur[1];
            //放入距离的map, 如果已经遍历过就跳过
            if(dist.containsKey(node)){
                continue;
            }
            dist.put(node, d);
            //遍历当前结点的子节点
            if(graph.containsKey(node)){
                for(int[] son:graph.get(node)){
                    //cur[0]->son[0]的距离
                    int dSon = son[1];
                    //子节点的值
                    int nodeSon = son[0];
                    //根结点到son[0]的距离为根结点到父节点的距离d+父节点到子节点的距离dSon
                    heap.offer(new int[]{d+dSon, nodeSon});
                }
            }
        }
        //所有不重复的结点值!=n, 说明有结点没有被遍历到,
        if(dist.size()!=n){
            return -1;
        }
        int res = 0;
        for(int d:dist.values()){
            res = Math.max(res, d);
        }
        return res;

    }
}
