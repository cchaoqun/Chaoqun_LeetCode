package Tree.tree0416;


import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description: 114. 二叉树展开为链表
给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。


示例 1：


输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [0]
输出：[0]


提示：

树中结点数在范围 [0, 2000] 内
-100 <= Node.val <= 100


进阶：你可以使用原地算法（O(1) 额外空间）展开这棵树吗？
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/16 17:20
 */
public class LC114 {
    //栈 前序遍历展开同步进行
    public void flatten(TreeNode root){
        if(root==null){
            return;
        }
        //栈进行先序遍历
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        //保留前驱结点
        TreeNode prev = new TreeNode(0);
        while(!stack.isEmpty()){
            //出栈结点接在前驱结点的后面
            prev.right = stack.pop();
            //移动前驱结点到当前出栈结点
            prev = prev.right;
            //先右后左将子节点入栈
            if(prev.right!=null){
                stack.push(prev.right);
            }
            if(prev.left!=null){
                stack.push(prev.left);
            }
            //置空左子节点
            prev.left = null;
        }
    }
}

class LC114_M2{
    //前驱结点
    public void flatten(TreeNode root){
        while(root!=null){
            //左子树已经处理完成
            if(root.left==null){
                root = root.right;
            }else{
                //处理左子树
                TreeNode prev = root.left;
                //找到左子树的最右子节点因为为左子树的先序遍历的尾结点
                //应该接在root右子树的前面
                while(prev.right!=null){
                    prev = prev.right;
                }
                //右子树根结点接在左子树最右子节点的后面
                prev.right = root.right;
                //左子树接在右子树上 左子树置空
                root.right = root.left;
                root.left = null;
                //所有结点都在右子树上,继续处理下一个左子节点
                root = root.right;
            }
        }
    }
}

//递归
class LC114_M3{
    public void flatten(TreeNode root){
        if(root==null){
            return;
        }
        //将左子树变成链表
        flatten(root.left);
        //保留右子树
        TreeNode right = root.right;
        //右子树已经保存 左子树已经变成链表 将左子树放到右子树 左子树置空
        root.right = root.left;
        root.left = null;
        //遍历到当前右子树的尾结点
        while(root.right!=null){
            root = root.right;
        }
        //处理之前根结点的右子树
        flatten(right);
        //拼接到链表的末尾 即 当前的root
        root.right = right;
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}