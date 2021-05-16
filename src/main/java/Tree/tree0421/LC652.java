package Tree.tree0421;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *652. 寻找重复的子树
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 *
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 *
 * 示例 1：
 *
 *         1
 *        / \
 *       2   3
 *      /   / \
 *     4   2   4
 *        /
 *       4
 * 下面是两个重复的子树：
 *
 *       2
 *      /
 *     4
 * 和
 *
 *     4
 * 因此，你需要以列表的形式返回上述重复子树的根结点。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/21-19:17
 */

public class LC652 {

    Map<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        this.map = new HashMap<>();
        this.res = new ArrayList<>();
        dfs(root);
        return res;
    }

    public String dfs(TreeNode node){
        if(node==null){
            return "#";
        }
        //序列化二叉树
        String serial = node.val+","+dfs(node.left)+","+dfs(node.right);
        map.put(serial, map.getOrDefault(serial, 0)+1);
        if(map.get(serial)==2){
            res.add(node);
        }
        return serial;

    }
}
