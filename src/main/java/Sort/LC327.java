package Sort;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/18-13:52
 */

public class LC327 {

    public int countRangeSum(int[] nums, int lower, int upper){
        if(nums==null || nums.length==0){
            return 0;
        }
        int len = nums.length;
        //前缀和数组 prefix[i] = sum [0:i] 闭区间
        long[] prefix = new long[len];
        prefix[0] = nums[0];
        //计算前缀和数组 prefix[i] = prefix[i-1] + nums[i]
        for(int i=1; i<len; i++){
            prefix[i] = nums[i]+prefix[i-1];
        }
        return calculateByMergeSort(prefix, lower, upper, 0, len-1);

    }

    /**
     * 计算区间L,R中满足   lower <= prefix[j]-prefix[i] <= upper 的所有区间
     * @param prefix 前缀和数组
     * @param lower 区间和的左界
     * @param upper 区间和的右界
     * @param L prefix中的左界
     * @param R prefix中的右界
     * @return
     */
    public int calculateByMergeSort(long[] prefix, int lower, int upper, int L, int R){
        if(L==R){
            //判断这个区间是否符合要求
            return (lower<=prefix[L] && prefix[L]<=upper)?1:0;
        }
        //计算区间中点
        int M = L + (R-L)/2;
        //递归计算左右两个区间
        int leftCount = calculateByMergeSort(prefix, lower, upper, L, M);
        int rightCount = calculateByMergeSort(prefix, lower, upper, M+1, R);

        //mergeSort合并左右两个排序后的区间计算合并后的结果
        int mergeCount = mergeSort(prefix, lower, upper, L, M, R);
        //返回左区间的结果+右区间的结果+合并左右区间的结果
        return leftCount+rightCount+mergeCount;

    }

    public int mergeSort(long[] prefix, int lower, int upper, int L, int M, int R){
        //合并两个区间的时候计算满足条件的组合
        int count = 0;
        //当前左右两个区间的左端点
        int curLeft = L;
        int curRight = M+1;
        /**
         * 左区间的指针 curLeft
         * 右区间的双指针 l r
         * 对于每一个curLeft, 我们希望找到左边第一个l 使得 prefix[curLeft]+lower <= prefix[l]
         *                  以及从左到右第一个r 使得 prefix[r] > prefix[curLeft]+upper
         *                  这样对于每一个 区间[l:r) 左闭右开的区间 都有 prefix[x]-prefix[curLeft]属于区间 [lower, upper]
         *                  区间内一个有 r-1-l+1 = r-l个数满足要求, 不包括r
         */
        int l = M+1;
        int r = M+1;
        while(curLeft<=M){
            //从左到右第一个l prefix[curLeft]+lower <= prefix[l]
            while(l<=R && prefix[l]<prefix[curLeft]+lower){
                l++;
            }
            //从左到右第一个r 使得 prefix[r] > prefix[curLeft]+upper
            while(r<=R && prefix[r]<=prefix[curLeft]+upper){
                r++;
            }
            //区间有r-l个数满足要求
            count += r-l;
            //继续尝试左区间下一个元素
            curLeft++;
        }
        //mergeSort 合并两个区间 [L:M] [M:R]
        long[] sorted = new long[R-L+1];
        //合并数组的索引
        int index = 0;
        //重置左右区间左端点指针
        curLeft = L;
        curRight = M+1;
        while(curLeft<=M && curRight<=R){
            //更小的先放入数组
            if(prefix[curLeft]<=prefix[curRight]){
                sorted[index++] = prefix[curLeft++];
            }else{
                sorted[index++] = prefix[curRight++];
            }
        }
        //处理剩余的没有放入合并数组的区间, 只有可能剩下一个
        while(curLeft<=M){
            sorted[index++] = prefix[curLeft++];
        }
        while(curRight<=R){
            sorted[index++] = prefix[curRight++];
        }
        //将合并后的数组sorted放入对应的prefix数组
        index = 0;
        curLeft = L;
        while(index<R-L+1){
            prefix[curLeft++] = sorted[index++];
        }
        return count;
    }
}
