package Tree.tree0410;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description:1315. 祖父节点值为偶数的节点和
给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。



示例：



输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：18
解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。


提示：

树中节点的数目在 1 到 10^4 之间。
每个节点的值在 1 到 100 之间。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/10 23:36
 */
public class LC1315 {
    //递归
    private int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        if(node.val%2==0){
            if(node.left!=null){
                if(node.left.left!=null){
                    sum += node.left.left.val;
                }
                if(node.left.right!=null){
                    sum += node.left.right.val;
                }

            }
            if(node.right!=null){
                if(node.right.left!=null){
                    sum += node.right.left.val;
                }
                if(node.right.right!=null){
                    sum += node.right.right.val;
                }
            }
        }
        dfs(node.left);
        dfs(node.right);
    }
}
class LC1315_M2{
    //迭代
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.val%2==0){
                if(node.left!=null){
                    if(node.left.left!=null){
                        sum += node.left.left.val;
                    }
                    if(node.left.right!=null){
                        sum += node.left.right.val;
                    }

                }
                if(node.right!=null){
                    if(node.right.left!=null){
                        sum += node.right.left.val;
                    }
                    if(node.right.right!=null){
                        sum += node.right.right.val;
                    }
                }
            }
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
        return sum;
    }
}

class LC1315_M3{
    //迭代
    private int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(1,1,root);
        return sum;

    }
    //记录父节点 祖父结点的值
    public void dfs(int g, int p, TreeNode node){
        if(node==null){
            return;
        }
        if(g%2==0){
            sum += node.val;
        }
        dfs(p, node.val, node.left);
        dfs(p, node.val, node.right);
    }
}