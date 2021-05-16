package DepthFirstSearch.dfs0112;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 17. 电话号码的字母组合
给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
9键
示例:
输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明:
尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/12 8:53
 */
public class LC17 {
    public static void main(String[] args) {
        List<String> res = letterCombinations("");
        System.out.println(res.size());
        System.out.println(res);
    }
    static String letterMap[] = {
            "",     //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz", //9
    };
    static List<String> list = new ArrayList<String>();

    public static List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return list;
        }
        dfs(digits,0,new StringBuilder());
        return list;
    }

    public static void dfs(String digits, int start, StringBuilder path){
        if(start==digits.length()){
            //到达该路径结尾,将组合添加到list集合
            list.add(path.toString());
            //回溯
            return;
        }
        //获取数字字符串的数字
        char d = digits.charAt(start);
        //根据数组获取对应代表的可能字符
        String letter = letterMap[d-'0']; //'2'-'0' = 0;
        //遍历可能的字符
        for(int i=0; i<letter.length(); i++){
            //获取第i个字符
            char s = letter.charAt(i);
            //将该字符添加到路径,并在此基础上递归的寻找该基础上的后续字符组合
            dfs(digits,start+1,path.append(s));
            //删除最后添加的字符,继续到下一次循环添加该d数字对应的下一个字符进行排列组合
            path.deleteCharAt(path.length()-1);
        }
    }
}
