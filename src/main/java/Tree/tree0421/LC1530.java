package Tree.tree0421;

import Tree.TreeNode;

/**
 *1530. 好叶子节点对的数量
 * 给你二叉树的根节点 root 和一个整数 distance 。
 *
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 *
 * 返回树中 好叶子节点对的数量 。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 *
 *
 * 输入：root = [1,2,3,null,4], distance = 3
 * 输出：1
 * 解释：树的叶节点是 3 和 4 ，它们之间的最短路径的长度是 3 。这是唯一的好叶子节点对。
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7], distance = 3
 * 输出：2
 * 解释：好叶子节点对为 [4,5] 和 [6,7] ，最短路径长度都是 2 。但是叶子节点对 [4,6] 不满足要求，因为它们之间的最短路径长度为 4 。
 * 示例 3：
 *
 * 输入：root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
 * 输出：1
 * 解释：唯一的好叶子节点对是 [2,5] 。
 * 示例 4：
 *
 * 输入：root = [100], distance = 1
 * 输出：0
 * 示例 5：
 *
 * 输入：root = [1,1,1], distance = 2
 * 输出：1
 *
 *
 * 提示：
 *
 * tree 的节点数在 [1, 2^10] 范围内。
 * 每个节点的值都在 [1, 100] 之间。
 * 1 <= distance <= 10
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/21-20:32
 */

public class LC1530 {
    public int countPairs(TreeNode root, int distance) {
        Pair pair = dfs(root,distance);
        return pair.count;
    }

    public Pair dfs(TreeNode node, int distance){
        //dep[i] 到达当前node结点 距离为i的叶子结点的个数
        int[] dep = new int[distance+1];
        if(node==null){
            return null;
        }
        //判断当前是否是叶子结点
        boolean isleaf = node.left==null && node.right==null?true:false;
        if(isleaf){
            //叶子结点到达本身的距离为0 叶子结点个数为1 为本身
            dep[0] = 1;
            //可以回传一个Pair类, 保存了当前结点的depth数组, 以及符合条件的好叶子结点的对数
            return new Pair(dep,0);
        }
        //保留左右子节点对应的符合条件的好叶子结点对数 和 距离数组
        int leftCount = 0;
        int rightCount = 0;
        int[] leftDep = new int[distance+1];
        int[] rightDep = new int[distance+1];
        //获得左右子节点的个数
        if(node.left!=null){
            Pair leftPair = dfs(node.left, distance);
            leftCount = leftPair.count;
            leftDep = leftPair.depth;
        }
        if(node.right!=null){
            Pair rightPair = dfs(node.right, distance);
            rightCount = rightPair.count;
            rightDep = rightPair.depth;
        }
        //更新当前结点距离数组同一个距离的左右都可能有
        for(int i=0; i<distance; i++){
            dep[i+1] += leftDep[i];
            dep[i+1] += rightDep[i];
        }
        //统计左右子树中到达当前结点的好叶子结点对数
        //只要左右的叶子结点到达当前结点的距离加起来小于distance,就是一对
        //所以这里是相乘
        int cnt = 0;
        for(int i=0; i<=distance; i++){
            for(int j=0; i+j+2<=distance; j++){
                cnt += leftDep[i]*rightDep[j];
            }
        }
        //返回的pair中包含了 到达当前结点的不同距离的叶子结点个数
        //以及以当前结点为根结点的树种 好叶子结点对的个数
        return new Pair(dep, cnt+leftCount+rightCount);

    }
}

class Pair{
    //dep[i]: 到达当前结点距离为i的叶子结点的个数
    //如果为叶子结点 dep[0] = 1, dep.length = 1;
    int[] depth;
    //当前结点左右子树中满足两个叶子结点之间最短距离< distance的好叶子结点对的个数
    int count;

    public Pair(int[] depth, int count){
        this.depth = depth;
        this.count = count;
    }
}
