package Tree.tree0331;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description:938. 二叉搜索树的范围和
给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。



示例 1：


输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
输出：32
示例 2：


输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
输出：23


提示：

树中节点数目在范围 [1, 2 * 104] 内
1 <= Node.val <= 105
1 <= low <= high <= 105
所有 Node.val 互不相同
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/31 15:30
 */
public class LC938 {
    private int sum;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        dfs(root, low, high);
        return sum;

    }

    void dfs(TreeNode node, int low, int high){
        if(node==null ){
            return;
        }
        //当前结点的值<low, 当前结点的左子树全部小于low, 只有可能右子树中的结点在范围内,只对右子树递归
        if(node.val<low){
            dfs(node.right, low, high);
        }else if(node.val<=high){
            //当前结点值在[low, high]内, 左右子树中结点都可能在返回内,并且当前结点值纳入总和
            dfs(node.left, low, high);
            sum += node.val;
            dfs(node.right, low, high);
        }else{
            //当前结点值>high, 只有可能左子树在返回内,只对左子树递归
            dfs(node.left,low,high);
        }

    }
}

class LC938_M2{
    //BFS
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        if(root==null){
            return sum;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            /**
             cur.val<low 当前结点右子节点不为空入队
             low<=cur.val<=high 当前左右子节点不为空都入队,并且当前结点值加入sum
             right<val 当前节点左子几点不为空入队
             */
            if(cur.val<low){
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }else if(cur.val<=high){
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
                sum += cur.val;
            }else{
                if(cur.left!=null){
                    q.offer(cur.left);
                }
            }
        }
        return sum;
    }
}
