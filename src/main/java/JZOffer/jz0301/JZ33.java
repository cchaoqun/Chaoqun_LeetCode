package JZOffer.jz0301;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @Description: 剑指 Offer 33. 二叉搜索树的后序遍历序列
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。



参考以下这颗二叉搜索树：

     5
    / \
   2   6
  / \
 1   3
示例 1：

输入: [1,6,3,2,5]
输出: false
示例 2：

输入: [1,3,2,6,5]
输出: true


提示：

数组长度 <= 1000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/1 17:48
 */
public class JZ33 {

    //递归
//    public boolean verifyPostorder(int[] postorder) {
//        return recur(postorder,0, postorder.length-1);
//    }
//
//    //递归找到根结点的左子树右子树范围,在左右子树上进行递归
//    //返回条件为区间只剩一个元素
//    boolean recur(int[] postorder, int i, int j){
//        if(i>=j){
//            return true;
//        }
//        int p = i;
//        while(postorder[p]< postorder[j]){
//            ++p;
//        }
//        //找到左右子树的分割点[0,m-1] -> 左子树 [m,j-1] -> 右子树 [j]根结点
//        //postorder[0,m-1]<postorder[j] postorder[m,j-1]>postorder[j]
//        int m = p;
//        while(postorder[m]> postorder[j]){
//            ++m;
//        }
//        //     当前        左子树                       右子树
//        return m==j && recur(postorder,i,m-1) && recur(postorder,m,j-1);
//    }

    //单调栈
    public boolean verifyPostorder(int[] postorder){
        //单调递增的单调栈
        Deque<Integer> stack = new LinkedList<>();
        //上一个根结点的元素
        //把这里的postorder最后一个元素root看成无穷大结点的左孩子
        int prevElem = Integer.MAX_VALUE;
        //逆序遍历,就是翻转的先序遍历 根结点->右子树->左子树
        for(int i=postorder.length-1; i>=0; --i){
            //左子树必须要小于递增栈被peek()访问的元素,否则就不是二叉树了
            if(postorder[i] > prevElem){
                return false;
            }

            while(!stack.isEmpty() && postorder[i] < stack.peek()){
                //数组元素小于单调栈的元素,说明往左子树走了,记录下上个根结点
                //找到这个左子树的根结点,之前右子树全部弹出,因为不可能往根结点右子树走了
                prevElem = stack.pop();
            }
            //当前结点入栈
            stack.push(postorder[i]);
        }
        return true;
    }
}
