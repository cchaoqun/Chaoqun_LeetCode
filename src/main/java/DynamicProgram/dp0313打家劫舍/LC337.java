package DynamicProgram.dp0313打家劫舍;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Description: 337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/13 10:14
 */
public class LC337 {

    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }

    /**
     *
     * @param node 当前根结点
     * @return dp[0] node不偷的最大值 dp[1] node偷的最大值
     */
    public int[] dfs(TreeNode node){
        if(node==null){
            //空节点,返回00
            return new int[]{0,0};
        }
        //后续遍历,先获得左右子节点的状态
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        //当前结点的状态根据左右子树状态来
        int[] dp = new int[2];
        //当前结点不偷, 为左右子节点的最大值
        //相加是因为左右子树不连接,故互不影响
        dp[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        //当前结点偷,左右子节点都不能偷
        dp[1] = node.val + left[0] + right[0];
        return dp;
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
