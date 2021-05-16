package Tree.tree0211;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @Description: 145. 二叉树的后序遍历
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/11 15:30
 */
public class LC145 {

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
