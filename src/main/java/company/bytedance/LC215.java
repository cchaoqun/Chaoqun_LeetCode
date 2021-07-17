package company.bytedance;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/23-15:35
 */

public class LC215 {

    @Test
    public void test(){
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        findKthLargest(nums, k);
        System.out.println(nums);
    }


    Random random = new Random();
    public int findKthLargest(int[] nums, int k) {
        // target = nums.length - k;
        //快速选择
        int len = nums.length;
        quickSelect(nums, 0, len-1, len-k);
        System.out.println(Arrays.toString(nums));
        return nums[len-k];

    }

    //选择下标和target相等
    private void quickSelect(int[] nums, int l, int r, int target){
        if(l>=r){
            return;
        }

        int pivot = randomPivot(nums, l, r);
        if(pivot==target){
            //找到了这个下标 直接返回
            return;
        }else if(pivot<target){
            quickSelect(nums, pivot+1, r, target);
        }else{
            quickSelect(nums, l, pivot-1, target);
        }
    }

    //[l:r]区间随机选择一个下标
    private int randomPivot(int[] nums, int l, int r){
        int pivot = random.nextInt(r-l+1)+l;
        //查看这个随机选择的下标排序后所在的下标
        return quickSelectSort(nums, l, r, pivot);
    }

    //查看这个pivot下标对应的nums[pivot]数标排序后所在的下标
    private int quickSelectSort(int[] nums, int l, int r, int pivot){
        int index = l;
        //先交换到当前区间的最左边
        swap(nums, l, pivot);
        //从l+1开始与nums[l]比较
        for(int i=l+1; i<=r; i++){
            //<=nums[l]的数交换到坐标, index代表当前<=nums[l]数坐在的最后一个下标
            if(nums[i]<=nums[l]){
                index++;
                swap(nums, index, i);
            }
        }
        //把目标元素nums[l] 与 <=nums[l]元素的最后一个位置交换
        swap(nums, l, index);
        //返回排序后的下标
        return index;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class LC215_M2{

    //堆
    public int findKthLargest(int[] nums, int k) {
        //维护大小为k的最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //前k个元素入堆
        for(int i=0; i<k; i++){
            heap.offer(nums[i]);
        }
        //剩余的元素, 只要比堆顶的元素大就入堆
        for(int i=k; i<nums.length; i++){
            if(nums[i]>heap.peek()){
                heap.poll();
                heap.offer(nums[i]);
            }
        }
        //堆顶元素为第k大的元素
        return heap.peek();
    }
}
