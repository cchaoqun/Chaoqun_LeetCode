package Tree.tree0409;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @Description: 653. 两数之和 IV - 输入 BST
给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

案例 1:

输入:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

输出: True


案例 2:

输入:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

输出: False
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/9 14:25
 */
public class LC653 {
    //递归
    private Set<Integer> set = new HashSet<>();
    public boolean findTarget(TreeNode root, int k) {
        //递归终止条件
        if(root==null){
            return false;
        }
        //处理当前结点
        int target = k-root.val;
        if(set.contains(target)){
            return true;
        }
        set.add(root.val);
        //左右子树的情况
        return findTarget(root.left, k) || findTarget(root.right,k);
    }
}

class LC653_M2{
    //迭代
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        if(root==null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int target = k-node.val;
            if(set.contains(target)){
                return true;
            }
            set.add(node.val);
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return false;
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