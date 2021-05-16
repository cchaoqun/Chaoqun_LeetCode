package JZOffer.jz0308;
/*
 * @Description: 剑指 Offer 64. 求1+2+…+n
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。



示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45


限制：

1 <= n <= 10000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/8 21:58
 */
public class jz64 {
    int res = 0;
    public int sumNums(int n) {
        boolean flag = n>1 && sumNums(n-1)>0;
        res += n;
        return res;
    }

//    int[] res1 = new int[]{0};
//    public int sumNums(int n){
//        try{
//            return res1[n];
//        }catch(Exception e){
//            res1[0] += n;
//            return sumNums(n-1);
//        }
//    }
}
