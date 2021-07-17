package company.bytedance;

import Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-12:55
 */

public class LC236 {
    //笨方法 记录两个结点 从根开始的路径到一个双端队列, 只要两个队列头相等, 更新parent 并出队,
    //队列空 或者队列头不同 跳出循环, 返回之前的parent
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Deque<TreeNode> path1 = new LinkedList<>();
        Deque<TreeNode> path2 = new LinkedList<>();
        dfs(root, p.val, path1);
        dfs(root, q.val, path2);
        TreeNode parent = root;
        while(!path1.isEmpty() && !path2.isEmpty() && path1.peek() == path2.peek()){
            parent = path1.removeFirst();
            path2.removeFirst();
        }
        return parent;
    }

    private boolean dfs(TreeNode parent, int target, Deque<TreeNode> path){
        if(parent==null){
            return false;
        }
        if(parent.val==target){
            path.addFirst(parent);
            return true;
        }
        boolean left = dfs(parent.left, target, path);
        boolean right = dfs(parent.right, target, path);
        if(left || right){
            path.addFirst(parent);
            return true;
        }
        return false;

    }
}

class LC236_M2{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //不存在结果 或者 找到一个结点
        if(root==null || root==p || root==q){
            return root;
        }
        //递归遍历两颗子树
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //两个结点 p q 在root的一侧的情况
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        //在root两侧的情况 直接返回root
        return root;
    }
}
