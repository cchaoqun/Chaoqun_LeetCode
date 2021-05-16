package TypicalProblem.TopK;

import java.util.Random;

/*
 * @Description: 215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 *
 * @param null
 * @return
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/24 18:14
 */
public class LC215 {

    //暴力排序
    //返回第 len-k 个元素
//    public int findKthLargest(int[] nums, int k) {
//        int len = nums.length;
//        Arrays.sort(nums);
//        return nums[len-k];
//    }

    private static Random random = new Random(System.currentTimeMillis());
    //快速选择排序
    public int findKthLargest(int[] nums, int k){
        int len = nums.length;
        //第k大的元素实际上是下标为len-k的数字
        int target = len - k;
        int left = 0;
        int right = len-1;
        while(true){
            int index = partition(nums, left, right);
            //如果随机选到的元素下标<target
            if(index<target){
                //target在区间右边
                left = index + 1;
            }else if(index>target){
                //target在区间左边
                right = index - 1;
            }else{
                //所求target,返回下标对应的数字
                return nums[index];
            }
        }
    }

    public int partition(int[] nums, int left, int right){
        if(right>left){
            //获取区间[1, right]中的随机坐标
            int randomIndex = left+1+random.nextInt(right-left);
            //将随机坐标对应的数据交换到left(0)
            swap(nums, left, randomIndex);
        }

        int pivot = nums[left];
        int j = left;
        for(int i=left+1; i<=right; ++i){
            if(nums[i] < pivot){
                //小于pivot的数字都交换到数组的前面而不是与pivot交换
                ++j;
                swap(nums, j, i);
            }
        }
        //最后j就是pivot应该在的位置,将其交换到j
        swap(nums, left, j);
        //返回对应的下标
        return j;
    }

    //交换数组中两个下标对应的元素
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //优先队列

    //使用len个元素的小顶堆,出队len-k个元素,堆顶为第k大的元素
//    public int findKthLargest(int[] nums, int k){
//        int len = nums.length;
//        //使用一个含有len个元素的小顶堆
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(len, (a, b) -> a-b);
//        //先将len个元素全部添加进来形成小顶堆
//        for(int i=0; i<len; ++i){
//            minHeap.add(nums[i]);
//        }
//        //出队len-k 个元素,这样剩下的(len-(len-k))=k个元素形成的小顶堆顶就为第k大的元素
//        for(int i=0; i<len-k; ++i){
//            minHeap.poll();
//        }
//        return minHeap.peek();
//    }

    //使用len个元素的大顶堆,出队k-1个元素,k-1个大的元素都出队了,堆顶为第k大的元素
//    public int findKthLargest(int[] nums, int k){
//        int len = nums.length;
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (a,b) -> b-a);
//        for(int i=0; i<len; ++i){
//            maxHeap.add(nums[i]);
//        }
//        for(int i=0; i<k-1; ++i){
//            maxHeap.poll();
//        }
//        return maxHeap.peek();
//    }

    //使用k个元素的小顶堆,遇到比顶大的元素出队一个入队一个
//    public int findKthLargest(int[] nums, int k){
//        int len = nums.length;
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a,b) -> a-b);
//        for(int i=0; i<k; ++i){
//            minHeap.add(nums[i]);
//        }
//        for(int i=k; i<len; ++i){
//            //看一眼堆顶元素
//            Integer topEle = minHeap.peek();
//            if(nums[i]>topEle){
//                minHeap.poll();
//                minHeap.add(nums[i]);
//            }
//
//        }
//        return minHeap.peek();
//    }

    //使用k+1个元素的小顶堆,k以后进来一个出去一个,让队列自己去维护大小关系,始终保持了队列有k个元素
//    public int findKthLargest(int[] nums, int k){
//        int len = nums.length;
//        PriorityQueue<Integer> queue = new PriorityQueue<>(k+1, (a,b) -> a-b);
//        for(int i=0; i<k; ++i){
//            queue.add(nums[i]);
//        }
//        for(int i=k; i<len; ++i){
//            queue.add(nums[i]);
//            queue.poll();
//        }
//        return queue.peek();
//    }
}

