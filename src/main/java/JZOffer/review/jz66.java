package JZOffer.review;

/**剑指 Offer 66. 构建乘积数组
 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。



 示例:

 输入: [1,2,3,4,5]
 输出: [120,60,40,30,24]


 提示：

 所有元素乘积之和不会溢出 32 位整数
 a.length <= 100000
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/30-15:20
 */

public class jz66 {
    public int[] constructArr(int[] a){
        int len = a.length;
        if(len==0){
            return new int[0];
        }
        int[] res = new int[len];
        res[0] = 1;
        //左到右求前缀积
        for(int i=1; i<len; i++){
            res[i] = res[i-1]*a[i-1];
        }
        //从右到左求前缀积
        int curMul = 1;
        for(int i=len-2; i>=0; i--){
            curMul *= a[i+1];
            res[i] *= curMul;
        }
        return res;

    }
}
