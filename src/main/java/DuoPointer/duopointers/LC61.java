package DuoPointer.duopointers;
/*
 * @Description: 61. 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/13 21:59
 */
public class LC61 {



    public ListNode rotateRight(ListNode head, int k) {
        //链表为空
        if(head==null){
            return head;
        }
        ListNode temp = head, cur = head;
        //获取链表的长度
        int len = 1;
        while(temp.next!=null){
            temp = temp.next;
            ++len;
        }
        //保留这里的temp为第二部分的尾结点
        //k可能超出链表的长度,那么实际需要翻转的长度为 k % len
        k = k % len;
        //k==0说明k刚好等于0或者是链表长度的整数倍,这样无需翻转
        if(k==0){
            return head;
        }
        //将链表分成两部分,第一部分不需要翻转,第二部分保持原来的顺序连接到原链表的head前面即可
        //第一步不需要翻转的部分长度=len-k
        int first = 1;
        //移动到第一部分的尾结点
        while(first<len-k){
            cur = cur.next;
            ++first;
        }
        //解除前后两部分的链接
        //第二部分的头结点
        ListNode nextHead = cur.next;
        //第一部分的尾部与第二部分的头部解除链接
        cur.next = null;
        //第二部分的尾结点指向之前链表的头结点完成翻转
        temp.next = head;
        return nextHead;
    }

    //成环断开
//    public ListNode rotateRight(ListNode head, int k){
//        if(head==null || head.next==null){
//            return head;
//        }
//        //计算链表长度
//        int n =1;
//        ListNode old_tail = head;
//        for(n=1; old_tail.next!=null; ++n){
//            old_tail = old_tail.next;
//        }
//        //将链表连接成环
//        old_tail.next = head;
//        //新链表的尾结点为从head开始后面 n-k%n-1个数
//        ListNode new_tail = head;
//        for(int i=0; i<n - k%n -1; ++i){
//            new_tail = new_tail.next;
//        }
//        //新的头结点在新的尾结点的后面一个结点
//        ListNode new_head = new_tail.next;
//        //在新链表尾剪断
//        new_tail.next = null;
//        return new_head;
//
//    }
}
