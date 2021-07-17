package Algorithm_HW.Week4;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/19-11:32
 */

//TODO 快排方法
public class LC75 {


    //一次遍历,双指针
    public void sortColors(int[] nums){
        int n = nums.length;
        if(n==0 || n==1){
            return;
        }
        /**
         需要将数组按照 [0 0 0 0.., 1 1 1 1 ..., 2 2 2 2] 排序
         那么开头的部分与结尾的部分一定是0  和 2
         只需要两个指针 r b 分别初始指向开头和结尾,
         r 指向的位置代表下一个遇到的 0 应该交换的位置
         b 指向的位置代表下一个遇到的 2 应该交换的位置
         */
        int r = 0;
        int b = n-1;
        for(int i=0; i<n; i++){
            //循环交换直到nums[b]不是2
            while(i<=b && nums[i]==2){
                swap(nums, i, b);
                b--;
            }
            //如果当前nums[i]==0 交换到 nums[r]的位置
            if(nums[i]==0){
                swap(nums, i, r);
                r++;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
