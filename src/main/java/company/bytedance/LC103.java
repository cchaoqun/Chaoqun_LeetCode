package company.bytedance;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-12:13
 */

public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /**
         偶数层 0 2 4
         左 --> 右 遍历本层结点 先左子节点后右子节点
         奇数层 1 3 5
         右 --> 左 先右子节点后左子节点
         具体实现
         不论那一层 都先左后右加入队列
         偶数层 addLast到list
         奇数层 addFirst到list
         */
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            //当前层遍历的结果
            LinkedList<Integer> curList = new LinkedList<>();
            for(int i=queue.size(); i>0; i--){
                TreeNode curNode = queue.poll();
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
                //偶数层 左到右 addLast
                if(level==0){
                    curList.addLast(curNode.val);
                }else{
                    //奇数层 右到左 addFirst
                    curList.addFirst(curNode.val);
                }
            }
            list.add(curList);
            level ^= 1 ;
        }
        return list;
    }
}
