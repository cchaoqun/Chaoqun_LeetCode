package JZOffer.review;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**剑指 Offer 34. 二叉树中和为某一值的路径
 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



 示例:
 给定如下二叉树，以及目标和 target = 22，

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 返回:

 [
 [5,4,11,2],
 [5,8,4,5]
 ]


 提示：

 节点总数 <= 10000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/26-17:54
 */

public class jz34 {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        dfs(root, target);
        return res;
    }

    private void dfs(TreeNode node, int target){
        if(node==null){
            return;
        }
        //当前结点入path
        path.add(node.val);
        target -= node.val;
        //判断是否是叶子结点
        if(node!=null && node.left==null && node.right==null){
            //判断到达叶子结点是否target刚好==0 这样就刚好是需要的路径
            if(target==0){
                res.add(new ArrayList<>(path));
            }
            //不return 这里不需要return 这里还需要返回之前删除最后添加的node.val

            //return 如果这里return需要删除最后添加的node.val
            // path.remove(path.size()-1);
            // return;
        }
        dfs(node.left, target);
        dfs(node.right, target);
        path.remove(path.size()-1);

    }
}
