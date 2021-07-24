package JZOffer.review;

import Tree.ListNode;

/**剑指 Offer 24. 反转链表
 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。



 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL


 限制：

 0 <= 节点个数 <= 5000


 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/23-12:07
 */

public class jz24 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

class jz24_M2{
    public ListNode reverseList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }
        //获得head.next为头的链表翻转后的头结点
        ListNode newHead = reverseList(head.next);
        //让head.next指向head
        head.next.next = head;
        //head.next指针置空
        head.next = null;
        return newHead;
    }
}
