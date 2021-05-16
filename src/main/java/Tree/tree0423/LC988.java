package Tree.tree0423;

import Tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-04-2021/4/23-23:33
 */

public class LC988 {


    List<String> list;
    public String smallestFromLeaf(TreeNode root) {
        this.list = new ArrayList<>();
        dfs(root, new StringBuilder());
        System.out.println(list);
        //自定义比较器
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        return list.get(0);
    }

    public void dfs(TreeNode node, StringBuilder sb){
        if(node==null){
            //这里没有变化,无需删除
            return;
        }

        sb.insert(0, (char)('a'+node.val));
        if(node.left==null && node.right==null){
            String res = sb.toString();
            list.add(res);
            //return之前需要重置, 删除第一个字符
            sb.deleteCharAt(0);
            return;
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        //return之前需要重置, 删除第一个字符
        sb.deleteCharAt(0);
    }
}

class LC988_M2{
    String res = "~";
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return res;
    }

    public void dfs(TreeNode node, StringBuilder sb){
        if(node==null){
            return;
        }

        sb.insert(0, (char)('a'+node.val));
        //实时比较,
        if(node.left==null && node.right==null){
            if(sb.toString().compareTo(res)<0){
                res = sb.toString();
            }
            sb.deleteCharAt(0);
            return;
        }
        dfs(node.left, sb);
        dfs(node.right, sb);
        sb.deleteCharAt(0);
    }
}
