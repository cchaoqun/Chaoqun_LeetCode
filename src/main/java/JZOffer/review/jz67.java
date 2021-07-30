package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/30-15:48
 */

public class jz67 {
    public int strToInt(String str) {
        /**
         * 删除左边的空格
         * 遇到符号记录
         * 遇到第一个连续的数字字符串
         * 保证当前的和 < Integer.MAX_VALUE/10
         * 如果 curSum ==Integer.MAX_VALUE/10 必须保证当前数字<=7 正数,  必须保证当前数字<=8 负数
         * 如果 curSum > Integer.MAX_VALUE/10 返回 max sign=1 min sign=-1
         *
         *
         */
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        int limit = max/10;
        int sign = 1;
        int index = 0;
        int len = str.length();
        while(index<len && str.charAt(index)==' '){
            index++;
        }
        if(index<len ){
            if(str.charAt(index)=='-'){
                sign = -1;
                index++;
            }else if(str.charAt(index)=='+'){
                index++;
            }
        }
        int num = 0;
        while(index<len ){
            char cur = str.charAt(index);
            if(0<=cur-'0' && cur-'0'<=9){
                if(num>limit){
                    return sign==1?max:min;
                }
                if(num==limit){
                    if(sign==1 && cur-'0'>7){
                        return max;
                    }
                    if(sign==-1 && cur-'0'>8){
                        return min;
                    }
                }
                num = num*10+cur-'0';

            }else{
                break;
            }
            index++;
        }
        return num*sign;

    }
}
