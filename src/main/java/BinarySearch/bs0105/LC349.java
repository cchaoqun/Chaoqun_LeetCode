package BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * @Description: 给定两个数组，编写一个函数来计算它们的交集。
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 10:32
 */
public class LC349 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }
    //两个集合
//    public static int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set1 = new HashSet<>();
//        Set<Integer> set2 = new HashSet<>();
//        if(nums1.length < nums2.length){
//            for(int i:nums2){
//                set2.add(i);
//            }
//            for(int i:nums1){
//                if(set2.contains(i)){
//                    set1.add(i);
//                }
//            }
//            int[] res = new int[set1.size()];
//            int index = 0;
//            for(int i:set1){
//                res[index] = i;
//                index++;
//            }
//            return res;
//        }else{
//            for(int i:nums1){
//                set1.add(i);
//            }
//            for(int i:nums2){
//                if(set1.contains(i)){
//                    set2.add(i);
//                }
//            }
//            int[] res = new int[set2.size()];
//            int index = 0;
//            for(int i:set2){
//                res[index] = i;
//                index++;
//            }
//            return res;
//        }

    //通过 list.retainAll求交集, addAll去重
//    public static int[] intersection(int[] nums1, int[] nums2){
//        Set<Integer> set1 = new HashSet<>();
//        Set<Integer> set2 = new HashSet<>();
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i:nums1){
//            set1.add(i);
//        }
//        for(int i:nums2){
//            list.add(i);
//        }
//        //求交集
//        list.retainAll(set1);
//        //去重
//        set2.addAll(list);
//        int index = 0;
//        int[] res = new int[set2.size()];
//        for(int i:set2){
//            res[index++] = i;
//        }
//        return res;
//    }

    //暴力双指针
//    public static int[] intersection(int[] nums1, int[] nums2){
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        Set<Integer> set = new HashSet<>();
//        int i = 0;
//        int j = 0;
//        while(i < nums1.length && j < nums2.length){
//            if(nums1[i] == nums2[j]){
//                set.add(nums1[i]);
//                i++;
//                j++;
//            }else if(nums1[i] > nums2[j]){
//                j++;
//            }else{
//                i++;
//            }
//        }
//        int index = 0;
//        int[] res = new int[set.size()];
//        for(int k:set){
//            res[index++] = k;
//        }
//        return res;
//    }

    //二分查找
    public static int[] intersection(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();
        for(int target:nums2){
            if(binarySearch(nums1,target) && !set.contains(target)){
                set.add(target);
            }
        }
        int index = 0;
        int[] res = new int[set.size()];
        for(int k:set){
            res[index++] = k;
        }
        return res;

    }
    public static boolean binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left<=right){
            int mid = (left+right)/2;
            if(nums[mid]==target){
                return true;
            }else if(target<nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
