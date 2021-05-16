package TypicalProblem.TopK.全排列_回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @Description: 剑指 Offer 38. 字符串的排列
输入一个字符串，打印出该字符串中字符的所有排列。



你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。



示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]


限制：

1 <= s 的长度 <= 8
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/2 16:15
 */
public class jz38 {

//    //保证添加的字符串不同
//    Set<String> res = new HashSet<>();
//    //全过程只有一个 可变字符串
//    StringBuilder sb = new StringBuilder();
//    //需要排列字符串的字符数组
//    char[] c;
//    //标记每个字符是否访问过
//    boolean[] isVisited;
//
//    public String[] permutation(String s) {
//        //初始化字符数组,标记数组
//        c = s.toCharArray();
//        isVisited = new boolean[s.length()];
//        dfs(s);
//        //将set中的字符串复制到数组中
//        String[] arr = new String[res.size()];
//        int i=0;
//        for(String cur:res){
//            arr[i++] = cur;
//        }
//        return arr;
//
//    }
//
//    void dfs(String s){
//        //可变字符串的长度等于原字符串的长度
//        if(sb.length() == s.length()){
//            //复制一份放入结果set中
//            res.add(new String(sb.toString()));
//            return;
//        }
//        for(int i=0; i<s.length(); ++i){
//            //如果当前字符未访问
//            if(!isVisited[i]){
//                //添加到路径中
//                sb.append(c[i]);
//                //当前字符置为已访问
//                isVisited[i] = true;
//                //递归
//                dfs(s);
//                //重置
//                sb.deleteCharAt(sb.length()-1);
//                //重置当前字符未访问
//                isVisited[i] = false;
//            }
//        }
//    }

    //字符串s对应的字符数组
    char[] c;
    //字符串
    String s;
    //存放排列的list集合
    List<String> res = new ArrayList<>();
    public String[] permutation(String s){
        //初始化s,c
        this.s = s;
        c = s.toCharArray();
        //递归
        dfs(0);
        //将list集合转化成相同大小的String数组
        return res.toArray(new String[res.size()]);
    }

    void dfs(int x){
        //到达第三层,其他位置已经固定好了,直接将字符数组转化成字符串后添加到res集合中
        if(x==s.length()-1){
            res.add(String.valueOf(c));
            return;
        }
        //确保同一层不存在相同的元素
        HashSet<Character> set = new HashSet<>();
        //i从x层开始,因为上一层的字符以及在swap后固定好了,只需要看后面的组合即可
        for(int i=x; i<s.length(); ++i){
            //如果这一层已经放入相同的元素,则跳过
            if(set.contains(c[i])){
                continue;
            }
            //当前字符未在本层出现过,添加都set中
            set.add(c[i]);
            //将c[i]固定到x位置上
            swap(i,x);
            //递归到下一层,确定x+1层的字符
            dfs(x+1);
            //递归回来,需要恢复交换,确定下一个固定在x位置上的字符
            swap(i,x);
        }
    }
    void swap(int x, int y){
        char temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }

}
