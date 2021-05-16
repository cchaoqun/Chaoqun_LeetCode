package JZOffer.jz0228;


/*
 * @Description: 剑指 Offer 26. 树的子结构
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
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/28 21:55
 */
public class JZ26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //匹配的条件为
        //1.A B不为空
        //2.以A结点为根结点的数与B匹配,|| A的左子树中与B匹配, || A的右子树与B匹配
        return ((A!=null && B!=null) && (dfs(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B)));
    }
    //判断以 A B为根结点的树是否匹配
    public boolean dfs(TreeNode A, TreeNode B){
        //B已经全部匹配完成
        if(B==null){
            return true;
        }
        //A已经遍历过叶子结点,或者A B结点的值不等
        if(A==null || A.val != B.val){
            return false;
        }
        //当前A B结点值相等,结果取决于对应的左右子树是否匹配
        return dfs(A.left,B.left) && dfs(A.right, B.right);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

