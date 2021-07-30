package JZOffer.review;

import Tree.TreeNode;

/**剑指 Offer 55 - II. 平衡二叉树
 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。



 示例 1:

 给定二叉树 [3,9,20,null,null,15,7]

 3
 / \
 9  20
 /  \
 15   7
 返回 true 。

 示例 2:

 给定二叉树 [1,2,2,3,3,null,null,4,4]

 1
 / \
 2   2
 / \
 3   3
 / \
 4   4
 返回 false 。



 限制：

 0 <= 树的结点个数 <= 10000
 注意：本题与主站 110 题相同：https://leetcode-cn.com/problems/balanced-binary-tree/
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/28-15:51
 */

public class jz55_II {
    //Top down
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        //左右子树深度之差<=1 并且左右子树也是平衡的
        return Math.abs(dfs(root.left)-dfs(root.right))<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    //求root为根的数的最大深度
    private int dfs(TreeNode root){
        if(root==null){
            return 0;
        }
        return Math.max(dfs(root.left), dfs(root.right))+1;
    }
}
class jz55_II_M2{
    // bottom up
    public boolean isBalanced(TreeNode root){
        return bottomUp(root)!=-1;
    }

    //return -1当自身不平衡的时候
    //return root为根的最大深度
    private int bottomUp(TreeNode node){
        if(node==null){
            return 0;
        }
        //求左右子树的最大深度, 如果不平衡直接返回-1
        int left = bottomUp(node.left);
        if(left==-1){
            return -1;
        }
        int right = bottomUp(node.right);
        if(right==-1){
            return -1;
        }
        //左右子树平衡, 检查当前树是否平衡
        return Math.abs(left-right)<=1? Math.max(left, right)+1:-1;
    }
}























