package Sort;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/17-16:02
 */

public class interview1616 {
    public int[] subSort(int[] array) {
        int len = array.length;
        //双指针初始指向数组两端
        int l = 0;
        int r = len-1;
        //需要返回的需要排序的区间 默认不需要排序
        int m = -1;
        int n = -1;
        if(len==0){
            return new int[]{m,n};
        }
        while(l<r){
            //找到需要改变的左端点和右端点
            //需要左边<=右边 并且左边从左到右是非递减的 右边从右到左是非递增的
            if(array[l]<=array[r] && array[l+1]>=array[l] && array[r-1]<=array[r]){
                l++;
                r--;
                continue;
            }
            //延续向右找到第一个 递减的点 array[l]>array[l+1]
            while(l+1<len && array[l+1]>=array[l]){
                l++;
            }
            //延续向左找到第一个 递增的点 array[r]<array[r-1]
            while(r-1>=0 && array[r-1]<=array[r]){
                r--;
            }
            //现在保证 [0:l] 递增  [r:len-1]递增
            //找到区间[l:r]的最大和最小值
            //从l向左找到最小值应该在的位置
            //从r向右找到最大值应该在的位置
            //如果中间的最大最小值和array[l]==array[r] 无需排序
            int max = array[l];
            int min = array[r];
            //找到[l:r]中的最大值和最小值
            for(int i=l; i<=r; i++){
                max = Math.max(max, array[i]);
                min = Math.min(min, array[i]);
            }
            //[l:r]区间元素全部相等 已经是默认排序好的了
            if(max==min && min==array[l] && array[l]==array[r]){
                return new int[]{m,n};
            }else{
                //向左找最小值应该在的位置 从l开始向左
                m = l;
                while(m>=0 && array[m]>min){
                    m--;
                }
                //当前的array[m]<=min 或者m==-1 所以 min应该在m+1的位置
                m++;
                //向右找最大值应该在的位置 从r开始向右
                n = r;
                while(n<len && array[n]<max){
                    n++;
                }
                //当前的array[n]>=max 或者n==len 所以 max应该在n-1的位置
                n--;
                //返回更新后的坐标
                return new int[]{m,n};
            }
        }
        return new int[]{m,n};
    }
}

class interview1616_M2{
    public int[] subSort(int[] array) {
        int len = array.length;
        //需要返回的需要排序的区间 默认不需要排序
        int m = -1;
        int n = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        if (len == 0) {
            return new int[]{m, n};
        }
        for(int i=0; i<len; i++){
            //左->右 更新的是需要排列的右端点
            //从左到右更新最大值, 如果当前array[i]小于之前的最大值, 说明这个位置是逆序的需要被重新排序
            // 即存在 array[i] < array[k] (0<=k<i)
            if(array[i]<max){
                n = i;
            }else{
                max = Math.max(max, array[i]);
            }
            //左<-右 更新的是需要排列的左端点
            //从右到左更新最小值, 如果当前值array[len-1-i]大于之前的最小值, 说明这个位置是逆序的 需要重新排序
            // 即存在 array[len-1-i] > array[len-1-k] (0<=k<i)
            if(array[len-1-i]>min){
                m = len-1-i;
            }else{
                min = Math.min(min, array[len-1-i]);
            }
        }
        return new int[]{m,n};
    }


}





















