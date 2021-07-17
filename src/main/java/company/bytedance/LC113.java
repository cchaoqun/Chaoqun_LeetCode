package company.bytedance;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/2-14:06
 */

public class LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res, path, targetSum, root);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> path, int target, TreeNode node){
        if(node==null){
            return;
        }
        path.add(node.val);
        if(node!=null && node.left==null && node.right==null && target-node.val==0){
            res.add(new ArrayList<>(path));
            return;
        }

        if(node.left!=null){
            dfs(res, path, target-node.val, node.left);
            path.remove(path.size()-1);
        }
        if(node.right!=null){
            dfs(res, path, target-node.val, node.right);
            path.remove(path.size()-1);
        }
    }
}
