package JZOffer.jz0228;
/*
 * @Description: 剑指 Offer 25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
限制：

0 <= 链表长度 <= 1000

注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/28 21:32
 */
public class JZ25 {

    //双指针
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(0);
//        ListNode curr = dummy;
//        while(l1!=null && l2!=null){
//            //比较两个节点指针对应结点值的大小
//            if(l1.val<l2.val){
//                ListNode temp1 = l1.next;
//                l1.next = null;
//                curr.next = l1;
//                l1 = temp1;
//            }else{
//                ListNode temp2 = l2.next;
//                l2.next = null;
//                curr.next = l2;
//                l2 = temp2;
//            }
//            //指针后移
//            curr = curr.next;
//        }
//        //判断哪个链表未遍历完直接接在新链表的后面
//        curr.next = l1==null ? l2 : l1;
//        return dummy.next;
//    }

    //递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //递归返回条件,其中一个链表遍历完,返回另一个链表
        if(l1==null || l2==null){
            return l1==null ? l2 : l1;
        }
        if(l1.val < l2.val){
            //l1.next等于 以l1.next l2为头结点的链表合并后的头结点
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            //l2.next等于 以l2.next l1为头结点的链表合并后的头结点
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }


}
