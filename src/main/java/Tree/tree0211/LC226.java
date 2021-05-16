package Tree.tree0211;

import java.util.LinkedList;

/*
 * @Description: 226. 翻转二叉树
翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
备注:
这个问题是受到 Max Howell 的 原问题 启发的 ：

谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 10:43
 */
public class LC226 {

    //递归
//    public TreeNode invertTree(TreeNode root) {
//        if(root == null){
//            return null;
//        }
//        //交换当前结点的左右子节点
//        TreeNode left = root.left;
//        root.left = root.right;
//        root.right = left;
//        //递归的交换左右子节点
//        invertTree(root.left);
//        invertTree(root.right);
//        //当前结点的左右子节点全部交换完成后返回当前结点
//        return root;
//    }

    //迭代
    public TreeNode invertTree(TreeNode root){
        if(root == null){
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //出队
            TreeNode temp = queue.poll();
            //交换出栈结点的左右子节点
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            //将当前结点的左右子节点入栈
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
        //返回处理完的根结点
        return root;

    }



}
