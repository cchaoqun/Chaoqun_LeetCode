package JZOffer.review;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**剑指 Offer 07. 重建二叉树
 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。

 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。



 示例 1:


 Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 Output: [3,9,20,null,null,15,7]
 示例 2:

 Input: preorder = [-1], inorder = [-1]
 Output: [-1]


 限制：

 0 <= 节点个数 <= 5000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/22-16:50
 */

public class jz07 {
    int root = 0;
    Map<Integer, Integer> inMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         前序遍历 [根 左子树  右子树]
         中序遍历 [左子树  根 右子树]
         前序遍历从左到右就是根结点
         需要在中序遍历中找到根结点对应的索引, 这个索引左边就是左子树, 右边是右子树
         根据中序遍历 建立 结点值 - 索引值的映射
         */
        inMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inMap.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length-1);


    }

    private TreeNode build(int[] preorder, int[] inorder,int l , int r){
        if(l>r){
            return null;
        }
        TreeNode node = new TreeNode(preorder[root]);
        int mid = inMap.get(preorder[root]);
        root++;
        TreeNode left = build(preorder, inorder, l, mid-1);
        TreeNode right = build(preorder, inorder, mid+1, r);
        node.left = left;
        node.right = right;
        return node;
    }

}
