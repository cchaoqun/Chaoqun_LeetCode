package DynamicProgram.dp0329;
/*
 * @Description: 1372. 二叉树中的最长交错路径
给你一棵以 root 为根的二叉树，二叉树中的交错路径定义如下：

选择二叉树中 任意 节点和一个方向（左或者右）。
如果前进方向为右，那么移动到当前节点的的右子节点，否则移动到它的左子节点。
改变前进方向：左变右或者右变左。
重复第二步和第三步，直到你在树中无法继续移动。
交错路径的长度定义为：访问过的节点数目 - 1（单个节点的路径长度为 0 ）。

请你返回给定树中最长 交错路径 的长度。



示例 1：



输入：root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
输出：3
解释：蓝色节点为树中最长交错路径（右 -> 左 -> 右）。
示例 2：



输入：root = [1,1,1,null,1,null,null,1,1,null,1]
输出：4
解释：蓝色节点为树中最长交错路径（左 -> 右 -> 左 -> 右）。
示例 3：

输入：root = [1]
输出：0


提示：

每棵树最多有 50000 个节点。
每个节点的值在 [1, 100] 之间。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/29 16:04
 */
public class LC1372 {
    //可以走的最长长度
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root==null){
            return 0;
        }
        dfs(root, false, 0);
        dfs(root, true, 0);
        return max;
    }

    /**
     当前结点为node, 应该走的方向为left=true 左 否则右, len当前结点之前已经走过的长度
     */
    public void dfs(TreeNode node, boolean left, int len){
        //更新走到当前结点的最长长度
        max = Math.max(max, len);
        //当前结点应该向左走
        if(left){
            if(node.left!=null){
                //左子节点不为空, 向左遍历, 下一个遍历方向改变, 当前结点可以走到左子节点,长度+1
                dfs(node.left, !left, len+1);
            }
            if(node.right!=null){
                //右子节点不为空, 如果当前结点向右走,下一个结点向左走,等于从这个结点重新开始,
                //到右子节点只走过了当前结点到右子节点长度为1的距离
                dfs(node.right, left, 1);
            }
        }else{//当前结点向右走,讨论相同
            if(node.right!=null){
                dfs(node.right, !left, len+1);
            }
            if(node.left!=null){
                dfs(node.left, left, 1);
            }
        }
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

