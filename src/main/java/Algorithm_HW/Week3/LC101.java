package Algorithm_HW.Week3;

import Algorithm_HW.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/14-16:38
 */

public class LC101 {
    //DFS 比较root的两个子树, 左子树的右子树与右子树的左子树 左子树的左子树和右子树的右子树 是否都相等
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        return dfs(root.left, root.right);
    }

    public boolean dfs(TreeNode node1, TreeNode node2){
        //两个结点必须同时为null才对称
        if(node1==null && node2==null){
            return true;
        }
        //其中一个为null 或者值不等
        if(node1==null || node2==null || node1.val!=node2.val){
            return false;
        }
        //比较node1的左子树和node2的右子树
        return dfs(node1.left, node2.right) && dfs(node1.right, node2.left);
    }
}

class LC101_M2{
    //BFS 迭代 左右子树反向迭代
    public boolean isSymmetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            //一次出队两个结点
            TreeNode lnode = queue.poll();
            TreeNode rnode = queue.poll();
            //都为null继续
            if(lnode==null && rnode==null){
                continue;
            }
            //其中一个为null 结束
            if(lnode==null || rnode==null){
                return false;
            }
            //值不等 结束
            if(lnode.val!=rnode.val){
                return false;
            }
            //左子树右子节点和右子树的左子节点入队
            queue.offer(lnode.right);
            queue.offer(rnode.left);
            //左子树的左子节点和右子树的右子节点入队
            queue.offer(lnode.left);
            queue.offer(rnode.right);
        }
        return true;
    }
}