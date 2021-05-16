package Tree.tree0418;

/**
 * 684. 冗余连接
 * 在本问题中, 树指的是一个连通且无环的无向图。
 *
 * 输入一个图，该图由一个有着N个节点 (节点值不重复1, 2, ..., N) 的树及一条附加的边构成。附加的边的两个顶点包含在1到N中间，这条附加的边不属于树中已存在的边。
 *
 * 结果图是一个以边组成的二维数组。每一个边的元素是一对[u, v] ，满足 u < v，表示连接顶点u 和v的无向图的边。
 *
 * 返回一条可以删去的边，使得结果图是一个有着N个节点的树。如果有多个答案，则返回二维数组中最后出现的边。答案边 [u, v] 应满足相同的格式 u < v。
 *
 * 示例 1：
 *
 * 输入: [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 解释: 给定的无向图为:
 *   1
 *  / \
 * 2 - 3
 * 示例 2：
 *
 * 输入: [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * 解释: 给定的无向图为:
 * 5 - 1 - 2
 *     |   |
 *     4 - 3
 * 注意:
 *
 * 输入的二维数组大小在 3 到 1000。
 * 二维数组中的整数在1到N之间，其中N是输入数组的大小。
 * 更新(2017-09-26):
 * 我们已经重新检查了问题描述及测试用例，明确图是无向 图。对于有向图详见冗余连接II。对于造成任何不便，我们深感歉意。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/18-23:31
 */

public class LC684 {
    public int[] findRedundantConnection(int[][] edges) {
        int nodeCount = edges.length;
        int[] parent = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            parent[i] = i;
        }
        //遍历二维数组顶点对
        int node1 = 0;
        int node2 = 0;
        for (int i = 0; i < nodeCount; i++) {
            node1 = edges[i][0];
            node2 = edges[i][1];
            ///如果能加入并查集返回true 不能加入返回false
            if (!union(parent, node1, node2)) {
                break;
            }
        }
        //产生闭环
        return new int[]{node1, node2};

    }

    //判断i,j两个数在parent中的父节点是否相同
    public boolean union(int[] parent, int i, int j) {
        int find1 = find(parent, i);
        int find2 = find(parent, j);
        //已经存在, 如果两个结点相连会产生闭环
        if (find1 == find2) {
            return false;
        }
        //加入并查集
        parent[find(parent, i)] = find(parent, j);
        return true;
    }

    //查找index在parent数组中的父节点
    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }

}



