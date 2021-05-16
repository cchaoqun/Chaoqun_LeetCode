package BinarySearch;

import java.util.Arrays;
import java.util.HashMap;


/*
 * @Description: 350. 两个数组的交集 II
给定两个数组，编写一个函数来计算它们的交集
输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
我们可以不考虑输出结果的顺序。
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/5 20:46
 */
public class LC350 {
    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = intersect(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }

    //HashMap
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return intersect(nums2,nums1);
        }
        //利用HashMap存储数组元素以及出现次数
        HashMap<Integer,Integer> map = new HashMap<>();
        //遍历较小长度的数组
        for(int i:nums1){
            int count = map.getOrDefault(i,0)+1;
            map.put(i,count);
        }
        //存放结果的数组
        int[] res = new int[nums1.length];
        //遍历较长的数组
        int index = 0;
        for(int i:nums2){
            int count = map.getOrDefault(i,0);
            if(count==0){
                continue;
            }
            if(count>0){
                //存在重合元素,放入数组
                res[index++] = i;
                //重复次数-1
                count--;
                //-1后仍然>0更新重复的次数
                if(count>0){
                    map.put(i,count);
                }else{
                    //-1后==0,移除
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    //排序
//    public static int[] intersect(int[] nums1, int[] nums2){
//        if(nums2.length<nums1.length){
//            return intersect(nums2,nums1);
//        }
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        int[] res = new int[nums1.length];
//        int index = 0;
//        int i=0,j=0;
//        while(i<nums1.length && j<nums2.length){
//            if(nums1[i] == nums2[j]){
//                res[index++] = nums1[i];
//                i++;
//                j++;
//            }else if(nums1[i] < nums2[j]){
//                i++;
//            }else{
//                j++;
//            }
//        }
//        return Arrays.copyOfRange(res,0,index);
//    }
}
