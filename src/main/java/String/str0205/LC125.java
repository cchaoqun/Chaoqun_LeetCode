package String.str0205;
/*
 * @Description: 125. 验证回文串
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

说明：本题中，我们将空字符串定义为有效的回文串。

示例 1:

输入: "A man, a plan, a canal: Panama"
输出: true
示例 2:

输入: "race a car"
输出: false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-palindrome
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/5 10:37
 */
public class LC125 {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }

//    //数字 [48,57] 大写字母 [65,90] 小写字母 [97,122]
//    public static char isValid(char c){
//        if ((48<=c && c<=57) || (97<=c && c<=122)){
//            //数字或者小写字母直接返回
//            return c;
//        }else if (65<=c && c<=90){
//            //大写字母变成小写后返回
//            return Character.toLowerCase(c);
//        }else{
//            //其余字符一律看做空格返回
//            return ' ';
//        }
//
//    }
//
//    public static boolean isPalindrome(String s) {
//        int n = s.length();
//        if(s==null || n<=1){
//            return true;
//        }
//        //双指针
//        char[] arr = s.toCharArray();
//        int p1 = 0, p2 = n-1;
//        while(p1<p2){
//            //忽略不为数字或字母的字符
//            while(p1<p2 && !Character.isLetterOrDigit(arr[p1])){
//                p1 += 1;
//            }
//            while(p2>p1 && !Character.isLetterOrDigit(arr[p2])){
//                p2 -= 1;
//            }
//            if(p1>=p2){
//                return true;
//            }
//            //比较两个数是否相等
//            if(Character.toLowerCase(arr[p1])==Character.toLowerCase(arr[p2])){
//                p1 += 1;
//                p2 -= 1;
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }

    public static boolean isPalindrome(String s){
        if(s.length()<=1 || s==null){
            return true;
        }
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            if(Character.isLetterOrDigit(arr[i])){
                sb.append(Character.toLowerCase(arr[i]));
            }
        }
        int i=0, j=sb.length()-1;
        while(i<j){
            if(sb.charAt(i)!=sb.charAt(j)){
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }


}
