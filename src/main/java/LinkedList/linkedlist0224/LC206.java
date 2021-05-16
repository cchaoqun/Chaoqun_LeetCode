package LinkedList.linkedlist0224;
/*
 * @Description: 206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 17:54
 */
public class LC206 {

    //递归
//    public ListNode reverseList(ListNode head) {
//        if(head==null || head.next==null){
//            return head;
//        }
//        //返回以head.next为头结点的链表的反转后链表的头结点
//        ListNode last = reverseList(head.next);
//        //让head.next结点翻转指向head head<--head.next
//        head.next.next = head;
//        //null<--head<--head.next
//        head.next = null;
//        //返回反转后链表的头结点
//        return last;
//    }

    //迭代
    public ListNode reverseList(ListNode head){
        ListNode curr = head, prev = null, next = null;
        while(curr!=null){
            //保存后续节点
            next = curr.next;
            //翻转指针
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
