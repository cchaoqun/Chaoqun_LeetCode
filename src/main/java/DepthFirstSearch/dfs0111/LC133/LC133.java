package DepthFirstSearch.dfs0111.LC133;

import java.util.*;

/*
 * @Description: 133. 克隆图
 *
给你无向连通图中一个节点的引用，请你返回该图的深拷贝（克隆）。
图中的每个节点都包含它的值 val（int） 和其邻居的列表（list[Node]）。
class Node {
    public int val;
    public List<Node> neighbors;
}

测试用例格式：
简单起见，每个节点的值都和它的索引相同。例如，第一个节点值为 1（val = 1），
*第二个节点值为 2（val = 2），以此类推。该图在测试用例中使用邻接列表表示。
邻接列表 是用于表示有限图的无序列表的集合。每个列表都描述了图中节点的邻居集。
给定节点将始终是图中的第一个节点（值为 1）。你必须将给定节点的拷贝作为对克隆图的引用返回。


提示：
节点数不超过 100 。
每个节点值Node.val 都是唯一的，1 <= Node.val <= 100。
无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
图是连通图，你可以从给定节点访问到所有节点。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/clone-graph
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/11 17:26
 */
public class LC133 {

    //DFS
//    Map<Node,Node> visited = new HashMap<>();
//    public Node cloneGraph(Node node){
//        if(node==null){
//            return node;
//        }
//        //该节点已经访问过,取出该节点的克隆结点并返回
//        if(visited.containsKey(node)){
//            return visited.get(node);
//        }
//        //创建该节点的克隆结点,邻接列表不拷贝
//        Node cloneNode = new Node(node.val, new ArrayList<>());
//        //哈希表存储
//        visited.put(node,cloneNode);
//        //访问该节点的邻接节点
//        for(Node neighbor: node.neighbors){
//            cloneNode.neighbors.add(cloneGraph(neighbor));
//        }
//        return cloneNode;
//    }

    //BFS
    public Node cloneGraph(Node node){
        if(node==null){
            return node;
        }

        Map<Node,Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        //克隆第一个结点
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            //访问该节点的邻接节点
            for(Node neighbor:temp.neighbors){
                //如果该节点未被访问,访问他的邻接节点
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.add(neighbor);
                }
                //更新当前结点的邻接节点
                visited.get(temp).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }

}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
