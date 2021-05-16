package NumList.List0201;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @Description: 238. 除自身以外数组的乘积
 *
给你一个长度为n的整数数组nums，其中n > 1，返回输出数组output，
其中 output[i]等于nums中除nums[i]之外其余各元素的乘积。

示例:

输入: [1,2,3,4]
输出: [24,12,8,6]


提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/product-of-array-except-self
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/1 20:56
 */
public class LC238 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = productExceptSelf(nums);
        System.out.println(Arrays.toString(res));

    }
    //O（n^2)
//    public static int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[] res = new int[n];
//        Arrays.fill(res, 1);
//        for(int i=0; i<n; i++){
//            for(int j=0; j<n; j++){
//                if(j!=i){
//                    res[j] *= nums[i];
//                }
//            }
//        }
//        return res;
//    }

    //一次遍历 前缀积，后缀积
    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res,1);
        int pre = 1, post = 1;
        for(int i=0; i<n; i++){
            //当前元素*前缀积
            res[i] *= pre;
            //对称的元素*后缀积
            res[n-1-i] *= post;
            //更新下一个元素的前缀积和后缀积
            pre *= nums[i];
            post *= nums[n-1-i];

        }
        return res;
    }

//    public static int[] productExceptSelf(int[] nums){
//        int n = nums.length;
//
//        int[] res = new int[n];
//        Arrays.fill(res,1);
//        int pre = 1, post = 1;
//        //正序遍历
//        for(int i=0; i<n-1; i++){
//            //更新下一个元素的前缀积和后缀积
//            pre *= nums[i];
//            //当前元素*前缀积
//            res[i+1] *= pre;
//
//        }
//        //倒序遍历
//        for(int i=n-1; i>0; i--){
//            //更新下一个元素的后缀积
//            post *= nums[i];
//            //对称的元素*后缀积
//            res[i-1] *= post;
//
//        }
//        return res;
//    }
}