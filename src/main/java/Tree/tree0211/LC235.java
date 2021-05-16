package Tree.tree0211;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 235. 二叉搜索树的最近公共祖先
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
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 11:17
 */
public class LC235 {

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        TreeNode ancestor = root;
//        while(true){
//            //如果两个结点的值都小于当前的父节点,则两个结点都在当前结点的左子树上
//            //当其中一个等于当前结点或者刚好一个大于一个小于当前结点说明当前结点为最近的公共祖先
//            if(p.val<ancestor.val && q.val<ancestor.val){
//                ancestor = ancestor.left;
//            }else if(p.val> ancestor.val && q.val> ancestor.val){
//                //都大于则为右子树的情况,同理
//                ancestor = ancestor.right;
//            }else{
//                break;
//            }
//        }
//        return ancestor;
//    }

    //两次遍历,先获取p q结点从根结点到结点的路径添加到list集合
    //依次比较,最后一个相同的结点为最近的公共祖先结点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        List<TreeNode> pPath = new ArrayList<>();
        List<TreeNode> qPath = new ArrayList<>();
        getPath(root, p.val, pPath);
        getPath(root, q.val, qPath);
        TreeNode ancestor = root;
        for(int i=0; i<pPath.size() && i<qPath.size(); i++){
            if (pPath.get(i)== qPath.get(i)){
                ancestor = pPath.get(i);
            }else{
                break;
            }
        }
        return ancestor;

    }

    //获取从根结点到目标节点的路径
    public void getPath(TreeNode root, int target, List<TreeNode> path){
        while(root.val != target){
            path.add(root);
            if(target<root.val){
                root = root.left;
            } else {
                root = root.right;
            }
        }
        //将目标结点添加到list
        path.add(root);
    }


}
