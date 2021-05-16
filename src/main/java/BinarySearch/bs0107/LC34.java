package BinarySearch.bs0107;

import java.util.Arrays;

/*
 * @Description: 34. 在排序数组中查找元素的第一个和最后一个位置
给定一个按照升序排列的整数数组 nums，和一个目标值 target。
找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回[-1, -1]。

进阶：
你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？


 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/7 22:05
 */
public class LC34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        int[] res = searchRange(nums,target);
        System.out.println(Arrays.toString(res));
    }

    //二分分两个函数
//    public static int[] searchRange(int[] nums, int target) {
//        if(nums.length==0 || nums == null){
//            return new int[]{-1,-1};
//        }
//        int[] res = new int[2];
//        Arrays.fill(res,-1);
//        int left = 0;
//        int right = nums.length;
//        boolean exist = false;
//        int pivot = 0;
//        while(left<right){
//            int mid = left+(right-left)/2;
//            if(target == nums[mid]){
//                //找到目标值 则继续寻找左右边界
//                exist = true;
//                //保留找到的下标索引,可以从这个位置开始寻找左右边界
//                pivot = mid;
//                break;
//            }else if(target>nums[mid]){
//                left = mid+1;
//            }else if(target<nums[mid]){
//                right = mid;
//            }
//        }
//        if(exist) {
//            res[0] = findLeft(nums, target, pivot);
//            res[1] = findRight(nums, target, pivot);
//        }
//        return res;
//    }
//
//    public static int findLeft(int[] nums,int target, int pivot){
//        int left = 0;
//        int right = pivot;
//        while(left<right){
//            int mid = left+(right-left)/2;
//            if(target == nums[mid]){
//                right = mid;
//            }else{
//                left = mid+1;
//            }
//        }
//        return right;
//    }
//
//    public static int findRight(int[] nums,int target, int pivot){
//        int left = pivot;
//        int right = nums.length;
//        while(left<right){
//            int mid = left+(right-left)/2;
//            if(target == nums[mid]){
//                left = mid+1;
//            }else{
//                right = mid;
//            }
//        }
//        return left-1;
//    }


    //定义一个函数分别用来找左右边界
    public static int[] searchRange(int[] nums, int target){
        int[] res = new int[2];
        Arrays.fill(res,-1);
        res[0] = findBound(nums,target,false);
        res[1] = findBound(nums,target,true);
        return res;
    }

    public static int findBound(int[] nums, int target, boolean findRight){
        int l = 0;
        int r = nums.length;
        while(l<r){
            int mid = l+(r-l)/2;
            if(target<nums[mid]){
                r = mid;
            }else if(target>nums[mid]){
                l = mid+1;
            }else{
                //找到目标值
                //找右边界
                if(findRight){
                    //在右边二分查找
                    int rL = mid;
                    int rR = nums.length;
                    while(rL<rR){
                        int rMid = rL+(rR-rL)/2;
                        if(target==nums[rMid]){
                            rL = rMid+1;
                        }else{
                            rR = rMid;
                        }
                    }
                    return rL-1;
                }else{
                    //找左边界
                    int lL = 0;
                    int lR = mid;
                    while(lL<lR){
                        int lMid = lL+(lR-lL)/2;
                        if(target==nums[lMid]){
                            lR = lMid;
                        }else{
                            lL = lMid+1;
                        }
                    }
                    return lR;
                }
            }
        }
        return -1;
    }

}
