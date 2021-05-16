package Tree.tree0406;

import java.util.LinkedList;
import java.util.Queue;

/*
 * @Description:
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/6 15:44
 */
public class LC559 {
    //递归
    //最大深度
    private int maxD = 0;
    public int maxDepth(Node root) {
        dfs(root,1);
        return maxD;
    }

    public void dfs(Node node, int level){
        //返回条件
        if(node==null){
            return;
        }
        //跟新最大深度
        maxD = Math.max(maxD, level);
        //遍历当前结点孩子结点,深度+1;
        for(Node child:node.children){
            dfs(child,level+1);
        }
    }
}
class LC559_M2{
    //迭代
    public int maxDepth(Node root) {
        //最大深度
        int maxD = 0;
        if(root==null){
            return maxD;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            //每进入一层,最大深度+1
            maxD += 1;
            //遍历当前队列中所有的结点,将其孩子结点添加到队列
            for(int i=queue.size(); i>0; i--){
                Node node = queue.poll();
                for(Node child:node.children){
                    queue.offer(child);
                }
            }
        }
        return maxD;
    }
}
