package JZOffer.review;

/**
 * @author Chaoqun Cheng
 * @date 2021-07-2021/7/28-14:22
 */

public class jz51 {
    public int reversePairs(int[] nums) {
        /**
         归并排序的思想, 并的时候计算逆序对的数量
         [x1,x2,x3,....,xn]  k = n/2
         [x1,x2,3,..,xk]      [xk+1, xk+2, ..., xn]
         l                     r
         每次l指向的元素被放入合并后的数组, r-(mid+1)就是l指向的元素对于逆数对的贡献
         因为[mid+1, r-1]的元素都小于左边的l指向的元素
         */
        int[] copy = nums;
        int[] res = new int[]{0};
        int len = nums.length;
        mergeSort(copy, 0, len-1, new int[len], res);
        return res[0];
    }

    private void mergeSort(int[] nums, int l, int r, int[] temp, int[] res){
        if(l>=r){
            return;
        }
        int mid = (l+r)>>>1;
        mergeSort(nums, l, mid, temp, res);
        mergeSort(nums, mid+1, r, temp, res);
        mergeTwoSortedArray(nums, l, mid, r, temp, res);
    }
    private void mergeTwoSortedArray(int[] nums, int l, int mid, int r, int[] temp, int[] res){
        System.arraycopy(nums, l, temp, l, r-l+1);
        int i = l;
        int j = mid+1;
        for(int k=l; k<=r; k++){
            if(i==mid+1){
                nums[k] = temp[j];
                j++;
            }else if(j==r+1){
                //temp[i]>所有的temp[mid+1, r]
                // temp[i]对逆数对的贡献是右区间的长度 r-(mid+1)+1 = r+1-(mid+1) = j-(mid+1)
                res[0] += j-(mid+1);
                nums[k] = temp[i];
                i++;
            }else if(temp[i]<=temp[j]){
                //移动左边的指针 说明 temp[i]<=temp[j] 并且大于所有的 temp[mid+1, j-1]
                //所以temp[i]对逆数对的贡献是 j-1-(mid+1)+1 = j-(mid+1)
                res[0] += j-(mid+1);
                nums[k] = temp[i];
                i++;
            }else {
                // temp[i]>temp[i];
                nums[k] = temp[j];
                j++;
            }
        }
    }
}
