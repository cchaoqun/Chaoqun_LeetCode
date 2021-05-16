package DepthFirstSearch.dfs0110;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树[1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3

但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

进阶：
你可以运用递归和迭代两种方法解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/symmetric-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/10 19:57
 */
public class LC101 {
    /*
     * @Description:
     * 如果同时满足下面的条件，两个树互为镜像：
     *  它们的两个根结点具有相同的值
     *  每个树的右子树都与另一个树的左子树镜像对称
     *
     * @return
     * @author Chaoqun
     * @creed: Talk is cheap,show me the code
     * @date 2021/1/10 20:03
     */

    //递归
//    public boolean isSymmetric(TreeNode root) {
//        return checkSymmetric(root,root);
//
//    }
//
//    public boolean checkSymmetric(TreeNode p, TreeNode q){
//        //两个结点都为空
//        if(p==null && q==null){
//            return true;
//        }
//        //有且只有一个结点为空
//        if(p==null || q==null){
//            return false;
//        }
//        //两个结点都存在,判断值是否相等
//        //并比较左右子树是否对称
//        //p.left == q.right  p.right==q.left
//        return p.val==q.val && checkSymmetric(p.left,q.right) && checkSymmetric(p.right,q.left);
//    }

    //迭代
    /*
     * @Description:
     * 初始化时我们把根节点入队两次。每次提取两个结点并比较它们的值
     * （队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），
     * 然后将两个结点的左右子结点按相反的顺序插入队列中。
     * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
     *
     * @param null
     * @return
     * @author Chaoqun
     * @creed: Talk is cheap,show me the code
     * @date 2021/1/10 20:22
     */
    public boolean isSymmetric(TreeNode root){
        return checkSymmetric(root,root);
    }

    public boolean checkSymmetric(TreeNode p, TreeNode q){
        //创建队列
        Queue<TreeNode> queue = new LinkedList<>();
        //两个子树的根结点入队
        queue.offer(p);
        queue.offer(q);
        //当队列为空或者不对称时退出循环
        while(!queue.isEmpty()){
            //出队两个元素
            p = queue.poll();
            q = queue.poll();

            //判断是否为空
            if(p==null && q==null){
                //对称,接着判断队列是否空,不空则继续
                continue;
            }

            //判断不对称的情况
            //有且只有一个为null
            if(p==null || q==null){
                return false;
            }
            //值不等
            if(p.val!=q.val){
                return false;
            }

            //左子树的左子节点和右子树的右子节点
            queue.offer(p.left);
            queue.offer(q.right);

            //左子树的右子节点和右子树的左子节点
            queue.offer(p.right);
            queue.offer(q.left);

        }
        //队列为空,未return false是对称的
        return true;
    }
}
