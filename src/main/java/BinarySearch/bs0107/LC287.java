package BinarySearch.bs0107;

/*
 * @Description: 287. 寻找重复数
给定一个包含n + 1 个整数的数组nums，其数字都在 1 到 n之间（包括 1 和 n），
可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。

说明：

不能更改原数组（假设数组是只读的）。
只能使用额外的 O(1) 的空间。
时间复杂度小于 O(n2) 。
数组中只有一个重复的数字，但它可能不止重复出现一次。


 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 12:48
 */
public class LC287 {
    public static void main(String[] args) {
        int res = findDuplicate(new int[]{3,1,3,4,2});
        System.out.println(res);
    }

    public static int findDuplicate(int[] nums) {
        //创建数组,每个下标记录的都是对应的值出现的次数
        int[] index = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            //该值对应的下标位置的值已经为1说明已经出现了,直接返回该值
            if(index[nums[i]] == 1){
                return nums[i];
            }else{
                //值为0,该次为第一次出现,+1
                index[nums[i]] += 1;
            }
        }
        return -1;
    }
}
