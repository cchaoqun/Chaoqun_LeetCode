package Tree.tree0417;

import Tree.TreeNode;

/*
 * @Description:814. 二叉树剪枝
给定二叉树根结点 root ，此外树的每个结点的值要么是 0，要么是 1。

返回移除了所有不包含 1 的子树的原二叉树。

( 节点 X 的子树为 X 本身，以及所有 X 的后代。)

示例1:
输入: [1,null,0,0,1]
输出: [1,null,0,null,1]

解释:
只有红色节点满足条件“所有不包含 1 的子树”。
右图为返回的答案。


示例2:
输入: [1,0,1,0,0,0,1]
输出: [1,null,1,null,1]



示例3:
输入: [1,1,0,1,1,0,1,0]
输出: [1,1,0,1,1,null,1]



说明:

给定的二叉树最多有 100 个节点。
每个节点的值只会为 0 或 1 。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/17 17:29
 */
public class LC814 {
    public TreeNode pruneTree(TreeNode root) {
        return dfs(root);
    }

    //递归后序遍历
    public TreeNode dfs(TreeNode node){
        if(node==null){
            return null;
        }
        node.left = dfs(node.left);
        node.right = dfs(node.right);
        //左右子树为空 并且当前结点为0 剪枝
        if(node.val==0 && node.left==null && node.right==null){
            return null;
        }
        return node;
    }
}
