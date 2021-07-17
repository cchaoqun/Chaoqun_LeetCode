package company.bytedance;

import Tree.ListNode;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/23-16:27
 */

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        //统计链表长度
        int Len = 0;
        ListNode cur = head;
        while(cur!=null){
            Len++;
            cur = cur.next;
        }
        //需要翻转的次数
        int num = Len / k;
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        cur = head;
        for(int i=0; i<num; i++){
            //从cur开始翻转k长度的结点
            ListNode[] arr = reverseList(cur, k);
            //翻转后的头结点 arr[0] 接到之前的翻转后的链表尾
            newHead.next = arr[0];
            //newHead移动到本次翻转后的链表的尾 arr[1], 准备接上下一个翻转链表的头
            newHead = arr[1];
            //下一个需要翻转的结点
            cur = arr[2];
        }
        //可能存在不足一次翻转的, 直接接上
        newHead.next = cur;
        return dummy.next;
    }

    //从head结点开始 翻转长度为len的结点 并返回ListNode[] newHead, newTail, 翻转链表后的下一个待翻转结点的起始结点
    public ListNode[] reverseList(ListNode head, int len){
        ListNode prev = null, cur = head, next = null;
        //迭代翻转当长度没有用完的情况
        while(len>0 && cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            len--;
        }
        return new ListNode[]{prev, head, next};
    }
}
