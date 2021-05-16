package DuoPointer.duopointers;


import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description: 19. 删除链表的倒数第 N 个结点
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

进阶：你能尝试使用一趟扫描实现吗？



示例 1：


输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
示例 2：

输入：head = [1], n = 1
输出：[]
示例 3：

输入：head = [1,2], n = 1
输出：[1]


提示：

链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/13 21:23
 */
public class LC19 {


    //双指针 无dummy结点,需要判断删除的为头结点的情况
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode quick = head, slow = head;
//        //快指针先走n个结点
//        while(n!=0){
//            quick = quick.next;
//            --n;
//        }
//        //如果快指针已经到达null,说明删除的结点为头结点
//        if(quick==null){
//            //临时结点保存头结点
//            ListNode temp = head.next;
//            //解除头结点的链接
//            head.next = null;
//            //剩下的链表的头结点为之前head结点的下一个结点
//            return temp;
//        }
//        //当快指针到达链表的最后一个结点的时候,慢指针到达了要删除结点的前一个结点
//        while(quick.next!=null){
//            quick = quick.next;
//            slow = slow.next;
//        }
//        //待删除的结点为慢指针后面的结点
//        slow.next = slow.next.next;
//        return head;
//
//    }


    //双指针,添加dummy结点,无需考虑删除头结点的情况
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0, head);
        ListNode quick = head, slow = dummy;
        while(n!=0){
            quick = quick.next;
            --n;
        }
        while(quick!=null){
            quick = quick.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    //栈
//    public ListNode removeNthFromEnd(ListNode head, int n){
//        //dummy结点在head的前面
//        ListNode dummy = new ListNode(0, head);
//        //将结点全部添加到栈
//        Deque<ListNode> stack = new LinkedList<>();
//        ListNode cur = dummy;
//        while(cur!=null){
//            stack.push(cur);
//            cur = cur.next;
//        }
//        //出栈n个结点
//        for(int i=0; i<n; ++i){
//            stack.pop();
//        }
//        //栈顶的结点为待删除结点的前一个结点
//        ListNode prev = stack.peek();
//        //删除待删除结点
//        prev.next = prev.next.next;
//        //返回dummy结点的后一个结点为链表的头结点
//        return dummy.next;
//    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
