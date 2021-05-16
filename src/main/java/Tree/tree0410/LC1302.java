package Tree.tree0410;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Description:1302. 层数最深叶子节点的和
给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。



示例 1：



输入：root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
输出：15
示例 2：

输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：19


提示：

树中节点数目在范围 [1, 104] 之间。
1 <= Node.val <= 100
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/10 23:03
 */
public class LC1302 {
    //迭代
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while(!queue.isEmpty()){
            sum = 0;
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }

        }
        return sum;
    }
}

class LC1302_M2{
    //递归
    private List<Integer> res;
    public int deepestLeavesSum(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 0);
        return res.get(res.size()-1);
    }

    public void dfs(TreeNode node, int level){
        if(node==null){
            return;
        }
        //第一次到达本层
        if(res.size()<=level){
            res.add(node.val);
        }else{
            //获取对应层数的和,并且更新
            res.set(level, res.get(level)+node.val);
        }
        dfs(node.left, level+1);
        dfs(node.right, level+1);

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