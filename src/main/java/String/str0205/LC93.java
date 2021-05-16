package String.str0205;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。

 

示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
示例 2：

输入：s = "0000"
输出：["0.0.0.0"]
示例 3：

输入：s = "1111"
输出：["1.1.1.1"]
示例 4：

输入：s = "010010"
输出：["0.10.0.10","0.100.1.0"]
示例 5：

输入：s = "101023"
输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 

提示：

0 <= s.length <= 3000
s 仅由数字组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/restore-ip-addresses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 9:44
 */
public class LC93 {
    public static void main(String[] args) {
        String s = "256";

        List<String>  res = restoreIpAddresses(s);
        System.out.println(res);
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s==null || s.length()<4 || s.length()>12){
            return res;
        }
        List<String> path = new ArrayList<>();
        dfs(s,res,path,0);
        return res;

    }

    public static void dfs(String s, List<String> res, List<String> path, int index){
        //结束递归条件
        if(index==s.length() && path.size()==4){
            res.add(String.join(".",path));
            return;
        }
        //剪枝
        //    下标索引越界     || 剩余字符串的数量<剩余地址数量最小所需字符数量 || > 剩余地址最大所需字符数量数量
        if(index>=s.length() || (s.length()-index)<(4-path.size()) || 3*(4-path.size())<(s.length()-index)){
            return;
        }
        //在下标在范围内,当前可以添加1-3位数的地址到路径中
        //添加1个
        if(index<s.length()){
            path.add(s.substring(index,index+1));
            //递归 index+1
            dfs(s,res,path,index+1);
            //重置
            path.remove(path.size()-1);
        }
        //添加2个,两位数不能以0开头
        if(s.charAt(index)!='0' && index<s.length() && index+2<=s.length()){
            path.add(s.substring(index,index+2));
            //递归 index+2
            dfs(s,res,path,index+2);
            //重置
            path.remove(path.size()-1);
        }
        //添加3个,不能以0开头,数字大小不能大于255
        if(s.charAt(index)!='0' && index<s.length() && index+3<=s.length()){
            //获取三位数
            String cur = s.substring(index,index+3);
            //解析成整数判断是否<=255
            if(Integer.parseInt(cur)<=255){
                path.add(cur);
                //递归 index+3
                dfs(s,res,path,index+3);
                //重置
                path.remove(path.size()-1);
            }
        }
    }
}
