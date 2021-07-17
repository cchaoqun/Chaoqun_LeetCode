package Algorithm_HW.Week3;

import Algorithm_HW.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**100. 相同的树
 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。



 示例 1：


 输入：p = [1,2,3], q = [1,2,3]
 输出：true
 示例 2：


 输入：p = [1,2], q = [1,null,2]
 输出：false
 示例 3：


 输入：p = [1,2,1], q = [1,1,2]
 输出：false


 提示：

 两棵树上的节点数目都在范围 [0, 100] 内
 -104 <= Node.val <= 104
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/14-17:04
 */

public class LC100 {
    //DFS
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null || p.val!=q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

class LC100_M2{
    //BFS 2个队列
    public boolean isSameTree(TreeNode p, TreeNode q){
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            TreeNode n1 = queue1.poll();
            TreeNode n2 = queue2.poll();
            //都为null
            if(n1==null && n2==null){
                continue;
            }
            //其中一个为null  或者结点值不等
            if(n1==null || n2==null || n1.val!=n2.val){
                return false;
            }
            //两个结点都为叶子结点 continue
            if(n1.left==null && n1.right==null && n2.left==null && n2.right==null){
                continue;
            }
            //两个结点的子节点都从左到右依次入队
            queue1.offer(n1.left);
            queue1.offer(n1.right);
            queue2.offer(n2.left);
            queue2.offer(n2.right);
        }
        return true;
    }
}

class LC100_M3{
    //BFS 一个队列
    public boolean isSameTree(TreeNode p, TreeNode q){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while(!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            if(n1==null && n2==null){
                continue;
            }
            if(n1==null || n2==null || n1.val!=n2.val){
                return false;
            }
            if(n1.left==null && n1.right==null && n2.left==null && n2.right==null){
                continue;
            }
            //两个结点的左子节点同时入队
            queue.offer(n1.left);
            queue.offer(n2.left);
            //两个结点的右子节点同时入队
            queue.offer(n1.right);
            queue.offer(n2.right);
        }
        return true;

    }
}
