package Tree.tree0211;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @Description: 144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。



示例 1：


输入：root = [1,null,2,3]
输出：[1,2,3]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[1,2]
示例 5：


输入：root = [1,null,2]
输出：[1,2]


提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶：递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/11 15:03
 */
public class LC144 {

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



}
