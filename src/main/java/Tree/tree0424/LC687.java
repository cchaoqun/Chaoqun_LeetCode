package Tree.tree0424;

import Tree.TreeNode;

/**
 * 687. 最长同值路径
 * 给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
 *
 * 注意：两个节点之间的路径长度由它们之间的边数表示。
 *
 * 示例 1:
 *
 * 输入:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * 输出:
 *
 * 2
 * 示例 2:
 *
 * 输入:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * 输出:
 *
 * 2
 * 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/24-22:34
 */

public class LC687 {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        //左右子树的最长连续相同结点路径长度
        int left = dfs(node.left);
        int right = dfs(node.right);
        int leftDis = 0;
        int rightDis = 0;
        //当前结点如果和左右子节点相同, 对应方向长度+1
        if(node.left!=null && node.left.val==node.val){
            leftDis = left + 1;
        }
        if(node.right!=null && node.right.val==node.val){
            rightDis = right + 1;
        }
        //更新最长相同结点值的路径长度
        res = Math.max(res, leftDis+rightDis);
        //向上返回只能返回当前左右子树中最长的一个
        return Math.max(leftDis, rightDis);

    }
}
