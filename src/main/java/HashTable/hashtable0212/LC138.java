package HashTable.hashtable0212;

import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 138. 复制带随机指针的链表
给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。

构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。

例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。

返回复制链表的头节点。

用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：

val：一个表示 Node.val 的整数。
random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
你的代码 只 接受原链表的头节点 head 作为传入参数。



示例 1：



输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
示例 2：



输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
示例 3：



输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
示例 4：

输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。


提示：

0 <= n <= 1000
-10000 <= Node.val <= 10000
Node.random 为空（null）或指向链表中的节点。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/12 16:24
 */
public class LC138 {
    //存储已经访问过的结点,key=Old node value = new node
    HashMap<Node, Node> visitedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //如果当前结点已经访问过了,返回已经创建过得当前结点
        if(this.visitedNode.containsKey(head)){
            return this.visitedNode.get(head);
        }
        //如果当前结点未被访问过,新建一个结点
        Node temp = new Node(head.val);
        //将新建的结点放入map
        this.visitedNode.put(head, temp);
        //递归的建立next和random
        temp.next = this.copyRandomList(head.next);
        temp.random = this.copyRandomList(head.random);

        //返回当前新建的结点
        return temp;

    }

    //迭代
//    public Node getCopyNode(Node node){
//        if(node!=null){
//            if(this.visitedNode.containsKey(node)){
//                return this.visitedNode.get(node);
//            }else{
//                //新建一个
//                this.visitedNode.put(node, new Node(node.val));
//                return this.visitedNode.get(node);
//            }
//        }
//        return null;
//    }
//    public Node copyRandomList(Node head){
//        if(head==null){
//            return null;
//        }
//        Node oldNode = head;
//        //复制头结点
//        Node newNode = new Node(head.val);
//        //头结点新老结点放入map
//        this.visitedNode.put(oldNode, newNode);
//        //遍历链表并通过辅助方法获得对应的next random
//        while(oldNode!=null){
//            newNode.next = this.getCopyNode(oldNode.next);
//            newNode.random = this.getCopyNode(oldNode.random);
//
//            oldNode = oldNode.next;
//            newNode = newNode.next;
//        }
//        //返回创建的head的复制结点
//        return this.visitedNode.get(head);
//    }

//    //空间迭代
//    public Node copyRandomList(Node head){
//        if(head==null){
//            return null;
//        }
//        Node cur = head;
//        //遍历链表,新建一个结点在源结点后面
//        while(cur!=null){
//            //新节点值与当前结点相同
//            Node newCur = new Node(cur.val);
//            //新节点next指向当前结点next
//            newCur.next = cur.next;
//            //当前结点next指向新节点
//            cur.next = newCur;
//            //当前结点变成新节点的下一个
//            cur = newCur.next;
//        }
//        cur = head;
//        //链接random指针
//        while(cur!=null){
//            //新节点的random指向旧结点random的复制的结点
//            cur.next.random = cur.random==null?null:cur.random.next;
//            cur = cur.next.next;
//        }
//        //将新旧结点按顺序链接起来
//        Node curOldNode = head;
//        Node curNewNode = head.next;
//        //该结点为最后返回的结点
//        Node newHead = head.next;
//        //链接next指针
//        while(curOldNode!=null){
//            curOldNode.next = curNewNode.next;
//            curNewNode.next = curNewNode.next==null?null:curNewNode.next.next;
//
//            curNewNode = curNewNode.next;
//            curOldNode = curOldNode.next;
//        }
//
//        return newHead;
//    }

}


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
