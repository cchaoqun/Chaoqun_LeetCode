package DepthFirstSearch.dfs0110;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 112. 路径总和
给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

说明:叶子节点是指没有子节点的节点。
*
示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/10 20:37
 */
public class LC112 {

    //递归
//    public boolean hasPathSum(TreeNode root, int sum) {
//        return pathSum(root,sum,0);
//    }
//
//    public boolean pathSum(TreeNode root, int target, int sum){
//        if(root!=null){
//            //判断路径和==target 并且当前结点为叶子结点
//            if(sum+root.val == target && root.left==null && root.right==null){
//                return true;
//            }else{
//                //sum加上当前结点的值
//                sum += root.val;
//                //在左子节点递归
//                //在右子节点递归
//                return pathSum(root.left,target,sum) || pathSum(root.right,target,sum);
//            }
//        }
//        return false;
//    }

    //递归简洁
//    public boolean hasPathSum(TreeNode root, int sum){
//        if(root==null){
//            return false;
//        }
//        if(root.left==null && root.right==null){
//            return root.val == sum;
//        }
//        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
//
//    }

    //BFS
    public boolean hasPathSum(TreeNode root, int sum){
        if(root==null){
            return false;
        }
        //创建两个队列
        //结点队列
        Queue<TreeNode> node = new LinkedList<>();
        //根结点到当前结点路径和的队列
        Queue<Integer> pathSum = new LinkedList<>();
        //入队
        node.offer(root);
        pathSum.offer(root.val);
        while(!node.isEmpty()){
            //出队
            TreeNode tempNode = node.poll();
            int tempSum = pathSum.poll();
            //当前为叶子结点
            if(tempNode.left==null && tempNode.right==null){
                //根结点到当前叶子结点的路径和==目标值
                if(tempSum == sum){
                    return true;
                }
                continue;
            }
            //当前不是叶子结点
            if(tempNode.left!=null){
                node.offer(tempNode.left);
                pathSum.offer(tempSum+tempNode.left.val);
            }
            if(tempNode.right!=null){
                node.offer(tempNode.right);
                pathSum.offer(tempSum+tempNode.right.val);
            }
        }
        return false;
    }

}
