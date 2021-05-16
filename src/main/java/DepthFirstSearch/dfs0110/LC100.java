package DepthFirstSearch.dfs0110;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 100. 相同的树
给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例1:
输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
*
示例 2:
输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false
*
示例3:
输入:       1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/same-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/10 16:45
 */
public class LC100 {
    public static void main(String[] args) {

    }

    //DFS
//    public static boolean isSameTree(TreeNode p, TreeNode q) {
//        if(p==null && q==null){
//            return true;
//        }else if(p==null || q==null){
//            return false;
//        }else if(p.val!=q.val){
//            return false;
//        }else{
//            boolean leftAns = false, rightAns = false;
//            //左子节点递归
//            leftAns = isSameTree(p.left,q.left);
//            //右子节点递归
//            rightAns = isSameTree(p.right,q.right);
//            return (leftAns==true && rightAns==true)? true:false;
//        }
//    }

    //BFS
    public static boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }else if(p==null || q==null){
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        //两个结点同时入队
        queue1.offer(p);
        queue2.offer(q);
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            //两个队列同时出列一个结点
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            //结点值不相等
            if(node1.val!=node2.val){
                return false;
            }
            //结点值相等
            TreeNode left1=node1.left, right1=node1.right, left2=node2.left, right2=node2.right;
            //判断子节点情况
            //不同时为真或为假
            if(left1==null ^ left2==null){
                return false;
            }
            if(right1==null ^ right2==null){
                return false;
            }
            //这里left1 left2 要么同时为空或者不为空
            if(left1!=null){
                queue1.offer(left1);
                queue2.offer(left2);
            }
            if(right1!=null){
                queue1.offer(right1);
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
