package company.bytedance;

import Tree.ListNode;

import java.util.PriorityQueue;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/2-13:00
 */

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b)->a.val-b.val);
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        for(ListNode l : lists){
            if(l!=null){
                minHeap.offer(l);
            }

        }
        while(!minHeap.isEmpty()){
            ListNode cur = minHeap.poll();
            head.next = cur;
            head = head.next;
            if(cur.next!=null){
                minHeap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}

class LC23_M2{
    public ListNode mergeKLists(ListNode[] lists) {
        return half(lists, 0, lists.length-1);
    }

    private ListNode half(ListNode[] lists, int lo, int hi){
        //全部合并完, 只剩一个listnode
        if(lo==hi){
            return lists[lo];
        }
        //lists为空
        if(lo>hi){
            return null;
        }
        //两个一组合并成一个, 一共有hi-lo+1个listNode, +1 是为了处理奇数个的情况, 只剩一个ListNode 也会变成一个
        int mid = (hi-lo+1+1)/2;
        ListNode[] nextNodes = new ListNode[mid];
        int index = 0;
        while(index<mid && lo<hi){
            //按顺序从左到右合并两个
            ListNode cur = merge(lists[lo], lists[lo+1]);
            nextNodes[index++] = cur;
            lo += 2;
        }
        //lists有奇数个listNdoe
        if(lo==hi){
            nextNodes[index] = lists[lo];
        }
        return half(nextNodes, 0, mid-1);
    }
    //合并两个升序链表
    private ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(node1!=null && node2!=null){
            if(node1.val<=node2.val){
                res.next = node1;
                node1 = node1.next;
            }else{
                res.next = node2;
                node2 = node2.next;
            }
            res = res.next;
        }
        res.next = node1==null?node2:node1;
        return dummy.next;
    }
}
