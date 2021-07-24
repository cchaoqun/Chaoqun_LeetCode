package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/22-20:23
 */

public class jz20 {
    public boolean isNumber(String s) {
        /**
         +/- 出现在开头, 如果后面出现, 必定前一个字符是e或者E
         . 出现了点, 不能出现e E 和 '.'
         e E 必须出现了数字 并且没出现E e 后面必须还要出现数字
         */
        char[] arr = s.trim().toCharArray();
        boolean isNum=false, isDot=false, isE = false;
        for(int i=0; i<arr.length; i++){
            if(isNum(arr[i])){
                isNum = true;
            }else if(arr[i]=='+' || arr[i]=='-'){
                // +/-前面必须是e E 如果不是开头
                if(i!=0 && (arr[i-1]!='e' && arr[i-1]!='E')){
                    return false;
                }
            }else if(arr[i]=='e' || arr[i]=='E'){
                if(!isNum || isE){
                    return false;
                }
                isNum = false;
                isE = true;
            }else if(arr[i]=='.'){
                if(isDot || isE){
                    return false;
                }
                isDot = true;
            }else{
                return false;
            }

        }
        return isNum;
    }

    private boolean isNum(char c){
        return '0'<= c && c<='9';
    }
}
