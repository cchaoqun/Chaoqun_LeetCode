package Tree.tree0211;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Tree_pre_in_post_order {

    //======================前序遍历========================
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    //递归
    public static void dfs(TreeNode node, List<Integer> list){
        if(node==null){
            return;
        }
        //访问当前结点
        list.add(node.val);
        dfs(node.left, list);
        dfs(node.right, list);
    }

    //迭代
//    public List<Integer> preorderTraversal(TreeNode root){
//        List<Integer> list = new ArrayList<>();
//        Deque<TreeNode> stack = new LinkedList<>();
//        if(root!=null){
//            stack.push(root);
//        }
//        while(!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            list.add(node.val);
//            //右子节点入栈
//            if(node.right!=null){
//                stack.push(node.right);
//            }
//            //左子节点入栈
//            if(node.left!=null){
//                stack.push(node.left);
//            }
//        }
//        return list;
//    }


    //=====================中序遍历=============================
    //递归
//    public static List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        dfs(root,list);
//        return list;
//    }
//    //递归
//    public static void dfs(TreeNode node, List<Integer> list){
//        if(node==null){
//            return;
//        }
//        //左递归
//        dfs(node.left, list);
//        //当前元素
//        list.add(node.val);
//        //右递归
//        dfs(node.right, list);
//    }

    //迭代

    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    //======================后序遍历===============================
    //递归
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        dfs(root, list);
//        return list;
//    }
//
//    public static void dfs(TreeNode node, List<Integer> list){
//        if(node==null){
//            return;
//        }
//        dfs(node.left, list);
//        dfs(node.right, list);
//        list.add(node.val);
//    }


    //迭代
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        TreeNode pre = null;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            //pre指向的结点都是已经遍历到的结点,当前结点的右节点已经遍历到或者当前结点右子节点为空,当前结点可以添加
            //添加了当前结点以后,pre指向当前元素,root置空
            if(root.right == null || root.right == pre){
                list.add(root.val);
                pre = root;
                root = null;
            }else{
                //右子节点未被遍历,当前结点还不能添加
                stack.push(root);
                //先遍历当前结点右子节点
                root = root.right;
            }
        }
        return list;
    }
}

