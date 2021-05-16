package Tree.tree0416;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 106. 从中序与后序遍历序列构造二叉树
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
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
 * @date 2021/4/16 17:58
 */
public class LC106 {

    private int[] inorder;
    private int[] postorder;
    //根结点的在中序遍历数组中的下标
    private int root_index;
    //key=inorder中的某个元素值  value=key在inorder中的下标
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder){
        //初始化数组 下标 map
        this.inorder = inorder;
        this.postorder = postorder;
        this.root_index = postorder.length-1;
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length-1);
    }

    public TreeNode dfs(int left, int right){
        if(left>right){
            return null;
        }
        //获取当前根结点的值
        int root_val = postorder[root_index];
        //根据map获取根结点在中序遍历数组中的下标
        //中序遍历 左 根 右  所以根结点下标左边为左子树  右边为右子树
        int root_index = map.get(root_val);
        //创建根结点
        TreeNode root = new TreeNode(root_val);
        //下一个构建的结点为右子节点 在后序遍历中根结点前面一位
        this.root_index--;
        //先构建右子树 因为后续遍历 左 右 根 所以后续遍历数组 根结点在最后一个 往前一位一定右子数的根结点
        root.right = dfs(root_index+1, right);
        //再构建左子树
        root.left = dfs(left,root_index-1);
        //返回根结点
        return root;
    }
}

class LC106_M2{
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
        //根结点左边为左子树,右边为右子树,先构建右子树
        //下一次从后序遍历数组获得次末尾位置为右子树根结点
        root_index--;
        root.right = helper(index+1,right);
        root.left = helper(left,index-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inOrder = inorder;
        this.postOrder = postorder;
        this.root_index = postOrder.length-1;

        //构建中序遍历对应的hashMap
        int in = 0;
        for(int i:inOrder){
            inOrderMap.put(i,in++);
        }

        return helper(0,inOrder.length-1);
    }
}
