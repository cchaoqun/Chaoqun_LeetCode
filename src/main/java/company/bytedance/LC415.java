package company.bytedance;

import org.junit.jupiter.api.Test;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/24-13:50
 */

public class LC415 {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int carry = 0;
        int rem = 0;
        int index1 = arr1.length-1;
        int index2 = arr2.length-1;
        StringBuffer sb = new StringBuffer();
        while(index1>=0 || index2 >=0 || carry>0){
            int c1 = index1>=0?arr1[index1]-'0':0;
            int c2 = index2>=0?arr2[index2]-'0':0;
            int curSum = c1+c2+carry;
            carry = curSum / 10;
            rem = curSum % 10;
            sb.append(rem);
            index1--;
            index2--;
        }

        return sb.reverse().toString();
    }
}
