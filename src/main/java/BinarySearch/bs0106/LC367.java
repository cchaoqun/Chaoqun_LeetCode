package BinarySearch.bs0106;
/*
 * @Description: 367. 有效的完全平方数
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
说明：不要使用任何内置的库函数，如 sqrt。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 17:56
 */
public class LC367 {
    public static void main(String[] args) {
        int num = 16*16;
        boolean res = isPerfectSquare(num);
        System.out.println(res);

    }
    //二分
//    public static boolean isPerfectSquare(int num) {
//        if(num<2){
//            return true;
//        }
//        long left=2, right = num/2, mid;
//        while(left<=right){
//            mid = left+(right-left)/2;
//            if(mid*mid == num){
//                return true;
//            }else if(mid*mid<num){
//                left = mid+1;
//            }else if(mid*mid>num){
//                right = mid-1;
//            }
//        }
//        return false;
//    }

    //牛顿迭代
    public static boolean isPerfectSquare(int num){
        if(num<2){
            return true;
        }
        //当num>4时, num/2 < sqrt(num), 所以此时 x*x一定大于num
        long x = num/2;
        while(x*x>num){
            x=(x+num/x)/2;
        }
        return x*x == num;
    }



}
