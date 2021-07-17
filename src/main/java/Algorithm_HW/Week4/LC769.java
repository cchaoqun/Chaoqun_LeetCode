package Algorithm_HW.Week4;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/12-10:38
 */

public class LC769 {
    public int maxChunksToSorted(int[] arr) {
        //arr[i]代表了这个元素本来应该在的位置
        int end = arr[0];
        int count = 0;
        for(int i=0; i<arr.length; i++){
            //每次都更新为当前范围内最大的
            end = Math.max(end, arr[i]);
            //如果i==end, 代表这个区间内所有的数都是对应下标的一个排列, 排序后就刚好与下标一一对应
            if(i==end){
                //可分的区间+1
                count++;
            }
        }
        return count;
    }
}
