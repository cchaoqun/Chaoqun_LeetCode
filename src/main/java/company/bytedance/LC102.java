package company.bytedance;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/25-12:17
 */

public class LC102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            List<Integer> cur = new ArrayList<>();
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                cur.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.add(cur);
        }
        return list;
    }
}

class LC102_M2{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }

    private void dfs(TreeNode node, List<List<Integer>> list, int level){
        if(node==null){
            return;
        }
        if(level>=list.size()){
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        dfs(node.left, list, level+1);
        dfs(node.right, list, level+1);

    }
}
