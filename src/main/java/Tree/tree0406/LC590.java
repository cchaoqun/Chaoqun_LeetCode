package Tree.tree0406;

import java.util.*;

/*
 * @Description: 590. N 叉树的后序遍历
给定一个 N 叉树，返回其节点值的 后序遍历 。

N 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。



进阶：

递归法很简单，你可以使用迭代法完成此题吗?



示例 1：



输入：root = [1,null,3,2,4,null,5,6]
输出：[5,6,3,2,4,1]
示例 2：



输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]


提示：

N 叉树的高度小于或等于 1000
节点总数在范围 [0, 10^4] 内
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/6 13:34
 */
public class LC590 {
    //递归
    private List<Integer> list;
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        dfs(root);
        Deque<Integer> stack = new LinkedList<>();
        return list;
    }

    public void dfs(Node node){
        //递归终止条件
        if(node==null){
            return;
        }
        //遍历当前结点的孩子结点
        List<Node> childs = node.children;
        for(int i=0; i<childs.size(); i++){
            dfs(childs.get(i));
        }
        //添加当前结点
        list.add(node.val);
    }
}

class LC590_M2{
    //迭代
    public List<Integer> postorder(Node root) {
        //压入结点的栈
        Deque<Node> stack = new LinkedList<>();
        //后续遍历的结果
        LinkedList<Integer> res = new LinkedList<>();
        if(root==null){
            return res;
        }
        //根结点入栈
        stack.push(root);
        while(!stack.isEmpty()){
            //每次栈顶元素出栈
            Node node = stack.pop();
            //当前结点的孩子结点
            List<Node> childs = node.children;
            //当前结点添加到双端队列尾
            res.addFirst(node.val);
            //将当前结点的孩子结点压入到栈中
            for(int i=0; i<childs.size(); i++){
                stack.push(childs.get(i));
            }
        }
        return res;
    }
}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};