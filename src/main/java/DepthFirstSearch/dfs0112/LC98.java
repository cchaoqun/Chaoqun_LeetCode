package DepthFirstSearch.dfs0112;


/*
 * @Description:98. 验证二叉搜索树
 *
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
*
示例1:
输入:
    2
   / \
  1   3
输出: true
*
示例2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。   根节点的值为 5 ，但是其右子节点值为 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/12 13:51
 */
public class LC98 {
    //前序遍历 stack
//    public boolean isValidBST(TreeNode root) {
//        Deque<TreeNode> stack = new LinkedList<>();
//        double pre = -Double.MAX_VALUE;
//        while(!stack.isEmpty() || root!=null){
//            while(root!=null){
//                stack.push(root);
//                root = root.left;
//            }
//            root = stack.pop();
//            if(root.val<=pre){
//                //前序遍历的结果如果当前结点值小于前一个结点不符合二叉搜索树的规则
//                return false;
//            }
//            //当前结点值赋给pre
//            pre = root.val;
//            root = root.right;
//        }
//        return true;
//    }

    //前序遍历
    long pre = -Long.MAX_VALUE;
    public boolean isValidBST(TreeNode root){
        if(root==null){
            return true;
        }
        //遍历左子树
        if(!isValidBST(root.left)){
            return false;
        }
        //判断当前结点值是否大于前一个
        if(root.val<=pre){
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);

    }
}



//Definition for a binary tree node.
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
