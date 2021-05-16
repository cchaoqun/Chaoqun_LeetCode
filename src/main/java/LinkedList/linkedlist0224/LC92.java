package LinkedList.linkedlist0224;
/*
 * @Description: 92. 反转链表 II
反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。

说明:
1 ≤ m ≤ n ≤ 链表长度。

示例:

输入: 1->2->3->4->5->NULL, m = 2, n = 4
输出: 1->4->3->2->5->NULL
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 11:53
 */
public class LC92 {

    //保存第n个结点后续的链表
    ListNode next = null;
    //递归
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //left==1可以调用reverseN方法获得从head开始的n个结点翻转
        if(left==1){
            //返回以head为头结点,翻转后续right个结点的头结点
            return reverseN(head,right);
        }
        //head后续节点应该为翻转链表后的头结点
        head.next = reverseBetween(head.next, left-1, right-1);
        return head;
    }

    //翻转从head开始的后续n个结点,同时将第n个结点后续的链表添加到翻转后的链表的后面
    public ListNode reverseN(ListNode head, int n){
        if(n==1){
            next = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        //head后一个结点指向head
        head.next.next = head;
        //head指向第n个结点的后续节点
        head.next = next;
        //以第n个结点为头结点的链表的头结点
        return last;
    }


    //迭代
//    public ListNode reverseBetween(ListNode head, int left, int right){
//        if(head==null || head.next==null){
//            return head;
//        }
//        ListNode prev = null, curr = head;
//        //将head移动到带翻转链表结点起始处
//        while(left>1){
//            prev = curr;
//            curr = curr.next;
//            --left;
//            --right;
//        }
//        //当前翻转链表部分的起点,反转后变成末尾
//        ListNode newHead = prev, tail = curr;
//        ListNode third = null;
//        while(right>0){
//            //保存curr后续节点
//            third = curr.next;
//            //翻转使得 prev<--curr
//            curr.next = prev;
//            //prev curr后移一位
//            prev = curr;
//            curr = third;
//            //每一次翻转一个结点
//            --right;
//        }
//        if(newHead==null){
//            //反转后链表起点为全部链表的起点
//            head = prev;
//        }else{
//            newHead.next = prev;
//        }
//        //反转后末尾结点指向剩余链表
//        tail.next = curr;
//        return head;
//    }


}
