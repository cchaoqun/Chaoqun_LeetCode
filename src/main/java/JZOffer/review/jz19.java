package JZOffer.review;

/**剑指 Offer 19. 正则表达式匹配
 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。

 示例 1:

 输入:
 s = "aa"
 p = "a"
 输出: false
 解释: "a" 无法匹配 "aa" 整个字符串。
 示例 2:

 输入:
 s = "aa"
 p = "a*"
 输出: true
 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 示例 3:

 输入:
 s = "ab"
 p = ".*"
 输出: true
 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 示例 4:

 输入:
 s = "aab"
 p = "c*a*b"
 输出: true
 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 示例 5:

 输入:
 s = "mississippi"
 p = "mis*is*p*."
 输出: false
 s 可能为空，且只包含从 a-z 的小写字母。
 p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/22-18:54
 */

public class jz19 {
    /**
     * char[] p = p.toCharArray();
     * char[] s = s.toCharArray();
     * p[j-1] = '*'
     *      dp[i][j-2] = true  p[j-1]* 看成 p[j-1]出现0次
     *      dp[i-1][j] && s[i-1]==p[j-2] 看成 p[i-2]* ==> p[i-2]p[i-2]   因为s[i-1]==p[j-2] 而且dp[i-1][j]已经匹配了 让p[j-2]多出现一次可以匹配s[i-1]
     *      dp[i-1][j] && p[j-2] == '.' s[i-1]一定可以匹配'.' 所以让p[j-2]多出现一次
     * p[j-1] != '*'
     *      s[i-1]==p[j-1] && dp[i-1][j-1] 当前位置字符相等
     *      p[j-1] == '.' && dp[i-1][j-1] 当前位置p[j-1]是通配符 可以匹配任意字符
     *
     *
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p){
        int l1 = s.length();
        int l2 = p.length();
        // dp[i][j] s以第i个字符(s.charAt(i-1)结尾 p以第j个字符(p.charAt(j-1))结尾是否匹配
        boolean[][] dp = new boolean[l1+1][l2+1];
        //都是空字符串时 可以匹配
        dp[0][0] = true;
        for(int j=2; j<=l2; j+=2){
            //当前位置是'*' 看成前一个字符出现0次
            dp[0][j] = dp[0][j-2] && p.charAt(j-1)=='*';
        }
        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(p.charAt(j-1)=='*'){
                    if(dp[i][j-2] || dp[i-1][j] && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')){
                        dp[i][j] = true;
                    }
                }else{
                    if(dp[i-1][j-1] && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')){
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[l1][l2];
    }

}





































