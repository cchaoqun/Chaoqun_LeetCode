package GreedyAlgorithm.greedy0507;

/**
 * 1850. 邻位交换的最小次数
 * 给你一个表示大整数的字符串 num ，和一个整数 k 。
 *
 * 如果某个整数是 num 中各位数字的一个 排列 且它的 值大于 num ，则称这个整数为 妙数 。可能存在很多妙数，但是只需要关注 值最小 的那些。
 *
 * 例如，num = "5489355142" ：
 * 第 1 个最小妙数是 "5489355214"
 * 第 2 个最小妙数是 "5489355241"
 * 第 3 个最小妙数是 "5489355412"
 * 第 4 个最小妙数是 "5489355421"
 * 返回要得到第 k 个 最小妙数 需要对 num 执行的 相邻位数字交换的最小次数 。
 *
 * 测试用例是按存在第 k 个最小妙数而生成的。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num = "5489355142", k = 4
 * 输出：2
 * 解释：第 4 个最小妙数是 "5489355421" ，要想得到这个数字：
 * - 交换下标 7 和下标 8 对应的位："5489355142" -> "5489355412"
 * - 交换下标 8 和下标 9 对应的位："5489355412" -> "5489355421"
 * 示例 2：
 *
 * 输入：num = "11112", k = 4
 * 输出：4
 * 解释：第 4 个最小妙数是 "21111" ，要想得到这个数字：
 * - 交换下标 3 和下标 4 对应的位："11112" -> "11121"
 * - 交换下标 2 和下标 3 对应的位："11121" -> "11211"
 * - 交换下标 1 和下标 2 对应的位："11211" -> "12111"
 * - 交换下标 0 和下标 1 对应的位："12111" -> "21111"
 * 示例 3：
 *
 * 输入：num = "00123", k = 1
 * 输出：1
 * 解释：第 1 个最小妙数是 "00132" ，要想得到这个数字：
 * - 交换下标 3 和下标 4 对应的位："00123" -> "00132"
 *
 *
 * 提示：
 *
 * 2 <= num.length <= 1000
 * 1 <= k <= 1000
 * num 仅由数字组成
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/7-21:56
 */

public class LC1850 {

    public int getMinSwaps(String num, int k){
        int res = 0;
        int len = num.length();
        int[] intnum = new int[len];
        int[] beginnum = new int[len];
        int index = 0;
        for(char c:num.toCharArray()){
            intnum[index] = c-'0';
            beginnum[index++] = c-'0';
        }
        //找k次 得到第k个秒数
        for(int i=0; i<k; i++){
            intnum = nextPermutation(intnum);
        }
        //第k个秒数
        int[] knum = intnum;
        //比较原始字符串对应的数组,和第k个秒数对应的数组
        //同位置相同的跳过
        //i位置不同的需要从beginnum[i+1,...]数组后续的位置找到最近的等于knum[i]的值并且交换过来
        for(int i=0; i<len; i++){
            if(beginnum[i]!=knum[i]){
                int j=i+1;
                //在[i+1,]从左到右找到第一个等于knum[i]的数字所在的位置
                while(beginnum[j]!=knum[i]){
                    j++;
                }
                //将找到的相同的数字向左交换到beginnum的i位置
                while(j!=i){
                    //向左交换
                    swap(beginnum,j, j-1);
                    //交换次数+1
                    res++;
                    //j左移一位
                    j--;
                }
            }
        }
        return res;
    }

    //找到下一个更大的排列
    public int[] nextPermutation(int[] nums){
        int len = nums.length;
        int i = len-2;
        //找到第一个nums[i]<nums[i+1]
        while(i>0 && nums[i]>=nums[i+1]){
            i--;
        }
        //数组不是全部递减排列的
        if(i>=0){
            int j=len-1;
            //在[i+1, len-1]中找到从右往左第一个大于nums[i]的位置, 至少存在一个nums[i+1] > nums[i]
            while(j>=0 && nums[i]>=nums[j]){
                j--;
            }
            //交换i j
            swap(nums, i, j);
            //将[i+1, len-1]的位置元素翻转, 因为本来已经是从左到右递减的, 需要变成递增的
            reverse(nums, i+1);
        }
        return nums;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start){
        int left = start;
        int right = nums.length-1;
        while(left<right){
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}




























