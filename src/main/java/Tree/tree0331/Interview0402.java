package Tree.tree0331;
/*
 * @Description: 面试题 04.02. 最小高度树
给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。

示例:
给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

          0
         / \
       -3   9
       /   /
     -10  5
通过次数26,558提交次数33,570
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/31 13:58
 */
public class Interview0402 {
    //总是选择区间的中点为头结点创建子树,这样左右节点数量尽可能相等平衡
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums==null || nums.length==0){
            return null;
        }
        return dfs(nums, 0, nums.length-1);
    }

    TreeNode dfs(int[] nums, int left, int right){
        //空区间,返回相当于越过了叶子结点
        if(right<left || left>right){
            return null;
        }
        //区间只有一个结点
        if(left==right){
            return new TreeNode(nums[left]);
        }
        int mid = left+(right-left)/2;
        //对应区间的头结点
        TreeNode head = new TreeNode(nums[mid]);
        //建立左子树
        head.left = dfs(nums, left, mid-1);
        //建立右子树
        head.right = dfs(nums, mid+1, right);
        //返回当前区间的头结点
        return head;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

