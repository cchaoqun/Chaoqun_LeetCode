package Tree.tree0408;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description:965. 单值二叉树
如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

只有给定的树是单值二叉树时，才返回 true；否则返回 false。



示例 1：



输入：[1,1,1,1,1,null,1]
输出：true
示例 2：



输入：[2,2,2,5,2]
输出：false


提示：

给定树的节点数范围是 [1, 100]。
每个节点的值都是整数，范围为 [0, 99] 。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/8 14:38
 */
public class LC965 {
    public boolean isUnivalTree(TreeNode root) {
        //根结点的值作为参考值
        return dfs(root, root.val);
    }
    public boolean dfs(TreeNode node, int val){
        //越过叶子结点不影响结果,返回true
        if(node==null){
            return true;
        }
        //只要发现不相等的直接返回false
        if(node.val!=val){
            return false;
        }
        //向左右子树递归,必须所有结点都相同才返回true
        return dfs(node.left, val) && dfs(node.right, val);
    }
}

class LC965_M2{
    //迭代
    public boolean isUnivalTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int val = root.val;
        while(!queue.isEmpty()){
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(node.val!=val){
                    return false;
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }
}
