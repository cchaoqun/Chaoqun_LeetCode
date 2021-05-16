package JZOffer.jz0303;
/*
 * @Description:剑指 Offer 46. 把数字翻译成字符串
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。



示例 1:

输入: 12258
输出: 5
解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"


提示：

0 <= num < 231
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/3 15:21
 */
public class jz46 {

    char[] c;
    int count = 0;
    //递归
    public int translateNum(int num) {
        c = String.valueOf(num).toCharArray();
        dfs(0);
        return count;
    }

    void dfs(int index){
        //当前位置已经超出范围或者到达最后一位,只有一种情况,count+1
        if(index>=c.length-1){
            count += 1;
            return;
        }
        //将当前字符当做一个数字
        dfs(index+1);
        //考虑与后面一个字符的组合,当前字符不能为0,因为 01,02不是有效的
        if(c[index]-'0'!=0 && index+1<c.length){
            //当前位与后面一位组合的数字大小
            int temp = Integer.parseInt(c[index]+""+c[index+1]);
            if(temp<26){
                dfs(index+2);
            }
        }
    }

    //dp
//    public int translateNum(int num){
//        //f(i-1)   f(i-2)
//        int a = 1, b = 1;
//        //当前位  右边一位
//        int x, y = num % 10;
//        while(num!=0){
//            num /= 10;
//            //获得当前位
//            x = num % 10;
//            //计算当前位与右边一位的组合大小
//            int temp = x*10 + y;
//            //如果组合在[10,25]则到当前位置位置的可能情况有 a(到后边一位的情况)+b(到后边两位的情况)
//            //                                        x(yqwer)       +     xy(qwer)
//            int c = (10<=temp && temp<=25)? a+b:a;
//            b = a;
//            a = c;
//            //更新前一位
//            y = x;
//        }
//        return a;
//    }

}
