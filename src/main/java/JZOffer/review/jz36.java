package JZOffer.review;

import Tree.TreeNode;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/26-20:29
 */

public class jz36 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "[]";
        }
        StringBuffer sb = new StringBuffer();
        Deque<TreeNode> queue = new LinkedList<>();
        if(root!=null){
            queue.offer(root);
        }
        sb.append("[");
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                sb.append(node.val+",");
                queue.offer(node.left);
                queue.offer(node.right);
            }else{
                sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("[]")){
            return null;
        }
        String[] arr = data.substring(1,data.length()-1).split(",");
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            index++;
            if(!arr[index].equals("null")){
                node.left = new TreeNode(Integer.parseInt(arr[index]));
                queue.offer(node.left);
            }
            index++;
            if(!arr[index].equals("null")){
                node.right = new TreeNode(Integer.parseInt(arr[index]));
                queue.offer(node.right);
            }
        }
        return root;
    }

}
class jz36_M2{
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return "null";
        }
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return dfs(new LinkedList<>(Arrays.asList(data.split(","))));

    }

    private TreeNode dfs(Queue<String> queue){
        String cur = queue.poll();
        if(cur.equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(cur));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }
}