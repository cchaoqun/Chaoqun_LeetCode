package Algorithm_HW.Week1;

/**
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/29-8:39
 */

public class LC168 {

    public static String convertToTitle(int n) {
        StringBuffer sb = new StringBuffer();
        while(n>0){
            n--;
            char cur = (char)(n%26+'A');
            sb.insert(0, cur);
            n /= 26;
        }
        return sb.toString();
    }
}
