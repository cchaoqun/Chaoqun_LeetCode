package JZOffer.review;

import Tree.ListNode;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/22-18:54
 */

public class jz18 {
    //双指针
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null){
            return null;
        }
        ListNode dummy  = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while(fast!=null && fast.val!=val){
            fast = fast.next;
            slow = slow.next;
        }
        if(fast==null){
            return null;
        }
        slow.next = fast.next;
        fast.next = null;
        return dummy.next;
    }
}
