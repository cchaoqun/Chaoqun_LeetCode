package Tree.tree0422;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 623. 在二叉树中增加一行
 * 给定一个二叉树，根节点为第1层，深度为 1。在其第 d 层追加一行值为 v 的节点。
 *
 * 添加规则：给定一个深度值 d （正整数），针对深度为 d-1 层的每一非空节点 N，为 N 创建两个值为 v 的左子树和右子树。
 *
 * 将 N 原先的左子树，连接为新节点 v 的左子树；将 N 原先的右子树，连接为新节点 v 的右子树。
 *
 * 如果 d 的值为 1，深度 d - 1 不存在，则创建一个新的根节点 v，原先的整棵树将作为 v 的左子树。
 *
 * 示例 1:
 *
 * 输入:
 * 二叉树如下所示:
 *        4
 *      /   \
 *     2     6
 *    / \   /
 *   3   1 5
 *
 * v = 1
 *
 * d = 2
 *
 * 输出:
 *        4
 *       / \
 *      1   1
 *     /     \
 *    2       6
 *   / \     /
 *  3   1   5
 *
 * 示例 2:
 *
 * 输入:
 * 二叉树如下所示:
 *       4
 *      /
 *     2
 *    / \
 *   3   1
 *
 * v = 1
 *
 * d = 3
 *
 * 输出:
 *       4
 *      /
 *     2
 *    / \
 *   1   1
 *  /     \
 * 3       1
 * 注意:
 *
 * 输入的深度值 d 的范围是：[1，二叉树最大深度 + 1]。
 * 输入的二叉树至少有一个节点。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/22-20:36
 */

public class LC623 {
    private int val;
    private int depth;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        this.val = val;
        this.depth = depth;
        //需要在根结点上面添加一个结点
        if(depth==1){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        return dfs(root, 1);
    }
    //后续遍历
    public TreeNode dfs(TreeNode node, int dep){
        if(node==null){
            return null;
        }
        TreeNode left = dfs(node.left, dep+1);
        TreeNode right = dfs(node.right, dep+1);
        //当前层的下一层需要添加
        if(dep == depth-1){
            //添加结点
            node.left = new TreeNode(val);
            node.right = new TreeNode(val);
            //添加上原来的左右子树
            node.left.left = left;
            node.right.right = right;
        }
        return node;
    }
}
class LC623_M2{
    //BFS
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int dep = 0;
        while(!queue.isEmpty()){
            dep++;
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(dep==depth-1){
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(val);
                    node.right = new TreeNode(val);
                    node.left.left = left;
                    node.right.right = right;
                }else{
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                }
            }
            if(dep==depth-1){
                break;
            }
        }
        return root;
    }
}