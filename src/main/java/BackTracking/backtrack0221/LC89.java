package BackTracking.backtrack0221;

import java.util.ArrayList;
import java.util.List;

/*
 * @Description: 89. 格雷编码
格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。

给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。

格雷编码序列必须以 0 开头。



示例 1:

输入: 2
输出: [0,1,3,2]
解释:
00 - 0
01 - 1
11 - 3
10 - 2

对于给定的 n，其格雷编码序列并不唯一。
例如，[0,2,3,1] 也是一个有效的格雷编码序列。

00 - 0
10 - 2
11 - 3
01 - 1
示例 2:

输入: 0
输出: [0]
解释: 我们定义格雷编码序列必须以 0 开头。
     给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
     因此，当 n = 0 时，其格雷编码序列为 [0]。
通过次数42,169提交次数60,361
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/21 12:20
 */
public class LC89 {

    public static void main(String[] args) {
        List<Integer> res = grayCode(2);
        System.out.println(res);
    }
    public static List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        //第一个元素必须为0
        res.add(0);

        int head = 1;
        for(int i=0; i<n; ++i){
            for(int j=res.size()-1; j>=0; --j){
                //每次倒序从res获取编码,在最高位+1(二进制, head依次为1,2,4,8...对应二进制01,10,100,1000)
                res.add(head+res.get(j));
            }
            //下一次的最高位+1的数字由head左移一位获得
            head <<= 1;
        }
        return res;
    }

//    public static void dfs(int n, StringBuilder sb, List<Integer> res, List<String> bin){
//        if(sb.length()==n){
//            if(res.size()==0){
//                res.add(parseStr(sb.toString()));
//                bin.add(sb.toString());
//            }else{
//                String pre = bin.get(res.size()-1);
//                int diff = diff(pre,sb.toString());
//                if(diff==1){
//                    res.add(parseStr(sb.toString()));
//                    bin.add(sb.toString());
//                }
//            }
//            return;
//        }
//        sb.append('0');
//        dfs(n, sb, res, bin);
//        sb.deleteCharAt(sb.length()-1);
//        sb.append('1');
//        dfs(n,sb,res,bin);
//        sb.deleteCharAt(sb.length()-1);
//    }
//
//    public static int diff(String s1, String s2){
//        int count = 0;
//        for(int i=0; i<s1.length(); ++i){
//            if(s1.charAt(i) != s2.charAt(i)){
//                ++count;
//            }
//        }
//        return count;
//    }
//    public static int parseStr(String s){
//        int res = 0;
//        for(int i=0, mul=1; i<s.length(); ++i, mul*=2){
//            int cur = (int)s.charAt(i);
//            res += cur * mul;
//        }
//        return res;
//    }
}
