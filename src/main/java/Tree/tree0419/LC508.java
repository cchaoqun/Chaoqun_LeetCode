package Tree.tree0419;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 *
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 *
 *
 *
 * 示例 1：
 * 输入:
 *
 *   5
 *  /  \
 * 2   -3
 * 返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。
 *
 * 示例 2：
 * 输入：
 *
 *   5
 *  /  \
 * 2   -5
 * 返回 [2]，只有 2 出现两次，-5 只出现 1 次。
 *
 *
 *
 * 提示： 假设任意子树元素和均可以用 32 位有符号整数表示。
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/19-15:54
 */

public class LC508 {
    //key:子树和 value:对应出现的次数
    Map<Integer, Integer> map;
    //最大的出现次数
    int max;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        max = 0;
        List<Integer> list = new ArrayList<>();
        dfs(root);
        //遍历获得的子树和以及对应出现的次数,等于max的值添加进list
        for(int key:map.keySet()){
            if(map.get(key)==max){
                list.add(key);
            }
        }
        //转换成int[]
        int[] res = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    //后序遍历 获取每个子树和出现的次数
    public int dfs(TreeNode node){
        if(node==null){
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        int curSum = node.val+left+right;
        map.put(curSum, map.getOrDefault(curSum,0)+1);
        //更新出现最多次数的子树和次数
        max = Math.max(max, map.get(curSum));
        return curSum;
    }
}
