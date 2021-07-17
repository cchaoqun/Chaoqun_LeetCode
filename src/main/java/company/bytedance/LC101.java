package company.bytedance;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/2-12:45
 */

public class LC101 {

    //递归
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        return dfs(root.left, root.right);
    }

    private  boolean dfs(TreeNode node1, TreeNode node2){
        if(node1==null){
            return node2==null;
        }
        if(node2==null){
            return node1==null;
        }
        return node1.val==node2.val && dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }
}

class LC101_M2{
    public boolean isSymmetric(TreeNode root) {
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        if(root.left==null || root.right==null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if(node1==null && node2==null){
                continue;
            }
            if((node1==null || node2==null) || node1.val!=node2.val){
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
