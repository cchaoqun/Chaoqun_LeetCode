package Tree.tree0409;
/*
 * @Description:572. 另一个树的子树
给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

示例 1:
给定的树 s:

     3
    / \
   4   5
  / \
 1   2
给定的树 t：

   4
  / \
 1   2
返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。

示例 2:
给定的树 s：

     3
    / \
   4   5
  / \
 1   2
    /
   0
给定的树 t：

   4
  / \
 1   2
返回 false。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/9 17:44
 */
public class LC572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null){
            return false;
        }
        //先比较当前结点 再比较左右子树
        return dfs(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t);


    }

    //比较 s t 两棵树是否相同
    public boolean dfs(TreeNode s, TreeNode t){
        //都为null
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null || s.val!=t.val){
            return false;
        }
        //s.val == t.val  比较左右子树
        return dfs(s.left,t.left) && dfs(s.right, t.right);

    }
}
