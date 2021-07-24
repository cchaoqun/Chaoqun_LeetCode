package JZOffer.review;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**剑指 Offer 28. 对称的二叉树
 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

 1
 / \
 2   2
 / \ / \
 3  4 4  3
 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

 1
 / \
 2   2
 \   \
 3    3



 示例 1：

 输入：root = [1,2,2,3,4,4,3]
 输出：true
 示例 2：

 输入：root = [1,2,2,null,3,null,3]
 输出：false


 限制：

 0 <= 节点个数 <= 1000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-12:55
 */

public class jz28 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        //左右子树对称
        return check(root.left, root.right);
    }

    private boolean check(TreeNode l, TreeNode r){
        //都为null 可以
        if(l==null && r==null){
            return true;
        }
        //其中一个为null 或者节点值不等 不可以
        if(l==null || r==null || l.val!=r.val){
            return false;
        }
        //对称
        return check(l.left, r.right) && check(l.right, r.left);
    }
}

class jz28_M2{
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        //左右子节点都不存可以
        if(root.left==null && root.right==null){
            return true;
        }
        //其中一个为null 不可以
        if(root.left==null || root.right==null){
            return false;
        }
        //左右子节点入队
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while(!queue.isEmpty()){
            //一次出对的两个必须值相等 或者都是null
            TreeNode l = queue.poll();
            TreeNode r = queue.poll();
            if(l==null && r==null){
                continue;
            }
            if(l==null || r==null || l.val!=r.val){
                return false;
            }
            //对称相等的节点放入队列
            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }
        return true;
    }
}
