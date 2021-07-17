package company.bytedance;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/25-13:37
 */

public class LC105 {
    /**
     对于前序遍历 [根 | 左子树 | 右子树]
     对于中序遍历 [左子树 | 根 | 右子树]
     需要一个指针指向前序遍历, 指针指向的位置就是当前需要构建的树的根结点对应的值
     需要根据这个值, 在中序遍历中找到对应根的位置, i
     [:i-1] 是该树的左子树
     [i+1:] 是该树的右子树
     对于左右子树, 递归的去构建
     先构建左子树 这样指针依次在前序遍历的数组中依次移动即可
     再构建右子树
     */

    int nextRoot;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map  = new HashMap<>();
        nextRoot = -1;
        //map<inorder[i], i>
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length-1, map);
    }

    //构建inorder范围在[left:right]的树
    private TreeNode build(int[] preorder, int[] inorder, int left, int right,Map<Integer, Integer> map){
        if(left>right){
            return null;
        }
        //更新当前树所对的根结点在preorder数组中的下标
        nextRoot++;
        if(left==right){
            return new TreeNode(inorder[left]);
        }
        //根绝根结点的值 preorder[nextRoot]找到inorder中的位置
        int curIndex = map.get(preorder[nextRoot]);
        //根结点
        TreeNode curRoot = new TreeNode(preorder[nextRoot]);
        //左子树 一定要先左子树, 因为preorder先遍历左子树再遍历右子树, nextRoot只要依次+1即可
        curRoot.left = build(preorder, inorder, left, curIndex-1,map);
        //右子树
        curRoot.right = build(preorder, inorder, curIndex+1, right, map);
        return curRoot;
    }
}
