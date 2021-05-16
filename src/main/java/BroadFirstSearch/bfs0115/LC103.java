package BroadFirstSearch.bfs0115;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Description: 103. 二叉树的锯齿形层序遍历
给定一个二叉树，返回其节点值的锯齿形层序遍历。
（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层序遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 11:55
 */
public class LC103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        //记录当前的层数 level = odd 从左到右, level = even 从右到左
        //要求 odd层的从右往左入队子结点
        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        //根结点入队
        queue.offer(root);
        while(!queue.isEmpty()){
            //记录当前层的结点个数
            int size = queue.size();
            //创建list集合记录当前层的结点值
            List<Integer> subList = new ArrayList<>();
            for(int i=0; i<size; i++){
                //头结点出队
                TreeNode node = queue.poll();
                //结点值添加到集合
                if(level%2!=0){
                    //判断当前层数,如果是odd,将结点值按顺序添加到subList
                    subList.add(node.val);

                }else{
                    //如果是even,将结点值总是添加到subList的第一个位置,这样就是从右到左
                    subList.add(0,node.val);
                }
                //始终先左后右,只需在偶数层修改添加结点值的顺序
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            //当前层结点遍历结束将当前层的list添加到结果list中
            list.add(subList);
            //level+1
            level++;
        }
        return list;
    }

    //DFS
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
//        List<List<Integer>> list = new ArrayList<>();
//        dfs(root,1,list);
//        return list;
//    }
//
//    public void dfs(TreeNode node, int level, List<List<Integer>> list){
//        if(node==null){
//            return;
//        }
//        //如果level大于list.size() level从1开始, 第一次到达该层
//        if(level>list.size()){
//            list.add(new ArrayList<Integer>());
//        }
//        //判断层数确定将结点添加到对应list的list的顺序
//        if(level%2==0){
//            //偶数层,需要从右到左添加元素,遍历结点的顺序是从左到右,
//            //所以每次都把结点添加到list的第一个位置
//            //level-1对应了该层的list集合在list中的位置
//            list.get(level-1).add(0,node.val);
//        }else{
//            //奇数层,按顺序从左到右依次将结点值添加到list的末尾即可
//            list.get(level-1).add(node.val);
//        }
//        dfs(node.left,level+1,list);
//        dfs(node.right, level+1, list);
//    }
}


//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
