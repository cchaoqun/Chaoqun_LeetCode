package JZOffer.jz0301;

/*
 * @Description: 剑指 Offer 35. 复杂链表的复制
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


注意：本题与主站 138 题相同：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/1 19:08
 */
public class JZ35 {
    //哈希表
//    public Node copyRandomList(Node head) {
//        if(head==null){
//            return null;
//        }
//        Node cur = head;
//        Map<Node,Node> map = new HashMap<>();
//        while(cur!=null){
//            //构建原结点->新建原结点的键值对,这一次只初始化新节点的值
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        cur = head;
//        //二次遍历,给map中新节点的next random域赋值
//        while(cur!=null){
//            // new(cur).next = new(cur.next)
//            map.get(cur).next = map.get(cur.next);
//            // new(cur).random = new(cur.random)
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);
//    }

    public Node copyRandomList(Node head){
        if(head==null){
            return null;
        }
        Node cur = head;
        //每个结点后面赋值一个值相同的结点
        while(cur!=null){
            //新建结点
            Node temp = new Node(cur.val);
            //连接到当前结点的后面
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        //复制random指针
        cur = head;
        while(cur!=null){
            if(cur.random != null){
                //新节点.random = 原结点.random.next
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //分开两个链表
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next!=null){
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        //单独处理原链表尾结点指向null
        pre.next = null;
        return res;

    }
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
