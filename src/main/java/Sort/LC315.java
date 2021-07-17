package Sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chaoqun Cheng
 * @date 2021-06-2021/6/18-15:02
 */

public class LC315 {
    //归并排序 索引数组
    public List<Integer> countSmaller(int[] nums){
        List<Integer> list = new ArrayList<>();
        if(nums==null || nums.length==0){
            return list;
        }
        //临时数组和索引数组
        int len = nums.length;
        int[] indexes = new int[len];
        int[] temp = new int[len];
        //初始化索引数组
        for(int i=0; i<len; i++){
            indexes[i] = i;
        }
        //结果数组
        int[] res =new int[len];
        mergeTwoSortedArray(indexes, temp, nums, res,0, len-1);
        for(int i=0; i<len; i++){
            list.add(res[i]);
        }
        return list;
    }

    public void mergeTwoSortedArray(int[] indexes, int[] temp, int[] nums, int[] res, int L, int R){
        //区间只有一个元素 直接返回
        if(L==R){
            return;
        }
        //分成左右区间递归
        int M = L+(R-L)/2;
        mergeTwoSortedArray(indexes, temp, nums, res, L, M);
        mergeTwoSortedArray(indexes, temp, nums, res, M+1, R);
        if(nums[indexes[M]]<=nums[indexes[M+1]]){
            //左边元素全部<=右边, 不存在右边有小于右边的元素
            return;
        }
        //合并两个区间 [L:M] [M+1:R]
        mergeSort(indexes, temp, nums, res,L, M, R);
    }

    public void mergeSort(int[] indexes, int[] temp, int[] nums, int[] res, int L, int M, int R){
        int l = L;
        int r = M+1;
        for(int i=L; i<=R; i++){
            //保存indexes [L:R]区间的元素, indexes会更新
            temp[i] = indexes[i];
        }
        for(int k=L; k<=R; k++){
            //如果左边的区间元素已经用完了
            if(l>M){
                indexes[k] = temp[r];
                r++;
            }else if(r>R){
                //右边元素用完了, 从现在开始的每一个左边的元素nums[temp[l]]都大于 右边全部的元素 共 R-M个
                indexes[k] = temp[l];
                l++;
                //indexes[k] 这个nums[]中的索引对应的元素 右边当前有 R-M个元素小于 nums[indexes[k]]
                res[indexes[k]] += R-M;
            }else if(nums[temp[l]]<=nums[temp[r]]){
                //对于每一个 nums[temp[M+1:r)] nums[temp[l]]都大于这个r-M-1个数
                indexes[k] = temp[l];
                l++;
                res[indexes[k]] += r-M-1;
            }else{
                //nums[temp[l]]>nums[temp[r]]
                indexes[k] = temp[r];
                r++;
            }
        }
    }
}
