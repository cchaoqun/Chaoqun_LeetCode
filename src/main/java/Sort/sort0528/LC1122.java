package Sort.sort0528;

import java.util.HashSet;
import java.util.Set;

/**
 * 1122. 数组的相对排序
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 * @author Chaoqun Cheng
 * @date 2021-05-2021/5/28-12:21
 */

public class LC1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //遍历arr1判断是否出现在arr2
        Set<Integer> set = new HashSet<>();
        for(int i:arr2){
            set.add(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i:arr1){
            max = Math.max(max, i);
        }
        //存放arr2出现在arr1中的数字次数
        int[] num1 = new int[max+1];
        //存放不出现在arr2中arr1的数字次数
        int[] num2 = new int[max+1];
        int[] res = new int[arr1.length];
        int count = 0;
        for(int i:arr1){
            if(set.contains(i)){
                count++;
                num1[i]++;
            }else{
                num2[i]++;
            }
        }
        int index = 0;
        //先按照arr2的顺序将arr1中数字放入
        for(int i:arr2){
            while(num1[i]>0){
                res[index++] = i;
                num1[i]--;
            }
        }
        //放入剩余的数字
        for(int i=0; i<=max; i++){
            if(num2[i]>0){
                while(num2[i]>0){
                    res[count++] = i;
                    num2[i]--;
                }
            }
        }
        return res;
    }
}

class LC122_M2{
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int max = Integer.MIN_VALUE;
        //获取最大值
        for(int i:arr1){
            max = Math.max(max, i);
        }
        //统计arr1每个数字频率
        int[] num1 = new int[max+1];
        int[] res = new int[arr1.length];
        for(int i:arr1){
            num1[i]++;
        }
        //按照arr2的顺序添加到res
        int index = 0;
        for(int i:arr2){
            while(num1[i]-->0){
                res[index++] = i;
            }
        }
        //剩余元素添加到res
        for(int i=0; i<=max; i++){
            if(num1[i]>0){
                while(num1[i]>0){
                    res[index++] = i;
                    num1[i]--;
                }
            }
        }
        return res;
    }
}