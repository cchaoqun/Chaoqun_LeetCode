package Tree.tree0422;

import Tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/22-21:25
 */

public class LC958 {
    //BFS 从右到左
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null&& root.right==null){
            return true;
        }
        //获取数的最大深度[1,...]
        int depth = dfs(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //代表每一层遍历的层数
        int dep = 1;
        while(!queue.isEmpty()){
            for(int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                //如果处在倒数第二层, 从右到左的BFS
                if(dep==depth-1){
                    //如果当前结点子节点个数为0 不影响
                    //如果当前结点的子节点个数为1
                    if(child(node)==1){
                        //倒数第二层任意结点左子节点为null 右子节点不为null 都不符合
                        if(node.left==null){
                            return false;
                        }
                        //从右到左, 如果当前只有一个子节点, 必须当前结点为最左结点, 或者下一个结点必须有两个子节点
                        if(!queue.isEmpty() && child(queue.peek())!=2){
                            return false;
                        }
                    }
                    //当前结点子节点个数为2
                    if(child(node)==2){
                        //下一个结点的结点个数必须为2 或者当前结点为最左结点
                        if(!queue.isEmpty() && child(queue.peek())!=2){
                            return false;
                        }
                    }

                }else{
                    //不是倒数第二层, 必须都有两个子节点
                    if(child(node)!=2){
                        return false;
                    }
                    if(node.right!=null){
                        queue.offer(node.right);
                    }
                    if(node.left!=null){
                        queue.offer(node.left);
                    }
                }
            }
            //遍历完倒数第二层没有返回, 说明全部符合要求, 返回true
            if(dep==depth-1){
                return true;
            }
            dep++;
        }
        return false;

    }

    //返回树的最大深度
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(dfs(node.left), dfs(node.right))+1;
    }

    //返回当前结点有几个子节点
    public int child(TreeNode node){
        if(node.left==null){
            return node.right==null?0:1;
        }
        if(node.right==null){
            return node.left==null?0:1;
        }
        return 2;
    }

}

class LC958_M2{
    //BFS 左-->右
    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //遇到第一个null以后就不能在遇到空节点了
        boolean reachEnd = false;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(reachEnd && node!=null){
                return false;
            }
            if(node==null){
                if(!reachEnd){
                    reachEnd = true;
                }
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);
        }
        return true;

    }
}