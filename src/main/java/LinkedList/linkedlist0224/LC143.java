package LinkedList.linkedlist0224;
/*
 * @Description: 143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 16:37
 */
public class LC143 {

    //递归
//    public void reorderList(ListNode head) {
//        if(head==null || head.next == null || head.next.next==null){
//            return;
//        }
//        //更新链表一次
//        head = insertLast(head);
//        //以原始链表的第二个结点开始重排链表
//        reorderList(head.next.next);
//    }
//
//    //将链表最后一个结点插入到head.next
//    public ListNode insertLast (ListNode head){
//        ListNode prev = head, curr = head.next;
//        //将curr移动到最后一个结点
//        while(curr!=null && curr.next!=null){
//            prev = curr;
//            curr = curr.next;
//        }
//        //最后一个结点指向head.next
//        curr.next = head.next;
//        //head.next指向最后一个结点
//        head.next = curr;
//        //将最后一个结点前一个结点与最后一个结点的链接断开
//        prev.next = null;
//        //返回更新后的头结点
//        return head;
//    }

    //翻转后半部分链表,再合并
    public void reorderList(ListNode head){
        if(head==null || head.next==null){
            return;
        }
        //找中点
        ListNode mid = findMid(head);
        ListNode l1 = head, l2 = mid.next;
        //切断中点与后续链表的链接
        mid.next = null;
        //翻转后半链表
        l2 = reverse(l2);
        //合并两部分链表
        merge(l1, l2);


    }

    //双指针寻找中点
    public ListNode findMid(ListNode head){
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //翻转后半部分链表
    public ListNode reverse(ListNode head){
        ListNode prev = null, curr = head;
        while(curr!=null){
            //保存后续链表
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //合并两个链表
    public void merge(ListNode l1, ListNode l2){
        ListNode temp1;
        ListNode temp2;
        while(l1!=null && l2!=null){
            //保存后续链表
            temp1 = l1.next;
            temp2 = l2.next;
            //l2插入到l1.next
            l1.next = l2;
            l1 = temp1;
            l2.next = l1;
            l2 = temp2;
        }
    }
}
