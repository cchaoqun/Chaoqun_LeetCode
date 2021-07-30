package JZOffer.review;

/**剑指 Offer 46. 把数字翻译成字符串
 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。



 示例 1:

 输入: 12258
 输出: 5
 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"


 提示：

 0 <= num < 231
 通过次数99,154提交次数183,463
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/27-14:41
 */

public class jz46 {
    public int translateNum(int num) {
        StringBuffer path = new StringBuffer();
        int[] res = new int[]{0};
        int index = 0;
        String str = String.valueOf(num);
        backtrack(res, path, index,str);
        return res[0];
    }

    private void backtrack(int[] res, StringBuffer path, int index, String str){
        if(index==str.length()){
            res[0]++;
            return;
        }
        //当前位置一位
        int num = getNum(str, index, index+1);
        char cur = getChar(num);
        path.append(cur);
        backtrack(res, path, index+1, str);
        path.deleteCharAt(path.length()-1);
        //当前位置两位 必须没有前导0
        if(index+1<str.length() && cur!='a'){
            num = getNum(str, index, index+2);
            //数字必须<=25
            if(num<=25){
                cur = getChar(num);
                path.append(cur);
                backtrack(res, path, index+2, str);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    //获取offset对应的字符映射
    private char getChar(int offset){
        return (char)('a'+offset);
    }

    //获取str[l:r]之间的数字
    private int getNum(String str, int l, int r){
        return Integer.parseInt(str.substring(l, r));
    }
}

class jz46_M2{
    /**
     * num有多少种解法取决于 dp[i-2] 和 dp[i-1]有多少种解法 dp[i-2] + nums[i-1:i] dp[i-1]+nums[i]
     * dp[i] = dp[i-2]+dp[i-1] dp[i-2]成立的条件是 25>=num[i-1:i]>=10 即 nums[i-1]不能是0
     */
    public int translateNum(int num){
        //dp[i-2]
        int dp1 = 1;
        //dp[i-1]
        int dp2 = 1;
        String s = String.valueOf(num);
        for(int i=2; i<=s.length(); i++){
            String temp = s.substring(i-2, i);
            int cur = temp.compareTo("10")>=0 && temp.compareTo("25")<=0?dp1+dp2:dp2;
            dp1 = dp2;
            dp2 = cur;
        }
        return dp2;

    }


}




















