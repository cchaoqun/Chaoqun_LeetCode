package JZOffer.jz0301;

import java.util.*;

/*
 * @Description: 剑指 Offer 32 - I. 从上到下打印二叉树
从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]


提示：

节点总数 <= 1000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/1 16:15
 */
public class JZ32 {

    public int[] levelOrder(TreeNode root) {
        //根结点为空,返回空数组
        if(root==null){
            return new int[0];
        }
        //List存储结点值
        List<Integer> res = new ArrayList<>();
        //维护队列
        Queue<TreeNode> queue = new LinkedList<>();
        //每次将结点添加值队列最后
        queue.add(root);
        while(!queue.isEmpty()){
            //出队头结点
            TreeNode node = queue.poll();
            //结点值添加到list集合
            res.add(node.val);
            //左右 子节点不为空时添加到队列的最后
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        int[] arr = new int[res.size()];
        for(int i=0; i<res.size(); ++i){
            arr[i] = res.get(i);
        }
        return arr;
    }
}
