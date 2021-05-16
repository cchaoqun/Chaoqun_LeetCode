package String.str0204;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @Description: 14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

 

示例 1：

输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。
 

提示：

0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-common-prefix
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/4 12:43
 */
public class LC14 {

//    public String longestCommonPrefix(String[] strs) {
//        int n = strs.length;
//        String res = "";
//        if(n==0){
//            return res;
//        }
//        int minLen = Integer.MAX_VALUE;
//        for (int i=0; i<n; i++){
//            if(strs[i].length()<minLen){
//                minLen = strs[i].length();
//            }
//        }
//        int index = 0;
//        while(index<minLen) {
//            char prefix = strs[0].charAt(index);
//            for (int i = 1; i < n; i++) {
//                String cur = strs[i];
//                if(cur.charAt(index)!=prefix){
//                    return res;
//                }
//            }
//            res += prefix;
//            index++;
//        }
//        return res;
//    }

    //横向比较
    public String longestCommonPrefix(String[] strs){
        int n = strs.length;
        if(n==0){
            return "";
        }
        //选取第一个字符串作为比较的基准
        String ans = strs[0];
        //遍历后续字符串
        for (int i=1; i<strs.length; i++){
            //从第一个字符开始比较两个字符串
            int j=0;
            for(;j<ans.length() && j<strs[i].length(); j++){
                //当遇到不同的字符时结束循环
                if(ans.charAt(j) != strs[i].charAt(j)){
                    break;
                }
            }
            //将结果更新为两个字符串的最长公共前缀字符串
            ans = ans.substring(0,j);
            //如果没有公共前缀字符串
            if(ans==""){
                //返回
                return ans;
            }
        }
        return ans;
    }

    //分治
//    public String longestCommonPrefix(String[] strs) {
//        if (strs == null || strs.length == 0) {
//            return "";
//        } else {
//            return  longestCommonPrefix(strs,0,strs.length-1);
//        }
//
//    }
//    public static String longestCommonPrefix(String[] strs, int start, int end){
//        if(start==end){
//            return strs[start];
//        }else{
//            int mid = start + (end-start)/2;
//            String leftPrefix = longestCommonPrefix(strs,start,mid);
//            String rightPrefix = longestCommonPrefix(strs,mid+1,end);
//            return commonPrefix(leftPrefix,rightPrefix);
//        }
//    }
//
//    public static String commonPrefix(String left, String right){
//        int minLen = Math.min(left.length(), right.length());
//        for(int i=0; i<minLen; i++) {
//            if (left.charAt(i) != right.charAt(i)) {
//                return left.substring(0,i);
//            }
//        }
//        return left.substring(0,minLen);
//    }

}
