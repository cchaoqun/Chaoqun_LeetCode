package Tree.tree0418;

import Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/18-21:20
 */

public class LC538 {
    //DFS
    //前一个遍历到的结点的值
    int prev;
    public TreeNode convertBST(TreeNode root) {
        this.prev = 0;
        dfs(root);
        return root;
    }
    //右中左 反中序遍历
    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        dfs(node.right);
        //先找到最右子节点, 更新结点值和前驱结点值为当前结点更新后的结点值
        node.val += prev;
        prev = node.val;
        dfs(node.left);
    }
}
class LC538_M2{
    //迭代 逆序中序遍历
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode temp = root;
        int prev = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        while(temp!=null || !stack.isEmpty()){
            //右子节点
            while(temp!=null){
                stack.push(temp);
                temp = temp.right;
            }
            //当前结点
            temp = stack.pop();
            //更新当前结点的值和前驱结点值为当前结点更新后的值
            temp.val += prev;
            prev = temp.val;
            //左子节点
            temp = temp.left;
        }
        return root;
    }
}
