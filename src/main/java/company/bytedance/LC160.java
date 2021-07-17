package company.bytedance;

import Tree.ListNode;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-12:18
 */

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        //两个结点不相交 或者不同时为null
        while(curA != curB){
            //当前走完了一条链表 下一步走到另一条链表的头
            curA = curA == null?headB:curA.next;
            curB = curB == null?headA:curB.next;
        }
        return curA;
    }
}
