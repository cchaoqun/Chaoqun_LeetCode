package JZOffer.jz0228;
/*
 * @Description: 剑指 Offer 17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]


说明：

用返回一个整数列表来代替打印
n 为正整数
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/28 15:28
 */
public class JZ17_Review {

    //不考虑大树
//    public int[] printNumbers(int n) {
//        int maxVal = 0;
//        while(n!=0){
//            maxVal = maxVal * 10 + 9;
//            --n;
//        }
//        int[] res = new int[maxVal];
//        for(int i=1; i<=maxVal; ++i){
//            res[i-1] = i;
//        }
//        return res;
//    }

    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    //考虑大数,用字符串考虑所以可能的全排列
    public int[] printNumbers(int n){
        this.n = n;
        res = new int[(int)Math.pow(10,n)-1];
        num = new char[n];
        start = n-1;
        dfs(0);
        return res;
    }

    void dfs(int x){
        if(x==n){
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")){
                res[count] = Integer.parseInt(s);
                ++count;
            }
            if(n-start == nine){
                --start;
            }
            return;
        }
        for(char i : loop){
            if(i=='9'){
                ++nine;
            }
            num[x] = i;
            dfs(x+1);
        }
        --nine;
    }
}
