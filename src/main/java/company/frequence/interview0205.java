package company.frequence;

import Tree.ListNode;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/8-12:40
 */

public class interview0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return helper(l1,l2,0);
    }

    // c 是 carry
    private ListNode helper(ListNode l1, ListNode l2, int c){
        // 两个链表都空了, 需要判断是否还有进位
        if(l1 == null && l2 ==null){
            // 没有进位, 返回null
            if(c==0){
                return null;
            }else{
                // 还有进位, 创建对应值的结点返回
                return new ListNode(c);
            }
        }
        // 获取l1 l2 当前结点的值. 如果为null 值为0
        int num1 = l1==null?0:l1.val;
        int num2 = l2==null?0:l2.val;
        // 计算当前结点的相加后剩下的余数
        int cur = (num1+num2+c)%10;
        // 计算进位
        c = (num1+num2+c)/10;
        // 创建当前结点
        ListNode node = new ListNode(cur);
        // 更新l1 l2 根据是否为空判断是否变成next
        l1 = l1==null?l1:l1.next;
        l2 = l2==null?l2:l2.next;
        // 递归获取剩下的链表, 并接在当前结点的后面
        node.next = helper(l1,l2,c);
        // 返回当前结点
        return node;
    }
}
