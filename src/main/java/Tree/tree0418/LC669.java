package Tree.tree0418;

import Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 669. 修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构（即，如果没有被移除，原有的父代子代关系都应当保留）。 可以证明，存在唯一的答案。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,0,2], low = 1, high = 2
 * 输出：[1,null,2]
 * 示例 2：
 *
 *
 * 输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
 * 输出：[3,2,null,1]
 * 示例 3：
 *
 * 输入：root = [1], low = 1, high = 2
 * 输出：[1]
 * 示例 4：
 *
 * 输入：root = [1,null,2], low = 1, high = 3
 * 输出：[1,null,2]
 * 示例 5：
 *
 * 输入：root = [1,null,2], low = 2, high = 4
 * 输出：[2]
 *
 *
 * 提示：
 *
 * 树中节点数在范围 [1, 104] 内
 * 0 <= Node.val <= 104
 * 树中每个节点的值都是唯一的
 * 题目数据保证输入是一棵有效的二叉搜索树
 * 0 <= low <= high <= 104
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/18-21:57
 */

public class LC669 {
    int low;
    int high;
    public TreeNode trimBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        return dfs(root);
    }

    //后序遍历
    public TreeNode dfs(TreeNode node){
        if(node==null){
            return null;
        }
        //先处理左右子节点
        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);
        //如果当前结点不在范围内需要改变
        if(node.val<low || node.val>high){
            //左右子节点都为空 返回null
            if(left==null && right==null){
                return null;
            }else if(left==null){
                //左子节点为空 返回右节点
                return right;
            }else if(right==null){
                //右子节点为空 返回左子节点
                return left;
            }else{
                //左右子节点都不为空 将右子树添加到左子树的最左子节点的右子节点上
                TreeNode temp = left;
                //找到左子树的最左子节点
                while(temp.left!=null){
                    temp = temp.left;
                }
                //右子树接到左子树最左子节点的右子节点上
                temp.right = right;
                return left;
            }
        }
        //没有变化直接返回当前结点
        return node;
    }
}

class LC69_M2{
    //迭代
    public TreeNode trimBST(TreeNode root, int low, int high){
        if(root==null){
            return null;
        }
        //找到修剪后二叉搜索树的根结点
        //root.val<low, 左子树的值全部小于low, 舍弃整个左子树, 根结点在右子树种
        //root.val>high, 右子树的值全部大于high, 舍弃整个右子树, 根结点在左子树
        while(root!=null && (root.val>high || root.val<low)){
            root = root.val>high? root.left : root.right;
        }

        //迭代处理左子树
        TreeNode curr = root;
        while(curr!=null){
            while(curr.left!=null && curr.left.val<low){
                //左子节点的值<low 舍弃左子节点和左子节点的左子树,左子节点变成左子节点的右子节点
                //直到找到>=low的节点
                curr.left = curr.left.right;
            }
            //继续递归的去舍弃不符合条件的结点
            curr = curr.left;
        }
        //迭代处理右子树
        curr = root;
        while(curr!=null){
            while(curr.right!=null && curr.right.val>high){
                curr.right = curr.right.left;
            }
            curr = curr.right;
        }
        return root;
    }
}
class LC69_M3{
    public TreeNode trimBST(TreeNode root, int low, int high){
        if(root==null){
            return null;
        }
        if(root.val>high){
            return trimBST(root.left, low, high);
        }
        if(root.val<low){
            return trimBST(root.right, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}