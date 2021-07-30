package JZOffer.review;

import java.util.HashMap;
import java.util.Map;

/**剑指 Offer 35. 复杂链表的复制
 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。



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

 -10000 <= Node.val <= 10000
 Node.random 为空（null）或指向链表中的节点。
 节点数目不超过 1000 。

 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/26-18:07
 */

public class jz35 {
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        /**
         第一遍循环
         在每个node后面加一个值相同的node
         第二遍循环
         将每个新建的node.random指向 node.pre.random.next
         第三遍循环
         从链表中分分离出新建的node组成一条链表

         */
        Node cur = head;
        //1. 每个结点后面新建相同val的结点
        while(cur!=null){
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        //2. 更新每个新建结点的random field
        cur = head;
        while(cur!=null){
            if(cur.random!=null){
                cur.next.random = cur.random.next;
            }

            cur = cur.next.next;
        }
        //3. 分离结点成链表
        Node res = head.next;
        //通过这两个结点分离出两条链表, 解除结点之间的链接关系
        Node pre = head;
        cur = head.next;
        while(cur.next!=null){
            // 原本的node
            pre.next = pre.next.next;
            // 新建的noed
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null;
        return res;

    }
}

class jz35_M2{
    public Node copyRandomList(Node head) {
        if(head==null){
            return head;
        }
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while(cur!=null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur!=null){
            map.get(cur).random = map.get(cur.random);
            map.get(cur).next = map.get(cur.next);
            cur = cur.next;
        }
        return map.get(head);

    }
}

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
