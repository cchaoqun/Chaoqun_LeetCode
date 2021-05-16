package DuoPointer.duopointers;
/*
 * @Description: 86. 分隔链表
给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。

你应当 保留 两个分区中每个节点的初始相对位置。



示例 1：


输入：head = [1,4,3,2,5,2], x = 3
输出：[1,2,2,4,3,5]
示例 2：

输入：head = [2,1], x = 2
输出：[1,2]


提示：

链表中节点的数目在范围 [0, 200] 内
-100 <= Node.val <= 100
-200 <= x <= 200
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/13 22:49
 */
public class LC86 {

    //维护两个单链表一条存储比x小的结点,一条存储比x大的结点
    public ListNode partition(ListNode head, int x) {
        //small large 为两条单链表的尾结点
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        //smallHead largeHead 为两条单链表的头结点
        //四个链表初始化都为dummy结点
        ListNode smallHead = small;
        ListNode largeHead = large;
        //遍历原始单链表
        while(head!=null){
            if(head.val<x){
                //<x的连接在small后面,small移动到链表尾
                small.next = head;
                small = small.next;
            }else{
                //>x的连接在large后面,large移动到链表尾
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        //large链表的链表尾结点可能还连接在原始的链表上,断开这个可能的链接
        large.next = null;
        //small链表的链表尾连接到large链表的表头,为large链表dummy结点的后一个结点
        small.next = largeHead.next;
        //整个链表头尾small链表的dummy结点后一个结点    
        return smallHead.next;
    }
}
