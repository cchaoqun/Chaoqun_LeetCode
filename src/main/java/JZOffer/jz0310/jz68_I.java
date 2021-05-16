package JZOffer.jz0310;
/*
 * @Description: 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]





示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。


说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。
注意：本题与主站 235 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/10 11:54
 */
public class jz68_I {

    //迭代
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //保证p.val<q.val
        if(p.val>q.val){
            return lowestCommonAncestor(root, q, p);
        }
        while(root!=null){
            if(root.val>q.val){
                //root.val > q.val > p.val, p q 在左子树
                root = root.left;
            }else if(root.val<p.val){
                //root.val < p.val < q.val p q 在右子树
                root = root.right;
            }else {
                //无论root.val等于pq其中一个结点,或者在pq之间,root已经是最近公共祖先
                break;
            }
        }
        return root;
    }

    //简洁迭代
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        while(root!=null){
//            if((p.val-root.val)*(q.val-root.val)<=0){
//                //pq在异侧或者root=其中一个结点, 当前root为祖先
//                return root;
//            }
//            //否则 p q在同侧,向左右子树寻找
//            root = root.val>p.val? root.left:root.right;
//        }
//        return root;
//    }



    //递归
//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        //pq值都小于root值,在左子树上
//        if(root.val>q.val && root.val > p.val){
//            return lowestCommonAncestor(root.left, p, q);
//        }else if(root.val < p.val && root.val <q.val){
//            //pq值都大于root值,在右子树上
//            return lowestCommonAncestor(root.right, p, q);
//        }
//        //其他情况,当前root为祖先
//        return root;
//    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

