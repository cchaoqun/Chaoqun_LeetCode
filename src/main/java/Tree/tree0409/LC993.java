package Tree.tree0409;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description:993. 二叉树的堂兄弟节点
在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。

我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。

只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。



示例 1：


输入：root = [1,2,3,4], x = 4, y = 3
输出：false
示例 2：


输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
输出：true
示例 3：



输入：root = [1,2,3,null,4], x = 2, y = 3
输出：false


提示：

二叉树的节点数介于 2 到 100 之间。
每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/9 16:47
 */
public class LC993 {
    //前序遍历
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] xVal = dfs(root, x, 0);
        int[] yVal = dfs(root, y, 0);
        //两个结点的父节点都找到了, 两个结点的层数相同  父节点不同
        if(xVal[1]*yVal[1]!=0 && xVal[0]==yVal[0] && xVal[1]!=yVal[1]){
            return true;
        }else{
            return false;
        }

    }

    //前序遍历 返回 int[0] 结点的层数, int[1] 父节点的值
    public int[] dfs(TreeNode node, int target, int level){
        if(node==null){
            return new int[]{0,0};
        }
        //当前结点是对应结点的父节点, 返回对应结点的层数 和 父节点的值
        if(node.left!=null && node.left.val==target){
            return new int[]{level+1, node.val};
        }
        if(node.right!=null && node.right.val==target){
            return new int[]{level+1, node.val};
        }
        //左右子树的情况
        int[] left = dfs(node.left, target, level+1);
        int[] right = dfs(node.right, target, level+1);
        //如果左子树没有就返回右子树
        if(left[1]==0){
            return right;
        }else{
            //否则返回左子树
            return left;
        }
    }
}

class LC993_M2{
    //前序遍历 迭代
    public boolean isCousins(TreeNode root, int x, int y) {
        //层数
        int level = -1;
        //x的父节点
        TreeNode px = null;
        //y的父节点
        TreeNode py = null;
        // x y 结点的层数
        int lx = -1;
        int ly = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //BFS
        while(!queue.isEmpty()){
            level++;
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                    if(node.left.val == x){
                        px = node;
                        lx = level+1;
                    }
                    if(node.left.val == y){
                        py = node;
                        ly = level+1;
                    }
                }
                if(node.right!=null){
                    queue.offer(node.right);
                    if(node.right.val==x){
                        px = node;
                        lx = level+1;
                    }
                    if(node.right.val==y){
                        py = node;
                        ly = level+1;
                    }
                }
                //父节点不同
                if(px!=null && py!=null && px!=py){
                    //层数不同
                    return lx==ly;
                }
            }
        }
        return false;
    }
}
