package Tree.tree0411;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description:1038. 把二叉搜索树转换为累加树
给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。

提醒一下，二叉搜索树满足下列约束条件：

节点的左子树仅包含键 小于 节点键的节点。
节点的右子树仅包含键 大于 节点键的节点。
左右子树也必须是二叉搜索树。
注意：该题目与 538: https://leetcode-cn.com/problems/convert-bst-to-greater-tree/  相同



示例 1：



输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
示例 2：

输入：root = [0,null,1]
输出：[1,null,1]
示例 3：

输入：root = [1,0,2]
输出：[3,3,2]
示例 4：

输入：root = [3,2,4,1]
输出：[7,9,4,10]


提示：

树中的节点数介于 1 和 100 之间。
每个节点的值介于 0 和 100 之间。
树中的所有值 互不相同 。
给定的树为二叉搜索树。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/11 19:59
 */
public class LC1038 {
    //递归 反向中序遍历
    int prev = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        //先处理右子节点
        dfs(node.right);
        //记录遍历过程前驱结点更新后的值
        //反向中序遍历的结果是递减的
        //前驱结点记录的就是大于当前结点的值的和
        node.val += prev;
        prev = node.val;
        dfs(node.left);
    }
}

class LC1038_M2{

    //迭代
    public TreeNode bstToGst(TreeNode root) {
        if(root==null){
            return root;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        int prev = 0;
        TreeNode node = root;
        while(node!=null || !stack.isEmpty()){
            //先处理右子节点
            while(node!=null){
                stack.push(node);
                node = node.right;
            }
            //处理当前结点
            node = stack.pop();
            //更新当前结点的值为 前驱结点的值+当前结点值
            node.val += prev;
            //更新prev
            prev = node.val;
            //处理左子节点
            node = node.left;
        }
        return root;
    }
}
