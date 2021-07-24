package JZOffer.review;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**剑指 Offer 27. 二叉树的镜像
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
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-12:45
 */

public class jz27 {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return root;
        }
        //交换当前结点的左右子树
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //更新左右子树
        mirrorTree(root.left);
        mirrorTree(root.right);
        return root;
    }
}
class jz27_M2{
    //迭代
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return root;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        //栈遍历结点
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //交换左右子树
            swap(node);
            //左右子节点入栈
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }

        }
        return root;
    }

    private void swap(TreeNode node){
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}