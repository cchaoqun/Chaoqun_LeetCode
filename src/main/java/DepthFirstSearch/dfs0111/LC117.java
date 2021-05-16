package DepthFirstSearch.dfs0111;

/*
 * @Description: 117. 填充每个节点的下一个右侧节点指针 II
 *
给定一个二叉树
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。
如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有next 指针都被设置为 NULL。

进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。


示例：
输入：root = [1,2,3,4,5,null,7]
输出：[1,#,2,3,#,4,5,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点
如图 B 所示。

提示：
树中的节点数小于 6000
-100<= node.val <= 100


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/11 19:28
 */
public class LC117 {

    //BFS
//    public Node connect(Node root) {
//        if(root==null){
//            return null;
//        }
//        //创建队列存储结点
//        Queue<Node> queue = new LinkedList<>();
//        //根结点入队
//        queue.offer(root);
//        while(!queue.isEmpty()){
//            //每一层的数量
//            int size = queue.size();
//            //前驱结点
//            Node prev = null;
//            //出队
//            Node node = queue.poll();
//            //遍历本层结点
//            while(size>0){
//                //如果prev为空,则当前结点为本层第一结点
//                if(prev!=null){
//                    prev.next = node;
//                }
//                prev = node;
//                //当前结点next=队列顶的元素,如果为空则为null
//                node.next = queue.peek();
//                if(node.left!=null){
//                    queue.offer(node.left);
//                }
//                if(node.right!=null){
//                    queue.offer(node.right);
//                }
//            }
//        }
//        return root;
//    }

    //将每一层看成是一个链表
//    public Node connect(Node root){
//        if(root == null){
//            return null;
//        }
//        //将curr看成是当前层的链表
//        Node curr = root;
//        while(curr!=null){
//            //在每一层的开头设置一个哑结点不影响树的结构
//            //通过哑结点把当前层的结点链接起来
//            //链接本层的结点是在上一层实现的
//            Node dummy = new Node(0);
//            //设置前驱结点,初始等于哑结点
//            Node prev = dummy;
//            while(curr!=null) {
//                //curr代表当前层
//                if (curr.left!= null) {
//                    //前驱结点指向当前结点左子节点
//                    prev.next = curr.left;
//                    //前驱结点右移一位
//                    prev = prev.next;
//                }
//                //右子结点同理
//                if (curr.right != null) {
//                    prev.next = curr.right;
//                    prev = prev.next;
//                }
//                //当前结点后移
//                curr = curr.next;
//            }
//            //遍历完本层,下一层也链接起来,让哑结点赋值给curr,继续循环,直到curr==null
//            curr = dummy.next;
//        }
//        return root;
//    }

    //递归
    //借助方法 找到本层下一个有子节点的结点
    public Node connect(Node root){
        if(root==null || (root.left==null && root.right==null)){
            return root;
        }
        //左右子节点都存在
        if (root.left != null && root.right != null) {
            //左子节点指向右子节点
            root.left.next = root.right;
            //右子节点指向下一个有子节点的结点的子节点
            root.right.next = getNextHasKid(root);
        }
        //只有右子节点
        if (root.left == null) {
            root.right.next = getNextHasKid(root);
        }
        //只有左子节点
        if (root.right == null) {
            root.left.next = getNextHasKid(root);
        }

        //这里要注意：先递归右子树，否则右子树根节点next关系没建立好，
        //左子树到右子树子节点无法正确挂载
        root.right = connect(root.right);
        root.left = connect(root.left);
        return root;
    }

    public Node getNextHasKid(Node node){
        //node下一个结点不为空
        while(node.next!=null){
            //如果存在左子节点 则返回
            if(node.next.left!=null){
                return node.next.left;
            }
            //否则如果存在右子节点则返回
            if(node.next.right!=null){
                return node.next.right;
            }
            //如果没有子节点,继续查找下一个结点
            node = node.next;
        }
        //遍历完本层都没有子节点,返回null
        return null;
    }
}
