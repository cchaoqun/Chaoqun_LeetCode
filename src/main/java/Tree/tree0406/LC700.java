package Tree.tree0406;

import java.util.LinkedList;
import java.util.Queue;


public class LC700 {
    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        //当前结点==val, 或者已经为null,返回当前结点即可
        if(root==null || root.val==val){
            return root;
        }
        //目标值<当前结点值, 目标值结点可能在左子树
        if(val<root.val){
            return searchBST(root.left, val);
        }else{
            //否则可能在右子树
            return searchBST(root.right, val);
        }
    }
}

class LC700_M2{
    //迭代
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //出队一个结点
            TreeNode node = queue.poll();
            //如果当前结点值=目标值 返回结点
            if(node.val==val){
                return node;
            }else if(val<node.val){
                //目标值小于当前结点值,可能在左子树(需要检查左子节点是否存在)
                if(node.left!=null){
                    queue.offer(root.left);
                }
            }else{
                //可能在右子树
                if(node.right!=null){
                    queue.offer(root.right);
                }
            }
        }
        return null;
    }
}

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
