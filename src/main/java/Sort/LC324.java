package Sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/22-14:38
 */

public class LC324 {
    @Test
    public void test(){
        int[] nums = {1,2,3,3,5,5,2,4,5,2,3,2};
        wiggleSort(nums);

    }

    Random random = new Random();
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int n = len;
        //快速选择 选择中间位置下标 使得中间位置左边都比中间小, 右边都比中间大 非严格
        quickSelect(nums, 0, len-1, (len-1)/2);
        //中间位置的值
        int mid = nums[(len-1)/2];
        //3-way partition 将与中间位置相等的元素都移动到中间一起
        for(int i=0,j=0,k=len-1; j<k; j++){
            //从左到右遍历数组, 当前元素>mid就交换到后面
            if(nums[j]>mid){
                swap(nums, j, k);
                k--;
            }else if(nums[j]<mid){
                //当前元素<mid 就交换到前面
                swap(nums, i, j);
                i++;
            }
        }
        //复制数组
        int[] temp = nums.clone();
        //分成两部分 右边更大的部分插入到奇数位置
        for(int i=1; i<len; i+=2){
            nums[i] = temp[--n];
        }
        //
        for(int i=0; i<len; i+=2){
            nums[i] = temp[--n];
        }

    }

    private void quickSelect(int[] nums, int l, int r, int mid){
        if(l>=r){
            return;
        }
        int pivot = randomPick(nums, l, r);
        if(pivot==mid){
            return;
        }else if(pivot<mid){
            quickSelect(nums, pivot+1, r, mid);
        }else{
            quickSelect(nums, l, pivot-1, mid);
        }
    }

    private int randomPick(int[] nums, int l, int r){
        int pivot = l+random.nextInt(r-l);
        return quickSelectSort(nums, l, r, pivot);
    }

    private int quickSelectSort(int[] nums, int l, int r, int pivot){
        int index = l;
        swap(nums, l, pivot);
        for(int i=l+1; i<=r; i++){
            if(nums[i]<=nums[l]){
                index++;
                swap(nums, i, index);
            }
        }
        swap(nums, index, l);
        return index;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

class LC324_M2{
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int n = len;
        Arrays.sort(nums);
        //复制数组
        int[] temp = nums.clone();
        //分成两部分 右边更大的部分插入到奇数位置
        for(int i=1; i<len; i+=2){
            nums[i] = temp[--n];
        }
        //
        for(int i=0; i<len; i+=2){
            nums[i] = temp[--n];
        }

    }
}
