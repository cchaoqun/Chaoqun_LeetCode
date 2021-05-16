package Tree.tree0406;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/*
 * @Description:589. N 叉树的前序遍历
给定一个 N 叉树，返回其节点值的 前序遍历 。

N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。



进阶：

递归法很简单，你可以使用迭代法完成此题吗?



示例 1：



输入：root = [1,null,3,2,4,null,5,6]
输出：[1,3,5,6,2,4]
示例 2：


输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]


提示：

N 叉树的高度小于或等于 1000
节点总数在范围 [0, 10^4] 内
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/6 14:58
 */
public class LC589 {
    //递归
    private List<Integer> list;
    public List<Integer> preorder(Node root) {
        list = new ArrayList<>();
        dfs(root);
        return list;

    }
    public void dfs(Node node){
        if(node==null){
            return;
        }
        list.add(node.val);
        for(Node child:node.children){
            dfs(child);
        }
    }
}

class LC589_M2{

    //迭代
    //每次出栈一个结点后就将结点的孩子结点从右往左压入栈中
    public List<Integer> preorder(Node root) {
        //存放结果的list
        List<Integer> res = new ArrayList<>();
        //存放结点的栈
        Deque<Node> stack = new LinkedList<>();
        if(root==null){
            return res;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            //出栈一个元素
            Node node = stack.poll();
            //将当前结点加入结果列表
            res.add(node.val);
            //将孩子结点从右到左压栈,这样出栈的顺序为从左到右
            for(int i=node.children.size()-1; i>=0; i--){
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
}
