package JZOffer.review;

import Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/28-15:36
 */

public class jz54 {
    int res, k;
    public int kthLargest(TreeNode root, int k) {
        /**
         中序遍历倒序 右 当 左
         */
        res = 0;
        this.k = k;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode node){
        if(node==null){
            return;
        }
        dfs(node.right);
        k--;
        if(k==0){
            res = node.val;
            return;
        }
        dfs(node.left);
    }
}

class jz54_II_M2{
    public int kthLargest(TreeNode root, int k){
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root==null){
            return -1;
        }
        while(root!=null || !stack.isEmpty()){
            //右
            while(root!=null){
                stack.push(root);
                root = root.right;
            }
            //当前
            root = stack.pop();
            k--;
            if(k==0){
                return root.val;
            }
            //左
            root = root.left;
        }
        return -1;
    }
}
