package Tree.tree0211;

import java.util.*;

/*
 * @Description: 94. 二叉树的中序遍历
给定一个二叉树的根节点 root ，返回它的 中序 遍历。



示例 1：


输入：root = [1,null,2,3]
输出：[1,3,2]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [1]
输出：[1]
示例 4：


输入：root = [1,2]
输出：[2,1]
示例 5：


输入：root = [1,null,2]
输出：[1,2]


提示：

树中节点数目在范围 [0, 100] 内
-100 <= Node.val <= 100


进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * @param null
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/11 13:54
 */
public class LC94 {

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

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
