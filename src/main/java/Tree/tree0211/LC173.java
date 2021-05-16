package Tree.tree0211;

import java.util.*;

/*
 * @Description:173. 二叉搜索树迭代器
实现一个二叉搜索树迭代器。你将使用二叉搜索树的根节点初始化迭代器。

调用 next() 将返回二叉搜索树中的下一个最小的数。



示例：



BSTIterator iterator = new BSTIterator(root);
iterator.next();    // 返回 3
iterator.next();    // 返回 7
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 9
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 15
iterator.hasNext(); // 返回 true
iterator.next();    // 返回 20
iterator.hasNext(); // 返回 false


提示：

next() 和 hasNext() 操作的时间复杂度是 O(1)，并使用 O(h) 内存，其中 h 是树的高度。
你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 中至少存在一个下一个最小的数。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 9:25
 */
public class LC173 {
    //迭代
    ArrayList<Integer> container;
    int index;



    //递归
//    public BSTIterator(TreeNode root) {
//        //迭代
//        this.container = new ArrayList<>();
//        this.index = -1;
//        this.inOrder(root);
//
//    }
//
//    //中序遍历的结果就是二叉搜索树的升序
//    public void inOrder(TreeNode root){
//        if(root==null){
//            return;
//        }
//        inOrder(root.left);
//        container.add(root.val);
//        inOrder(root.right);
//    }
//
//    //返回下一个最小值 0~container.size()-1
//    public int next() {
//        return this.container.get(++this.index);
//    }
//
//    public boolean hasNext() {
//        //下一个元素的下标是否小于list下标范围
//        return this.index+1<this.container.size();
//
//    }


    //受控递归, 维护显式的栈
//    Deque<TreeNode> stack;
//
//    //受控迭代
//    public BSTIterator(TreeNode root){
//        this.stack = new ArrayDeque<>();
//        leftNode(root);
//    }
//
//    //将node结点的所有左子节点入栈
//    public void leftNode(TreeNode node){
//        while(node!=null){
//            this.stack.push(node);
//            node = node.left;
//        }
//    }
//
//    //返回下一个最小的元素
//    public int next(){
//        TreeNode nextMin = this.stack.pop();
//        //如果该节点有右子节点,将右子节点的左子节点全部入栈
//        if(nextMin.right!=null){
//            this.leftNode(nextMin.right);
//        }
//        return nextMin.val;
//    }
//
//    //是否有下一个元素
//    public boolean hasNext(){
//        return !stack.isEmpty();
//    }
}
