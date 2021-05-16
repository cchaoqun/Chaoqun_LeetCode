package DepthFirstSearch.dfs0110;

/*
 * @Description: 109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。

示例:

给定的有序链表： [-10, -3, 0, 5, 9],

一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/10 21:54
 */
public class LC109 {

//    public TreeNode sortedListToBST(ListNode head) {
//        List<Integer> list = new ArrayList<>();
//        while(head!=null){
//            list.add(head.val);
//            head = head.next;
//        }
//        int n = list.size();
//        if(n==0){
//            return null;
//        }
//        int[] nums = new int[n];
//        //获取单链表对应的数组
//        for(int i=0; i<n; i++){
//            nums[i] = list.remove(0);
//        }
//        //构造二叉搜索树
//        return constructAVL(nums,0,n-1);
//
//    }
//
//    public TreeNode constructAVL(int[] nums,int left, int right){
//        while(left<right){
//            //总是选取中间点作为根结点
//            int mid = left+(right-left)/2;
//            TreeNode root = new TreeNode(nums[mid]);
//            root.left = constructAVL(nums,0,mid-1);
//            root.right = constructAVL(nums,mid+1,nums.length-1);
//            return root;
//        }
//        return null;
//    }


    //快慢指针
    public TreeNode sortedListToBST(ListNode head){
        return buildTree(head,null);
    }
    public TreeNode buildTree(ListNode left, ListNode right){
        if(left==right){
            return null;
        }
        ListNode mid = getMedian(left,right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left,mid);
        root.right = buildTree(mid.next,right);
        return root;

    }
    //找出链表中位数节点的方法多种多样，其中较为简单的一种是「快慢指针法」。
    // 初始时，快指针和慢指针均指向链表的左端点。
    // 我们将快指针向右移动两次的同时，将慢指针向右移动一次，直到快指针到达边界
    // （即快指针到达右端点或快指针的下一个节点是右端点）。
    // 此时，慢指针对应的元素就是中位数。

    public ListNode getMedian(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while(fast!=right && fast.next!=right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}



//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */