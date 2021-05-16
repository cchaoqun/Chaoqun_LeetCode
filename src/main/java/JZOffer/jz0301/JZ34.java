package JZOffer.jz0301;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 剑指 Offer 34. 二叉树中和为某一值的路径
输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。



示例:
给定如下二叉树，以及目标和 sum = 22，

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
 * @date 2021/3/1 18:34
 */
public class JZ34 {

    //结果
    List<List<Integer>> res = new ArrayList<>();
    //路径
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root,sum);
        return res;
    }

    //dfs1
//    void dfs(TreeNode node,  int target){
//        if(node==null){
//            return;
//        }
//        //当前结点值添加到路径
//        path.add(node.val);
//        //目标值减去当前结点值为剩余所需要的和
//        target -= node.val;
//        if(node.left==null && node.right==null && target == 0){
//            //当前结点为叶子结点并且目标为0
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        //左右子树递归
//        //这里需要确保左右子节点不为0,否则如果为null下一层返回来时,路径并没有改变,但是后续有重置操作,
//        //因此需要添加条件确保有枝可剪
//        if(node.left!=null){
//            dfs(node.left,target);
//            //重置
//            path.remove(path.size()-1);
//        }
//        if(node.right!=null){
//            dfs(node.right,target);
//            //重置
//            path.remove(path.size()-1);
//        }
//    }

    //dfs2
    void dfs(TreeNode node,  int target){
        if(node==null){
            return;
        }
        //当前结点值添加到路径
        path.add(node.val);
        //目标值减去当前结点值为剩余所需要的和
        target -= node.val;
        if(node.left==null && node.right==null && target == 0){
            //当前结点为叶子结点并且目标为0
            res.add(new ArrayList<>(path));
            //这里没有ruturn,可以让后续的重置操作减掉当前添加进去的结点值
            //所以这里找到路径后有无返回决定了后续递归前是否需要进行判断
            //return
        }
        //左右子树递归
        //这里不需要进行判断,因为找到目标后并没有返回
        dfs(node.left, target);
        dfs(node.right, target);
        path.remove(path.size()-1);
    }
}
