package DepthFirstSearch.dfs0111;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 106. 从中序与后序遍历序列构造二叉树
 *
根据一棵树的中序遍历与后序遍历构造二叉树。
注意:
你可以假设树中没有重复的元素。
*
例如，给出
中序遍历 inorder =[9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/11 10:47
 */
public class LC106 {
    //每次从postOrder的末尾获得右子树的根结点
    int root_index;
    int[] inOrder;
    int[] postOrder;
    //中序遍历数组对应的值与下标
    Map<Integer,Integer> inOrderMap = new HashMap<>();

    public TreeNode helper(int left, int right){
        if(left>right){
            return null;
        }
        //获取根结点的值,对应后续遍历最后一个位置的值
        int rootVal = postOrder[root_index];
        //根据中序遍历对应的hashMap获取根结点在中序遍历中的位置下标
        int index = inOrderMap.get(rootVal);
        //构建根结点
        TreeNode root = new TreeNode(rootVal);
        //下一次从后序遍历数组获得次末尾位置为右子树根结点
        root_index--;
        //根结点左边为左子树,右边为右子树,先构建右子树
        root.right = helper(index+1,right);
        root.left = helper(left,index-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inOrder = inorder;
        this.postOrder = postorder;
        //从后续遍历的最后一个元素开始
        this.root_index = postOrder.length-1;

        //构建中序遍历对应的hashMap(元素,下标)
        int in = 0;
        for(int i:inOrder){
            inOrderMap.put(i,in++);
        }

        return helper(0,inOrder.length-1);
    }
}
