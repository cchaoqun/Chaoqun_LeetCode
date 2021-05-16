package DepthFirstSearch.dfs0111;

/*
 * @Description: 116. 填充每个节点的下一个右侧节点指针
 *
给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
初始状态下，所有next 指针都被设置为 NULL。

进阶：
你只能使用常量级额外空间。
使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。

示例：
输入：root = [1,2,3,4,5,6,7]
输出：[1,#,2,3,#,4,5,6,7,#]
解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。

提示：
树中节点的数量少于4096
-1000 <= node.val <= 1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/11 14:58
 */
public class LC116 {

    //满二叉树,每一层的最后一个结点的next->null,其余结点指向当前层右边结点
    //BFS
//    public Node connect(Node root) {
//        if(root==null){
//            return null;
//        }
//        //创建一个队列 先进先出
//        Queue<Node> queue = new LinkedList<>();
//        //根结点入队
//        queue.offer(root);
//        //临时变量,用来存储本层最右侧的元素
//        Node curr = null;
//        while(!queue.isEmpty()){
//            //获取当前栈内元素个数=当前层元素个数
//            int size = queue.size();
//            while(size>0){
//                //出栈一个元素
//                curr = queue.poll();
//                //队列不为空,curr.next->queue.peek()
//                if(size-1>0){
//                    //当前结点不为本层最右结点
//                    curr.next = queue.peek();
//                    //如果当前结点时最右结点,无需处理,默认next=null
//                }
//                //左子节点先入队,这样下一层从左到右出队
//                if(curr.left!=null){
//                    queue.offer(curr.left);
//                }
//                if(curr.right!=null){
//                    queue.offer(curr.right);
//                }
//                size--;
//            }
//        }
//        return root;
//    }

    //满二叉树,每一层的最后一个结点的next->null
    //BFS 双指针保留前驱结点
//    public Node connect(Node root) {
//        if(root==null){
//            return null;
//        }
//
//        //创建一个队列 先进先出
//        Queue<Node> queue = new LinkedList<>();
//        //根结点入队
//        queue.offer(root);
//        //临时变量,用来存储本层最右侧的元素
//        Node prev = null;
//        Node curr = null;
//        while(!queue.isEmpty()){
//            //每层先置空prev
//            prev = null;
//            //获取当前栈内元素个数=当前层元素个数
//            int size = queue.size();
//            while(size>0){
//                //出栈一个元素
//                curr = queue.poll();
//                if(prev == null){
//                    //curr为该层的最左结点
//                    prev = curr;
//                }else{
//                    //curr不是该层的最左结点
//                    prev.next = curr;
//                }
//                //左子节点先入队,这样下一层从左到右出队
//                if(curr.left!=null){
//                    queue.offer(curr.left);
//                }
//                if(curr.right!=null){
//                    queue.offer(curr.right);
//                }
//                prev = curr;
//                size --;
//            }
//            //curr指向本层的最右结点
//            //将next指针指向null
//            curr.next = null;
//
//        }
//        return root;
//    }

    //方法二：使用已建立的 next 指针
    //1.第一种情况是连接同一个父节点的两个子节点
    // 它们可以通过同一个节点直接访问到，因此执行下面操作即可完成连接。
    //2.第二种情况在不同父亲的子节点之间建立连接，这种情况不能直接连接。
//    public Node connect(Node root){
//        if(root==null){
//            return null;
//        }
//        Node leftMost = root;
//        while(leftMost.left!=null){
//            Node head = leftMost;
//            while(head!=null){
//                //connection1 head左子节点指向右子节点
//                head.left.next = head.right;
//                //connection2 head右子节点指向head.next.left
//                if(head.next!=null){
//                    head.right.next = head.next.left;
//                }
//                //head右移
//                head = head.next;
//            }
//            //去下一层
//            leftMost = leftMost.left;
//        }
//        return root;
//    }

    //递归
    public Node connect(Node root){
        dfs(root);
        return root;
    }
    public void dfs(Node root){
        if(root==null){
            return;
        }
        Node left = root.left;
        Node right = root.right;
        while(left!=null){
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfs(root.left);
        dfs(root.right);
    }
}


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
