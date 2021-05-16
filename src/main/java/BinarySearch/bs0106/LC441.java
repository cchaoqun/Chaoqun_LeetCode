package BinarySearch.bs0106;
/*
 * @Description: 441. 排列硬币
你总共有n枚硬币，你需要将它们摆成一个阶梯形状，第k行就必须正好有k枚硬币。
给定一个数字n，找出可形成完整阶梯行的总行数。
n是一个非负整数，并且在32位有符号整型的范围内。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/6 19:35
 */
public class LC441 {
    public static void main(String[] args) {
        int n = 1804289383;
        long res = arrangeCoins(n);
        System.out.println(res);
    }

    //二分 注意强制类型转换, mid sum需要定义成long类型 防止int类型溢出
    public static int arrangeCoins(int n) {
        if(n==0){
            return 0;
        }
        int left=0, right=n;
        long mid,sum;
        while(left<=right){
            mid = left+(right-left)/2;
            //前mid行硬币总和
            sum = mid*(mid+1)/2;
            if(sum>n){
                right = (int)mid-1;
            }else if(sum==n){
                //刚好排列成mid行
                return (int)mid;
            }else if(sum<n){
                //n-sum是否不满mid+1
                if((n-sum) < (mid+1)){
                    return (int)mid;
                }else{
                    left = (int)mid+1;
                }
            }
        }
        return left-1;
    }

    //数学方法 一直让n- 1,2,3,4...直到n<=0 n=0 返回i, n<0 返回i-1
//    public static int arrangeCoins(int n){
//        int i=0;
//        while(n>0){
//            i++;
//            n-=i;
//        }
//        if(n==0){
//            //刚好减i 等于0
//            return i;
//        }else{
//            //减i小于0
//            return i-1;
//        }
//    }

    //根据数学公式，k(k+1) /2 = n，可以得到其正数解为：k = sqrt(2n+1/4) - 1/2。然后求整即可。
    //唯一的问题是，这里2n+1/4有可能会超出sqrt函数的参数范围。
    //于是，我们可以变换一下， k = sqrt(2) * sqrt(n+1/8) - 1/2，这样求平方根就不会超限了。
    //于是，我们就有了这么一行代码
//    public static int arrangeCoins(int n){
//        return (int)(Math.sqrt(2)*Math.sqrt(n+0.125)-0.5);
//    }
}
