package JZOffer.jz0303;


import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description:剑指 Offer 54. 二叉搜索树的第k大节点
给定一棵二叉搜索树，请找出其中第k大的节点。



示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4


限制：

1 ≤ k ≤ 二叉搜索树元素个数
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 18:52
 */
public class jz54 {

    //迭代
    //全局变量
//    int res, k;
//    public int kthLargest(TreeNode root, int k) {
//        this.k = k;
//        dfs(root);
//        return res;
//    }
//
//    //中序遍历的倒序为递减
//    void dfs(TreeNode root){
//        if(root==null){
//            return;
//        }
//        //先右后左 中序遍历的倒序
//        dfs(root.right);
//        //第k大的结点前面有k-1个结点,每次遍历到一个结点k -= 1
//        k -= 1;
//        //k==0当前结点为第k大的结点
//        if(k==0){
//            //赋值
//            res = root.val;
//            //找到后直接返回
//            return;
//        }
//        dfs(root.left);
//    }

    //迭代 中序遍历倒序
    public int kthLargest(TreeNode root, int k){
        Deque<TreeNode> stack = new LinkedList<>();
        //保存第k大结点的值
        int res = -1;
        while(root!=null || !stack.isEmpty()){
            //找到最右叶子结点
            while(root!=null){
                stack.push(root);
                root = root.right;
            }
            root = stack.pop();
            //遇到一个结点 k-=1
            k -= 1;
            //判断是否为0
            if(k==0){
                res = root.val;
                return res;
            }
            //找左子节点
            root = root.left;
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

