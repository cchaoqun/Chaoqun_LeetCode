package LeetCodeWeeklyContest;

import Tree.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/11-10:30
 */

public class Contest_0711_249 {

    @Test
    public void test(){

    }

    /**
     对于相同的字符, 中间间隔的不同的字符数量就是结果
     */
    public int countPalindromicSubsequence(String s) {
        int len = s.length();
        int[][] range = new int[26][2];
        for(int i=0; i<26; i++){
            range[i][0] = len;
            range[i][1] = -1;
        }
        char[] arr = s.toCharArray();
        for(int i=0; i<len; i++){
            int cur = arr[i]-'a';
            range[cur][0] = Math.min(i, range[cur][0]);
            range[cur][1] = Math.max(i, range[cur][1]);
        }
        int res = 0;
        for(int i=0; i<26; i++){
            if(range[i][0]==len || range[i][1]==-1){
                continue;
            }
            if(range[i][0]==range[i][1]){
                continue;
            }
            res += findDiff(arr, range[i][0], range[i][1]);
        }
        return res;
    }

    private int findDiff(char[] arr, int start, int end){
        Set<Character> set = new HashSet<>();
        int res=0;
        for(int i=start+1; i<end; i++){
            if(!set.contains(arr[i])){
                res++;
                set.add(arr[i]);
            }
        }
        return res;
    }


    public TreeNode canMerge(List<TreeNode> trees) {
        // 根据根结点的值获取根结点
        Map<Integer, TreeNode> roots = new HashMap<>();
        // 所有叶子结点的值的set
        Set<Integer> leafs = new HashSet<>();
        // 最后返回的树的根结点
        TreeNode root = null;
        // 遍历所有的根结点初始化 roots leafs
        for(TreeNode node : trees){
            roots.put(node.val, node);
            if(node.left!=null){
                leafs.add(node.left.val);
            }
            if(node.right!=null){
                leafs.add(node.right.val);
            }
        }
        // 遍历所有的根结点的map
        for(Map.Entry<Integer, TreeNode> entry : roots.entrySet()){
            // 当前根结点的值
            int curVal = entry.getKey();
            // 如果当前根结点不在叶子结点, 可以作为根结点
            if(!leafs.contains(curVal)){
                // 这样的根结点只能有一个
                if(root!=null){
                    return null;
                }else{
                    root = entry.getValue();
                }
            }
        }
        // 如果没有这样的根结点无法构成树
        if(root==null){
            return null;
        }
        // 将这个根从roots移除
        roots.remove(root.val);
        // 保存所有待更新叶子结点的根结点,
        // queue中的TreeNode都是我们希望找到一个其他的根结点刚好可以放在他的叶子结点上
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!roots.isEmpty() && !queue.isEmpty()){
            // 当前待找其叶子结点的根结点
            TreeNode node = queue.poll();
            // 如果有左子节点
            if(node.left!=null){
                // 通过左子节点的值尝试获取对应的根结点
                TreeNode left = roots.get(node.left.val);
                // 如果找不到 无法构建树
                if(left==null){
                    return null;
                }
                // 找到了对应的左子树, 放到左子节点上
                node.left = left;
                // 还需要找这个左子树的叶子结点
                queue.offer(left);
                // 从roots中删除已经放到树中的根结点
                roots.remove(left.val);
            }
            // 如果有右子节点
            if(node.right!=null){
                // 通过右子节点的值尝试获取对应的根结点
                TreeNode right = roots.get(node.right.val);
                // 找不到无法构建
                if(right==null){
                    return null;
                }
                // 接到右子节点上
                node.right = right;
                // 继续找右子树的叶子结点对应的根结点
                queue.offer(right);
                // 从roots中删除已经放到树中的根结点
                roots.remove(right.val);
            }
        }
        // 如果roots中还有没放入树中的根结点, 无法构建树
        if(!roots.isEmpty()){
            return null;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        // 不符合返回null
        if(!valid(root, stack )){
            return null;
        }
        // 返回这个树
        return root;

    }

    // 判断这个构建的数是否是符合二叉搜索树的性质
    private boolean valid(TreeNode root, Deque<Integer> stack){
        if(root==null){
            return true;
        }
        boolean left = valid(root.left,stack);
        if(!stack.isEmpty() && stack.peek()>=root.val){
            return false;
        }
        stack.push(root.val);
        boolean right = valid(root.right,stack);
        return left&&right;
    }
}
