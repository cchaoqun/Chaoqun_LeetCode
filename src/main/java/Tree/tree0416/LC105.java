package Tree.tree0416;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/16 18:43
 */
public class LC105 {
    private int[] preorder;
    private int[] inorder;
    private int pre_index;
    private Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        this.inorder = inorder;
        this.pre_index = 0;
        int in = 0;
        for(int i:inorder){
            inorderMap.put(i, in);
            in++;
        }
        return dfs(0, preorder.length-1);
    }

    public TreeNode dfs(int left, int right){
        if(left>right){
            return null;
        }
        int root_val = preorder[pre_index];
        int root_index = inorderMap.get(root_val);
        this.pre_index++;
        TreeNode root = new TreeNode(root_val);
        root.left = dfs(left, root_index-1);
        root.right = dfs(root_index+1, right);
        return root;
    }
}

class LC105_M2{
    //从前序遍历获得的根结点的下标
    int rootIndex;
    int[] preOrder;
    int[] inOrder;
    //创建中序遍历对应的map(元素,下标)用来获取根结点在中序遍历中的下标.左边为左子树,右边为右子树
    Map<Integer,Integer> map = new HashMap<>();

    public TreeNode helper(int left, int right){
        if(left>right){
            return null;
        }
        //获取根结点的值
        int rootVal = preOrder[rootIndex];
        rootIndex++;
        //创建根结点
        TreeNode root = new TreeNode(rootVal);
        //获取根结点在中序遍历中的下标
        int mid = map.get(rootVal);
        //中序遍历数组左边为左子树,右边为右子树
        //因为前序遍历根结点后面为左子结点,先创建左子树
        root.left = helper(left,mid-1);
        root.right = helper(mid+1,right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //初始化前序中序遍历数组
        this.preOrder = preorder;
        this.inOrder = inorder;
        //前序遍历数组第一个元素为根结点
        rootIndex = 0;

        //构建中序遍历对应的map
        int index = 0;
        for(int i:inOrder){
            map.put(i,index++);
        }

        return helper(0,preOrder.length-1);
    }
}
