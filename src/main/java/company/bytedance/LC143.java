package company.bytedance;

import Tree.ListNode;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/1-14:38
 */

public class LC143 {
    public void reorderList(ListNode head) {
        /**
         快慢指针找到链表中点
         翻转链表右半部分
         合并两部分
         */
        if(head==null || head.next==null){
            return;
        }
        //找中点
        ListNode mid = findMid(head);
        //翻转链表右半部分
        // System.out.println(mid.val);
        ListNode reverseHead = reverse(mid.next);
        mid.next = null;
        //合并两部分
        combine(head, reverseHead);
    }

    //合并两个单链表
    private ListNode combine(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode temp2 = l2.next;
        ListNode temp1 = l1.next;
        l2.next = l1.next;
        l1.next = l2;
        l1.next.next = combine(temp1, temp2);
        return l1;
    }
    //翻转链表
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    //找到链表的中点
    private ListNode findMid(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode temp = head;
        while(fast!=null){
            temp = slow;
            fast = fast.next;
            slow = slow.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        return temp;
    }
}
