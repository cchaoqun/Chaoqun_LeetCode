package Algorithm_HW.Week4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/26-19:08
 */

public class LC92 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(res, s, 0, path);
        return res;
    }

    private void backtrack(List<String> res, String s, int start, List<String> path){
        //递归终止的条件, 截取的字符串个数为4 并且 start 刚好在 s.length()
        if(path.size()==4 && start==s.length()){
            //以 "." 为separator join
            res.add(String.join(".", path));
            return;
        }

        //剪枝
        // start 越界
        // 剩余字符个数小于 剩余需要的 字符串的数量
        // 剩余字符个数 > 剩余需要的每个字符串都是size==3
        if(start>=s.length() || s.length()-start < 4-path.size() || 3*(4-path.size())<s.length()-start){
            return;
        }

        //从start 开始截取1个字符
        if(start<s.length()){
            String cur = s.substring(start, start+1);
            path.add(cur);
            backtrack(res, s, start+1, path);
            path.remove(path.size()-1);
        }

        //从start 开始截取2个字符 需要保证 起始字符不等于0
        if(s.charAt(start)!='0' && start<s.length() && start<=s.length()-2){
            String cur = s.substring(start, start+2);
            path.add(cur);
            backtrack(res, s, start+2, path);
            path.remove(path.size()-1);
        }

        //从start 开始截取3个字符 需要保证 起始字符不等于0, 并且截取的数字<=255
        if(s.charAt(start)!='0' && start<s.length() && start<=s.length()-3){
            String cur = s.substring(start, start+3);
            if(Integer.parseInt(cur)<=255){
                path.add(cur);
                backtrack(res, s, start+3, path);
                path.remove(path.size()-1);
            }

        }
    }
}
