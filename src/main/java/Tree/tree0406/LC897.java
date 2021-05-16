package Tree.tree0406;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description:897. 递增顺序查找树
给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。



示例 ：

输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \
1        7   9

输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9


提示：

给定树中的结点数介于 1 和 100 之间。
每个结点都有一个从 0 到 1000 范围内的唯一整数值。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/6 15:19
 */
public class LC897 {
    //新树的根结点
    private TreeNode head;
    //辅助创建新树的指针
    private TreeNode temp;
    public TreeNode increasingBST(TreeNode root) {
        dfs(root);
        return head;
    }

    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        //遍历左子节点
        dfs(node.left);
        //新树的根结点未被初始化
        if(head==null){
            //初始化其值为当前结点的值
            head = new TreeNode(node.val);
            //temp指针指向head,帮助创建右子树
            temp = head;
        }else{
            //将右子节点初始化当前结点的值
            temp.right = new TreeNode(node.val);
            //将指针移动到最右子节点的位置,等待下一个插入的新节点
            temp = temp.right;
        }
        dfs(node.right);
    }
}

class LC897_M2{
    //迭代
    public TreeNode increasingBST(TreeNode root) {
        if(root==null){
            return null;
        }
        //新树的根结点
        TreeNode head=null;
        //辅助创建新树的指针
        TreeNode temp=null;
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null || !stack.isEmpty()){
            //左子节点
            while(root!=null){
                //当前结点入栈
                stack.push(root);
                //寻找最左子节点
                root = root.left;
            }
            //当前结点
            root = stack.pop();
            //新树的根结点为null
            if(head==null){
                //初始化根结点的值为当前结点的值
                head = new TreeNode(root.val);
                //更新指针
                temp = head;
            }else{
                //创建右子节点值为当前结点的值
                temp.right = new TreeNode(root.val);
                //保证指针在最右子节点等待新节点的创建
                temp = temp.right;
            }
            //右子节点
            root = root.right;
        }
        return head;

    }
}
