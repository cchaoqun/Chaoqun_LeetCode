package Tree.tree0211;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”



示例 1：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
示例 2：


输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
示例 3：

输入：root = [1,2], p = 1, q = 2
输出：1


提示：

树中节点数目在范围 [2, 105] 内。
-109 <= Node.val <= 109
所有 Node.val 互不相同 。
p != q
p 和 q 均存在于给定的二叉树中。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 12:34
 */
public class LC236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        getPath(root,p.val,pPath);
        getPath(root,q.val,qPath);
        TreeNode ancestor = root;
        //路径中最后一个相同的结点为最近的祖先结点
        for(int i=0; i<pPath.size() && i<qPath.size(); ++i){
            if(pPath.get(i)==qPath.get(i)){
                ancestor = pPath.get(i);
            }else{
                break;
            }
        }
        return ancestor;

    }

    //获取路径,回溯
    public void getPath(TreeNode root, int target, List<TreeNode> path){
        path.add(root);
        //返回条件
        //到达空节点或者当前结点的值等于目标结点的值
        if( root==null || root.val==target){
            return;
        }
        //左子树递归
        getPath(root.left,target,path);
        //回溯后,如果路径中最后一个结点为空或者值与目标值不等,则删除最后一个
        if(path.get(path.size()-1) == null || path.get(path.size()-1).val!=target){
            //重置
            path.remove(path.size()-1);
        }
        //右子树递归
        getPath(root.right,target,path);
        if(path.get(path.size()-1) == null || path.get(path.size()-1).val!=target){
            //重置
            path.remove(path.size()-1);
        }
    }

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
//        //如果当前结点为空或者为p q中的一个则返回当前结点
//        if(root==null || root==p || root==q){
//            return root;
//        }
//        //递归
//        TreeNode left = lowestCommonAncestor(root.left,p,q);
//        TreeNode right = lowestCommonAncestor(root.right,p,q);
//        //如果左右子节点都为空,则返回空节点
//        //如果左右子节点一个为空则返回另一个,p q在不为空的分支上
//        if(left==null){
//            return right;
//        }
//        if(right==null){
//            return left;
//        }
//        //如果左右子节点都不为空,则p q分别当前结点的两边,当前结点为最近公共祖先
//        return root;
//
//
//    }
}
