package Tree.tree0420;

import Tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/20-22:06
 */

public class interview0406 {
    //中序遍历
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null){
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            //左子树
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            //当前结点
            root = stack.pop();
            //当前结点是待查找的结点, 查找其后继结点
            if(root.val==p.val){
                //右子节点不为空 找到右子树的最左子节点为下一个遍历的结点
                if(root.right!=null){
                    return findLeft(root.right);
                }else if(!stack.isEmpty()){
                    //右子节点为空 如果栈不为空 栈顶元素为下一个遍历的结点
                    return stack.pop();
                }else{
                    //当前元素为最后一个元素 无后继结点
                    return null;
                }
            }
            root = root.right;
        }
        return null;
    }

    //找到node的最左子节点
    public TreeNode findLeft(TreeNode node){
        if(node==null){
            return null;
        }
        while(node.left!=null){
            node = node.left;
        }
        return node;
    }
}

class interview0406_M2{
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //如果当前结点下一步向左走记录当前结点为下一步结点的前驱结点
        //如果当前结点下一步向右走,无需记录前驱结点,因为右子树的结点一定在当前结点后面遍历
        TreeNode pre = null;
        while(root.val!=p.val){
            if(root.val<p.val){
                root = root.right;
            }else{
                pre = root;
                root = root.left;
            }
        }
        //当前结点值等于p.val
        //如果当前结点没有右子节点, 下一个遍历的就是前驱结点 返回pre
        if(root.right==null){
            return pre;
        }else{
            //当前结点有右子节点,找到右子树的最左子节点为下一个遍历的结点
            TreeNode temp = root.right;
            while(temp.left!=null){
                temp = temp.left;
            }
            return temp;
        }
    }
}
