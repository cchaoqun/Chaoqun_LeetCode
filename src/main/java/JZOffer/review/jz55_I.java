package JZOffer.review;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/28-15:48
 */

public class jz55_I {
    //DFS
    int res = 0;
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode root, int level) {
        if (root == null) {
            res = Math.max(res, level);
            return;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }
}

class jz55_I_M2{
    //BFS
    public int maxDepth(TreeNode root){
        Deque<TreeNode> queue = new ArrayDeque<>();
        int res = 0;
        if(root==null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            res++;
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
