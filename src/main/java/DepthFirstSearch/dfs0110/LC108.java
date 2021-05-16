package DepthFirstSearch.dfs0110;
/*
 * @Description: 108. 将有序数组转换为二叉搜索树
 *
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
*
示例:
给定有序数组: [-10,-3,0,5,9],
一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/10 13:35
 */
public class LC108 {
    public static void main(String[] args) {

    }


    //从数组中间开始 左边小于mid 右边大于mid 保证二叉树平衡

    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    public TreeNode helper(int[] nums, int left, int right){
        if(left>right){
            return null;
        }

        //选择中间结点作为树(子树)的根结点
        int mid = left+(right-left)/2;
        TreeNode root = new TreeNode(left + (right-left)/2);

        root.left = helper(nums,left,mid-1);
        root.right = helper(nums,mid+1,right);
        return root;
    }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

