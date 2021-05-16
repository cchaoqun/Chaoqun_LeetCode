package LinkedList.linkedlist0224;
/*
 * @Description: 237. 删除链表中的节点
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:

示例 1：

输入：head = [4,5,1,9], node = 5
输出：[4,1,9]
解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
示例 2：

输入：head = [4,5,1,9], node = 1
输出：[4,5,9]
解释：给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.


提示：

链表至少包含两个节点。
链表中所有节点的值都是唯一的。
给定的节点为非末尾节点并且一定是链表中的一个有效节点。
不要从你的函数中返回任何结果。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 18:04
 */
public class LC237 {

    public void deleteNode(ListNode node) {
        //因为无法访问node之前的结点,依旧无法通过prev.next = prev.next.next删除目标结点
        //将node.val替换成后一个结点的值
        node.val = node.next.val;
        //删除后一个结点
        //因为待删除结点不是最后一个结点,可以保证这个样的方法一定是有效的
        node.next = node.next.next;
    }
}
