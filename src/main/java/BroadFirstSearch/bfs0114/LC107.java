package BroadFirstSearch.bfs0114;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @Description: 107. 二叉树的层序遍历 II
给定一个二叉树，返回其节点值自底向上的层序遍历。
（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其自底向上的层序遍历为：

[
  [15,7],
  [9,20],
  [3]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/14 16:54
 */
public class LC107 {

    //利用队列 BFS
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        if(root == null){
//            return list;
//        }
//        //维护一个队列
//        Queue<TreeNode> queue = new LinkedList<>();
//        //根结点入队
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            //本层结点个数
//            int size = queue.size();
//            //创建本层对应的list集合,存储结点的值
//            List<Integer> subList = new ArrayList<>();
//            //从左到右遍历本层的结点
//            while(size>0){
//                //头结点出队
//                TreeNode node = queue.poll();
//                //将结点的值添加到list集合中
//                subList.add(node.val);
//                //将结点的左右子节点入队, 先左后右,这样保证出队也是先左后右
//                if(node.left!=null){
//                    queue.add(node.left);
//                }
//                if(node.right!=null){
//                    queue.add(node.right);
//                }
//                size--;
//            }
//            //遍历完本层,将本层结点值的list添加到结果list中的第一个位置
//            list.add(0,subList);
//        }
//        return list;
//    }

    //DFS
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        ArrayList<List<Integer>> list = new ArrayList<>();
        dfs(root,1,list);
        Collections.reverse(list);
        return list;
    }

    public void dfs(TreeNode node, int depth, ArrayList<List<Integer>> list){
        if(node == null){
            return;
        }
        //depth start from 1 size() start from 0
        if(depth > list.size()){
            //第一次达到该层,新建一个list,并且添加到第一个位置
            list.add(new ArrayList<Integer>());
        }
        //获取该结点对应的层数的list集合,并将结点值添加到集合
        list.get(depth-1).add(node.val);
        //向左递归
        dfs(node.left,depth+1, list);
        //向右递归
        dfs(node.right,depth+1, list);
    }
}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

