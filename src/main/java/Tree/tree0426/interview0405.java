package Tree.tree0426;

import Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 面试题 04.05. 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/26-15:05
 */

public class interview0405 {
    //DFS
    public boolean isValidBST(TreeNode root) {
        //初始左右设置成null
        //这样子树中的结点如果处在最左端或者最右端, 只需要办证结点值大于或者小于父节点即可
        return dfs(root, null, null);
    }

    public boolean dfs(TreeNode node, Integer left, Integer right){
        if(node==null){
            return true;
        }
        if(left!=null && node.val<=left){
            return false;
        }
        if(right!=null && node.val>=right){
            return false;
        }
        if(!dfs(node.left, left, node.val)){
            return false;
        }
        if(!dfs(node.right, node.val, right)){
            return false;
        }
        return true;
    }
}

class interview0405_M2{
    //BFS
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        double prev = -Double.MAX_VALUE;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val<=prev){
                return false;
            }
            prev = root.val;
            root = root.right;
        }
        return true;
    }
}
