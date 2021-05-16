package Tree.tree0417;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description:
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/17 18:24
 */
public class LC1123 {
    //需要返回的祖先结点
    TreeNode res = null;
    //之前祖先结点的最大深度
    int max = 0;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 1);
        return res;
    }
    public int dfs(TreeNode node, int dep){
        if(node==null){
            return dep;
        }
        //左右子树的深度
        int left = dfs(node.left, dep+1);
        int right = dfs(node.right, dep+1);
        //如果左右子树深度相等 并且子树的深度大于等于之前的最大深度, 当前结点为最深的祖先结点 并更新最大深度
        if(left==right && left>=max){
            res = node;
            max = left;
        }
        //左右子树深度不同,最深的叶子结点一定在深度较大的那一个子树当中
        return Math.max(left, right);
    }
}
class LC1123_M2{
    //缓存 key=node values=node所处的深度
    Map<TreeNode, Integer> map = new HashMap<>();
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root==null){
            return null;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left==right){
            return root;
        }
        if(left>right){
            return lcaDeepestLeaves(root.left);
        }else{
            return lcaDeepestLeaves(root.right);
        }

    }

    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        //如果存在直接返回深度
        if(map.containsKey(node)){
            return map.get(node);
        }
        //左右子树的最大深度
        int left = dfs(node.left);
        int right = dfs(node.right);
        //当前结点为根的树的最大深度
        int curDep = Math.max(left, right)+1;
        //当前结点即最大深度放入缓存
        map.put(node, curDep);
        return curDep;
    }
}