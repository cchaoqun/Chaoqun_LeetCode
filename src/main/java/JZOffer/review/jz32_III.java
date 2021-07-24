package JZOffer.review;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-14:07
 */

public class jz32_III {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> cur = new LinkedList<>();
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(list.size()%2==0){
                    cur.add(node.val);
                }else{
                    cur.addFirst(node.val);
                }
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
class jz32_III_M2{
    //递归
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<>();
        if(root==null){
            return list;
        }
        dfs(root,0);

        return list;
    }
    private void dfs(TreeNode root, int level){
        if(root==null){
            return;
        }
        if(level>=list.size()){
            list.add(new LinkedList<>());
        }
        dfs(root.left, level+1);
        if(level%2==0){
            list.get(level).add(root.val);
        }else{
            list.get(level).add(0,root.val);
        }

        dfs(root.right, level+1);
    }
}