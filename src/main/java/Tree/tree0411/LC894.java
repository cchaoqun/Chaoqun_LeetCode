package Tree.tree0411;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description:
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/11 20:24
 */
public class LC894 {
    //递归
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        dfs(n, ans);
        return ans;
    }

    //当前N个结点可以构建的数 放入ans集合
    public void dfs(int N, List<TreeNode> ans){
        //只有一个结点, 只能创建一个结点 放入ans并返回
        if(N==1){
            ans.add(new TreeNode(0));
            return;
        }
        //子树的结点只可能是奇数个 1, 3, 5 ...
        //i为左子树的个数 N-i-1为右子树的个数 i每次递增2
        for(int i=1; i<N-1; i+=2){
            List<TreeNode> left = new ArrayList<>();
            List<TreeNode> right = new ArrayList<>();
            //构建左右子树
            dfs(i, left);
            dfs(N-i-1, right);
            //遍历每一种可能的组合 并创建对应的树放入ans集合
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
    }
}
