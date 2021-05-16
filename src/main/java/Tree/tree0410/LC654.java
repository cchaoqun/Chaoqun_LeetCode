package Tree.tree0410;
/*
 * @Description:654. 最大二叉树
给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：

二叉树的根是数组 nums 中的最大元素。
左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
返回有给定数组 nums 构建的 最大二叉树 。



示例 1：


输入：nums = [3,2,1,6,0,5]
输出：[6,3,5,null,2,0,null,null,1]
解释：递归调用如下所示：
- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
        - 空数组，无子节点。
        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
            - 空数组，无子节点。
            - 只有一个元素，所以子节点是一个值为 1 的节点。
    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
        - 只有一个元素，所以子节点是一个值为 0 的节点。
        - 空数组，无子节点。
示例 2：


输入：nums = [3,2,1]
输出：[3,null,2,null,1]


提示：

1 <= nums.length <= 1000
0 <= nums[i] <= 1000
nums 中的所有整数 互不相同
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/10 23:22
 */
public class LC654 {
    //递归
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }

    public TreeNode dfs(int[] nums, int left, int right){
        //区间为空
        if(left>right){
            return null;
        }
        //获取区间最大值
        int maxIndex = findMax(nums, left, right);
        //创建该区间的根结点
        TreeNode node = new TreeNode(nums[maxIndex]);
        //递归建造左树和右树
        node.left = dfs(nums, left,maxIndex-1);
        node.right = dfs(nums, maxIndex+1, right);
        return node;
    }

    //找到 [left, right]区间内的最大值的下标
    public int findMax (int[] nums, int left, int right){
        int index = -1;
        int max = Integer.MIN_VALUE;
        for(int i=left; i<=right; i++){
            if(nums[i]>max){
                max = nums[i];
                index = i;
            }
        }
        return index;

    }
}
