package JZOffer.jz0302;


import java.util.*;

/*
 * @Description: 剑指 Offer 37. 序列化二叉树
请实现两个函数，分别用来序列化和反序列化二叉树。

示例:

你可以将以下二叉树：

    1
   / \
  2   3
     / \
    4   5

序列化为 "[1,2,3,null,null,4,5]"
注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/2 15:14
 */
public class jz37 {

    // Encodes a tree to a single string.

    //BFS
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        //左括号
        sb.append("[");
        if(root==null){
            return "[]";
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            //不为空节点
            if(cur!=null){
                //添加结点值 + ","
                sb.append(cur.val).append(",");
                //添加左右结点
                queue.addLast(cur.left);
                queue.addLast(cur.right);
            }else{
                //空节点则添加 "null,"
                sb.append("null,");
            }
        }
        //删除最后一个','
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    Deque<Integer> deser = new LinkedList<>();
    public TreeNode deserialize(String data) {
        if(data.equals("[]")){
            return null;
        }
        //删除左右两边的括号并且以","为分隔符变成字符串数组
        String[] nodeArr = data.substring(1,data.length()-1).split(",");
        //以第一个元素值创建根结点
        TreeNode root = new TreeNode(Integer.parseInt(nodeArr[0]));
        //从第二个元素开始创建左右子节点
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            //左
            if(!nodeArr[index].equals("null")){
                //创建左子节点
                cur.left = new TreeNode(Integer.parseInt(nodeArr[index]));
                //左子节点入队
                queue.add(cur.left);
            }
            ++index;
            if(!nodeArr[index].equals("null")){
                //创建右子节点
                cur.right = new TreeNode(Integer.parseInt(nodeArr[index]));
                //右子节点入队
                queue.add(cur.right);
            }
            ++index;
        }
        return root;
    }

    //DFS
    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if(root==null){
//            return "null";
//        }
//        //     当前结点             左子树                         右子树
//        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        //data按照","分隔开转化成队列
//        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
//        //按照队列递归
//        return dfs(queue);
//    }
//
//    private TreeNode dfs(Queue<String> queue){
//        //根结点出队
//        String cur = queue.poll();
//        //返回null
//        if(cur.equals("null")){
//            return null;
//        }
//        //当前结点不为null,以节点值创建新节点
//        TreeNode root = new TreeNode(Integer.parseInt(cur));
//        //递归创建左右子树
//        root.left = dfs(queue);
//        root.right = dfs(queue);
//        //返回根结点
//        return root;
//    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
