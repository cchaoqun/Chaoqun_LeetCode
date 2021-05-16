package BinarySearch.bs0107;


import java.util.LinkedList;

/*
 * @Description: 222. 完全二叉树的节点个数

完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2^h个节点。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 9:00
 */
public class LC222 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        Tree tree = new Tree(root);

        int nodeCount = countNodes(root);
        System.out.println(nodeCount);
    }


    //递归实现DFS
//    public static int countNodes(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int left = countNodes(root.left);
//        int right = countNodes(root.right);
//
//        return left+right+1;
//    }


    //利用完全二叉树特点 分别计算左右子树的结点个数
    public static int countNodes(TreeNode root){
        if(root==null){
            return 0;
        }
        //计算左右子树的高度
        int left = countLevel(root.left);
        int right = countLevel(root.right);
        //左右子树高度相等,左子树为满二叉树
        if(left==right){
            //      右子树结点个数(不包括根结点) 左子树个数(2^left-1+1)包括根结点所以+1
            //位运算因为优先级低需要加()
            return countNodes(root.right) + (1<<left);
        }else{
            //左右子树高度不等,右子树为满二叉树
            //      左子树结点个数(不包括根结点) 右子树个数(2^right-1+1)包括根结点所以+1
            return countNodes(root.left) + (1<<right);
        }

    }

    //计算树的层数
    public static int countLevel(TreeNode root){
        int level = 0;
        while(root!=null){
            level++;
            root = root.left;
        }
        return level;
    }

//    //BFS
//    public static int countNodes(TreeNode root){
//        int count = 0;
//        Queue<TreeNode> queue = new LinkedList<>();
//        if(root==null){
//            return 0;
//        }
//        //入队
//        queue.add(root);
//        while(!queue.isEmpty()){
//            //移除队列头部元素
//            TreeNode node = queue.poll();
//            //统计结点个数
//            count++;
//            if(node.left!=null){
//                queue.add(node.left);
//            }
//            if(node.right!=null){
//                queue.add(node.right);
//            }
//        }
//        return count;
//    }


}
class Tree{
    private TreeNode root;
    public void setRoot(TreeNode root){
        this.root = root;
    }

    public Tree(TreeNode root){
        setRoot(root);
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    LinkedList list;
    public TreeNode(int val){
        this.val = val;
    }
}
