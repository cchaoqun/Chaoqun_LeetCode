package Tree.tree0409;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description:783. 二叉搜索树节点最小距离
给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。



示例：

输入: root = [4,2,6,1,3,null,null]
输出: 1
解释:
注意，root是树节点对象(TreeNode object)，而不是数组。

给定的树 [4,2,6,1,3,null,null] 可表示为下图:

          4
        /   \
      2      6
     / \
    1   3

最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。


注意：

二叉树的大小范围在 2 到 100。
二叉树总是有效的，每个节点的值都是整数，且不重复。
本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/9 14:52
 */
public class LC783 {
    //递归
    private int minDiff = Integer.MAX_VALUE;
    private int val = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root);
        return minDiff;
    }
    //中序遍历 比较当前结点与前驱结点的差值并更新最小差值
    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        dfs(node.left);
        if(val!=Integer.MAX_VALUE){
            minDiff = Math.min(node.val-val, minDiff);
        }
        val = node.val;
        dfs(node.right);
    }
}
class LC783_M2{
    //迭代
    public int minDiffInBST(TreeNode root) {
        //最小差值
        int minDiff = Integer.MAX_VALUE;
        //前驱结点的值
        int val = Integer.MAX_VALUE;
        if(root==null){
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            //遍历左子节点
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            //当前结点
            root = stack.pop();
            //判断是否有前驱结点
            if(val!=Integer.MAX_VALUE){
                //更新最小差值
                minDiff = Math.min(minDiff, root.val-val);
            }
            //更新前驱结点的值为当前结点的值
            val = root.val;
            //遍历右子节点
            root = root.right;
        }
        return minDiff;
    }
}
