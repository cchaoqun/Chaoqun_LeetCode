package JZOffer.jz0228;
/*
 * @Description: 剑指 Offer 20. 表示数值的字符串
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
* 字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
* 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/28 17:22
 */
public class JZ20 {

    public boolean isNumber(String s) {
        char[] arr = s.toCharArray();
        //s为空对象或者长度为0,不能表示数值
        if(s==null || s.length()==0){
            return false;
        }
        //标记是否遇到 数字,小数点,e或E
        boolean isNum = false, isDot = false, ise_E = false;
        for(int i=0; i<arr.length; ++i){
            //1.遇到数字
            if((arr[i]>='0') && (arr[i]<='9')){
                isNum = true;
            }
            //2.遇到小数点
            else if(arr[i] == '.'){
                //如果之前遇到过小数点 || 之前有e/E
                if(isDot || ise_E){
                    return false;
                }
                //标记已经遇到过小数点
                isDot = true;
            }
            //3.遇到e/E
            else if(arr[i] == 'e' || arr[i] == 'E'){
                //e/E前面必须有数字,并且只能有一个e/E
                if(!isNum ||ise_E){
                    return false;
                }
                //e/E后续必须还有数字
                isNum = false;
                //标记遇到了e/E
                ise_E = true;
            }
            //4.遇到了 + -
            else if(arr[i] == '+' || arr[i] == '-'){
                //'+' '-' 不在首尾,那么前面必须有'e/E'
                if(i!=0 && arr[i-1]!='e' && arr[i-1]!='E'){
                    return false;
                }
            }
            else{
                //其他情况均不合法
                return false;
            }
        }
        return isNum;
    }
}
