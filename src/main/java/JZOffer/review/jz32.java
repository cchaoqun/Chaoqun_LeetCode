package JZOffer.review;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-13:57
 */

public class jz32 {
    //迭代
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
        }
        int[] res = new int[list.size()];
        int index = 0;
        for(int i:list){
            res[index++] = i;
        }
        return res;

    }
}

class jz32_M2{
    //递归
    List<List<Integer>> list;
    int size = 0;
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        list = new ArrayList<>();
        dfs(root,0);
        int[] res = new int[size];
        int index = 0;
        for(List<Integer> cur : list){
            for(int i : cur){
                res[index++] = i;
            }
        }
        return res;
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
        size++;
        dfs(root.right, level+1);

    }
}
