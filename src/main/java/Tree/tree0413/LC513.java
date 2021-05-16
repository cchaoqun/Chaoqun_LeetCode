package Tree.tree0413;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description:513. 找树左下角的值
给定一个二叉树，在树的最后一行找到最左边的值。

示例 1:

输入:

    2
   / \
  1   3

输出:
1


示例 2:

输入:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

输出:
7


注意: 您可以假设树（即给定的根节点）不为 NULL。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/14 20:50
 */
public class LC513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int left = 0;
        while(!queue.isEmpty()){
            //每一层只取最左边的结点的值
            left = queue.peek().val;
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        return left;
    }
}

class LC513_M2{
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node = null;
        while(!queue.isEmpty()){
            //从右往左,最后一个结点就是最后一层最左边的结点
            node = queue.poll();
            if(node.right!=null){
                queue.offer(node.right);
            }
            if(node.left!=null){
                queue.offer(node.left);
            }
        }
        return node.val;
    }
}

class LC513_M3{
    private int maxDep = -1;
    private int left = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root,0);
        return left;
    }

    public void dfs(TreeNode node, int dep){
        if(node==null){
            return;
        }
        //叶子结点且层数大于最大层数才更新
        if(node.left==null && node.right==null){
            if(maxDep<dep){
                maxDep =dep;
                left = node.val;
            }
        }
        dfs(node.left, dep+1);
        dfs(node.right, dep+1);
    }
}