package Tree.tree0419;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *515. 在每个树行中找最大值
 * 您需要在二叉树的每一行中找到最大的值。
 *
 * 示例：
 *
 * 输入:
 *
 *           1
 *          / \
 *         3   2
 *        / \   \
 *       5   3   9
 *
 * 输出: [1, 3, 9]
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/19-17:58
 */

public class LC515 {
    //BFS
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int curMax = Integer.MIN_VALUE;
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                curMax = Math.max(curMax, node.val);
            }
            list.add(curMax);
        }
        return list;
    }
}

class LC515_M2{
    //DFS
    List<Integer> list;
    public List<Integer> largestValues(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, 0);
        return list;
    }

    public void dfs(TreeNode node, int dep){
        if(node==null){
            return;
        }
        //第一次到达该层
        if(list.size()<=dep){
            //该层还没有元素,当前结点值为本层最大
            list.add(node.val);
        }else{
            //当前结点对应层已经有之前比较后的较大值, 重置为两者中较大的
            list.set(dep, Math.max(list.get(dep), node.val));
        }
        dfs(node.left, dep+1);
        dfs(node.right, dep+1);
    }
}