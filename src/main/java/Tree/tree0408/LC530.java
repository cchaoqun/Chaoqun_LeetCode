package Tree.tree0408;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description: 530. 二叉搜索树的最小绝对差
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。



示例：

输入：

   1
    \
     3
    /
   2

输出：
1

解释：
最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。


提示：

树中至少有 2 个节点。
本题与 783 https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/ 相同
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/8 15:58
 */
public class LC530 {
    //递归
    public int getMinimumDifference(TreeNode root) {
        //val[0] = 中序遍历中前一个结点的值
        //val[1] = 当前的最小差值
        int[] val = {-1, Integer.MAX_VALUE};
        dfs(root, val);
        return val[1];
    }

    //中序遍历 dfs
    public void dfs(TreeNode node, int[] val){
        if(node==null){
            return;
        }
        //遍历左子节点
        dfs(node.left, val);
        //val[0]>=0 已经被更新过,有前驱结点
        if(val[0]>=0){
            //最小的差值一定出现在中序遍历连续的两个值之间
            //更新最小差值
            val[1] = Math.min(node.val-val[0], val[1]);
        }
        //更新前驱结点的值为当前结点值
        val[0] = node.val;
        //遍历右子节点
        dfs(node.right, val);
    }
}
class LC530_M2{
    //递归
    public int getMinimumDifference(TreeNode root) {
        //前驱结点的值
        int prev = -1;
        //最小差值
        int minDiff = Integer.MAX_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            //遍历左子节点
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            //当前结点
            root = stack.pop();
            //更新最小差值
            if(prev>=0){
                //当前结点不是中序遍历的第一个结点
                minDiff = Math.min(root.val-prev, minDiff);
            }
            prev = root.val;
            //遍历右子节点
            root = root.right;
        }
        return minDiff;
    }
}