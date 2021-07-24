package JZOffer.review;

import Tree.ListNode;

/**剑指 Offer 06. 从尾到头打印链表
 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



 示例 1：

 输入：head = [1,3,2]
 输出：[2,3,1]


 限制：

 0 <= 链表长度 <= 10000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/21-15:18
 */

public class jz06 {
    // 遍历链表获得长度
    // 创建数组
    // 遍历链表知道了链表长度就知道了对应的位置
    public int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[0];
        }
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int[] res = new int[len];
        while(head!=null){
            res[len-1] = head.val;
            len--;
            head = head.next;
        }
        return res;
    }
}

class jz06_M2{
    int[] res;
    public int[] reversePrint(ListNode head) {
        if(head==null){
            return new int[0];
        }
        recursion(head, 1);
        return res;
    }
    //利用递归的特性, 返回的时候给对应数组位置赋值
    //链表尾创建数组, 将结点值填入res[0] 返回1 返回的值就是上一个结点对应数组的下标
    //len参数表示从头到当前结点有多少个结点 包括当前结点
    //通过递归的返回值直到当前结点的下标 并将下标+1返回给上一层
    private int recursion(ListNode head, int len){
        if(head.next==null){
            res = new int[len];
            res[0] = head.val;
            return 1;
        }
        int index = recursion(head.next, len+1);
        res[index] = head.val;
        return index+1;
    }
}
