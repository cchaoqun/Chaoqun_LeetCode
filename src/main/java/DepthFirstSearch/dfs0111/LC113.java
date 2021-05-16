package DepthFirstSearch.dfs0111;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 113. 路径总和 II
 *
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
说明:叶子节点是指没有子节点的节点。
*
示例:
给定如下二叉树，以及目标和sum = 22，

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

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/path-sum-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/11 18:31
 */
public class LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        dfs(root,list,path,sum);
        return list;
    }

    //不重置path
//    public void dfs(TreeNode node, List<List<Integer>> list, List<Integer> path, int sum){
//        if(node==null){
//            return;
//        }
//        //当前结点值添加到路径
//        path.add(node.val);
//        //如果当前结点为叶子结点
//        if(node.left==null && node.right==null){
//            if(sum==node.val){
//                list.add(path);
//                return;
//            }
//        }
//        //向左右子节点递归
//        dfs(node.left, list, new ArrayList<>(path), sum-node.val);
//        dfs(node.right, list, new ArrayList<>(path), sum-node.val);
//    }
    //每次重置path,遇到符合情况的才copy
    public void dfs(TreeNode node, List<List<Integer>> list, List<Integer> path, int sum){
        if(node==null){
            return;
        }
        //当前结点值添加到路径
        path.add(node.val);
        //如果当前结点为叶子结点
        if(node.left==null && node.right==null){
            if(sum==node.val){
                // path 全局只有一份，必须做拷贝
                list.add(new ArrayList<>(path));
                //注意：这里 return 之前必须重置
                path.remove(path.size()-1);
                return;
            }
        }
        //向左右子节点递归
        dfs(node.left, list, path, sum-node.val);
        dfs(node.right, list, path, sum-node.val);
        //递归完 重置
        path.remove(path.size()-1);
    }

//    //BFS
//    public List<List<Integer>> pathSum(TreeNode root, int sum){
//        List<List<Integer>> list = new ArrayList<>();
//        if(root==null){
//            return list;
//        }
//        //创建两个队列 一个结点队列,一个路径队列
//        Queue<TreeNode> nodeQueue = new LinkedList<>();
//        Queue<List<Integer>> pathQueue = new LinkedList<>();
//        //根结点以及路劲入队列
//        nodeQueue.add(root);
//        List<Integer> path = new ArrayList<>();
//        path.add(root.val);
//        pathQueue.add(path);
//        while(!nodeQueue.isEmpty()){
//            //出队
//            TreeNode node = nodeQueue.poll();
//            List<Integer> temp = pathQueue.poll();
//            //满足条件
//            if(node.val==sum && node.left==null && node.right==null){
//                list.add(new ArrayList<>(temp));
//            }
//            if(node.left!=null){
//                temp.add(node.left.val);
//                pathQueue.add(new ArrayList<>(temp));
//                node.left.val += node.val;
//                nodeQueue.add(node.left);
//                //重置
//                temp.remove(temp.size()-1);
//            }
//            if(node.right!=null){
//                temp.add(node.right.val);
//                pathQueue.add(new ArrayList<>(temp));
//                node.right.val += node.val;
//                nodeQueue.add(node.right);
//                //重置
//                temp.remove(temp.size()-1);
//            }
//        }
//        return list;
//    }
}
