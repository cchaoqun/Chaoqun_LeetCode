package Tree.tree0425;

import Tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/25-21:32
 */

public class LC662 {
    public int widthOfBinaryTree(TreeNode root){
        Queue<InfoNode> queue = new LinkedList<>();
        queue.add(new InfoNode(root, 0, 0));
        //当前层的深度
        int curDep = 0;
        //当前层对应的最左侧结点位置
        int left = 0;
        //最大宽度
        int ans = 0;
        while(!queue.isEmpty()){
            InfoNode temp = queue.poll();
            if(temp.node!=null){
                queue.add(new InfoNode(temp.node.left, temp.depth+1, temp.pos*2));
                queue.add(new InfoNode(temp.node.right, temp.depth+1, temp.pos*2+1));
                //当前结点深度不等于当前层深度, 说明当前结点第一次来到该层, 当前结点为当前层最左结点位置
                if(curDep!=temp.depth){
                    curDep = temp.depth;
                    left = temp.pos;

                }
                ans = Math.max(ans, temp.pos-left+1);
            }

        }
        return ans;
    }
}
//InfoNode类包含了
class InfoNode{
    //结点
    TreeNode node;
    //当前结点对应的深度
    int depth;
    //当前结点对应的位置
    int pos;
    public InfoNode(TreeNode node, int depth, int pos){
        this.node = node;
        this.depth = depth;
        this.pos = pos;
    }
}



class LC662_M2{
    //1.key=深度 value=深度对应的最左侧结点位置
    Map<Integer, Integer> left;
    int ans;
    public int widthOfBinaryTree(TreeNode root){
        this.left = new HashMap<>();
        this.ans = 0;
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode node, int depth, int pos){
        //递归终止
        if(node==null){
            return;
        }
        //第一次到达当前层, 当前结点的位置为最左侧位置
        if(left.get(depth)==null){
            left.put(depth, pos);
        }
        //更新当前层对应的宽度
        ans = Math.max(ans, pos-left.get(depth)+1);
        //左右递归, 向左走, 位置变成2倍, 向右走位置变成2倍+1
        dfs(node.left, depth+1, pos*2);
        dfs(node.right, depth+1, pos*2+1);
    }

}
