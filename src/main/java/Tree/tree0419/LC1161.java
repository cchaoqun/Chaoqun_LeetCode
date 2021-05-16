package Tree.tree0419;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 *
 * 请你找出层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 *
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 *
 *
 * 提示：
 *
 * 树中的节点数介于 1 和 10^4 之间
 * -10^5 <= node.val <= 10^5
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/19-17:12
 */

public class LC1161 {
    //保存每一层结点和
    List<Integer> level;
    public int maxLevelSum(TreeNode root) {
        this.level = new ArrayList<>();
        dfs(root,0);
        int levelNum = 0;
        int max = Integer.MIN_VALUE;
        //遍历list结合 第一个遇到最大和的层数就是所求的层号
        for(int i=0; i<level.size(); i++){
            if(level.get(i)>max){
                max = level.get(i);
                levelNum = i+1;
            }
        }
        return levelNum;
    }

    public void dfs(TreeNode node, int dep){
        if(node==null){
            return;
        }
        //第一次到达该层直接添加
        if(level.size()<=dep){
            level.add(node.val);
        }else{
            //获取对应层的和并且加上当前结点的值
            level.set(dep, level.get(dep)+node.val);
        }
        dfs(node.left, dep+1);
        dfs(node.right, dep+1);
    }
}

class LC1161_M2{
    //BFS 迭代
    public int maxLevelSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //行号
        int levelNum = 0;
        //最大层数和对应的层号
        int maxLevel = 0;
        //最大层数和的值
        int maxSum = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            levelNum++;
            //当前层的结点值的和
            int curSum = 0;
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                curSum += node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            //当前层数和的值大于之前的最大值更新最大和和层号
            if(curSum > maxSum){
                maxSum = curSum;
                maxLevel = levelNum;
            }
        }
        return maxLevel;
    }
}
