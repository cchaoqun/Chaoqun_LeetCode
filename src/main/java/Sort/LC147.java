package Sort;


/*
 * @Description: 147. 对链表进行插入排序
对链表进行插入排序。


插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。



插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。


示例 1：

输入: 4->2->1->3
输出: 1->2->3->4
示例 2：

输入: -1->5->3->4->0
输出: -1->0->3->4->5
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/14 13:42
 */
public class LC147 {

    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return null;
        }
        //dummy结点放在新链表头结点的前面
        ListNode newHead = head, dummy = new ListNode(0,newHead), node = head.next;
        //断开新链表头与原始链表的链接
        newHead.next = null;
        while(node!=null){
            //保留当前结点的后一个结点
            ListNode temp = node.next;
            //将当前结点插入
            insert(dummy,node);
            //遍历的结点
            node = temp;
        }
        return dummy.next;
    }

    //将node结点插入到链表头尾head的链表中
    public void insert(ListNode head, ListNode node){
        ListNode prev = head, cur = head.next;
        //插入的位置为第一个大于待插入结点的前面一个位置,需要借助两个指针来实现
        while(cur!=null && node.val>cur.val){
            prev = prev.next;
            cur = cur.next;
        }
        //插入位置在prev和cur结点中间
        ListNode tempcur = cur;
        prev.next = node;
        node.next = tempcur;
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

