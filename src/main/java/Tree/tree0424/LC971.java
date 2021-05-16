package Tree.tree0424;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 971. 翻转二叉树以匹配先序遍历
 * 给你一棵二叉树的根节点 root ，树中有 n 个节点，每个节点都有一个不同于其他节点且处于 1 到 n 之间的值。
 *
 * 另给你一个由 n 个值组成的行程序列 voyage ，表示 预期 的二叉树 先序遍历 结果。
 *
 * 通过交换节点的左右子树，可以 翻转 该二叉树中的任意节点。例，翻转节点 1 的效果如下：
 *
 *
 * 请翻转 最少 的树中节点，使二叉树的 先序遍历 与预期的遍历行程 voyage 相匹配 。
 *
 * 如果可以，则返回 翻转的 所有节点的值的列表。你可以按任何顺序返回答案。如果不能，则返回列表 [-1]。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,2], voyage = [2,1]
 * 输出：[-1]
 * 解释：翻转节点无法令先序遍历匹配预期行程。
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3], voyage = [1,3,2]
 * 输出：[1]
 * 解释：交换节点 2 和 3 来翻转节点 1 ，先序遍历可以匹配预期行程。
 * 示例 3：
 *
 *
 * 输入：root = [1,2,3], voyage = [1,2,3]
 * 输出：[]
 * 解释：先序遍历已经匹配预期行程，所以不需要翻转节点。
 *
 *
 * 提示：
 *
 * 树中的节点数目为 n
 * n == voyage.length
 * 1 <= n <= 100
 * 1 <= Node.val, voyage[i] <= n
 * 树中的所有值 互不相同
 * voyage 中的所有值 互不相同
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/24-22:07
 */

public class LC971 {
    int[] arr;
    List<Integer> res;
    boolean isReversed;
    int index;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.arr = voyage;
        this.isReversed = true;
        this.index = 0;
        this.res = new ArrayList<>();
        dfs(root);
        if(!isReversed){
            res.clear();
            res.add(-1);
        }
        return res;
    }

    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        //当前结点不等则一定不存在
        //这里每次都会比较一次, 即便不成立index仍然++
        if(node.val!=arr[index++]){
            isReversed = false;
            res.clear();
            res.add(-1);
            return;
        }
        //左子节点不等于数组里下一个遍历的值. 则遍历右子节点代替翻转
        if(index<arr.length && node.left!=null && node.left.val!=arr[index]){
            res.add(node.val);
            dfs(node.right);
            dfs(node.left);
        }else{
            dfs(node.left);
            dfs(node.right);
        }

    }
}

class LC971_M2{
    //BFS
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {

        List<Integer> res = new ArrayList<>();
        if(root==null){
            res.add(-1);
            return res;
        }
        int index = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            //比较当前结点的值是否匹配先序遍历数组对应值
            if(node.val!=voyage[index++]){
                res.clear();
                res.add(-1);
                return res;
            }
            //左子节点值不等于先序遍历下一个遍历的值
            //下一个遍历右子树代替左右子树的翻转
            if(index<voyage.length && node.left!=null && node.left.val!=voyage[index]){
                res.add(node.val);
                if(node.left!=null){
                    stack.push(node.left);
                }
                if(node.right!=null){
                    stack.push(node.right);
                }
            }else{
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }
            }
        }
        return res;

    }
}
