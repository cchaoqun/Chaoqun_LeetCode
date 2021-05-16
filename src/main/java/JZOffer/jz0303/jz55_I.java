package JZOffer.jz0303;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 剑指 Offer 55 - I. 二叉树的深度
输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7
返回它的最大深度 3 。



提示：

节点总数 <= 10000
注意：本题与主站 104 题相同：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 19:51
 */
public class jz55_I {

    //递归
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        //以当前结点为根结点的数的最大深度= 左子树和右子树的最大深度+1
        return Math.max(dfs(node.left), dfs(node.right))+1;
    }

    //迭代
//    public int maxDepth(TreeNode root){
//        if(root==null){
//            return 0;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        int res = 0;
//        while(!queue.isEmpty()){
//            res += 1;
//            for(int i=queue.size(); i>0; --i){
//                TreeNode cur = queue.poll();
//                if(cur.left!=null){
//                    queue.offer(cur.left);
//                }
//                if(cur.right!=null){
//                    queue.offer(cur.right);
//                }
//            }
//        }
//        return res;
//    }
}
