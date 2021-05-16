package JZOffer.jz0301;


import java.util.ArrayDeque;

/*
 * @Description: 剑指 Offer 27. 二叉树的镜像
请完成一个函数，输入一个二叉树，该函数输出它的镜像。

例如输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
镜像输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1



示例 1：

输入：root = [4,2,7,1,3,6,9]
输出：[4,7,2,9,6,3,1]


限制：

0 <= 节点个数 <= 1000

注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/1 14:05
 */
public class JZ27 {

    //递归 自下而上的进行左右子节点的交换
//    public TreeNode mirrorTree(TreeNode root) {
//        //返回条件,遇到空节点即返回null
//        if(root==null){
//            return null;
//        }
//        //先保留当前结点的右子树
//        TreeNode tempright = root.right;
//        //当前结点的右子树为左子节点为头结点的子树的镜像
//        root.right = mirrorTree(root.left);
//        //当前结点左子树为右子节点为头结点的子树的镜像
//        root.left = mirrorTree(tempright);
//        //返回当前结点
//        return root;
//    }

    //迭代 自上而下进行当前结点的左右子节点的交换
    public TreeNode mirrorTree(TreeNode root){
        if(root==null){
            return null;
        }
        //维护栈
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        //头结点入栈
        stack.push(root);
        //栈不为空
        while(!stack.isEmpty()){
            //出栈一个结点
            TreeNode node = stack.pop();
            //如果左右子节点不为空则入栈
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            //交换当前结点的左右子节点
            TreeNode tempLeft = node.left;
            node.left = node.right;
            node.right = tempLeft;
        }
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
