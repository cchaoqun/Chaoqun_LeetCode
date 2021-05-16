package LinkedList.linkedlist0224;
/*
 * @Description: 21. 合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。



示例 1：


输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]


提示：

两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列
 *
 * @param null
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 9:12
 */
public class LC21 {
    public static void main(String[] args) {
        ListNode temp = new ListNode();
        System.out.println(temp!=null);
    }

    //迭代
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyNew = new ListNode(-101);
        //双指针
        ListNode curr = dummyNew;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = l1==null?l2:l1;
        return dummyNew.next;
    }

    //递归
    /**
     * list1[0] + merge(list1[1:], list2) list1[0]<list2[0]
     * list2[0] + merge(list1, list2[1:]) otherwise
     */
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        //判断两个链表有空的情况
//        if(l1==null){
//            return l2;
//        }else if(l2==null){
//            return l1;
//        }else if(l1.val < l2.val){
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }else{
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }
//    }

}





class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
