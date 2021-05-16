package DepthFirstSearch.dfs0110;


import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 104. 二叉树的最大深度
 *
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明:叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度3 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/10 12:48
 */
public class LC104 {
    public static void main(String[] args) {

    }

    //Own solution
//    public static int maxDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        return dfs(root)+1;
//    }
//
//    public static int dfs(TreeNode root){
//        int leftDep = 0, rightDep = 0;
//        if(root.left!=null){
//            leftDep = dfs(root.left)+1;
//        }
//        if(root.right!=null){
//            rightDep = dfs(root.right)+1;
//        }
//        return Math.max(leftDep,rightDep);
//    }

    //递归
//    public static int maxDepth(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        int leftDep = maxDepth(root.left);
//        int rightDep = maxDepth(root.right);
//        return Math.max(leftDep,rightDep)+1;
//    }

    //BFS
    public static int maxDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        //记录最大深度
        int ans = 0;
        //队列存储结点
        Queue<TreeNode> queue = new LinkedList<>();
        //根结点入队
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                //节点依次出队
                TreeNode temp =  queue.poll();
                //分别判断左右结点是否存在,存在则入队
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                size--;
            }
            //结束本层后 层数+1
            ans++;
        }

        return ans;

    }

}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

