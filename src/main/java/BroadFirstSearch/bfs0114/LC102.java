package BroadFirstSearch.bfs0114;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 102. 二叉树的层序遍历
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层序遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/14 22:22
 */
public class LC102 {
    //BFS
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> list = new ArrayList<>();
//        if(root == null){
//            return list;
//        }
//        //维护队列按层遍历二叉树
//        Queue<TreeNode> queue = new LinkedList<>();
//        //根结点入队
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            //记录每层结点个数
//            int size = queue.size();
//            //创建集合list记录每层结点的值
//            List<Integer> subList = new ArrayList<>();
//            for(int i=0; i<size; i++){
//                //头结点出队
//                TreeNode node = queue.poll();
//                //结点值加入集合
//                subList.add(node.val);
//                //左子节点先入队
//                if(node.left!=null){
//                    queue.offer(node.left);
//                }
//                if(node.right!=null){
//                    queue.offer(node.right);
//                }
//            }
//            //该层结点从左至右遍历结束,将对应结点值的集合添加到结果集合
//            list.add(subList);
//        }
//        return list;
//    }

    //DFS
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        dfs(root,1,list);
        return list;
    }

    public void dfs(TreeNode node, int depth, List<List<Integer>> list){
        if(node == null){
            return;
        }
        //depth 从1开始 list.size()初始为0
        //depth > list.size() 说明第一次达到该层,则需要新建一个list集合添加进来用于保存该层的结点值
        if(depth > list.size()){
            list.add(new ArrayList<Integer>());
        }
        //获取该层的记录结点值的集合并将当前结点的值添加到集合的最后
        list.get(depth-1).add(node.val);
        //向左子结点递归
        dfs(node.left, depth+1, list);
        //向右子节点递归
        dfs(node.right, depth+1, list);
    }


}
