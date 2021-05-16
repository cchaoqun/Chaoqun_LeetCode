package DepthFirstSearch.dfs0111;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description: 129. 求根到叶子节点数字之和
 *
给定一个二叉树，它的每个结点都存放一个0-9的数字，每条从根到叶子节点的路径都代表一个数字。
例如，从根到叶子节点路径 1->2->3 代表数字 123。
计算从根到叶子节点生成的所有数字之和。
说明:叶子节点是指没有子节点的节点。
*
示例 1:
输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.
*
示例 2:
输入: [4,9,0,5,1]
    4
   / \
  9   0
/ \
5   1
输出: 1026
解释:
从根到叶子节点路径 4->9->5 代表数字 495.
从根到叶子节点路径 4->9->1 代表数字 491.
从根到叶子节点路径 4->0 代表数字 40.
因此，数字总和 = 495 + 491 + 40 = 1026.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-root-to-leaf-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/11 16:28
 */
public class LC129 {

    //list存储
//    public int sumNumbers(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        String path = "";
//        List<String> list = new ArrayList<>();
//        dfs(root,path,list);
//        int res = 0;
//        for(String s : list){
//            res += Integer.parseInt(s);
//        }
//        return res;
//    }
//
//    /*
//     * @Description:
//     *
//     * @param node 当前结点
//     * @param path 根结点到当前结点的路径字符串
//     * @param list 保留每个从根结点到叶子结点的路径字符串的list集合
//     */
//    public void dfs(TreeNode node, String path, List<String> list){
//        if(node==null){
//            return;
//        }
//        //将当前结点的值添加到路径
//        path = path+node.val;
//        if(node.left==null && node.right==null){
//            //当前结点为叶子结点,将路径字符串添加到list集合
//            list.add(path);
//            return;
//        }
//        //在左右子节点递归
//        dfs(node.left,path,list);
//        dfs(node.right,path,list);
//    }

    //数字存储
//    public int sumNumbers(TreeNode root){
//        return dfs(root,0);
//    }
//
//    public int dfs(TreeNode node, int sum){
//        if(node == null){
//            return 0;
//        }
//        sum = sum*10+node.val;
//        if(node.left==null && node.right==null){
//            return sum;
//        }
//        return dfs(node.left, sum)+dfs(node.right, sum);
//    }

    //BFS
    public int sumNumbers(TreeNode root){
        if(root == null){
            return 0;
        }
        //创建两个队列
        // 一个存储结点一个存储结点的值
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> valQueue = new LinkedList<>();
        //根结点入队
        nodeQueue.offer(root);
        valQueue.offer(root.val);
        int sum = 0;
        while(!nodeQueue.isEmpty()){
            //出队
            TreeNode node = nodeQueue.poll();
            int val = valQueue.poll();
            TreeNode left=node.left, right=node.right;
            if(node.left==null && node.right==null){
                sum += val;
            }
            if(left!=null){
                left.val = val*10+left.val;
                nodeQueue.offer(left);
                valQueue.offer(left.val);
            }
            if(right!=null){
                right.val = val*10+right.val;
                nodeQueue.offer(right);
                valQueue.offer(right.val);
            }
        }
        return sum;



    }
}
