package Algorithm_HW.Week4;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/30-13:26
 */

public class LC72 {
    //二维dp
    public int minDistance(String word1, String word2) {
        /**
         dp[i][j] word1.subtring(0,i) 与 word2.substring(0,j)的编辑距离

         word1.charAt(i) != word2.charAt(j)

         dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1
         word1.charAt(i) == word2.charAt(j)
         dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1])+1, dp[i-1][j-1])

         dp[0][0] = 0;
         dp[0][j] = j
         dp[i][0] = i

         */
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1+1][len2+1];
        //word2 为空串 编辑距离为 word1的长度
        for(int i=1;i<=len1; i++){
            dp[i][0] = i;
        }
        //word1 为空串 编辑距离为 word2的长度
        for(int j=1; j<=len2; j++){
            dp[0][j] = j;
        }
        //从两个字符串都只有一个字符开始dp
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                //当前的两个字符不同
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                }else{
                    //当前的两个字符相同
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1])+1, dp[i-1][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}

class LC72_M2{
    //一维 dp
    public int minDistance(String word1, String word2) {

        int len1 = word1.length();
        int len2 = word2.length();
        //一维
        int[] dp = new int[len2+1];
        //对于word1为空串的情况, word2不同长度的需要的编辑距离
        for(int i=0; i<=len2; i++){
            dp[i] = i;
        }
        //对于word1.substring(0,i)结尾的子串和不同的Word2的子串
        for(int i=1; i<=len1; i++){
            //原来的dp[i-1][j-1]
            int lu = dp[0];
            //word2为空串, 当前Word1子串的长度是i, 编辑距离就是i
            dp[0] = i;
            for(int j=1; j<=len2; j++){
                //保留当前dp[j] 就是下一个j对于的dp[i-1][j-1] 因为现在的 i, j 对于下一个i',j'来说是 i-1 j-1
                int temp = dp[j];
                //左上角的值 dp[i-1][j-1]
                if(word1.charAt(i-1)!=word2.charAt(j-1)){
                    dp[j] = Math.min(Math.min(lu, dp[j-1]), dp[j])+1;
                }else{
                    dp[j] = lu;
                }
                //lu更新为dp[i-1][j-1]
                lu = temp;
            }
        }
        return dp[len2];

    }
}
