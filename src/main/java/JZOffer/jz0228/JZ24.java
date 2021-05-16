package JZOffer.jz0228;
/*
 * @Description: 剑指 Offer 24. 反转链表
定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。



示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL


限制：

0 <= 节点个数 <= 5000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/28 21:08
 */
public class JZ24 {

    //迭代
//    public ListNode reverseList(ListNode head) {
//        ListNode prev = null, curr = head;
//        //逐个结点改变结点next指针的指向
//        while(curr!=null){
//            //保留curr指针后续节点
//            ListNode next = curr.next;
//            //当前指针next指向前一个结点
//            curr.next = prev;
//            //prev指针后移
//            prev = curr;
//            //curr指针后移
//            curr = next;
//        }
//        //curr==null时,prev到达原始结点的尾结点即为翻转后的头结点
//        return prev;
//    }

    //递归
    public ListNode reverseList(ListNode head){
        //递归返回条件为到达链表末尾,返回最后一个结点
        if(head==null || head.next==null){
            return head;
        }
        //last保留了以head.next为头结点链表翻转后的头结点
        ListNode last = reverseList(head.next);
        //让当前结点的后一个结点指向当前结点
        head.next.next = head;
        //当前结点next指针置空
        head.next = null;
        //返回翻转后的头结点
        return last;
    }
}
