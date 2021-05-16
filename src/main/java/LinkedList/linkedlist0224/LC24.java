package LinkedList.linkedlist0224;
/*
 * @Description: 24. 两两交换链表中的节点
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。



示例 1：


输入：head = [1,2,3,4]
输出：[2,1,4,3]
示例 2：

输入：head = []
输出：[]
示例 3：

输入：head = [1]
输出：[1]


提示：

链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100


进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 10:05
 */
public class LC24 {
    //迭代
    public ListNode swapPairs(ListNode head) {
        //哑结点
        ListNode dummy = new ListNode(0, head);
        //链表长度为0或1直接返回头结点
        if(head==null || head.next==null){
            return head;
        }
        //创建三个指针分别指向需要交换的两个结点以及之前的一个结点
        ListNode prev = dummy, curr = head, next = head.next;
        //迭代终止的条件是待交换的两个结点中有空节点
        while(curr!=null && next!=null){
            //prev指向next
            prev.next = next;
            //curr指向next.next
            curr.next = next.next;
            //next指向curr
            next.next = curr;
            //更新prev,当前curr与next以及交换了,curr变成三个结点中的第三个
            prev = curr;
            //下一次curr应该在prev后面,即当前curr的后一个
            curr = curr.next;
            //避免空指针异常,需要判断此时更新后的curr是否为空
            if(curr!=null){
                next = curr.next;
            }else{
                next = null;
            }
        }
        //如果剩余一个结点
        prev.next = curr;
        return dummy.next;
    }

    //递归
//    public ListNode swapPairs(ListNode head){
//        ListNode dummy = new ListNode(0,head);
//        if(head==null || head.next==null){
//            return head;
//        }
//        //head.next为新链表的头结点
//        ListNode newHead = head.next;
//        //head交换后变成第二个,指向后续两个结点交换后的头结点
//        head.next = swapPairs(newHead.next);
//        //新链表的头结点指向head
//        newHead.next = head;
//        return newHead;
//    }
}
