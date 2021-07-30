package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/28-15:31
 */

public class jz53_II {
    public int missingNumber(int[] nums) {
        /**
         初始化： 左边界 i = 0i=0 ，右边界 j = len(nums) - 1j=len(nums)−1 ；代表闭区间 [i, j][i,j] 。
         循环二分： 当 i \leq ji≤j 时循环 （即当闭区间 [i, j][i,j] 为空时跳出） ；
         计算中点 m = (i + j) // 2m=(i+j)//2 ，其中 "////" 为向下取整除法；
         若 nums[m] ==m ，则 “右子数组的首位元素” 一定在闭区间 [m + 1, j] 中，因此执行 i = m + 1
         若 nums[m] !=m ，则 “左子数组的末位元素” 一定在闭区间 [i, m - 1] 中，因此执行 j = m - 1
         返回值： 跳出时，变量 ii 和 jj 分别指向 “右子数组的首位元素” 和 “左子数组的末位元素” 。因此返回 ii 即可。

         */
        if(nums==null || nums.length==0){
            return -1;
        }
        int l=0, r=nums.length-1;
        int mid = (l+r)>>>1;
        while(l<=r){
            mid = (l+r)>>>1;
            if(nums[mid]==mid){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return l;
    }
}
