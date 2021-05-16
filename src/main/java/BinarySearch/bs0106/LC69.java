package BinarySearch.bs0106;
/*
 * @Description: 69. x 的平方根
实现int sqrt(int x)函数。
计算并返回x的平方根，其中x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 21:15
 */
public class LC69 {
    public static void main(String[] args) {
        int x =2147483647;
        int res = mySqrt(x);
        System.out.println(res);
    }

    //二分
//    public static int mySqrt(int x) {
//        if(x==0){
//            return 0;
//        }
//        int left = 0, right = x/2, mid;
//        long sq;
//        while(left<=right){
//            mid = left+(right-left)/2;
//            sq = mid*mid;
//            if(sq==x){
//                return (int)Math.floor(mid);
//            }else if(sq<x){
//                left = mid+1;
//            }else if(sq>x){
//                right = mid-1;
//            }
//        }
//        return right;
//    }

    //牛顿迭代
    public static int mySqrt(int x){
        long x0 = x;
        while((long)x0*x0 > x){
            x0 = (x0+x/x0)/2;
        }
        return (int)x0;
    }
}
