package JZOffer.jz0301;

import java.util.*;

/*
 * @Description: 剑指 Offer 32 - III. 从上到下打印二叉树 III
请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。



例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [20,9],
  [15,7]
]


提示：

节点总数 <= 1000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/1 16:45
 */
public class JZ32_III {

    //迭代,奇数层将按顺序添加的列表reverse即可
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            //代表目前出队结点所在的层数 0~二叉树层数
            //偶数数层从左到右，奇数层从右到左
            int depth = res.size();
            List<Integer> cur = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size; ++i){
                TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
                cur.add(node.val);
            }
            if(depth%2 !=0){
                //奇数层需要从右向左遍历
                Collections.reverse(cur);
            }
            res.add(cur);
        }
        return res;
    }


    //迭代,双端队列,判断奇偶层,层数0~  奇数层: 左<-右 偶数层: 左->右
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if(root==null){
//            return res;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()){
//            //代表目前出队结点所在的层数 0~二叉树层数
//            //偶数数层从左到右，奇数层从右到左
//            int depth = res.size();
//            //双端队列,可以在队列两端操作
//            LinkedList<Integer> cur = new LinkedList<>();
//            int size = queue.size();
//            for(int i=0; i<size; ++i){
//                TreeNode node = queue.poll();
//                if(node.left!=null){
//                    queue.add(node.left);
//                }
//                if(node.right!=null){
//                    queue.add(node.right);
//                }
//                //奇数层左 <- 右
//                if(depth%2 != 0){
//                    cur.addFirst(node.val);
//                }else{
//                    //偶数层 左 -> 右
//                    cur.addLast(node.val);
//                }
//            }
//            res.add(cur);
//        }
//        return res;
//    }

    //不判断奇偶层,连着打印两行,先偶后奇数 0,1  2,3 ..., 偶数层打印完需要判断队列是否空
//    public List<List<Integer>> levelOrder(TreeNode root){
//        List<List<Integer>> res = new ArrayList<>();
//        if(root==null){
//            return res;
//        }
//        Deque<TreeNode> deque = new LinkedList<>();
//        deque.addLast(root);
//        while(!deque.isEmpty()){
//            //当前层列表
//            List<Integer> cur = new ArrayList<>();
//            for(int i=deque.size(); i>0; --i){
//                //偶数层,左->右
//                TreeNode node = deque.removeFirst();
//                cur.add(node.val);
//                //先左后右加入下一层结点
//                if(node.left!=null){
//                    deque.addLast(node.left);
//                }
//                if(node.right!=null) {
//                    deque.addLast(node.right);
//                }
//            }
//            //当前层列表集合添加到list
//            res.add(cur);
//            //判断是否为二叉树的最后一层
//            if(deque.isEmpty()){
//                break;
//            }
//            //下一层
//            List<Integer> next = new ArrayList<>();
//            for(int i=deque.size(); i>0; --i){
//                //奇数层 左<-右
//                TreeNode node = deque.removeLast();
//                next.add(node.val);
//                //先右后左加入下一层结点,并且结点添加在双端队列的头部
//                //保证了下一层按顺序出队,就是原本从左往右的顺序
//                if(node.right!=null){
//                    deque.addFirst(node.right);
//                }
//                if(node.left!=null){
//                    deque.addFirst(node.left);
//                }
//
//            }
//            //下一层列表集合添加到list
//            res.add(next);
//        }
//        return res;
//    }
}
