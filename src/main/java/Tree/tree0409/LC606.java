package Tree.tree0409;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * @Description: 606. 根据二叉树创建字符串
你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。

示例 1:

输入: 二叉树: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

输出: "1(2(4))(3)"

解释: 原本将是“1(2(4)())(3())”，
在你省略所有不必要的空括号对之后，
它将是“1(2(4))(3)”。
示例 2:

输入: 二叉树: [1,2,3,null,4]
       1
     /   \
    2     3
     \
      4

输出: "1(2()(4))(3)"

解释: 和第一个示例相似，
除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/4/9 15:05
 */
public class LC606 {
    //递归
    //最后返回的字符串
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        dfs(t);
        return sb.toString();
    }
    public void dfs(TreeNode node){
        if(node==null){
            return;
        }
        //添加当前结点值
        sb.append(node.val);
        //如果是叶子结点提前返回,没有子节点需要反映映射关系
        if(node.left==null && node.right==null){
            return;
        }
        //处理左子节点 用 ()将左子树的结果括起来
        //即便左子树为空,但是只要当前结点不是叶子结点都需要空的()反映位置关系
        sb.append("(");
        dfs(node.left);
        sb.append(")");
        //处理右子节点, 如果右子树为空,则可以省略括号
        sb.append("(");
        dfs(node.right);
        //判断右子树是否为空,如果最后一个字符为左括号,右子树为空,
        if(sb.charAt(sb.length()-1)=='('){
            //删除左括号
            sb.deleteCharAt(sb.length()-1);
        }else{
            //右子树不为空
            sb.append(")");
        }
    }
}
class LC606_M2{
    //迭代
    public String tree2str(TreeNode t) {
        if(t==null){
            return "";
        }
        //最后返回的字符串
        StringBuilder sb = new StringBuilder();
        //前序遍历需要的栈
        Deque<TreeNode> stack = new LinkedList<>();
        //保存已经遍历过得结点, 再次遍历到相同的结点类似于递归回到当前结点
        //这个时候需要加上右括号")" 并且删除当前结点
        Set<TreeNode> visited = new HashSet<>();
        stack.push(t);
        while(!stack.isEmpty()){
            TreeNode node = stack.peek();
            if(visited.contains(node)){
                sb.append(")");
                stack.pop();
            }else{
                visited.add(node);
                sb.append("("+node.val);
                if(node.left==null && node.right!=null){
                    //左空右非空,需要左子节点位置添加一对括号占位
                    sb.append("()");
                }
                //先右后左,这样出栈顺序为从左到右
                if(node.right!=null){
                    stack.push(node.right);
                }
                if(node.left!=null){
                    stack.push(node.left);
                }

            }
        }
        //去除根结点对应的左右括号 字符串的头尾
        return sb.toString().substring(1, sb.length()-1);
    }
}
