package Tree.tree0409;
/*
 * @Description: 543. 二叉树的直径
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。



示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。



注意：两结点之间的路径长度是以它们之间边的数目表示。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/9 16:09
 */
public class LC543 {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    //统计node结点为根的树的最大深度
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        //最长的距离不一定是根结点左子树的的最大深度+右子树的最大深度
        //对于每个结点左右子树的最大深度和都需要确认
        //可能存在某个子节点的左右子树深度都很大,但是返回的只是最大值
        //所以这里对于每个结点都需要更新最大值, 自下而上
        max = Math.max(max, left+right);
        return Math.max(left, right)+1;
    }
}
