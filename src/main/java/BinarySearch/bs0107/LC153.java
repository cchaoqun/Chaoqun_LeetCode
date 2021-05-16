package BinarySearch.bs0107;
/*
 * @Description: 153. 寻找旋转排序数组中的最小值
假设按照升序排序的数组在预先未知的某个点上进行了旋转。
例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2] 。

请找出其中最小的元素。

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 16:00
 */
public class LC153 {
    public static void main(String[] args) {
        int nums[] = new int[]{4,5,6,7,0,1,2};
        int res = findMin(nums);
        System.out.println(res);
    }

    public static int findMin(int[] nums) {
        //本来就是按顺序排列
        if(nums[0]<=nums[nums.length-1]){
            return nums[0];
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            //mid有可能为最小的元素,需要保留
            if(nums[mid]<=nums[right]){
                right = mid;
            }else{
                //大于右端点,该点肯定不是最小,右移一位
                left = mid+1;
            }
        }
        return nums[left];
    }
}
