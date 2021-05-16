package BackTracking.backtrack0221;

import java.util.*;

/*
 * @Description: 46. 全排列
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 *
 * @param null 
 * @return 
 * @author Chaoqun
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/21 9:22
 */
public class LC46 {

//    //存放排列结果的list集合
//    private static List<List<Integer>> res = new ArrayList<>();
//    private static List<Integer> path = new ArrayList<>();
//    //使用boolean数组来判断当前元素是否已经添加到path效率更高,通过下标在O1时间内确定结果,重置时也很方便
//    private static boolean[] isVisited = new boolean[3];
//
//    public static void main(String[] args) {
//        int[] nums = {1,2,3};
//        List<List<Integer>> res = permute(nums);
//        System.out.println(res);
//    }
//
//    public static List<List<Integer>> permute(int[] nums) {
//        dfs(nums);
//        return res;
//    }
//
//    public static void dfs(int[] nums){
//
//        //返回条件 path中元素数量等于数组中数量,说明是一个全排列
//        if(path.size()==nums.length){
//            //创建path的拷贝,添加到res, path从头到尾只有一份
//            res.add(new ArrayList<>(path));
//            return;
//        }
//        for(int j=0; j<nums.length; ++j){
//            //添加的元素为本层除了当前元素以外的其他所有元素
//            if(!isVisited[j]){
//                //将当前元素添加到list标记为已经访问过
//                isVisited[j] = true;
//                //当前元素加入path
//                path.add(nums[j]);
//                System.out.println(" 递归之前 ==>" + path);
//                //递归
//                dfs(nums);
//                //重置
//                path.remove(path.size()-1);
//                System.out.println("递归之后 ==>" + path);
//                isVisited[j] = false;
//            }
//        }
//    }

    //交换
    //存放结果的list结合,全局变量,递归函数无需传入参数
    List<List<Integer>> res = new ArrayList<>();
    //同上,但是主函数中需要初始化
    int[] nums;
    public List<List<Integer>> permute(int[] nums){
        //初始化
        this.nums = nums;
        //递归,从第一个位置开始
        dfs(0);
        return res;
    }

    //递归函数
    void dfs(int x){
        //当到达最后一个位置时,0~n-2位置的数都已经固定好了,直接返回整个数组对应的顺序即可
        if(x==nums.length-1){
            //新建一个list,将当前顺序下数组中的数依次添加
            List<Integer> temp = new ArrayList<>();
            for(int i:nums){
                temp.add(i);
            }
            //添加到res
            res.add(temp);
            return;
        }

        //i从x位置开始,因为0~x-1位置的数字都已经固定好了
        //例如x=0, 第一个位置有nums.length-1个可能的情况,(无重复元素的情况下)
        for(int i=x; i<nums.length; ++i){
            //交换i,x位置对应的数字,这一步是将nums[i]固定到x位置上
            swap(i,x);
            //递归取固定下一个位置的值
            dfs(x+1);
            //递归回来,在固定x位置=nums[i]情况下所有的可能顺序都已经添加完了
            //进入下一个循环,继续寻找x位置可以存在的数字的情况
            //所以这里需要回复之前的交换
            swap(i,x);
        }
    }

    void swap(int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
