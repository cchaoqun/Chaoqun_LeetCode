package LinkedList.linkedlist0224;
/*
 * @Description: 83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 11:21
 */
public class LC83 {

    //递归
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0,head);
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = dummy, curr = head;
        //如果当前结点与下一个结点值相同
        if(curr.val==curr.next.val){
            //将当前结点添加到链表
            prev.next = curr;
            //prev指针移到当前结点
            prev = curr;
            //向后找到下一个不等的结点
            while(curr!=null && curr.next!=null && curr.val==curr.next.val){
                curr = curr.next;
            }
            //prev指针指向以下一个不等的结点为头结点的删除重复元素的链表
            prev.next = deleteDuplicates(curr.next);
            //返回当前结点
            return prev;
        }else{
            //当前结点与下一个结点值不等
            //当前结点添加到链表
            prev.next = curr;
            prev = curr;
            //将以下一个结点为头结点的删除重复元素的链表添加进来
            prev.next = deleteDuplicates(curr.next);
            //返回当前结点
            return prev;
        }
    }

    //迭代
//    public ListNode deleteDuplicates(ListNode head){
//        ListNode dummy = new ListNode(0, head);
//        if(head==null || head.next==null){
//            return head;
//        }
//        ListNode prev = dummy, curr = head, next = head.next;
//        while(prev!=null && curr!=null && next!=null){
//            if(curr.val == next.val){
//                prev.next = curr;
//                prev = curr;
//                while(next!=null && next.val==curr.val){
//                    next = next.next;
//                }
//                curr = next;
//                if(curr!=null){
//                    next = curr.next;
//                }else{
//                    next = null;
//                }
//            }else{
//                prev.next = curr;
//                prev = curr;
//                curr = curr.next;
//                next = next.next;
//            }
//        }
//        prev.next = curr;
//        return dummy.next;
//    }

    //迭代,简洁,遇到相同的就跳过
//    public ListNode deleteDuplicates(ListNode head){
//        ListNode curr = head;
//        while(curr!=null && curr.next!=null){
//            if(curr.val == curr.next.val){
//                //遇到相同的就跳过,不移动curr指针
//                curr.next = curr.next.next;
//            }else{
//                //遇到不同的移动curr指针
//                curr = curr.next;
//            }
//        }
//        return head;
//    }
}
