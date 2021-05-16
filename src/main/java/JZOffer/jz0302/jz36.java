package JZOffer.jz0302;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description: 剑指 Offer 36. 二叉搜索树与双向链表
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。



为了让您更好地理解问题，以下面的二叉搜索树为例：







我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。

下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。







特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。



注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/

注意：此题对比原题有改动。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/2 13:58
 */
public class jz36 {

    //中序遍历,递归
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root==null){
            return null;
        }
        dfs(root);
        //pre当前为最右子节点
        head.left = pre;
        pre.right = head;
        return head;
    }

    void dfs(Node cur){
        if(cur==null){
            return;
        }
        //递归左子树
        dfs(cur.left);
        //判断prev是否为null
        if(pre!=null){
            pre.right = cur;
        }else{
            //当前结点为最左叶子结点,为链表的头
            head = cur;
        }
        //当前结点left指向前驱结点
        cur.left = pre;
        pre = cur;
        //递归遍历右子节点
        dfs(cur.right);
    }


    //迭代
//    public Node treeToDoublyList(Node root){
//        Node pre = null, head = null;
//        if(root==null){
//            return null;
//        }
//        //维护栈
//        Deque<Node> stack = new LinkedList<>();
//        //根结点非空或者栈不为空则继续循环
//        while(root!=null || !stack.isEmpty()){
//            while(root!=null){
//                //当前结点入栈
//                stack.push(root);
//                //变成左子节点
//                root = root.left;
//            }
//            //出栈一个结点
//            root = stack.pop();
//            if(pre!=null){
//                //存在前驱结点,前驱结点右指针指向当前结点
//                pre.right = root;
//            }else{
//                //不存在前驱结点,当前结点为最左子节点,即为链表的头结点
//                head = root;
//            }
//            //当前结点左指针指向前驱结点
//            root.left = pre;
//            //前驱结点移动到当前结点
//            pre = root;
//            //向当前结点的右子树查找
//            root = root.right;
//        }
//        //处理头尾结点的关系,遍历完,pre指向链表的尾结点
//        pre.right = head;
//        head.left = pre;
//        return head;
//    }
}



class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
