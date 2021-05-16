package DepthFirstSearch.dfs0110;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/binary-tree-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/10 14:57
 */
public class LC257 {
    public static void main(String[] args) {

    }

    //DFS 递归
    public static List<String> binaryTreePaths(TreeNode root){
        List<String> pathList = new ArrayList<>();
        String pathStr = "";
        getAllPath(root,pathStr,pathList);
        return pathList;

    }

    public static void getAllPath(TreeNode root, String pathStr, List<String> pathList){
        if(root == null){
            return;
        } else{
            StringBuilder sb = new StringBuilder();
            //当前结点添加到路径
            sb.append(pathStr).append(root.val+"");
            //判断当前结点是否是叶子结点
            if(root.left == null && root.right == null){
                //是叶子结点则添加到list集合中
                pathList.add(sb.toString());
            }else{
                //当前结点不是叶子结点,递归查找子节点
                getAllPath(root.left,sb.append("->").toString(),pathList);
                getAllPath(root.right,sb.append("->").toString(),pathList);
            }
        }
    }

    //DFS 非递归
//    public static List<String> binaryTreePaths(TreeNode root){
//        List<String> list = new ArrayList<>();
//        if(root == null){
//            return list;
//        }
//        //栈中保存的结点和路径都是对应入栈和出栈的
//        Stack<Object> stack = new Stack<>();
//        //当前结点和路径同时入栈
//        stack.push(root);
//        stack.push(root.val+"");
//        while(!stack.isEmpty()){
//            //对应结点和路径同时出栈
//            String path = (String)stack.pop();
//            TreeNode node = (TreeNode)stack.pop();
//
//            //如果为叶子结点就将路径添加到list集合
//            if(node.left==null && node.right==null){
//                list.add(path);
//            }
//
//            //非叶子结点
//            if(node.right!=null){
//                stack.push(node.right);
//                stack.push(path+"->"+node.right.val);
//            }
//            if(node.left!=null){
//                stack.push(node.left);
//                stack.push(path+"->"+node.left.val);
//            }
//
//        }
//        return list;
//    }

    //BFS
//    public static List<String> binaryTreePaths(TreeNode root){
//        List<String> paths = new ArrayList<>();
//        Queue<TreeNode> node = new LinkedList<>();
//        Queue<String> path = new LinkedList<>();
//        if(root==null){
//            return paths;
//        }
//        node.offer(root);
//        path.offer(root.val+"");
//        //结点队列不为空
//        while(!node.isEmpty()){
//            TreeNode tempNode = node.poll();
//            String tempPath = path.poll();
//
//            //该结点为叶子结点,说明找到一条完整的路径
//            if(tempNode.left==null && tempNode.right==null){
//                //将路径添加到paths集合中
//                paths.add(tempPath);
//            }else{
//                //如果右子节点不为空,就把右子节点和路径存放到队列中
//                if(tempNode.right!=null){
//                    node.offer(tempNode.right);
//                    path.offer(tempPath+"->"+tempNode.right.val);
//                }
//                //如果左子节点不为空,就把左子节点和路径存放到队列中
//                if(tempNode.left!=null){
//                    node.offer(root.left);
//                    path.offer(tempPath+"->"+tempNode.left.val);
//                }
//            }
//        }
//        return paths;
//    }

    //递归
}
