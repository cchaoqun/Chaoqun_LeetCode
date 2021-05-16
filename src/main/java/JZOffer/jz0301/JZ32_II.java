package JZOffer.jz0301;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 剑指 Offer 32 - II. 从上到下打印二叉树 II
从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。



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
  [9,20],
  [15,7]
]


提示：

节点总数 <= 1000
注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/1 16:27
 */
public class JZ32_II {

    //迭代
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> res = new ArrayList<>();
//        if(root==null){
//            return res;
//        }
//        //维护队列
//        Queue<TreeNode> queue = new LinkedList<>();
//        //根结点入队
//        queue.add(root);
//        while(!queue.isEmpty()){
//            //cur存放本层的结点值
//            List<Integer> cur = new ArrayList<>();
//            //决定了本层的结点个数,只需要出队size个结点即可
//            int size = queue.size();
//            for(int i=0; i<size; ++i){
//                //出队一个结点
//                TreeNode node = queue.poll();
//                //结点值添加到本层的list集合
//                cur.add(node.val);
//                //左右子节点非空时入队
//                if(node.left!=null){
//                    queue.add(node.left);
//                }
//                if(node.right!=null){
//                    queue.add(node.right);
//                }
//            }
//            //本层结点全部出队后,将本层list集合添加到res中
//            res.add(cur);
//        }
//        return res;
//    }

    //递归
    //存放结果的list集合
    private List<List<Integer>> res =  new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root){
        //根结点为空
        if(root==null){
            return res;
        }
        dfs(0, root);
        return res;
    }

    public void dfs(int depth, TreeNode node){
        //空节点返回
        if(node==null){
            return;
        }
        //如果当前深度与res大小相同说明第一次到达这一层,需要创建一个新list存放本层的结点值
        if(depth==res.size()){
            res.add(new ArrayList<>());
        }
        //获取该结点对应层数的res中的list集合,并将数据存放进去
        res.get(depth).add(node.val);
        //先递归左子节点
        dfs(depth+1, node.left);
        //再递归右子节点
        dfs(depth+1, node.right);
    }
}
