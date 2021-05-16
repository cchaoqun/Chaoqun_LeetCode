package Tree.tree0408;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Description: 637. 二叉树的层平均值
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。



示例 1：

输入：
    3
   / \
  9  20
    /  \
   15   7
输出：[3, 14.5, 11]
解释：
第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。


提示：

节点值的范围在32位有符号整数范围内。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/8 14:05
 */
public class LC637 {
    //迭代
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            double curAvg = 0.0;
            int size = queue.size();
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                curAvg += node.val;
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            curAvg /= size;
            res.add(curAvg);
        }
        return res;
    }
}
class LC637_M2{
    //每层结点的和
    List<Double> res;
    //每层结点的个数
    List<Integer> size;
    public List<Double> averageOfLevels(TreeNode root) {
        //初始化
        res = new ArrayList<>();
        size = new ArrayList<>();
        //递归
        dfs(root, 0);
        //结果数组
        List<Double> list = new ArrayList<>();
        for(int i=0; i<res.size(); i++){
            //平均值=和/个数
            list.add(res.get(i) / size.get(i));
        }
        return list;
    }

    public void dfs(TreeNode node, int level){
        if(node==null){
            return;
        }
        //第一次到达该层,直接添加
        if(res.size()<=level){
            //这里以double形式存储每层结点值的和,因为相加可能超出int范围
            res.add(node.val*1.0);
            size.add(1);
        }else{
            //不是第一次到达该层,获取该层的数据添加当前结点的值后更新
            res.set(level, res.get(level) + node.val);
            size.set(level, size.get(level)+1);
        }
        //左右递归
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
