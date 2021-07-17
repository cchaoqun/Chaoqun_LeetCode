package company.frequence;

import Tree.ListNode;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/23-15:07
 */

public class LC206 {
    // 迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
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

class LC206_M2{
    //递归
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
