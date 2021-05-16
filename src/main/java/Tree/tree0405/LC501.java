package Tree.tree0405;

import java.util.ArrayList;


/*
 * @Description:501. 二叉搜索树中的众数
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

提示：如果众数超过1个，不需考虑输出顺序

进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/5 20:16
 */
public class LC501 {
    //包含众数的list
    ArrayList<Integer> list = new ArrayList<>();
    //当前结点值对应的数量
    int count = 1;
    //当前的结点值
    int current = Integer.MIN_VALUE;
    //出现次数最多的结点的出现次数
    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        dfs(root);
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;


    }

    /**
     二叉搜索树的中序遍历
     */
    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        //左递归
        dfs(node.left);
        //当前结点的值
        int nodeVal = node.val;
        //如果当前结点值=和上一个出现的结点值相同
        if(nodeVal==current){
            count++;
        }else{
            //出现新的结点值, 第一次出现
            current = nodeVal;
            //重置count
            count = 1;
        }
        //当前结点值出现的次数如果=之前的众数出现的次数
        if(count==maxCount){
            //添加进list,出现相同次数的结点值可能有多个
            list.add(nodeVal);
        }else if(count>maxCount){
            //如果出现次数>之前众数的出现次数.需要清空list, 当前结点为暂时的唯一众数
            list.clear();
            list.add(nodeVal);
            //更新众数出现的次数
            maxCount = count;
        }
        dfs(node.right);
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

