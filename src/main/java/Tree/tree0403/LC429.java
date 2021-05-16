package Tree.tree0403;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Description: 429. N 叉树的层序遍历
给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。

树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。



示例 1：



输入：root = [1,null,3,2,4,null,5,6]
输出：[[1],[3,2,4],[5,6]]
示例 2：



输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]


提示：

树的高度不会超过 1000
树的节点总数在 [0, 10^4] 之间
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/3 22:24
 */
public class LC429 {
    //迭代
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //当前层的list
            List<Integer> cur = new ArrayList<>();
            //遍历当前层的每一个结点
            for(int i=queue.size(); i>0; i--){
                //每出队一个结点
                Node node = queue.poll();
                //将其val添加到本层的list
                cur.add(node.val);
                //获取当前结点的孩子结点
                List<Node> child = node.children;
                //遍历孩子结点添加到队列
                for(int j=0; j<child.size(); j++){
                    queue.offer(child.get(j));
                }
            }
            //当前层list加入res
            res.add(cur);
        }
        return res;
    }
}
class LC429_M2{
    //递归
    List<List<Integer>> res;
    public List<List<Integer>> levelOrder(Node root){
        res = new ArrayList<>();
        if(root==null){
            return res;
        }
        dfs(root, 0);
        return res;
    }

    public void dfs(Node node, int level){
        //还不存在当前层的list<Integer>
        if(res.size()<=level){
            //new一个
            res.add(new ArrayList<>());
        }
        //获取当前层的list,将当前结点值加进去
        res.get(level).add(node.val);
        //当前结点不是叶子结点
        if(node.children.size()>0){
            List<Node> child = node.children;
            //依次递归当前结点的孩子结点
            for(int i=0; i<child.size(); i++){
                dfs(child.get(i), level+1);
            }
        }
    }

}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

