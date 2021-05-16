package NumList.List0130;

import java.util.Arrays;

/*
 * @Description: 88. 合并两个有序数组
 *
给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，
这样它就有足够的空间保存来自 nums2 的元素。
*
示例 1：
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]
*
示例 2：
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]

提示：

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/merge-sorted-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/30 17:41
 */
public class LC88 {

    public static void main(String[] args) {
        int nums1[] = {0};
        int nums2[] = {1};
        merge(nums1,0,nums2,1);
        System.out.println(Arrays.toString(nums1));

    }

//    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        if(n==0){
//            return;
//        }
//
//        int p1 = m-1;
//        for(int i=0; i<n; i++){
//            while(p1>=0 && nums2[i]<=nums1[p1]){
//                nums1[p1+1] = nums1[p1];
//                p1--;
//            }
//            //插入位置在p1后面
//            nums1[p1+1] = nums2[i];
//            //下一次比较的位置后移一位
//            p1 = m+i;
//        }
//    }

    public static void merge(int[] nums1, int m, int[] nums2, int n){
        if(n==0){
            return;
        }

        int p1 = m-1;
        int p2 = n-1;
        int p = m+n-1;
        while(p2>=0){
            if(p1>=0 && nums1[p1]>nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }else{
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

    }

}
