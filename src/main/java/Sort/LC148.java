package Sort;
/*
 * @Description: 148. 排序链表
给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。

进阶：

你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？


示例 1：


输入：head = [4,2,1,3]
输出：[1,2,3,4]
示例 2：


输入：head = [-1,5,3,4,0]
输出：[-1,0,3,4,5]
示例 3：

输入：head = []
输出：[]


提示：

链表中节点的数目在范围 [0, 5 * 104] 内
-105 <= Node.val <= 105
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/15 10:35
 */
public class LC148 {


    //自顶向下归并排序
//    public ListNode sortList(ListNode head) {
//        return sort(head, null);
//
//    }
//
//    //自顶向下分治
//    public ListNode sort(ListNode head, ListNode tail){
//        if(head==null){
//            return head;
//        }
//        //链表只有头尾两个结点或者只有一个结点，返回头节点
//        if(head.next==tail){
//            head.next = null;
//            return head;
//        }
//        //找到链表中间结点
//        ListNode fast = head, slow = head;
//        while(fast!=tail){
//            slow = slow.next;
//            fast = fast.next;
//            if(fast!=tail){
//                fast = fast.next;
//            }
//        }
//        //将链表分成 head---->mid mid---->tail 再继续分治
//        ListNode mid = slow;
//        ListNode list1 = sort(head, mid);
//        ListNode list2 = sort(mid, tail);
//        //按升序合并head--->mid mid---->tail
//        ListNode newHead = merge(list1, list2);
//        //返回head
//        return newHead;
//
//    }

    //按升序合并两个单链表
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0), dummyHead = dummy, temp1 = head1, temp2 = head2;
        //结点值较小的放在新的链表的后面
        while(temp1!=null && temp2!=null){
            if(temp1.val<temp2.val){
                dummyHead.next = temp1;
                temp1 = temp1.next;
            }else{
                dummyHead.next = temp2;
                temp2 = temp2.next;
            }
            dummyHead = dummyHead.next;
        }
        //如果其中一个链表插入完了,将剩下的链表直接放在新链表的后面
        if(temp1==null){
            dummyHead.next = temp2;
        }else{
            dummyHead.next = temp1;
        }
        //返回头结点,为哑结点的后面一个位置
        return dummy.next;
    }


    //自底向上
    public ListNode sortList(ListNode head){
        if(head==null){
            return head;
        }
        //计算链表长度
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            ++len;
            temp = temp.next;
        }
        //每次排序子链表的长度
        int subLen = 1;
        //哑结点
        ListNode dummy = new ListNode(0, head);
        //位运算效率更高,每次subLen变为原来的2倍
        for(subLen = 1; subLen<len; subLen<<=1){
            ListNode prev = dummy, curr = dummy.next;
            while(curr!=null){
                //第一条链表头
                ListNode head1 = curr;
                //使得第一条链表长度为subLen,最后一条链表长度可以小于subLen
                for(int i=1; i<subLen && curr.next!=null; ++i){
                    curr = curr.next;
                }
                //第二条链表头
                ListNode head2 = curr.next;
                //断开第一条链表与后续链表的链接
                curr.next = null;
                curr = head2;
                for(int i=1; i<subLen && curr!=null && curr.next!=null; ++i){
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr!=null){
                    //保存下一次分治的链表头
                    next = curr.next;
                    //断开第二条链表与后续链表的链接
                    curr.next = null;
                }
                //将拆分开的两条链表按升序合并
                ListNode merged = merge(head1, head2);
                //将合并后链表连接到prev后面(dummy)
                prev.next = merged;
                //将prev移动到合并后的链表尾
                while(prev.next!=null){
                    prev = prev.next;
                }
                //curr指针移动到后续链表头,这样prev依然在curr前一个位置
                curr = next;
            }
        }
        return dummy.next;
    }

}
