package Tree.tree0421;

import Tree.TreeNode;

import java.util.*;

/**
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 *
 * 提示：
 *
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/21-21:13
 */

public class LC863 {
    //获取父节点的map
    Map<TreeNode, TreeNode> par;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        this.par = new HashMap<>();
        dfs(root,null);

        Queue<TreeNode> queue = new LinkedList<>();
        //null相当于当前层与下一层的分隔符
        queue.add(null);
        queue.add(target);

        //判断当前结点是否已经被遍历过
        Set<TreeNode> seen = new HashSet<>();
        //null看做一个结点,就不需要判断左右子节点或者父节点是否为空
        seen.add(null);
        seen.add(target);

        int dist = 0;
        //BFS
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            //遇到null说明一层已经遍历完了
            if(node==null){
                //队列中剩余结点都在一层,到达target结点的距离都是K
                if(dist==K){
                    //到达target距离为K的结点值添加到list返回
                    List<Integer> res = new ArrayList<>();
                    for(TreeNode t: queue){
                        res.add(t.val);
                    }
                    return res;
                }
                //下一层的距离
                dist++;
                //继续添加null到队列尾,下一次遇到null说明一层遍历完了
                queue.offer(null);
            }else{
                //三个方向BFS
                if(!seen.contains(node.left)){
                    seen.add(node.left);
                    queue.offer(node.left);
                }
                if(!seen.contains(node.right)){
                    seen.add(node.right);
                    queue.offer(node.right);
                }
                TreeNode parentNode = par.get(node);
                if(!seen.contains(parentNode)){
                    seen.add(parentNode);
                    queue.offer(parentNode);
                }
            }
        }
        return new ArrayList<Integer>();
    }

    //初始化map key=node value=node的父节点
    public void dfs(TreeNode node, TreeNode parent){
        if(node!=null){
            par.put(node,parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
