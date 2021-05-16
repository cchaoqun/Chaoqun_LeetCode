package Tree.tree0417;
import Tree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*
 * @Description: 面试题 04.08. 首个共同祖先
设计并实现一个算法，找出二叉树中某两个节点的第一个共同祖先。不得将其他的节点存储在另外的数据结构中。注意：这不一定是二叉搜索树。

例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4]

    3
   / \
  5   1
 / \ / \
6  2 0  8
  / \
 7   4
示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/17 13:25
 */


public class interview0408 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        //找到和其中一个结点相等的值就返回当前结点
        if(root.val==p.val || root.val==q.val){
            return root;
        }
        //向左右子树递归
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //如果其中一个为null就返回另外一个结点
        if(right==null){
            return left;
        }
        if(left==null){
            return right;
        }
        //两个都不为null说明当前结点为公共祖先 返回当前结点
        return root;
    }
}

class interview0408_M2{
    //key=结点值 value=结点对应的父节点
    Map<Integer, TreeNode> parent = new HashMap<>();
    //已经访问过的结点值
    Set<Integer> visited = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        //初始化parent map
        dfs(root);
        //向上找自己的父节点, 第一个相同的结点就是需要找的公共祖先结点
        while(p!=null){
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while(q!=null){
            if(visited.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;

    }
    //存储所有结点的值以及其父节点到parent map
    public void dfs(TreeNode root){
        if(root.left!=null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right!=null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}






























