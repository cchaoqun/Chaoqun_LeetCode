package JZOffer.jz0301;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description: 剑指 Offer 28. 对称的二叉树
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

注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/1 14:24
 */
public class JZ28 {

    //递归
//    public boolean isSymmetric(TreeNode root) {
//        if(root==null){
//            return true;
//        }
//        //查看根结点左右子树是否对称
//        return recur(root.left, root.right);
//
//    }
//
//    //查看以left 和 right为根结点的数是否对称
//    public boolean recur(TreeNode left, TreeNode right){
//        //两个结点同时越过叶子结点,从上到下全部匹配
//        if(left==null && right==null){
//            return true;
//        }
//        //其中一个越过叶子结点,不对称
//        if(left==null || right==null){
//            return false;
//        }
//        //当前两结点的值不相等,不对称
//        if(left.val!=right.val){
//            return false;
//        }
//        //查看左数左子节点与右树右子节点 左树右子节点和右树左子节点
//        return recur(left.left, right.right) && recur(left.right, right.left);
//    }

    //迭代
    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }
        //维护双头队列
        Deque<TreeNode> stack = new LinkedList<>();
        //左右结点入队
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            //出队两个结点
            TreeNode rightNode = stack.pop();
            TreeNode leftNode = stack.pop();
            //如果两个结点都为null跳过本轮
            if(rightNode==null && leftNode==null){
                continue;
            }
            //如果其中一个为null或者两个结点的值不等,不对称
            if(rightNode==null || leftNode==null || rightNode.val!=leftNode.val){
                return false;
            }
            //将需要比较值是否相等的两个结点连续入队
            stack.push(leftNode.left);
            stack.push(rightNode.right);
            stack.push(leftNode.right);
            stack.push(rightNode.left);

        }
        return true;
    }
}
