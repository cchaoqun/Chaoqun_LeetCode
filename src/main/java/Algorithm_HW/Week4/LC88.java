package Algorithm_HW.Week4;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/21-18:00
 */

public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //nums1 nums2的指针指向最后一位
        int p1 = m-1;
        int p2 = n-1;
        //合并后数组的指针指向最后一位
        int p = m+n-1;
        while(p1>=0 && p2>=0){
            //谁大谁就放在合并后数组的最后一位
            if(nums1[p1]>=nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }else{
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        //剩余的没有放完的一次从大到小放入即可
        while(p1>=0){
            nums1[p] = nums1[p1];
            p--;
            p1--;
        }
        while(p2>=0){
            nums1[p] = nums2[p2];
            p--;
            p2--;
        }

    }
}
