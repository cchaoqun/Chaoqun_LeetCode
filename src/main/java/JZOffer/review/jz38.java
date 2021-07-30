package JZOffer.review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**剑指 Offer 38. 字符串的排列
 输入一个字符串，打印出该字符串中字符的所有排列。



 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。



 示例:

 输入：s = "abc"
 输出：["abc","acb","bac","bca","cab","cba"]


 限制：

 1 <= s 的长度 <= 8
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/26-20:54
 */

public class jz38 {
    public String[] permutation(String s) {
        List<String> res = new ArrayList<>();
        StringBuffer path = new StringBuffer();
        int index = 0;
        boolean[] visited = new boolean[s.length()];
        backtrack(res, path, visited, s);
        return  res.toArray(new String[res.size()]);
    }

    private void backtrack(List<String> res, StringBuffer path, boolean[] visited, String s){
        if(path.length()==visited.length){
            res.add(new String(path));
            return;
        }
        Set<Character> set = new HashSet<>();
        for(int i=0; i<visited.length; i++){
            if(visited[i] || set.contains(s.charAt(i))){
                continue;
            }
            set.add(s.charAt(i));
            visited[i]=true;
            path.append(s.charAt(i));
            backtrack(res, path, visited, s);
            path.deleteCharAt(path.length()-1);
            visited[i] = false;
        }
    }
}
