package company.bytedance;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-15:20
 */

public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            list.add(queue.peekFirst().val);
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(node.left!=null){
                    queue.offer(node.left);
                }
            }
        }
        return list;
    }
}
class LC199_M2{
    int maxLevel = -1;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, 0);
        return list;
    }


    //DFS
    private void dfs(TreeNode node, List<Integer> list, int level ){
        if(node==null){
            return ;
        }
        //当前结点为level层的第一个一定是最左的
        if(level>maxLevel){
            list.add(node.val);
            maxLevel = level;
        }
        //先右后左
        dfs(node.right,list,level+1);
        dfs(node.left, list,level+1);
    }
}