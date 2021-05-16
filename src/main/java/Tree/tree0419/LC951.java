package Tree.tree0419;

import Tree.TreeNode;

/**
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/19-16:23
 */

public class LC951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        //当前两个结点必须都为null才返回true, 一个为null一个不为null返回false
        if(root1==null){
            return root2==null;
        }
        if(root2==null){
            return root1==null;
        }
        //当前两个结点值不等一定不能构成翻转等价
        if(root1.val!=root2.val){
            return false;
        }
        //当前结点值相等, 只要左右子树中 翻转或不翻转的情况有一个构成翻转等价即可
        return (flipEquiv(root1.left, root2.left)&&flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
