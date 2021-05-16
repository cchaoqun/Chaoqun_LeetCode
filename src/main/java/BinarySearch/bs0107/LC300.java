package BinarySearch.bs0107;
/*
 * @Description: 300. 最长递增子序列
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
进阶：

你可以设计时间复杂度为 O(n2) 的解决方案吗？
你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 17:02
 */
public class LC300 {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,4};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }

    //dp
//    public static int lengthOfLIS(int[] nums){
//        if(nums.length == 0){
//            return 0;
//        }
//        int maxAns = 1;
//        //维护一个dp数组保存第i个元素对应的最长子序列长度
//        int dp[] = new int[nums.length];
//        dp[0] = 1;
//        for(int i=1; i<nums.length; i++){
//            //先把长度设为1
//            dp[i] = 1;
//            //遍历i位置以前的元素
//            for(int j=0; j<i; j++){
//                //如果j元素值小于i
//                if(nums[j] < nums[i]){
//                    //比较i位置长度和j位置长度+1
//                    dp[i] = Math.max(dp[i], dp[j]+1);
//                }
//            }
//            //比较当前位置最长子序列长度和之前的最大值
//            maxAns = Math.max(maxAns, dp[i]);
//        }
//        return maxAns;
//    }

    //贪心算法
    public static int lengthOfLIS(int[] nums){
        int len = 1;
        int n = nums.length;
        //维护一个数组d[] d[i]表示最长子序列长度为i的末尾最小值
        int[] d = new int[n+1];
        //将数组第一个元素赋给 d[1]
        d[len] = nums[0];
        //从数组第二个元素开始遍历
        for(int i=1; i<n; i++){
            //如果该元素大于当前长度的末尾最小值,长度+1,该元素放入数组
            if(nums[i] > d[len]){
                d[++len] = nums[i];
            }else{
                //当前元素小于当前长度的末尾最小值,在d[]中找到第一个小于nums[i]的元素d[k]
                //使用二分查找
                int l=1,r=len,pos=0;//pos=0防止d[]所有元素都大于nums[i]
                while(l<r){
                    int mid = l+(r-l)/2;
                    if(d[mid]<nums[i]){
                        pos = mid;
                        l = mid+1;
                    }else{
                        r = mid;
                    }
                }
                //在找到第一个小于当前元素的位置后一个放入当前元素
                d[pos+1] = nums[i];
            }
        }
        return len;
    }
}
