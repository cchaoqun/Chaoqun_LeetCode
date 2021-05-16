package DuoPointer.duopointers;

import java.util.HashSet;
import java.util.Set;

/*
 * @Description: 142. 环形链表 II
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

说明：不允许修改给定的链表。

进阶：

你是否可以使用 O(1) 空间解决此题？


示例 1：



输入：head = [3,2,0,-4], pos = 1
输出：返回索引为 1 的链表节点
解释：链表中有一个环，其尾部连接到第二个节点。
示例 2：



输入：head = [1,2], pos = 0
输出：返回索引为 0 的链表节点
解释：链表中有一个环，其尾部连接到第一个节点。
示例 3：



输入：head = [1], pos = -1
输出：返回 null
解释：链表中没有环。


提示：

链表中节点的数目范围在范围 [0, 104] 内
-105 <= Node.val <= 105
pos 的值为 -1 或者链表中的一个有效索引
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/14 10:39
 */
public class LC142 {

    //快慢指针 fast slow
    //链表的两个部分,第一部分单链表长度为a 第二部分环的长度为b
    //fast slow第一次相遇的时候,fast走了f, slow走了s,fast比slow多走了nb(整数倍环形的长度), 同时fast的走的长度为slow走的两倍,因为fast每次走两步,slow每次走一步
    // f = s + nb  f = 2s ==> s = nb, f = 2nb
    // 从head走到环入口结点的步数为k=a+nb, slow已经走了nb步, 还需要再走a步才能到达入口点,
    // 让fast移动到head,两人相遇的时候刚好走了a步,在入口结点相遇
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode fast = head, slow = head;
        //找到fast slow 指针第一次相遇的地方
        while(fast!=null){
            //如果fast后面两个结点存在null说明无环
            if(fast.next==null || fast.next.next==null){
                return null;
            }
            //快指针后移两个
            fast = fast.next.next;
            //慢指针后移一个
            slow = slow.next;
            //如果两个指针相遇,跳出循环
            if(fast==slow){
                break;
            }
        }
        //判断跳出循环的情况如果为fast指针到达null,则无环
        if(fast==null){
            return null;
        }
        //跳出循环条件为快慢指针在环内相遇
        //将快指针移到链表头
        fast = head;
        //快慢指针继续后移,当两个指针再次相遇的时候,即为入口点
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //哈希表
//    public ListNode detectCycle(ListNode head){
//        ListNode cur = head;
//        Set<ListNode> set = new HashSet<>();
//        while(cur!=null){
//            if(set.contains(cur)){
//                return cur;
//            }else{
//                set.add(cur);
//            }
//            cur = cur.next;
//        }
//        return null;
//    }
}
