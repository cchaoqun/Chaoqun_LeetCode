package JZOffer.jz0310;
/*
 * @Description: 剑指 Offer 66. 构建乘积数组
给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。



示例:

输入: [1,2,3,4,5]
输出: [120,60,40,30,24]


提示：

所有元素乘积之和不会溢出 32 位整数
a.length <= 100000
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/3/10 10:45
 */
public class jz66 {

    public int[] constructArr(int[] a) {
        if(a==null || a.length==0){
            return new int[0];
        }
        //结果数组
        int[] res = new int[a.length];
        //第一个元素初始化为1
        res[0] = 1;
        //从右边开始元素的乘积
        int right = 1;
        //从res第二个元素开始
        for(int i=1; i<res.length; ++i){
            //res[i] = 当前i位置左边所有a中元素的乘积
            res[i] = res[i-1] * a[i-1];
        }
        //从res倒数第二个元素开始
        for(int i=a.length-2; i>=0; --i){
            //right = 当前i位置右边所有a中元素的乘积
            right *= a[i+1];
            //res[i] 原本等于i位置左边所有位置元素乘积 * 当前i位置右边所有元素乘积
            res[i] *= right;
        }

        return res;
    }
}
