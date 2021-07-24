package JZOffer.review;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-14:04
 */

public class jz32_II {

    //递归
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        if(root==null){
            return list ;
        }
        dfs(root,0);
        return list;
    }
    private void dfs(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(level>=list.size()){
            list.add(new ArrayList<>());
        }
        dfs(root.left, level+1);
        list.get(level).add(root.val);
        dfs(root.right, level+1);
    }
}
class jz32_II_M2{
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
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