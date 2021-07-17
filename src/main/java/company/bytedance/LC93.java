package company.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/14-13:55
 */

public class LC93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        backtrack(res, path, 0, s);
        return res;
    }

    private void backtrack(List<String> res, List<String> path, int start, String s){
        if(start==s.length() && path.size()==4){
            // res.add(String.join(".",path));
            // return ;
            StringBuffer sb = new StringBuffer();
            for(String str : path){
                sb.append(str);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length()-1);
            res.add(sb.toString());
            return;
        }
        // 剪枝
        // 剩余字符数量 s.length()-1-start+1 = s.length()-start
        // 剩余需要的字符串的数量 4-path.size()
        // s.length()-start <4-path.size()
        // s.length()-start > 3*(4-path.size())
        if(s.length()-start <4-path.size() || s.length()-start > 3*(4-path.size())){
            return;
        }

        // 处理一个字符
        if(start+1<=s.length()){
            path.add(s.substring(start, start+1));
            backtrack(res, path, start+1, s);
            path.remove(path.size()-1);
        }
        // 处理两个字符
        if(s.charAt(start)!='0' && start+2<=s.length()){
            path.add(s.substring(start, start+2));
            backtrack(res, path, start+2, s);
            path.remove(path.size()-1);
        }
        // 处理三个字符
        if(s.charAt(start)!='0' && start+3<=s.length()){
            String cur = s.substring(start, start+3);
            if(Integer.parseInt(cur)<=255){
                path.add(s.substring(start, start+3));
                backtrack(res, path, start+3, s);
                path.remove(path.size()-1);
            }

        }
    }
}
