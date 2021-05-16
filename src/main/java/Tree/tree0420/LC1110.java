package Tree.tree0420;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1110. 删点成林
 * 给出二叉树的根节点 root，树上每个节点都有一个不同的值。
 *
 * 如果节点值在 to_delete 中出现，我们就把该节点从树上删去，最后得到一个森林（一些不相交的树构成的集合）。
 *
 * 返回森林中的每棵树。你可以按任意顺序组织答案。
 *
 *
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * 输出：[[1,2,null,4],[6],[7]]
 *
 *
 * 提示：
 *
 * 树中的节点数最大为 1000。
 * 每个节点都有一个介于 1 到 1000 之间的值，且各不相同。
 * to_delete.length <= 1000
 * to_delete 包含一些从 1 到 1000、各不相同的值。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/20-20:44
 */

public class LC1110 {
    List<TreeNode> res;
    Set<Integer> set;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        this.res = new ArrayList<>();
        this.set = new HashSet<>();
        //数组放到set中 O(1)时间内判断结点是否需要删除
        for(int i:to_delete){
            set.add(i);
        }
        root = dfs(root, to_delete);
        //最后的根结点更新后如果不为null也需要加入到res
        if(root!=null){
            res.add(root);
        }
        return res;
    }

    //后序遍历
    public TreeNode dfs(TreeNode node, int[] to_delete){
        if(node==null){
            return null;
        }
        //左右子节点
        TreeNode left = dfs(node.left, to_delete);
        TreeNode right = dfs(node.right, to_delete);
        //如果当前结点是待删除的结点
        if(set.contains(node.val)){
            //左右子节点不为空则加入结果数组
            //后序遍历子节点已经处理过了不为空则一定不需要再删除
            if(left!=null){
                res.add(left);
            }
            if(right!=null){
                res.add(right);
            }
            //删除当前结点
            return null;
        }
        //当前结点不需要删除更新左右子节点后返回当前结点
        node.left = left;
        node.right = right;
        return node;
    }
}
