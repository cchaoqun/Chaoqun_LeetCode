package Tree.tree0409;
/*
 * @Description:面试题 04.04. 检查平衡性
实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。


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
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/9 14:48
 */
public class interview0404 {
    //自顶向下
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        //判断当前结点
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(Math.abs(left-right)>1){
            return false;
        }
        //递归判断左右子节点
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    //返回node结点对应的高度
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        return Math.max(left, right)+1;
    }
}
class interview0404_M2{
    //自底向上
    public boolean isBalanced(TreeNode root) {
        return dfs(root)>=0;
    }
    //返回node结点对应的高度, 如果不平衡返回-1
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        //左右子树不平衡或者当前结点不平衡 则返回-1
        if(left==-1 || right==-1 || Math.abs(left-right)>1){
            return -1;
        }
        return Math.max(left, right)+1;
    }
}