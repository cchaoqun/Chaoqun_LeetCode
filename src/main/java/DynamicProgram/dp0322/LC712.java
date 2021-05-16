package DynamicProgram.dp0322;
/*
 * @Description:712. 两个字符串的最小ASCII删除和
给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。

示例 1:

输入: s1 = "sea", s2 = "eat"
输出: 231
解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
在 "eat" 中删除 "t" 并将 116 加入总和。
结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
示例 2:

输入: s1 = "delete", s2 = "leet"
输出: 403
解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
注意:

0 < s1.length, s2.length <= 1000。
所有字符串中的字符ASCII值在[97, 122]之间。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/22 22:12
 */
public class LC712 {

    public int minimumDeleteSum(String s1, String s2){

        //dp[i][j] = s1[i:] 和 s2[j:]两个字符串如果相等需要删除的字符串的ASCII和的最小值
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        //两个字符串都为空,则不需要删除,最小和为0
        dp[s1.length()][s2.length()] = 0;
        //两个字符串其中一个为空,最小和为另一个非空字符串的所有字符和
        //dp[i][s2.length]表示s2为空字符串的情况,
        //  需要删除s1中所有的字符,即等于s1[i:]所有字符的ASCII的和
        //  递推式为dp[i+1][s2.length()]+ascii(s1[i])
        //dp[s1.length()][j]表示s1为空字符串的情况
        //  需要删除s1中所有的字符
        //  递推式为dp[s1.length()][j] = dp[s1.length()][j+1]+ascii(s2[j])
        for(int i=s1.length()-1; i>=0; i--){
            //s2为空
            dp[i][s2.length()] = dp[i+1][s2.length()]+s1.codePointAt(i);
        }
        for(int j=s2.length()-1; j>=0; j--){
            //s1为空
            dp[s1.length()][j] = dp[s1.length()][j+1]+s2.codePointAt(j);
        }

        //两个字符串都不为空的情况
        //从两个字符串的最后一个字符开始比较,因为每一个状态都依赖与后面的状态
        for(int i=s1.length()-1; i>=0; i--){
            for(int j=s2.length()-1; j>=0; j--){
                //如果两个字符串相等,当前字符不需要删除,对于最小和不影响
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    //两个字符不相等,对于这个位置删除较小的
                    //如果删除s1当前字符,需要比较s1[i+1:]和s2[j:]
                    //如果删除s2当前字符,需要比较s1[i:]和s2[j+1:]
                    //取两种情况的最小值
                    dp[i][j] = Math.min(s1.codePointAt(i)+dp[i+1][j]
                            ,s2.codePointAt(j)+dp[i][j+1]);
                }
            }
        }
        //最后返回s1[0:]和s2[0:]两个字符串的结果即完整的s1和s2
        return dp[0][0];
    }
}
