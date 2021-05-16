package DepthFirstSearch.dfs0111;


/*
 * @Description:
 *
给定一个二叉树，原地将它展开为一个单链表。
*
例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
*
将其展开为：
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

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/11 9:25
 */
public class LC114 {
    //前序遍历保存到list集合,依次取出全部放在右子树
//    public void flatten(TreeNode root) {
//        //创建list集合
//        ArrayList<TreeNode> list = new ArrayList<>();
//        //按照前序遍历存储结点到list
//        preOrder(root,list);
//        //循环取出两个连接在单链表上
//        for(int i=1; i<list.size(); i++){
//            TreeNode cur = list.get(i);
//            TreeNode pre = list.get(i-1);
//            //将当前结点连接在上一个结点的右子树上
//            pre.right = cur;
//            pre.left = null;
//        }
//    }
//    //前序遍历
//    public void preOrder(TreeNode root, ArrayList<TreeNode>list){
//        //按照前序遍历的顺序将结点存储到list集合中
//        if(root!=null){
//            list.add(root);
//            preOrder(root.left,list);
//            preOrder(root.right,list);
//        }
//    }

    //前序遍历和展开同步进行,非递归
//    public void flatten(TreeNode root){
//        if(root==null){
//            return;
//        }
//        //维护栈保存根结点的右子节点信息
//        Stack<TreeNode> stack = new Stack<>();
//        //展开为单链表的做法是，
//        // 维护上一个访问的节点 prev，
//        // 每次访问一个节点时，令当前访问的节点为 curr，
//        // 将 prev 的左子节点设为 null 以及将 prev 的右子节点设为 curr，
//        // 然后将 curr 赋值给 prev，
//        // 进入下一个节点的访问，直到遍历结束。
//        // 需要注意的是，初始时 prev 为 null，只有在 prev 不为 null 时才能对 prev 的左右子节点进行更新。
//        TreeNode prev = null;
//        stack.push(root);
//        while(!stack.isEmpty()){
//            TreeNode curr = stack.pop();
//            //更新pre的左右子节点
//            if(prev!=null){
//                prev.left = null;
//                prev.right = curr;
//            }
//            TreeNode left = curr.left, right = curr.right;
//            //当前结点的右子结点先入栈,这样后出栈就放在了左子结点的后面
//            if(right!=null){
//                stack.push(right);
//            }
//            if(left!=null){
//                stack.push(left);
//            }
//            //将prev设置成当前结点curr
//            prev = curr;
//        }
//    }

    //前驱结点
    public void flatten(TreeNode root){
        while(root!=null){
            if(root.left==null){
                //当前结点不存在左子节点,后移到右子节点
                root = root.right;
            }else{
                //找到左子树的最右子节点,该结点为右子树的前驱结点
                TreeNode prev = root.left;
                while(prev.right!=null){
                    prev = prev.right;
                }
                //找到该左子树最右子节点,将根结点右子树连接在该最右子节点
                prev.right = root.right;
                //当前根结点的子节点都在左子树,将左子树放到右子树
                root.right = root.left;
                //将左子树置空
                root.left = null;
                //根结点向右子结点移动一位
                root = root.right;
            }
        }

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