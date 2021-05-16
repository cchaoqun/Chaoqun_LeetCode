package LinkedList.linkedlist0224;
/*
 * @Description: 203. 移除链表元素
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 17:47
 */
public class LC203 {

    public ListNode removeElements(ListNode head, int val) {
        //添加烧饼结点
        ListNode dummy = new ListNode(val-1,head), prev = dummy, curr = head;
        while(curr!=null){
            //当前结点值为目标值
            if(curr.val == val){
                //跳过当前结点
                curr = curr.next;
                //prev指针指向curr
                prev.next = curr;
            }else{
                //两个指针均后移一位
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }
}
