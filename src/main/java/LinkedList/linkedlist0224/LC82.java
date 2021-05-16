package LinkedList.linkedlist0224;
/*
 * @Description: 82. 删除排序链表中的重复元素 II
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 10:34
 */
public class LC82 {

    //迭代
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = dummy, curr = head, next = head.next;
        while(prev!=null && curr!=null && next!=null){
            if(curr.val!=next.val){
                //更新指针关系
                prev.next = curr;
                prev = curr;
                curr = next;
                next = next.next;
            }else{
                //找到下一个不相等的结点
                while(next!=null && next.val==curr.val){
                    next = next.next;
                }
                //curr指向下一个与当前结点不相等的结点
                curr = next;
                //避免空指针异常
                if(curr!=null){
                    next = curr.next;
                }else{
                    next = null;
                }
            }

        }
        prev.next = curr;
        return dummy.next;
    }

    //递归
//    public ListNode deleteDuplicates(ListNode head){
//        if(head==null || head.next==null){
//            return head;
//        }
//        //head和下一个结点值不同
//        if(head.val!=head.next.val){
//            //head指向以head.next为头结点的删除重复元素的单链表
//            head.next = deleteDuplicates(head.next);
//            //返回head
//            return head;
//        }else{
//            //head与下一个结点值相同,移动到下一个不同的结点
//            while(head!=null && head.val==head.next.val){
//                head = head.next;
//            }
//            //直接返回以下一个不同的结点为头结点的删除重复元素的链表
//            return deleteDuplicates(head.next);
//        }
//    }
}
