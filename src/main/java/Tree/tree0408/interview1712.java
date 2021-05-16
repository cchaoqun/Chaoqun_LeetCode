package Tree.tree0408;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description: 面试题 17.12. BiNode
二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。

返回转换后的单向链表的头节点。

注意：本题相对原题稍作改动



示例：

输入： [4,2,5,1,3,null,6,0]
输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
提示：

节点数量不会超过 100000。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/8 14:45
 */
public class interview1712 {
    //迭代
    public TreeNode convertBiNode(TreeNode root) {
        //前驱结点
        TreeNode prev = null;
        //重构后的单链表的头结点,为原二叉树的最左叶子结点
        TreeNode head = null;
        //栈
        Deque<TreeNode> stack = new LinkedList<>();
        //中序遍历二叉搜索树为有序的
        while(root!=null || !stack.isEmpty()){
            //中序遍历每次先找到当前结点为根的数的最左子节点
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            //当前结点需要做的操作
            root = stack.pop();
            //1.如果head为空,说明当前结点为最左子节点, 初始化head prev
            if(head==null){
                head = root;
                prev = root;
                //中序遍历的遍历右子节点
                root = root.right;
            }else{
                //2.head不为空,
                //需要将前驱结点的right指向当前结点
                prev.right = root;
                //移动前驱结点到当前结点
                prev = root;
                //置空当前结点的左子子节点,因为已经处理过了
                root.left = null;
                //中序遍历的遍历右子节点
                root = root.right;
            }
        }
        return head;
    }
}
class interview1712_M2{
    //递归
    //头结点
    private TreeNode head;
    //前驱结点
    private TreeNode prev;
    public TreeNode convertBiNode(TreeNode root) {
        //初始化
        head = null;
        prev = null;
        dfs(root);
        return head;
    }
    //中序遍历
    public void dfs(TreeNode node){
        //递归终止条件
        if(node==null){
            return;
        }
        //中序遍历左子节点
        dfs(node.left);
        //遍历当前结点
        //1.如果head==null, 当前结点为最左左子节点
        if(head==null){
            //确定返回链表的头结点
            head = node;
            //更新前驱结点
            prev = node;
        }else{
            //2.更新前驱结点的right指针指向当前结点
            prev.right = node;
            //更新前驱结点为当前结点
            prev = node;
            //置空当前结点的left指针
            node.left = null;
        }
        //中序遍历右子节点
        dfs(node.right);
    }
}
