package Tree.tree0411;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description:1305. 两棵二叉搜索树中的所有元素
给你 root1 和 root2 这两棵二叉搜索树。

请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.



示例 1：



输入：root1 = [2,1,4], root2 = [1,0,3]
输出：[0,1,1,2,3,4]
示例 2：

输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
输出：[-10,0,0,1,2,5,7,10]
示例 3：

输入：root1 = [], root2 = [5,1,7,0,2]
输出：[0,1,2,5,7]
示例 4：

输入：root1 = [0,-10,10], root2 = []
输出：[-10,0,10]
示例 5：



输入：root1 = [1,null,8], root2 = [8,1]
输出：[1,1,8,8]


提示：

每棵树最多有 5000 个节点。
每个节点的值在 [-10^5, 10^5] 之间。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/11 20:41
 */
public class LC1305 {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        create(list1, list2);
        return list;
    }

    //递归获取中序遍历
    public void dfs(TreeNode node, List<Integer> list){
        if(node==null){
            return;
        }
        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
    //将两个list按大小升序插入到新的list中
    public void create(List<Integer> list1, List<Integer> list2){
        int n1 = list1.size();
        int n2 = list2.size();
        int i1 = 0;
        int i2 = 0;
        while(i1<n1 && i2<n2){
            int cur1 = list1.get(i1);
            int cur2 = list2.get(i2);
            if(cur1<=cur2){
                list.add(cur1);
                i1++;
            }else{
                list.add(cur2);
                i2++;
            }
        }
        if(i1==n1){
            while(i2<n2){
                list.add(list2.get(i2));
                i2++;
            }
        }else{
            while(i1<n1){
                list.add(list1.get(i1));
                i1++;
            }
        }
    }
}
