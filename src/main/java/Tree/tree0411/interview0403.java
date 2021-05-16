package Tree.tree0411;






import Math.math0205.LC2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Description: 面试题 04.03. 特定深度节点链表
给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。



示例：

输入：[1,2,3,4,5,null,7,8]

        1
       /  \
      2    3
     / \    \
    4   5    7
   /
  8

输出：[[1],[2,3],[4,5,7],[8]]
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/11 19:43
 */
public class interview0403 {
    //BFS
    public ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> list = new ArrayList<>();
        if(tree==null){
            return new ListNode[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        while(!queue.isEmpty()){
            //创建每层的链表
            ListNode head = new ListNode(0);
            ListNode cur = head;
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                cur.next = new ListNode(node.val);
                cur = cur.next;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.add(head.next);
        }
        ListNode[] res = new ListNode[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
