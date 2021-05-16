package DepthFirstSearch.dfs0111;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 199. 二叉树的右视图
 *
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
示例:
输入:[1,2,3,null,5,null,4]
输出:[1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-right-side-view
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/11 18:00
 */
public class LC199 {

    //BFS 返回每一层最右结点
//    public List<Integer> rightSideView(TreeNode root) {
//        if(root==null){
//            return new ArrayList<Integer>();
//        }
//        List<Integer> list = new ArrayList<>();
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        //临时变量保存每一层最右结点
//        TreeNode temp = null;
//        while(!queue.isEmpty()){
//            //每一轮置空temp
//            temp = null;
//            int size = queue.size();
//            while(size>0){
//                temp = queue.poll();
//                if(temp.left!=null){
//                    queue.offer(temp.left);
//                }
//                if(temp.right!=null){
//                    queue.offer(temp.right);
//                }
//                size--;
//            }
//            //结束本层循环,temp=最右子节点
//            list.add(temp.val);
//        }
//        return list;
//    }

    //DFS 递归寻找结点的右子节点
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> list = new ArrayList<>();
        dfs(root,list,0);
        return list;
    }

    public void dfs(TreeNode root, List<Integer> list, int level){
        if(root==null){
            return;
        }
        //下面条件成立表示当前结点时该层第一个访问到的结点
        //level表示第几层,level==list.size()表示这一层是第一次被访问到,
        //总是优先访问右子树,该层第一次被访问到的结点就是最右的结点
        if(level==list.size()){
            list.add(root.val);
        }
        dfs(root.right,list,level+1);
        dfs(root.left,list,level+1);


    }


}
