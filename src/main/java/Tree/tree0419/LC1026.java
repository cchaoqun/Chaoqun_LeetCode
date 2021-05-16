package Tree.tree0419;

import Tree.TreeNode;

/**
 * 1026. 节点与其祖先之间的最大差值
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 *
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * 示例 2：
 *
 *
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 *
 *
 * 提示：
 *
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 105
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/19-16:53
 */

public class LC1026 {
    //最大差值
    int diff = 0;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root, root.val, root.val);
        return diff;
    }

    //max当前结点祖先节点中的最大值和最小值
    public void dfs(TreeNode node, int max, int min){
        if(node==null){
            return;
        }
        //最大差值只存在于当前结点值与最大最小值的差的绝对值
        diff = Math.max(diff, Math.abs(node.val-max));
        diff = Math.max(diff, Math.abs(node.val-min));
        //更新最大最小值
        max = Math.max(max, node.val);
        min = Math.min(min, node.val);
        //向左右子树递归
        dfs(node.left, max, min);
        dfs(node.right, max, min);
    }
}
