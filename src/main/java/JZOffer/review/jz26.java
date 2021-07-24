package JZOffer.review;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**剑指 Offer 26. 树的子结构
 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)

 B是A的子结构， 即 A中有出现和B相同的结构和节点值。

 例如:
 给定的树 A:

 3
 / \
 4   5
 / \
 1   2
 给定的树 B：

 4
 /
 1
 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。

 示例 1：

 输入：A = [1,2,3], B = [3,1]
 输出：false
 示例 2：

 输入：A = [3,4,5,1,2], B = [4,1]
 输出：true
 限制：

 0 <= 节点个数 <= 10000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-12:17
 */

public class jz26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null ||B==null){
            return false;
        }
        return recur(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean recur(TreeNode A, TreeNode B){
        if(B==null){
            return true;
        }
        if(A==null || A.val!=B.val){
            return false;
        }
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}

class jz26_M2{
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null){
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(A);
        boolean res = false;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur.val==B.val){
                res = res || check(cur, B);
            }
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
        }
        return res;
    }

    private boolean check(TreeNode A, TreeNode B){
        Queue<TreeNode> a = new LinkedList<>();
        Queue<TreeNode> b = new LinkedList<>();
        a.offer(A);
        b.offer(B);
        while(!a.isEmpty()&&!b.isEmpty()){
            TreeNode cur1 = a.poll();
            TreeNode cur2 = b.poll();
            if(cur1==null || cur1.val!=cur2.val){
                return false;
            }
            if(cur2.left!=null){
                b.offer(cur2.left);
                a.offer(cur1.left);
            }
            if(cur2.right!=null){
                b.offer(cur2.right);
                a.offer(cur1.right);
            }
        }
        return true;
    }
}
