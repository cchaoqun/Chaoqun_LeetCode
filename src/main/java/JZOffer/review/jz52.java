package JZOffer.review;

import Tree.ListNode;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/28-15:03
 */

public class jz52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        while(a!=b){
            a = a==null?headB:a.next;
            b = b==null?headA:b.next;

        }
        return a;
    }
}
