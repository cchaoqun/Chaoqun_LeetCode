package BinarySearch.bs0107;

import java.util.LinkedList;

/*
 * @Description: 230. 二叉搜索树中第K小的元素
给定一个二叉搜索树，编写一个函数kthSmallest来查找其中第k个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 12:31
 */
public class LC230 {
    public static void main(String[] args) {

    }

    //借助栈
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(true){
            while(root!=null){
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if(--k == 0){
                return root.val;
            }
            root = root.right;
        }
    }

    //借助ArrayList中序遍历 提前判断结束
//    static int count = 0
//    public int kthSmallest(TreeNode root, int k) {
//        ArrayList<TreeNode> res = inOrder(root,new ArrayList<>(),k);
//        return res.get(k-1).val;
//    }
//    //中序遍历
//    public ArrayList<TreeNode> inOrder(TreeNode node, ArrayList<TreeNode> list, int k){
//        if(node==null){
//            return list;
//        }
//        inOrder(node.left,list,k);
//        list.add(node);
//        if(++count == k){
//            return list;
//        }
//        inOrder(node.right,list,k);
//        return list;
//    }


    //借助ArrayList中序遍历
//    public int kthSmallest(TreeNode root, int k) {
//        ArrayList<TreeNode> list = new ArrayList<>();
//        ArrayList<TreeNode> res = inOrder(root,list);
//        return res.get(k-1).val;
//    }
//    //中序遍历
//    public ArrayList<TreeNode> inOrder(TreeNode node, ArrayList<TreeNode> list){
//        if(node==null){
//            return list;
//        }
//        inOrder(node.left,list);
//        list.add(node);
//        inOrder(node.right,list);
//        return list;
//    }

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
