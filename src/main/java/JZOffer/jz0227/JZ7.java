package JZOffer.jz0227;


import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 剑指 Offer 07. 重建二叉树
输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7


限制：

0 <= 节点个数 <= 5000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 12:20
 */
public class JZ7 {

    int[] preOrder;
    int rootIndex;
    //中序遍历(元素:下标)通过结点值获得下标i i左边都为左子树,i右边都为右子树
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //初始化前序中序遍历数组以及根结点索引
        this.preOrder = preorder;
        rootIndex = 0;
        //初始化中序遍历对应的map
        for(int i=0; i<inorder.length; ++i){
            map.put(inorder[i], i);
        }
        TreeNode head = construct(0, 0,preOrder.length-1);
        return head;
    }

    public TreeNode construct(int rootIndex, int left, int right){
        if(left>right){
            return null;
        }
        //获取根结点的值
        int rootVal = preOrder[rootIndex];
        //创建结点
        TreeNode root = new TreeNode(rootVal);
        //获取根结点值在中序遍历中的下标划分当前根结点的左右子树
        int mid = map.get(rootVal);
        //中序遍历左子树在左边,右子树在右边
        //前序遍历根结点后面是左子树,先创建左子树
        //前序遍历中左子树在根结点后面一个位置 rootIndex+1
        root.left = construct(rootIndex+1,left,mid-1);
        //前序遍历中,右子树在根结点后面 左子树长度+1的位置 mid-left为左子树长度
        root.right = construct(rootIndex+mid-left+1, mid+1,right);
        return root;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

