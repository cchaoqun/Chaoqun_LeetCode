package Tree.tree0423;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题 04.12. 求和路径
 * 给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * 3
 * 解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
 * 提示：
 *
 * 节点总数 <= 10000
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/23-20:57
 */

public class interview0412 {
    //DFS
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        //和=当前结点开始 以及左右子树开始的所有路径中路径和为sum的个数
        return dfs(root,0, sum)+pathSum(root.left, sum)+pathSum(root.right, sum);
    }

    //preSum 到当前结点之前的路径节点和
    //sum目标和
    public int dfs(TreeNode node, int preSum, int sum){
        if(node==null){
            return 0;
        }
        //当前结点以及当前结点的子树中存在的终点结点个数
        //到这些结点终止的路径和=sum
        int curCount = 0;
        if(preSum+node.val==sum){
            curCount+=1;
        }
        curCount += dfs(node.left, preSum+node.val, sum);
        curCount += dfs(node.right, preSum+node.val, sum);
        return curCount;
    }
}

class interview0402_M2{
    int sum;
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        this.sum = sum;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root,0,map);

    }

    //前缀和
    public int dfs(TreeNode node, int curSum, Map<Integer,Integer> map){
        if(node==null){
            return 0;
        }
        //当前结点以及当前结点的子树中符合条件的结点个数
        int res = 0;
        //从根结点到当前结点的路径和
        curSum += node.val;
        //如果根结点到当前结点的路径上存在一个结点 从根结点到那个结点的路径和为curSum-sum
        //那么从那个结点下面开始到当前结点的路径上的结点路径和为sum,
        res += map.getOrDefault(curSum-sum, 0);
        //将当前结点的路径和放入前缀和map中
        map.put(curSum, map.getOrDefault(curSum, 0)+1);
        //左右子树中符合情况的结点个数
        res += dfs(node.left, curSum, map);
        res += dfs(node.right, curSum, map);
        //返回上一层, 需要将当前结点对应的根结点开始的路径和的次数-1, 因为已经返回上一层了
        map.put(curSum, map.get(curSum)-1);
        return res;
    }
}
