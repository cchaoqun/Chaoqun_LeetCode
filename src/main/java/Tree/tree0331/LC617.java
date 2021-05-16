package Tree.tree0331;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 617. 合并二叉树
给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

示例 1:

输入:
	Tree 1                     Tree 2
          1                         2
         / \                       / \
        3   2                     1   3
       /                           \   \
      5                             4   7
输出:
合并后的树:
	     3
	    / \
	   4   5
	  / \   \
	 5   4   7
注意: 合并必须从两个树的根节点开始。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/31 14:11
 */
public class LC617 {

    //DFS
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1, root2);
    }

    //同步dfs两颗二叉搜索树
    TreeNode dfs(TreeNode node1, TreeNode node2){
        //如果两个结点都为空, 返回null
        if(node1==null && node2==null){
            return null;
        }
        //新建当前结点,初始值为0
        int curVal = 0;
        TreeNode cur = new TreeNode(0);
        //情况1 两个结点都不为空,当前结点值更新为两个结点的值的和
        //继续同时向当前两个结点左右子结点遍历
        if(node1!=null && node2!=null){
            cur.left = dfs(node1.left, node2.left);
            cur.right = dfs(node1.right, node2.right);
            curVal = node1.val+node2.val;
        }else if(node1!=null){
            //node2为空,保持空节点到下一层的遍历
            //当前值更新为node1的值,
            //保持空节点不会对后续的遍历产生影响,当两个结点为null就会返回空节点
            cur.left = dfs(node1.left, node2);
            cur.right = dfs(node1.right, node2);
            curVal = node1.val;
        }else{
            //node1为空,类似
            cur.left = dfs(node1, node2.left);
            cur.right = dfs(node1, node2.right);
            curVal = node2.val;
        }
        //更新当前结点的值
        cur.val = curVal;
        return cur;
    }
}
class LC617_M2{
    //简洁DFS
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            //返回的是root2为根结点的子树
            return root2;
        }
        if(root2==null){
            //返回的是root1为根结点的子树
            return root1;
        }
        TreeNode cur = new TreeNode(root1.val+root2.val);
        cur.left = mergeTrees(root1.left, root2.left);
        cur.right = mergeTrees(root1.right, root2.right);
        return cur;
    }
}

class LC617_M3{
    //BFS 维护3个队列
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return null;
        }else if (root1==null){
            return root2;
        }else if( root2==null){
            return root1;
        }
        //确保了两个树都不为空
        //新树的头结点
        TreeNode merged = new TreeNode(root1.val+root2.val);
        //root1
        Queue<TreeNode> q1 = new LinkedList<>();
        //root2
        Queue<TreeNode> q2 = new LinkedList<>();
        //新树
        Queue<TreeNode> q3 = new LinkedList<>();
        q1.offer(root1);
        q2.offer(root2);
        q3.offer(merged);

        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode cur = q3.poll(), node1 = q1.poll(), node2 = q2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            //创建左子树
            if(left1!=null || left2!=null){
                //两个结点都不为空
                if(left1!=null && left2!=null){
                    //创建新的左子树
                    TreeNode left = new TreeNode(left1.val+left2.val);
                    //链接
                    cur.left = left;
                    //对应的左子节点都入队
                    q3.offer(left);
                    q1.offer(left1);
                    q2.offer(left2);
                }else if(left1!=null){
                    cur.left = left1;
                }else{
                    cur.left = left2;
                }
            }
            if(right1!=null || right2!=null){
                if(right1!=null && right2!=null){
                    TreeNode right = new TreeNode(right1.val+right2.val);
                    cur.right = right;
                    q3.offer(right);
                    q1.offer(right1);
                    q2.offer(right2);
                }else if(right1!=null){
                    cur.right = right1;
                }else{
                    cur.right = right2;
                }
            }
        }
        return merged;
    }
}