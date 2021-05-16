package LinkedList.linkedlist0224;
/*
 * @Description: 链表常见操作
 * 翻转链表(递归)
 * 翻转链表(迭代)
 * 双指针寻找中点
 * 合并两个链表
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 17:23
 */
public class ReverseLinkedList {

    //递归翻转整个链表
    public ListNode reverseLinkedList(ListNode head){
        //返回条件head为空或者只有一个结点
        if(head==null || head.next==null){
            return head;
        }
        //以head.next为头结点的链表反转后的头结点
        ListNode last = reverseLinkedList(head.next);
        //head后一个结点指向head
        head.next.next = head;
        //head.next指向null,当前head变成了链表的最后一个结点
        head.next = null;
        return last;
    }

    //非递归翻转整个链表
    public ListNode reverseLinkedListNoRecur(ListNode head){
        ListNode prev = null, curr = head;
        while(curr!=null){
            //保存后续链表
            ListNode next = curr.next;
            //翻转curr指向前一个结点 prev<---curr
            curr.next = prev;
            //两个指针后移一位
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //双指针找链表的中点
    public ListNode findMid(ListNode head){
        ListNode fast = head, slow = head;
        while(fast.next!=null && fast.next.next!=null){
            //慢指针一次走一步
            slow = slow.next;
            //快指针一次走两步
            fast = fast.next;
        }
        return slow;
    }

    //合并两个链表一对一合并
    public void merge(ListNode l1, ListNode l2){
        ListNode temp1, temp2;
        while(l1!=null && l2!=null){
            //保存后续节点
            temp1 = l1.next;
            temp2 = l2.next;

            l1.next = l2;
            l1 = temp1;

            l2.next = l1;
            l2 = temp2;
        }
    }
}
