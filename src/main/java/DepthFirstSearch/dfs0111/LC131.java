package DepthFirstSearch.dfs0111;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @Description: 131. 分割回文串
 *
给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
返回 s 所有可能的分割方案。
*
示例:
输入:"aab"
输出:
[
  ["aa","b"],
  ["a","a","b"]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/palindrome-partitioning
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/11 11:36
 */
public class LC131 {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        System.out.println(res);
    }

//    public static List<List<String>> partition(String s) {
//        List<List<String>> list = new ArrayList<>();
//        int n = s.length();
//        if(s==null){
//            return list;
//        }
//        // Stack 这个类 Java 的文档里推荐写成 Deque<Integer> stack = new ArrayDeque<Integer>();
//        // 注意：只使用 stack 相关的接口
//        Deque<String> stack = new ArrayDeque<String>();
//        backTracking(s,0,n,stack,list);
//        return list;
//    }
//
//    public static void backTracking(String s, int start, int len, Deque<String> path, List<List<String>> list){
//        if(start==len){
//            list.add(new ArrayList<>(path));
//            return;
//        }
//        for(int i=start; i<len; i++){
//            if(!helper(s,start,i)){
//                continue;
//            }
//
//            path.add(s.substring(start,i+1));
//            backTracking(s,i+1,len,path,list);
//            path.removeLast();
//        }
//
//    }
//
//    //判断当前的分割子串是否是回文串
//    public static boolean helper(String s, int left, int right){
//        while(left<right){
//            if(s.charAt(left) == s.charAt(right)){
//                left++;
//                right--;
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }

    public static List<List<String>> partition(String s){
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        if(s==null){
            return res;
        }
        Deque<String> stack = new ArrayDeque<>();
        backTracking(s,0,n,stack,res);
        return res;
    }

    public static void backTracking(String s, int start, int len, Deque<String> path, List<List<String>> res){
        if(start==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start; i<len; i++){
            if(!check(s,start,i)){
                continue;
            }
            path.addLast(s.substring(start,i+1));
            backTracking(s,i+1,len,path,res);
            path.removeLast();
        }
    }

    public static boolean check(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }

}
