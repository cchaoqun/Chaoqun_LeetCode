package JZOffer.jz0303;
/*
 * @Description: 剑指 Offer 55 - II. 平衡二叉树
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
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 20:07
 */
public class jz55_II {

//    //自上而下
//    public boolean isBalanced(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        //左右子树是否平衡
//        boolean left = isBalanced(root.left);
//        boolean right = isBalanced(root.right);
//        //计算以当前结点为根结点树的左右子树的深度差
//        int diff = dfs(root.left)-dfs(root.right);
//        //左子树,右子树,并且当前数都平衡才是平衡二叉树
//        return left && right && Math.abs(diff)<=1;
//    }
//
//    int dfs(TreeNode node){
//        if(node==null){
//            return 0;
//        }
//        return Math.max(dfs(node.left), dfs(node.right))+1;
//    }

    //自底向上后续遍历,遇到不符则剪枝
    public boolean isBalanced(TreeNode root){
        return bottomTop(root)!=-1;
    }

    int bottomTop(TreeNode node){
        if(node==null){
            return 0;
        }
        //左子树深度
        int left = bottomTop(node.left);
        if(left==-1){
            //提前剪枝
            return -1;
        }
        //右子树深度
        int right = bottomTop(node.right);
        if(right==-1){
            //提前剪枝
            return -1;
        }
        //左右子树深度差<2,返回其中的最大值+1,否则不是平衡二叉树,返回-1代表不是平衡二叉树
        return Math.abs(left-right)<2 ? Math.max(left,right)+1 : -1;
    }
}
