package GreedyAlgorithm.greedy0524;

/**
 * 1775. 通过最少操作次数使数组的和相等
 * 给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。
 *
 * 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。
 *
 * 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * - 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
 * 示例 2：
 *
 * 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
 * 输出：-1
 * 解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
 * 示例 3：
 *
 * 输入：nums1 = [6,6], nums2 = [1]
 * 输出：3
 * 解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
 * - 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
 * - 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
 * - 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
 *
 *
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 6
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/24-21:22
 */

public class LC1775 {
    public int minOperations(int[] nums1, int[] nums2) {
        //记录两数组的和
        int sum1 = 0;
        int sum2 = 0;
        //diff1[i] = 两个数组中有多少个 i可以从总和中减去
        int[] diff1 = new int[6];
        //默认nums1和<=nums2
        for(int i:nums1){
            //求和
            sum1+=i;
            //当前数字为i, 因为nums1默认为和小的数组
            //需要将nums1的总和加大, 对于i来说, 最大能增加到6, 可以贡献的增加为6-i,提供一次
            diff1[6-i]++;
        }
        for(int i:nums2){
            sum2+=i;
            //nums2为和较大的数组, 当前数组的和需要减少
            //对于i来说, 最小能减少到1,可以贡献的减少为i-1, 提供一次
            //这里的nums2和减少等于nums1和增加,
            diff1[i-1]++;
        }
        if(sum1>sum2){
            //使得默认nums1和更小
            return minOperations(nums2, nums1);
        }

        int diff = sum2-sum1;
        int count = 0;
        //从最大的可以减少差的5开始直到i=1, i=0不提供任何帮助
        for(int i=5; i>=1 && diff>0; i--){
            //对于每一个减量, 全部用完
            while(diff1[i]>0 && diff>0){
                diff1[i]--;
                diff -= i;
                count++;
            }
        }
        //最后差仍然大于0, 不能完成
        return diff>0?-1:count;


    }
}
