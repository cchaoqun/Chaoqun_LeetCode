package Tree.tree0404;
/*
 * @Description:450. 删除二叉搜索树中的节点
给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

示例:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/4 17:25
 */
public class LC450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        //当前结点为空,返回null
        if(root==null){
            return root;
        }
        //key<当前结点值,key对应结点在当前结点的左子树
        if(key<root.val){
            //当前结点的左子节点为左子树删除结点更新后的新的树
            root.left = deleteNode(root.left, key);
        }else if(key>root.val){
            //同理,右子树中删除结点后返回右子树的根结点
            root.right = deleteNode(root.right, key);
        }else{
            //当前结点为待删除结点
            //如果左右子树都不为空
            if(root.left!=null && root.right!=null){
                //找到右子树的最左子节点
                TreeNode temp = root.right;
                while(temp.left!=null){
                    temp = temp.left;
                }
                //右子树最右子节点的left指向当前结点的左子节点
                temp.left = root.left;
                //删除当前结点后,返回右子节点
                return root.right;
            }else if(root.right!=null){
                //左子树直接返回右子树
                return root.right;
            }else if(root.left!=null){
                //右子树为空直接返回左树
                return root.left;
            }else{
                //左右子树都为空 返回null
                return null;
            }
        }
        //没有找到待删除结点返回根结点
        return root;
    }
}
