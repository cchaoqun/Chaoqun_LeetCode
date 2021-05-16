package JZOffer.jz0227;


import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 剑指 Offer 06. 从尾到头打印链表
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。



示例 1：

输入：head = [1,3,2]
输出：[2,3,1]


限制：

0 <= 链表长度 <= 10000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/27 12:03
 */
public class JZ6 {

    List<Integer> res=  new ArrayList<>();
    //递归,利用回溯过程逆向打印链表
    public int[] reversePrint(ListNode head) {
        //空链表的情况
        if(head==null){
            return new int[0];
        }
        //递归
        dfs(head);
        int[] resArr = new int[res.size()];
        int i=0;
        //为数组赋值
        for(int num:res){
            resArr[i] = num;
            ++i;
        }
        return resArr;
    }
    //递归
    public void dfs(ListNode head){
        //到达链表末尾结点
        if(head.next==null){
            //第一个添加的数
            res.add(head.val);
            return;
        }
        //递归
        dfs(head.next);
        //递归回来后再添加当前结点的值
        res.add(head.val);
    }

    //利用栈
//    public int[] reversePrint(ListNode head){
//        //维护栈
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        int size = 0;
//        while(head!=null){
//            //当前结点值压栈
//            stack.push(head.val);
//            head = head.next;
//            ++size;
//        }
//        int i=0;
//        int[] res = new int[size];
//        while(i<size){
//            res[i] = stack.pop();
//            ++i;
//        }
//        return res;
//
//    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

