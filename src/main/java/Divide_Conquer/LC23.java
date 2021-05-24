package Divide_Conquer;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 *
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/22-9:55
 */

public class LC23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return quickSelect(lists, 0, lists.length-1);
    }

    /**
     * 合并lists数组中 [lo,hi]闭区间的链表
     */
    public ListNode quickSelect(ListNode[] lists, int lo, int hi){
        //空区间, 没有链表
        if(lo>hi){
            return null;
        }
        //区间只有一个链表直接返回这个链表
        if(lo==hi){
            return lists[hi];
        }
        //将区间两列合并, 合并后区间剩下一半的链表
        //如果当前链表个数为奇数或偶数都应该剩下 (n+1)/2个链表
        int nextNodes = (hi-lo+1+1)/2;
        //合并后新的链表数组
        ListNode[] next = new ListNode[nextNodes];
        //新链表的索引
        int index = 0;
        while(index<nextNodes && lo<hi){
            //按顺序两两合并
            ListNode cur = merge(lists[lo], lists[lo+1]);
            //当前位置为合并后的链表
            next[index] = cur;
            //索引右移一位
            index++;
            //合并了 lo, lo+1两个位置的lists[]中的链表, 下一轮从lo+2开始合并
            lo += 2;
        }
        //lists[]原本有奇数个链表, 漏掉了最后一个没有合并, 单独的链表直接添加
        if(lo==hi){
            next[index]=lists[hi];
        }
        //接着两两合并 合并后新的链表数组next中的链表
        return quickSelect(next, 0, next.length-1);
    }
    
    //合并两个链表
    public ListNode merge(ListNode node1, ListNode node2){
        ListNode p1 = node1;
        ListNode p2 = node2;
        //哑结点, 合并后的链表头为dummy.next
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(p1!=null && p2!=null){
            if(p1.val<=p2.val){
                res.next = p1;
                p1 = p1.next;
            }else{
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
            res.next = null;
        }
        //还有剩余的直接添加到res.next
        res.next = p1==null?p2:p1;
        return dummy.next;
    }
}

class LC23_M2{
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length==0){
            return null;
        }
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi){
        if(lo==hi){
            return lists[lo];
        }
        int mid = lo+(hi-lo)/2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid+1, hi);
        return merge2Lists(l1, l2);
    }

    //递归合并两个链表
    private ListNode merge2Lists(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }
        l2.next = merge2Lists(l1, l2.next);
        return l2;
    }
}

class LC23_M3{
    //优先队列
    public ListNode mergeKLists(ListNode[] lists){
        //按链表头的最小排列
        Queue<ListNode> pq = new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        for(ListNode l:lists){
            if(l!=null){
                pq.offer(l);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur =  dummy;
        while(!pq.isEmpty()){
            //出队一个链表, 链表头添加到新的链表
            cur.next = pq.poll();
            cur = cur.next;
            //出队链表剩下的部分非空就入队
            if(cur.next!=null){
                pq.offer(cur.next);
            }
        }
        return dummy.next;

    }
}

class LC{
    //递归合并两个链表
    private ListNode merge2Lists(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        if(l1.val<l2.val){
            l1.next = merge2Lists(l1.next, l2);
            return l1;
        }
        l2.next = merge2Lists(l1, l2.next);
        return l2;
    }

    //迭代合并两个链表
    public ListNode merge(ListNode node1, ListNode node2){
        ListNode p1 = node1;
        ListNode p2 = node2;
        //哑结点, 合并后的链表头为dummy.next
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(p1!=null && p2!=null){
            if(p1.val<=p2.val){
                res.next = p1;
                p1 = p1.next;
            }else{
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
            res.next = null;
        }
        //还有剩余的直接添加到res.next
        res.next = p1==null?p2:p1;
        return dummy.next;
    }
}


























