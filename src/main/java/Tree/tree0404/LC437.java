package Tree.tree0404;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * @Description: 437. 路径总和 III
给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/4 13:56
 */
public class LC437 {
    //BFS
    public int pathSum(TreeNode root, int sum) {
        if(root==null){
            return 0;
        }
        //队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        //队列依次遍历每个结点,查看路径和为sum的个数
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            //统计路径和
            count += pathCount(node, sum);
            //左右子节点入队
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return count;
    }

    /**
     *
     * @param node 开始统计的结点
     * @param target 从node开始的路径和
     * @return node开始的路径和为target的路径数
     */
    public int pathCount(TreeNode node, int target){
        if(node==null){
            return 0;
        }
        //当前node开始路径和为target的路径数
        int count = 0;
        //前序遍历, 当前结点
        if(node.val==target){
            ++count;
        }
        //左子节点开始路径和为target-node.val的个数
        int rpathCount = pathCount(node.left, target-node.val);
        int lpathCount = pathCount(node.right, target-node.val);
        //返回 当前结点所有的路径和为target的数量
        return count+rpathCount+lpathCount;

    }
}

class LC437_M2{
    //DFS双重递归
    public int pathSum(TreeNode root, int sum){
        if(root==null){
            return 0;
        }
        //1.当前root结点开始,路径和为sum的个数
        //2.root.left开始,路径和为sum的个数
        //3.root.right开始,路径和为sum的个数
        return pathCount(root,sum)
                +pathSum(root.left,sum)
                +pathSum(root.right, sum);
    }

    /**
     * node开始路径和为target的个数
     * @param node
     * @param target
     * @return
     */
    public int pathCount(TreeNode node, int target){
        if(node==null){
            return 0;
        }
        int count = 0;
        if(node.val==target){
            ++count;
        }
        return count
                +pathCount(node.left, target-node.val)
                +pathCount(node.right, target-node.val);
    }

}

class LC437_M3{
    //key=根结点到某个结点的路径和 value=对应路径和的个数
    Map<Integer, Integer> map;
    public int pathSum(TreeNode root, int sum){
        map = new HashMap<>();
        map.put(0,1);
        int res = prefixSum(root, sum , 0);
        return res;

    }

    /**
     * node开始,路径和为target的个数
     * @param node node结点开始
     * @param target 路径和为target
     * @param curSum root-->node的路径和
     * @return
     */
    public int prefixSum(TreeNode node, int target, int curSum){
        //1.递归终止条件
        if(node==null){
            return 0;
        }
        //2.当前结点路径和为target的个数
        int count= 0;
        //到node结点为止的路径和
        curSum += node.val;
        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，
        //  如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，
        //  起点的sum+target=currSum，当前点到起点的距离就是target

        count+=map.getOrDefault(curSum-target,0);
        //当前路径和的个数+1
        map.put(curSum, map.getOrDefault(curSum,0)+1);
        //3.左右子节点递归
        count+=prefixSum(node.left, target, curSum);
        count+=prefixSum(node.right, target, curSum);
        //4.回到本层，恢复状态，去除当前节点的前缀和数量
        map.put(curSum, map.get(curSum)-1);
        return count;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

