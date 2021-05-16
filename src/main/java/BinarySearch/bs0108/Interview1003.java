package BinarySearch.bs0108;
/*
 * @Description: 面试题 10.03. 搜索旋转数组
搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。

若有多个相同元素，返回索引值最小的一个。

示例1:
 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 输出: 8（元素5在该数组中的索引）
 *
示例2:
 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 输出：-1 （没有找到）
 *
提示:
arr 长度范围在[1, 1000000]之间

 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/1/8 13:07
 */
public class Interview1003 {
    public static void main(String[] args) {
        int[] arr = {-30, -25, -22, -22, -18, -12, -11, -11, -9, -8, -8, -1, 0, 0, 5, 6, 6, 13, 14, 16, 16, 18, 19, 19, 21, 21, 22, 23, 25, 26, 30, 30, 30, 32, 37, 38, 40, 41, 43, 43, 45, 45, 45, 46, 46, 47, 56, 59, 61, 62, 64, 65, 69, 73, 74, 80, 84, 84, 86, 86, 88, 88, 89, 89, 90, 90, 91, 92, 92, -93, -93, -87, -84, -82, -80, -80, -79, -77, -74, -73, -70, -68, -66, -64, -60, -58, -55, -52, -51, -51, -49, -46, -43, -34};
        int target = 89;
        int res =search(arr,target);
        System.out.println(res);
    }
    public static int search(int[] arr, int target) {
        int n = arr.length;
        if(n==0){
            return 0;
        }
        //先判断左端是否==target
        if(arr[0] == target){
            return 0;
        }

        int l = 0;
        int r = n-1;
        while(l<r){
            int mid = l+(r-l)/2;
            if(arr[mid]==target){
                //找最小的索引向左寻找最小的下标
                r = mid;
                //!!!直接进入下一次
                continue;
            }
            //左区间递增
            if(arr[l]<arr[mid]){
                if(arr[l]<=target && target<=arr[mid]){
                    //target在左区间
                    r = mid;
                }else{
                    l = mid+1;
                }
            }else if(arr[l]>arr[mid]){
                //右区间递增
                if(arr[mid]<target && target<=arr[r]){
                    //target在右区间
                    l = mid+1;
                }else{
                    r = mid;
                }
            }else{
                //arr[l] == arr[mid]
                if(arr[l] == target){
                    l = mid;
                }else{
                    l++;
                }
            }
        }
        return arr[l]==target ? l:-1;
    }
}
