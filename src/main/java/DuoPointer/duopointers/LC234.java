package DuoPointer.duopointers;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 234. 回文链表
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
进阶：
你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/14 11:33
 */
public class LC234 {


    //ArrayList
    public boolean isPalindrome(ListNode head) {
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();
        while(cur!=null){
            list.add(cur);
            cur = cur.next;
        }
        int len = list.size();
        int i = 0;
        while(i<len/2){
            if(list.get(i).val != list.get(len-1-i).val){
                return false;
            }
            ++i;
        }
        return true;
    }

    //数组实现
//    public boolean isPalindrome(ListNode head){
//        ListNode cur = head;
//        List<Integer> list = new ArrayList<>();
//        while(cur!=null){
//            list.add(cur.val);
//            cur = cur.next;
//        }
//        int len = list.size()-1;
//        int i = 0;
//        while(i<len){
//            if(!list.get(i).equals(list.get(len))){
//                return false;
//            }
//            ++i;
//            --len;
//        }
//        return true;
//    }


    //翻转后半部分,在比较,最后还原链表
//    public boolean isPalindrome(ListNode head){
//        if(head==null){
//            return true;
//        }
//
//        ListNode firstend = findMid(head);
//        ListNode secondhead = reverseList(firstend.next);
//
//        ListNode p1 = head, p2 = secondhead;
//        while(p2!=null){
//            if(p1.val!=p2.val){
//                return false;
//            }
//            p1 = p1.next;
//            p2 = p2.next;
//        }
//        firstend.next = reverseList(secondhead);
//        return true;
//
//    }
//
//    //翻转链表
//    public ListNode reverseList(ListNode head){
//        ListNode prev = null;
//        ListNode curr = head;
//        while(curr!=null){
//            //保存当前结点的后一个结点
//            ListNode currNext = curr.next;
//            //当前结点指向之前的结点
//            curr.next = prev;
//            //prev指针移到当前结点
//            prev = curr;
//            //curr指针移动到当前结点的下一个
//            curr = currNext;
//        }
//        return prev;
//    }
//
//    //找到链表的中点结点
//    public ListNode findMid(ListNode head){
//        ListNode fast = head, slow = head;
//        while(fast.next!=null && fast.next.next!=null){
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
}
