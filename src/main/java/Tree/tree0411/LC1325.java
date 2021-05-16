package Tree.tree0411;
/*
 * @Description:1325. 删除给定值的叶子节点
给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。

注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。

也就是说，你需要重复此过程直到不能继续删除。



示例 1：



输入：root = [1,2,3,2,null,2,4], target = 2
输出：[1,null,3,null,4]
解释：
上面左边的图中，绿色节点为叶子节点，且它们的值与 target 相同（同为 2 ），它们会被删除，得到中间的图。
有一个新的节点变成了叶子节点且它的值与 target 相同，所以将再次进行删除，从而得到最右边的图。
示例 2：



输入：root = [1,3,3,3,2], target = 3
输出：[1,3,null,null,2]
示例 3：



输入：root = [1,2,null,2,null,2], target = 2
输出：[1]
解释：每一步都删除一个绿色的叶子节点（值为 2）。
示例 4：

输入：root = [1,1,1], target = 1
输出：[]
示例 5：

输入：root = [1,2,3], target = 1
输出：[1,2,3]


提示：

1 <= target <= 1000
每一棵树最多有 3000 个节点。
每一个节点值的范围是 [1, 1000]
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/11 21:00
 */
public class LC1325 {
    private int target;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.target = target;
        if(root==null){
            return null;
        }
        //对于根结点同样需要后续遍历 处理外左右子树再处理根结点
        dfs(root, root.left, true);
        dfs(root, root.right, false);
        if(root.val==target && root.left==null && root.right==null){
            return null;
        }
        return root;
    }
    //递归 后续遍历
    public void dfs(TreeNode p, TreeNode node, boolean left){
        if(node==null){
            return;
        }
        dfs(node, node.left, true);
        dfs(node, node.right, false);
        //当前结点的值=target 并且为叶子结点
        if(node.val==target && node.left==null && node.right==null){
            //通过保存的父节点 以及 左右信息 删除当前结点
            if(left){
                p.left = null;
            }else{
                p.right = null;
            }
        }
    }
}

class LC1325_M2{
    private int target;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        this.target = target;
        if(root==null){
            return null;
        }
        return dfs(root);

    }
    //递归 后续遍历
    public TreeNode dfs(TreeNode node){
        if(node==null){
            return null;
        }
        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);
        node.left = left;
        node.right = right;
        if(node.val==target && node.left==null && node.right==null){
            return null;
        }
        return node;

    }
}
