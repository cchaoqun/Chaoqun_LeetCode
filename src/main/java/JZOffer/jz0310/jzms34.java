package JZOffer.jz0310;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 面试题34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



示例:
给定如下二叉树，以及目标和 target = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]


提示：

节点总数 <= 10000
注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/10 12:26
 */
public class jzms34 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum){
        dfs(root, sum);
        return res;
    }

    void dfs(TreeNode node, int sum){
        if(node==null){
            return;
        }
        //当前结点值加入路径
        path.add(node.val);
        //sum-node.val
        sum -= node.val;
        //判断是否满足条件
        if(sum==0 && node.left==null && node.right==null){
            res.add(new ArrayList<>(path));
            //这里没有ruturn,可以让后续的重置操作减掉当前添加进去的结点值

        }
        dfs(node.left, sum);
        dfs(node.right, sum);
        //当前添加的node.val在这里剪枝重置
        path.remove(path.size()-1);
    }
}
