package Tree.tree0403;


import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 404. 左叶子之和
计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/3 21:54
 */
public class LC404 {
    //递归
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        //从左叶子结点的父节点判断
        if(node.left!=null && node.left.left==null && node.right==null){
            sum += node.left.val;
        }
        dfs(node.left);
        dfs(node.right);
    }
}
class LC404_M2{
    //迭代
    public int sumOfLeftLeaves(TreeNode root){
        if(root==null){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            //左子节点不空
            if(node.left!=null){
                //左子节点是叶子结点
                if(isLeafNode(node.left)){
                    sum += node.left.val;
                }else{
                    //不是叶子结点就入队
                    queue.offer(node.left);
                }
            }
            //右子节点不空
            if(node.right!=null){
                //右子节点不为叶子结点
                if(!isLeafNode(node.right)){
                    //入队
                    queue.offer(node.right);

                }
            }
        }
        return sum;
    }
    //判断是否是叶子结点
    public boolean isLeafNode(TreeNode node){
        return node.left==null && node.right==null;
    }

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

