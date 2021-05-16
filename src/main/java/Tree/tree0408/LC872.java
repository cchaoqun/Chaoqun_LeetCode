package Tree.tree0408;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @Description: 872. 叶子相似的树
请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。



举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。



示例 1：



输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
输出：true
示例 2：

输入：root1 = [1], root2 = [1]
输出：true
示例 3：

输入：root1 = [1], root2 = [2]
输出：false
示例 4：

输入：root1 = [1,2], root2 = [2,2]
输出：true
示例 5：



输入：root1 = [1,2,3], root2 = [1,3,2]
输出：false


提示：

给定的两棵树可能会有 1 到 200 个结点。
给定的两棵树上的值介于 0 到 200 之间。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/8 15:27
 */
public class LC872 {
    //递归
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //两个数对应叶子结点从左到右值的集合
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        //获取叶子结点的值
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        //如果数量不等一定不相似
        if(leaf1.size()!=leaf2.size()){
            return false;
        }
        //依次比较叶子结点的值
        for(int i=0; i<leaf1.size(); i++){
            if(leaf1.get(i)!=leaf2.get(i)){
                return false;
            }
        }
        return true;
    }

    //先序遍历, 获取二叉树的叶子结点从左到右的值
    public void dfs(TreeNode node, List<Integer> leaf){
        if(node==null){
            return;
        }
        //判断叶子结点, 值添加到leaf集合中
        if(node.left==null && node.right==null){
            leaf.add(node.val);
            return;
        }
        //递归遍历左右子树
        dfs(node.left, leaf);
        dfs(node.right, leaf);
    }
}

class LC872_M2{
    //迭代, 后序遍历
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //两个数对应的叶子结点集合
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        //层序遍历两颗数获得叶子结点值的集合
        bfs(root1, leaf1);
        bfs(root2, leaf2);
        //如果数量不等一定不相似
        if(leaf1.size()!=leaf2.size()){
            return false;
        }
        //按顺序从左到右比较叶子结点的值
        for(int i=0; i<leaf1.size(); i++){
            if(leaf1.get(i)!=leaf2.get(i)){
                return false;
            }
        }
        return true;

    }

    public void bfs(TreeNode node, List<Integer> leaf){
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        while(node!=null || !stack.isEmpty()){
            //先左子节点
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            //当前结点
            node = stack.pop();
            //当前结点为叶子结点
            if(node.left==null && node.right==null){
                prev = node;
                leaf.add(node.val);
                //这样可以返回上一层
                node = null;
            }else if(node.right!=null && prev!=node.right){
                //当前结点右子节点还没被遍历,后续遍历需要遍历完右子树才能遍历当前结点
                //当前结点重新压入栈
                stack.push(node);
                //遍历右子节点
                node = node.right;
            }else{
                //当前结点右子节点已经遍历过了或者右子节点为空,遍历当前结点
                //前驱结点移到当前结点
                prev = node;
                //返回上一层
                node = null;
            }
        }

    }
}