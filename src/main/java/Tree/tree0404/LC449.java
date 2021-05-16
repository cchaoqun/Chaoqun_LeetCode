package Tree.tree0404;
/*
 * @Description: 449. 序列化和反序列化二叉搜索树
序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。

设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。

编码的字符串应尽可能紧凑。



示例 1：

输入：root = [2,1,3]
输出：[2,1,3]
示例 2：

输入：root = []
输出：[]


提示：

树中节点数范围是 [0, 104]
0 <= Node.val <= 104
题目数据 保证 输入的树是一棵二叉搜索树。


注意：不要使用类成员/全局/静态变量来存储状态。 你的序列化和反序列化算法应该是无状态的。
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/4 15:38
 */
public class LC449 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //需要序列化的树为空
        if(root==null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        //sb保留构建的二叉树先序遍历的结果
        prefix(root, sb);
        //去除最后一个","
        return sb.toString().substring(0, sb.length()-1);
    }
    //前序遍历,构建二叉搜索树的字符串
    public void prefix(TreeNode node, StringBuilder sb){
        if(node == null){
            return;
        }
        //当前结点
        sb.append(node.val).append(",");
        //先左后右
        prefix(node.left, sb);
        prefix(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //二叉树为空
        if(data==null || data.length()==0){
            return null;
        }
        //先序遍历通过","分割结点值
        String[] arr = data.split(",");
        //将结点值的字符串转换成int数组
        int[] nums = new int[arr.length];
        for(int i=0; i<arr.length; i++){
            nums[i] = Integer.valueOf(arr[i]);
        }
        return rebuild(nums, 0, nums.length-1);
    }

    /**
     * 重构二叉树
     * @param nums 二叉树先序遍历的int[]
     * @param l 当前构建的树的左边界
     * @param r 右边界
     * @return
     */
    public TreeNode rebuild(int[] nums, int l, int r){
        //说明区间已经为空
        if(l>r){
            return null;
        }
        //先序遍历的结果,最左边为根结点的值
        int rootVal = nums[l];
        //index为第一个大于根结点的值的下标,为右子树的根结点
        int index = r+1;
        //遍历数组
        for(int i=l+1; i<=r; i++){
            //找到第一个大于根结点值的结点就是右子节点
            if(nums[i]>rootVal){
                index = i;
                break;
            }
        }
        //构建根结点
        TreeNode root = new TreeNode(rootVal);
        //[l,r]当前构建树的区间
        //[l+1, index-1] 为左子树的区间
        //[index+1, r] 为右子树的区间
        root.left = rebuild(nums, l+1, index-1);
        root.right = rebuild(nums, index, r);
        return root;
    }
}
