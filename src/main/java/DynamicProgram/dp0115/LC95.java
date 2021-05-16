package DynamicProgram.dp0115;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 95. 不同的二叉搜索树 II*
给定一个整数 n，生成所有由 1 ...n 为节点所组成的 二叉搜索树 。

示例：
输入：3
输出：
[
 [1,null,3,2],
 [3,2,null,1],
 [3,1,null,null,2],
 [2,1,3],
 [1,null,2,null,3]
]
解释：
以上的输出对应以下 5 种不同结构的二叉搜索树：

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


提示：
0 <= n <= 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/15 18:00
 */
public class LC95 {
    //dfs
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            List<TreeNode> list = new ArrayList<>();
            return list;
        }
        return dfs(1,n);
    }
    //dfs
    /*
     * @Description:构建 left~right 范围内所有可能的二叉搜索树
     *
     * @param left 左子树的值为 1~left
     * @param right 右子树的值为 right~n
     */
    public List<TreeNode> dfs(int left, int right){
        List<TreeNode> list = new ArrayList<>();
        if(left>right){
            list.add(null);
            return list;
        }
        if(left==right){
            list.add(new TreeNode(left));
            return list;
        }
        for(int i=left; i<=right; i++){
            //左递归
            List<TreeNode> leftTree = dfs(left,i-1);
            //右递归
            List<TreeNode> rightTree = dfs(i+1, right);
            //从左右子树的情况中挑一个出来组合
            for(TreeNode lTree:leftTree){
                for(TreeNode rTree:rightTree){
                    //根结点
                    TreeNode node = new TreeNode(i);
                    node.left = lTree;
                    node.right = rTree;
                    list.add(node);
                }
            }
        }
        return list;
    }

    //dp
//    public List<TreeNode> generateTrees(int n){
//        List<TreeNode>[] dp = new ArrayList[n+1];
//        dp[0] = new ArrayList<>();
//        if(n==0){
//            return dp[0];
//        }
//        dp[0].add(null);
//        for(int i=1; i<n+1; i++){
//            //当前长度的可能的数的集合
//            dp[i] = new ArrayList<>();
//            //让每个值都作为数的根结点
//            for(int j=1; j<=i; j++){
//                //根结点左子树的节点个数
//                int left = j-1;
//                //根结点右子树的节点个数
//                int right = i-j;
//                /*
//                    假设n为5，root是3，那么左边有2个节点，所以去dp[2]里面找，
//                    右边也有两个节点4,5。所以还去dp[2]里面找。
//                    因为只有dp[2]里面都是2个节点的数。但是dp[2]中的数只有1和2，我们要的是4,5。
//                    我们不妨将1,2加上root，你会发现正好是4,5。
//                    所以得到结论，左子树的值直接找前面节点数一样的dp索引，右子树的值也找前面一样的dp索引,
//                    但是你需要加上root才能保证val是你需要的，所以右子树要重新创建，不然会破坏前面的树。
//                */
//                for(TreeNode lTree:dp[left]){
//                    for(TreeNode rTree:dp[right]){
//                        //每一个可能的根结点
//                        TreeNode root = new TreeNode(j);
//                        //左子树直接连接
//                        root.left = lTree;
//                        //右子树需要加上根结点的值
//                        root.right = clone(j,rTree);
//                        //将当前的情况加到list集合中
//                        dp[i].add(root);
//                    }
//                }
//            }
//        }
//        return dp[n];
//    }
//
//    public TreeNode clone(int offset, TreeNode node){
//        if(node==null){
//            return null;
//        }
//        //当前结点值+偏移量
//        TreeNode temp = new TreeNode(node.val+offset);
//        //左右递归
//        temp.left = clone(offset,node.left);
//        temp.right = clone(offset,node.right);
//        return temp;
//    }




}
//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}