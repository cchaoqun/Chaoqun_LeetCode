package BinarySearch.bs0106;
/*
 * @Description:374. 猜数字大小
猜数字游戏的规则如下：

每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，
返回值一共有 3 种可能的情况（-1，1或 0）：

-1：我选出的数字比你猜的数字小 pick < num
1：我选出的数字比你猜的数字大 pick > num
0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 13:42
 */
public class LC374 {
    public static void main(String[] args) {

    }

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */
    //二分查找
//    public int guessNumber(int n) {
//        int left = 0;
//        int right = n;
//        while(left<=right){
//            int mid = left+(right-left)/2;
//            if(guess(mid) <0 ){
//                right = mid-1;
//            }else if(guess(mid) > 0){
//                left = mid+1;
//            }else{
//                return mid;
//            }
//        }
//        return -1;
//    }
    //二分法第二种写法：************************************************************
//    public int guessNumber(int n){
//        int low=1;
//        int high=n;
//        int mid=(low+high)>>>1;
//        int res=guess(mid);
//        while(res!=0){
//            if(res==-1){
//                high=mid-1;
//            }else{
//                low=mid+1;
//            }
//            mid=(low+high)>>>1;
//            res=guess(mid);
//        }
//        return mid;
//    }

    //三分查找
//    public int guessNumber(int n){
//        int left = 0;
//        int right = n;
//        while(left<=right){
//            int mid1 = left+(right-left)/3;
//            int mid2 = left+(right-left)*2/3;
//            int g1 = guess(mid1);
//            int g2 = guess(mid2);
//            if(g1==0){
//                return mid1;
//            }
//            if(g2==0){
//                return mid2;
//            }
//            if(g1<0){
//                right = mid1-1;
//            }else if(g1>0 && g2<0){
//                left = mid1+1;
//                right = mid2-1;
//            }else{
//                left = mid2+1;
//            }
//        }
//        return -1;
//    }


}
