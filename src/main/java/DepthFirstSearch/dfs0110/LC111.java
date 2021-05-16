package DepthFirstSearch.dfs0110;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 111. 二叉树的最小深度
 *
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。


示例 1：
输入：root = [3,9,20,null,null,15,7]
输出：2
*
示例 2：
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5

提示：
树中节点数的范围在 [0, 105] 内
-1000 <= Node.val <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/10 21:22
 */
public class LC111 {

    //DFS
//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        //如果左子节点==null 返回右子节点的最小深度,
//        // 因为这里如果根结点的子节点为null,叶子结点只存在右子树
//        if(root.left==null){
//            return minDepth(root.right)+1;
//        }
//        //右子节点同理
//        if(root.right==null){
//            return minDepth(root.left)+1;
//        }
//        //左右子节点都存在,则返回当中的最小值
//        return Math.min(minDepth(root.left), minDepth(root.right))+1;
//    }

    //BFS
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //层数
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            //遍历每一层的结点
            while(size>0){
                TreeNode temp = queue.poll();
                //如果为叶子结点,则返回层数,第一个达到的叶子结点所在的层一定是最小深度
                if(temp.left==null && temp.right==null){
                    return level;
                }
                //不是叶子结点则将其子节点入列
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                size--;
            }
            //遍历完一层,层数增加
            level++;

        }
        return level;
    }
}
